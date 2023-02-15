import java.util.Scanner;
public class Gcd{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Two Numbers :");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int max = (a>b) ? a : b;
		int min = (a<b) ? a : b;
		for(int i = min; i>=1; i--){
			if(max%i == 0){
				System.out.println("Gcd of "+a+" and "+b+" is "+i);
				break;
			}
		}
	}
}
