import java.util.Scanner;

public class Temperature{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		float F = sc.nextFloat();

		float C = (F-32)*5.0f/9;

		System.out.println(C + "C = " + F + "F");	
	}
}
