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
	public static void main(String ars[]){
		Euler e1 = new Euler();
		System.out.println(e1.answer());
	}
}

class Expression{
	String[] allExpressions;
	Expression parent;
	Expression neighbour;
	ArrayList <Expression> childs = new ArrayList<Expression>();
	String myExpression;
	String relation;
	double myAns;
	double childAns;
	int childCount = 0;

	Expression(){
	}

	Expression(String e){
		allExpressions = e.split(" ");
	}
	Expression( Expression parent, String myExpression){
		this.parent = parent;
		this.myExpression = myExpression;
	}

	public void setAllExpressions(String function){
		allExpressions = function.split(" ");
	}

	public void createStructure(){
		createStructure( allExpressions, 0 );
	}

	void createStructure(String[] allExpressions, int index){
		if( index == allExpressions.length ){
			System.out.println("exited");
			return;
		}
		else if( allExpressions[index].equals("(") ){
			Expression dummy;
			if(relation != null){ 
				Expression dummyNeighbour = new Expression();
				neighbour = dummyNeighbour;
				dummy = new Expression(neighbour, allExpressions[index+1] );
				neighbour.childs.add(dummy);

			}else{
				dummy = new Expression(this, allExpressions[ index + 1 ]);
				childs.add(dummy);
			}

			System.out.println("create child node   "+ allExpressions[ index + 1 ]);
			dummy.createStructure(allExpressions, index + 2 );	
		}
		else if(allExpressions[index].equals("+") || allExpressions[index].equals("-") || allExpressions[index].equals("*") || allExpressions[index].equals("/") || allExpressions[index].equals("^")){
			this.relation = allExpressions[index];
			System.out.println("applied relation   " + allExpressions[ index ] + "  to  " + myExpression);
			createStructure(allExpressions, index + 1);
		}
		else if(!allExpressions[ index ].equals(")") ){
			if(myExpression == null){
				System.out.println("------------" + myExpression);
				myExpression = allExpressions[index];
				System.out.println("------------" + myExpression);
				createStructure(allExpressions, index+1);
//			}else if(allExpressions[index].equals("sin")){
//				System.out.println("------------" + myExpression);
//				myExpression = allExpressions[index];
//				System.out.println("------------" + myExpression);
//				createStructure(allExpressions, index+1);
			}
			else{
				Expression dummy = new Expression(parent, allExpressions[ index ]);
				this.neighbour = dummy;
				System.out.println("create neighbour node   "+ allExpressions[index]);
				dummy.createStructure(allExpressions, index+1);
			}
		}
		else{
			System.out.println("return to parent node");
			if(parent.myExpression == null){
				parent.myExpression = " ";
			}
			this.parent.createStructure(allExpressions, index+1);
		}
	}
	void print(){
		if(neighbour == null){
			System.out.println(myExpression);
			if(childs.size() > 0){
				System.out.println(myExpression);
				System.out.println(relation);
				childs.get(0).print();
			}
			return;
		}
		
		System.out.println(myExpression);
		System.out.println(relation);
		if(childs.size() > 0){
			childs.get(0).print();
		}
		neighbour.print();

	}

	double evaluate2( double x, double y){
		if(neighbour == null){
			return selfEvaluate(x,y);
		}
		if(neighbour.neighbour == null){
			return mathFunction2a(selfEvaluate(x,y), relation, neighbour.selfEvaluate(x,y));
		}

		return mathFunction2a(selfEvaluate(x,y), relation, neighbour.evaluate2(x,y));
	}
	double selfEvaluate(double x, double y){
		if(childs.size() > 0){
			childAns = childs.get(0).evaluate2(x,y);
			return  mathFunction2(myExpression, childAns);
		}else{
			System.out.println(".........."+mathFunction2(myExpression,x,y));
			return mathFunction2(myExpression,x,y);
		}
	}

	double mathFunction2(String expression, double x, double y){
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

	double mathFunction2(String expression, double argue){
		System.out.println(expression + " " + argue);
		if(expression.equals("sin")){
			return Math.sin(argue);
		}else if(expression.equals("cos")){
			return Math.cos(argue);
		}

		return argue;
	}

	double mathFunction2a(double a, String operator, double b){
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
	private static Scanner scString = new Scanner( System.in );
	private static Scanner scDouble = new Scanner( System.in );
	double X0;
	double Y0;
	double h;
	double n;
	double X;
	double x,y; // dummy use
	
	Question(){

		System.out.print("Enter Function = ");
		String function = scString.nextLine();
		System.out.print("Value of X0 = ");
		X0 = scDouble.nextDouble();
		System.out.print("Value of Y0 = ");
		Y0 = scDouble.nextDouble();
		System.out.print("Value of h = ");
		h = scDouble.nextDouble();
		System.out.print("Value of n = ");
		n = scDouble.nextDouble();
		System.out.print("Value of X  = ");
		X = scDouble.nextDouble();
		x = X0;
		y = Y0;

		super.setAllExpressions( function );
		createStructure();
	}

	Question(double X0, double Y0, double h, double n, double X){
		this.X0 = X0;
		this.Y0 = Y0;
		this.h = h;
		this.n = n;
		this.X = X;
		this.x = X0;
		this.y = Y0;
	}

	double function(double x, double y){
		return x + y;
	}
}

class Euler extends Question{

	Euler(){
		super();
	}

	Euler(double X0, double Y0, double h, double n, double X){
		super(X0, Y0, h, n, X);
	}
	double answer(){
		while( x < X ){
			y = y + ( h *evaluate2(x,y));
			x = x + h;
		}
		return y;
	}
}
