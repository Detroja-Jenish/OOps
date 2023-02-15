import java.util.Scanner;

public class Fibbonacci{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter length of series");
		int n = sc.nextInt();

		for(int i=1; i<=n; i++){
			System.out.print(fibbo(i) + " ");
		}
	}
	static int fibbo(int n){
		if(n==1 || n==2){
			return n-1;
		}
		return fibbo(n-1) + fibbo(n-2);
	}
}
