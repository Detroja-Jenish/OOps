import java.util.Scanner;

public class Find{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of array :");
		int n = sc. nextInt();
		int num[] = new int[n];
		System.out.print("Enter elements of num");
		for(int i = 0; i<n; i++){
			num[i] = sc.nextInt();
		}
		System.out.print("Enetr Query : ");
		int q= sc.nextInt();
		for(int i = 0; i<n; i++){
			if(num[i] == q){
				System.out.println("FOund at "+( i+1));
			}
		}
	}
}
