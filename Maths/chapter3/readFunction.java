// first calcu;ate childs and then convert it in string and store in parents myExpression
// make differnce between parent , neighbour and child constructor 
//package chapter3;
import java.util.ArrayList;
import java.lang.NumberFormatException;
import java.util.Scanner;
public class readFunction{
	public static void main(String args[]){
		Scanner sc =new Scanner(System.in);
		String function = sc.nextLine();
		Expression e = new Expression(function);
		e.createStructure();
		System.out.println("\n\n\n\n\n");
		e.print();
		System.out.println("\n\n\n\n\n");
		System.out.println("\n\nanswer at ( 8, 6 ) = " + e.evaluate2(8,6));
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
		createStructure2( allExpressions, 0 );
	}

	void createStructure2(String[] allExpressions, int index){
		// x + ( ( 2 * x ) / y )
		System.out.print(index + "  " );
		if( index == allExpressions.length ){
			return;
		}else if(myExpression == null){
			System.out.println( " expression was set " );
			myExpression = allExpressions[ index ];
			createStructure2( allExpressions, index + 1);
		}else if(relation != null){
			//neighbour node
			System.out.println( "neighbour node created.... "+ allExpressions[ index ]);
			neighbour = new Expression( parent, allExpressions[ index ]);
			neighbour.createStructure2( allExpressions, index + 1 );
		}else if(allExpressions[index].equals("+") || allExpressions[index].equals("-") || allExpressions[index].equals("*") || allExpressions[index].equals("/") || allExpressions[index].equals("^")){
			relation = allExpressions[index];
			System.out.println("applied relation   " + allExpressions[ index ] + "  to  " + myExpression);
			createStructure2(allExpressions, index + 1);
		}else if(myExpression.equals("(") || allExpressions[ index ].equals("(")){
			//create child
			System.out.println( "child node created.... "+ allExpressions[ index ]);
			Expression childNode = new Expression( this, allExpressions[ index ]);
			childs.add( childNode );
			childNode.createStructure2( allExpressions, index+1);
		}else if( allExpressions[ index ].equals(")") ){
			System.out.println( "Back to the parentNode" ); 
			parent.createStructure2( allExpressions, index + 1 );
		}else{
			//neighbour Node
			System.out.println( "neighbour node created...2 "+ allExpressions[ index ]);
			neighbour = new Expression( parent, allExpressions[ index ] );
			neighbour.createStructure2( allExpressions, index + 1 );
		}
	}

	void createStructure(String[] allExpressions, int index){
		if( index == allExpressions.length ){
			System.out.println("exited");
			return;
		}
		else if( allExpressions[index].equals("(") ){
			Expression dummy;
			if(relation != null){ 
				neighbour = new Expression(parent, allExpressions[index]);
				System.out.println("create neighbour node   "+ allExpressions[index]);
				neighbour.createStructure(allExpressions, index + 1);
			}else{
				dummy = new Expression(this, allExpressions[ index ]);
				childs.add(dummy);
				System.out.println("create child node   "+ allExpressions[ index + 1 ]);
				dummy.createStructure( allExpressions, index + 1);
			}

			//dummy.createStructure(allExpressions, index + 2 );	
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
			}else if(myExpression.equals("(")){
				Expression dummy = new Expression(this, allExpressions[ index ]);
				childs.add(dummy);
				System.out.println("create child node   "+ allExpressions[ index + 1 ]);
				dummy.createStructure( allExpressions, index + 1);
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

