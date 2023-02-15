import java.util.Scanner;

public class max{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter two numbers : ");
		int a = sc.nextInt();
		int b = sc.nextInt();

	}
	static int Max(int a, int b){
		return (a>=b) ?
		   				((a==b) ? System.out.print("Both are equal") : System.out.print(a))
					   	: System.out.print(b);
	}
}
