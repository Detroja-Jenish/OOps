// first calcu;ate childs and then convert it in string and store in parents myExpression
import java.util.ArrayList;
import java.lang.NumberFormatException;
import java.util.Scanner;
public class readFunction{
	public static void main(String args[]){
		Scanner sc =new Scanner(System.in);
		String function = sc.nextLine();
		Expression e = new Expression(function);
		e.createStructure();
		System.out.println("\n\nanswer at ( 8, 6 ) = " + e.evaluate(8,6));
	}
}

class Expression{
	String[] allExpressions;
	Expression parent;
	Expression neighbour;
	ArrayList <Expression> childs = new ArrayList<Expression>();
	String myExpression;
	String relation;
	double ans;
	int childCount = 0;

	Expression(String e){
		allExpressions = e.split(" ");
	}
	Expression( Expression parent, String myExpression){
		this.parent = parent;
		this.myExpression = myExpression;
	}

	void createStructure(){
		createStructure( allExpressions, 0 );
	}

	void createStructure(String[] allExpressions, int index){
		if( index == allExpressions.length ){
			System.out.println("exited");
			return;
		}
		else if( allExpressions[index].equals("(") ){
			Expression dummy = new Expression(this, allExpressions[index+1] );
			this.childs.add(dummy);
			this.childCount++;
			System.out.println("create child node   "+ allExpressions[ index + 1 ]);
			dummy.createStructure(allExpressions, index + 2 );	
		}
		else if(allExpressions[index].equals("+") || allExpressions[index].equals("-") || allExpressions[index].equals("*") || allExpressions[index].equals("/") || allExpressions[index].equals("^")){
			this.relation = allExpressions[index];
			System.out.println("applied relation   " + allExpressions[ index ]);
			createStructure(allExpressions, index + 1);
		}
		else if(!allExpressions[ index ].equals(")") ){
			if(myExpression == null){
				myExpression = allExpressions[index];
				createStructure(allExpressions, index+1);
			}
			else{
				Expression dummy = new Expression(this, allExpressions[ index ]);
				this.neighbour = dummy;
				System.out.println("create neighbour node   "+ allExpressions[index]);
				dummy.createStructure(allExpressions, index+1);
			}
		}
		else{
			System.out.println("return to parent node");
			this.parent.createStructure(allExpressions, index+1);
		}
	}

//	double evaluate( double x, double y){
//		Expression dummy = this;
//		while( dummy.neighbour != null || dummy.childs.length > 0){
//			if(dummy.childs.length > 0){
//				dummy.childs.get(0).evaluate( x, y);
//			}
//		}
//
//	}

	double mathFunctions(String expression, double x, double y){
		try{
			return Double.parseDouble( expression );
		}finally{
			if( expression.equals("sin") ){
				return Math.sin( x );
			}else if(expression.equals("x")){
				return x;
			}else if(expression.equals("y")){
				return y;
			}
		}
	}
	double mathFunctions(double a, String relation, double b, double x, double y){
		if(relation.equals("+")){
			return a + b;
		}else if(relation.equals("-")){
			return a - b;
		}else if(relation.equals("*")){
			return a * b;
		}
		return a/b;
	}

	double mathFunctions(String expression, String relation, double b, double x, double y){
		double a;
		try{
			a = Double.parseDouble( expression );
		}catch(NumberFormatException e){
			if(expression.equals("x")){
				a = x;
			}else if(expression.equals("y")){
				a = y;
			}else{
				a = 1;
			}
		}
		return mathFunctions(a, relation, b, x, y);
	}

	double mathFunctions( String expression, String relation, String neighbourExpression, double x, double y){
		double a, b;
		try{
			a = Double.parseDouble( expression );
		}catch(NumberFormatException e){
			if(expression.equals("x")){
				a = x;
			}else if(expression.equals("y")){
				a = y;
			}
			else{
				a = 1;
			}
		}

		try{
			b = Double.parseDouble( neighbourExpression );
		}catch(NumberFormatException e){
			if(neighbourExpression.equals("x")){
				b = x;
			}else if(neighbourExpression.equals("y")){
				b = y;
			}else{
				b = 1;
			}
		}
		return mathFunctions(a, relation, b, x, y);

	}

	double evaluate(double x, double y){
	//	Expression dummy = this;
		
		if(neighbour.neighbour == null){
			return mathFunctions(myExpression, relation, neighbour.myExpression, x, y);
		}
		return mathFunctions(myExpression, relation, neighbour.evaluate(x,y), x, y);

	}

//	double evaluateNeighbours( double x, double y){
//		if( childs.size() > 0){
//			ans = childs.get(0).evaluate(x,y);
//		}
//		return mathFunctions( ans , relation, neighbour.evaluateNeighbours(x,y), x, y);
//	}
//
//	double evaluateChilds( double x, double y){
//		if(childs.size() > 0 ){
//			//childs.get(0).evaluateChilds(x,y);
//			//return mathFunction( myExpression, childs.get(0).evaluateChilds(x,y));
//		}
//		return mathFunctions( myExpression, x, y );
//	}
//	double evaluate(double x, double y){
//		if( neighbour == null && childs.size() == 0 ){
//			return mathFunctions( myExpression, x, y);
//		}
//		else if(childs.size() > 0){
//			childs.get(0).evaluateChilds(x,y);
//		}
//		return 1;
//	}
}
