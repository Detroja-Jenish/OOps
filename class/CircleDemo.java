import java.util.Scanner;

public class CircleDemo{
	public static void main(String args[]){
		Circle c = new Circle(2);
		c.printArea();
		c.printPerimeter();
	}
}

class Circle{
	double radius;
	Circle(double radius){
		this.radius = radius;
	}

	void printArea(){
		System.out.println("Area : " + (Math.PI*radius*radius));
	}

	void printPerimeter(){
		System.out.println("Perimeter : " + (2*Math.PI*radius));
	}
}
