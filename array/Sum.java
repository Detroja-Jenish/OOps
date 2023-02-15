import java.util.Scanner;

public class sum{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		System.out.print("Enter size of array :");
		int n = sc. nextInt();
		int num[] = new int[n];

		for(int i = 0; i<n; i++){
			num[i] = sc.nextInt();
		}
		for(int i = 0; i<n; i++){
			if(num[i]%3 == 0 || num[i]%5 == 0){
				sum += num[i];
			}
		}
		System.out.println("sum = "+sum);
	}
}
