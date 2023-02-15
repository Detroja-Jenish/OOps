import java.util.Scanner;
public class Prime{
	public static void main(String args[]){
		Scanner sc = new Scanner (System.in);
		System.out.print("Enter a number : ");
		int n = sc.nextInt();

		if(isPrime(n)==1){ 
			System.out.print("number is prime " );
		}else{
			System.out.print("number is not prime ");
		}
	}

	static int isPrime(int n){
		for(int i = 2; i<n/2; i++){
			if(n%i == 0){
				return 0;
			}
		}
		return 1;
	}
}
