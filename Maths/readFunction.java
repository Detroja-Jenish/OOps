import java.util.ArrayList;
import java.util.Scanner;
public class readFunction{
	public static void main(String args[]){
		Scanner sc =new Scanner(System.in);
		String function = sc.nextLine();
		Expression e = new Expression(function);
		e.createStructure();
		System.out.println("\n\nanswer at ( 4, 0 ) = " + e.evaluate(4,0));
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
			Expression dummy = new Expression(this, allExpressions[ index ]);
			this.neighbour = dummy;
			childCount++;
			System.out.println("create neighbour node   "+ allExpressions[index]);
			dummy.createStructure(allExpressions, index+1);
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

	double mathFunctions( double ans, String relation, double ans2){
		if(relation.equals("+")){
			return ans + ans2;
		}else if(relation.equals("-")){
			return ans-ans2;
		}else if(relation.equals("*")){
			return ans * ans2;
		}
		return ans / ans2;
	}

	double evaluateNeighbours( double x, double y){
		if( childs.size() > 0){
			ans = childs.evaluate(x,y);
		}
		return mathFunction( ans , relation, neighbour.evaluateNeighbours(x,y), x, y);
	}

	double evaluateChilds( double x, double y){
		if(childs.size() > 0 ){
			//childs.get(0).evaluateChilds(x,y);
			//return mathFunction( myExpression, childs.get(0).evaluateChilds(x,y));
		}
		return mathFunctions( myExpression, x, y );
	}
	double evaluate(double x, double y){
		if( neighbour == null && childs.size() == 0 ){
			return mathFunctions( myExpression, x, y);
		}
		return 1;
	}
}
