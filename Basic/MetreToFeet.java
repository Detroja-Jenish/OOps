import java.util.Scanner;

public class MetreToFeet{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
	
		System.out.print("enter length in metre : " );
		float m = sc.nextFloat();

		float feet = 3.28084f*m;

		System.out.println(m + " metre = " + feet + " feet");
	}
}
