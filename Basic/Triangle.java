import java.util.Scanner;

public class Triangle{
	public static void main(String aargs[]){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter length of all sides of triangle");
		int side1 = sc.nextInt();
		int side2 = sc.nextInt();
		int side3 = sc.nextInt();
		

		if(side1 == side2 && side2 == side3){
			System.out.println("equalitrle triangle");
		}else if(side1==side2 || side2==side3){
			System.out.println("isoscalus triangle");
		}else if(side1*side1 == side2*side2 + side3*side3 || side3*side3 == side2*side2 + side1*side1 || side2*side2 == side1*side1 + side3*side3){
			System.out.println("right angled triangle");
		}else if(side1 + side2 > side3 || side2 + side3 > side1 || side1 + side3 > side2){
			System.out.println("for this lengths triangle not possible");
		}else{
			System.out.println("scalus");
		}

	}
}
