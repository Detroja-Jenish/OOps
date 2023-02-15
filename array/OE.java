import java.util.Scanner;

public class OE{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int odd = 0;
		int even = 0;
		System.out.print("Enter size of array :");
		int n = sc. nextInt();
		int num[] = new int[n];

		for(int i = 0; i<n; i++){
			num[i] = sc.nextInt();
		}
		for(int i = 0; i<n; i++){
			if(num[i]%2 == 0){
				even++;
			}
			else{
				odd++;
			}
		}
		System.out.println("odd numbers : "+odd);
		System.out.println("even numbers : "+even);
	}
}
