//import chapter3.Expression;
//import chapter3.Question;
//import chapter3.Euler;
//import chapter3.ModifiedEuler;
//import chapter3.RK3;
//import chapter3.RK4;
import java.util.ArrayList;
import java.lang.NumberFormatException;
import java.util.Scanner;

public class Answer{
	public static void main(String args[]){

		RK4 e = new RK4();

		System.out.println("\n\n\n\n\n");
		//e.print();
		//System.out.println("\n\n\n\n\n");
		System.out.println("\n\nanswer at ( 4, 2 ) = " + e.evaluate(4,2));
		System.out.println("solved answer = " + e.solve());
	}
}

class Expression{
	static String[] allExpressions;
	Expression parentNode;
	Expression neighbourNode;
	Expression childNode;
	String myExpression;
	String relation;
	double myAns;
	double childAns;
	int childCount = 0;

	Expression(){
		Scanner sc = new Scanner( System.in );
		System.out.print("Enter Function : ");
		String function = sc.nextLine();
		allExpressions = function.split(" ");

		createStructure();
	}

	Expression(String e){
		allExpressions = e.split(" ");
	}
	Expression( Expression parentNode, String myExpression){
		this.parentNode = parentNode;
		this.myExpression = myExpression;
	}

	public void setAllExpressions(String function){
		allExpressions = function.split(" ");
	}

	public void createStructure(){
		createStructure( allExpressions, 0 );
	}

	void createStructure(String[] allExpressions, int index){
		// x + ( ( 2 * x ) / y )
		System.out.print(index + "  " );
		if( index == allExpressions.length ){
			return;
		}else if(myExpression == null){
			System.out.println( " expression was set " );
			myExpression = allExpressions[ index ];
			createStructure( allExpressions, index + 1);
		}else if(relation != null){
			//neighbour node
			System.out.println( "neighbour node created.... "+ allExpressions[ index ]);
			neighbourNode = new Expression( parentNode, allExpressions[ index ]);
			neighbourNode.createStructure( allExpressions, index + 1 );
		}else if(allExpressions[index].equals("+") || allExpressions[index].equals("-") || allExpressions[index].equals("*") || allExpressions[index].equals("/") || allExpressions[index].equals("^")){
			relation = allExpressions[index];
			System.out.println("applied relation   " + allExpressions[ index ] + "  to  " + myExpression);
			createStructure(allExpressions, index + 1);
		}else if(myExpression.equals("(") ){
			//child Node
			System.out.println( "child node created.... "+ allExpressions[ index ]);
			childNode = new Expression( this, allExpressions[ index ]);
			childNode.createStructure( allExpressions, index+1);
		}else if(allExpressions[ index ].equals("(")){
			//child Node
			System.out.println( "child node created.... "+ allExpressions[ index + 1 ]);
			childNode = new Expression( this, allExpressions[ index + 1 ]);
			childNode.createStructure( allExpressions, index+2);
		}else if( allExpressions[ index ].equals(")") ){
			System.out.println( "Back to the parentNode" ); 
			parentNode.createStructure( allExpressions, index + 1 );
		}else{
			//neighbour Node
			System.out.println( "neighbour node created...2 "+ allExpressions[ index ]);
			neighbourNode = new Expression( parentNode, allExpressions[ index ] );
			neighbourNode.createStructure( allExpressions, index + 1 );
		}
	}

	void print(){
		if(neighbourNode == null){
			System.out.println(myExpression);
			if(childNode != null){
				System.out.println(myExpression);
				System.out.println(relation);
				childNode.print();
			}
			return;
		}
		
		System.out.println(myExpression);
		System.out.println(relation);
		if(childNode != null){
			childNode.print();
		}
		neighbourNode.print();

	}

	double evaluate( double x, double y){
		if(neighbourNode == null){
			return selfEvaluate(x,y);
		}
		//if(neighbour.neighbour == null){
		//	return mathFunction(selfEvaluate(x,y), relation, neighbour.selfEvaluate(x,y));
		//}

		return mathFunction(selfEvaluate(x,y), relation, neighbourNode.evaluate(x,y));
	}
	double selfEvaluate(double x, double y){
		if(childNode != null){
			childAns = childNode.evaluate(x,y);
			return  mathFunction(myExpression, childAns);
		}else{
			System.out.println(".........."+mathFunction(myExpression,x,y));
			return mathFunction(myExpression,x,y);
		}
	}

	double mathFunction(String expression, double x, double y){
		if(expression.equals("x")){
			return x;
		}else if(expression.equals("-x")){
			return -x;
		}else if(expression.equals("y")){
			return y;
		}else if(expression.equals("-y")){
			return -y;
		}else if(expression.equals("pi")){
			return Math.PI;
		}else if(expression.equals("e")){
			return Math.exp(1);
		}else{
			try{
				return Double.parseDouble( expression );
			}catch(NumberFormatException e){
				return 1;
			}
		}
		
	}

	double mathFunction(String expression, double argue){
		System.out.println(expression + " " + argue);
		if(expression.equals("sin")){
			return Math.sin(argue);
		}else if(expression.equals("cos")){
			return Math.cos(argue);
		}

		return argue;
	}

	double mathFunction(double a, String operator, double b){
		if(operator.equals("+")){
			return a + b;
		}else if( operator.equals("-") ){
			return a - b;
		}else if( operator.equals("*") ){
			return a * b;
		}else if( operator.equals("/") ){
			return a / b;
		}else if( operator.equals("^") ){
			return Math.pow(a,b);
		}
		return 1;
	}
}

class Question extends Expression{

	double X0;
	double Y0;
	double h;
	double n;
	
	Question(){
		super();
		Scanner sc = new Scanner( System.in );
		System.out.print("\n\nValue of X0 : ");
		X0 = sc.nextDouble();
		System.out.print("Value of Y0 : ");
		Y0 = sc.nextDouble();
		System.out.print("Value of h : ");
		h = sc.nextDouble();
		System.out.print("Value of n : ");
		n = sc.nextDouble();

	}
}

class Euler extends Question{
	Euler(){
		super();
	}

	double solve(){
		Scanner sc = new Scanner( System.in );
		System.out.print("Value of X ( y(x) ) : ");
		double X = sc.nextDouble();
		double x = X0;
		double y = Y0;

		while(x != X && x < X){
			
			y = y + h * evaluate(x,y);
			x = x + h;
			System.out.println(x);
		}

		return y;
	}
}

class ModifiedEuler extends Question{
	ModifiedEuler(){
		super();
	}

	double solve(){
		Scanner sc = new Scanner( System.in );
		System.out.print("Value of X ( y(x) ) : ");
		double X = sc.nextDouble();
		double x = X0;
		double y = Y0;
		double k1,k2;

		while(x != X && x < X){
			
			k1 = h * evaluate(x,y);
			k2 = h * evaluate(x + h, y + k1);
			y = y + ( (k1 + k2) / 2 );
			x = x + h;
			System.out.println(x);
		}

		return y;
	}
}

class RK3 extends Question{

	RK3(){
		super();
	}

	double solve(){
		Scanner sc = new Scanner( System.in );
		System.out.print("Value of X ( y(x) ) : ");
		double X = sc.nextDouble();
		double x = X0;
		double y = Y0;
		double k1,k2,k3;

		while(x != X && x < X){
			
			k1 = h * evaluate(x, y);
			k2 = h * evaluate( x + ( h/2 ), y + ( k1/2 ) );
			k3 = h * evaluate( x + h, y - k1 + ( 2*k2 ) );
			y  = y + ( ( k1 + ( 4 * k2 ) + k3 ) / 6 );
			x  = x + h;
			System.out.println(x);
		}

		return y;
	}
}

class RK4 extends Question{

	RK4(){
		super();
	}

	double solve(){
		Scanner sc = new Scanner( System.in );
		System.out.print("Value of X ( y(x) ) : ");
		double X = sc.nextDouble();
		double x = X0;
		double y = Y0;
		double k1, k2, k3, k4;

		while(x != X && x < X){

			k1 = h * evaluate(x, y);
			k2 = h * evaluate( x + ( h/2 ), y + ( k1/2 ) );
			k3 = h * evaluate( x + ( h/2 ), y + ( k2/2 ) );
			k4 = h * evaluate( x + h, y + k3 );
			y  = y + ( ( k1 + ( 2 * k2 ) + ( 2 * k3 ) + k4 ) / 6 );
			x  = x + h;
			System.out.println(x);
		}

		return y;
	}
}
