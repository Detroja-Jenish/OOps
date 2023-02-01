import java.util.Scanner;

public class LargeNum{
	public static void main(String aargs[]){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Three numbers : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int max = (a>b) ? ( (a>c) ? a : c ) : ( (b>c) ? b : c );
		System.out.println("Largest number among " + a + " , " + b + " and " + c + " is " + max);	
	}
}
