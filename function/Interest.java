import java.util.Scanner;
public class Interest{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter principal : ");
		int principal = sc.nextInt();
		System.out.print("Enter year : ");
		float year = sc.nextFloat();
		System.out.print("Enter Rate of Interest : ");
		float rateOfInterest = sc.nextFloat();

		printSI(principal, year, rateOfInterest);
	}

	public static void printSI(int principal,float year, float rateOfInterest){
		System.out.println("\n\nSimple Interest = " + ((float) principal*year*rateOfInterest)/100);
	}
}
