import java.util.Scanner;
public class MethodOverLoading{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch(choice){
			case 1:
				double r = sc.nextDouble();
				printArea(r);
				break;
			case 2:
				printArea(sc);
				break;
			case 3:
				System.out.print("Enter All Sides of Triangle: ");
				double area = printArea(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
				System.out.println("Area of triangle : " + area);
		}
	}
	static void printArea(double r){
		System.out.println("Area of Circle : " + (3.14*r*r));
	}
	static void printArea(Scanner sc){
		System.out.print("Enter length of square : " );
		double a = sc.nextDouble();
		System.out.println("Area of Square : " + (a*a));
	}
	static double printArea(double s1, double s2, double s3){
		double s = (s1 +s2 + s3)/2;
		return Math.sqrt(s*(s-s1)*(s-s2)*(s-s3));
	}
}
