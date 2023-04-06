import java.util.Scanner;

public class excShape{
	public static void main(String args[]){
		Circle c = new Circle(10);
		c.display();
	}
}

class Shape{
	String type;
	double area;
	Shape( String type ){
		this.type = type;
	}

	void display(){
		System.out.println("Type = "+type);
	}

}

class Circle extends Shape{
	double radius;

	Circle(double radius){
		super("circle");
		this.radius = radius;
		area = Math.PI * radius * radius;
	}
	void display(){
		super.display();
		System.out.print(" radius = "+radius+" area = "+area);
	}
}

	
