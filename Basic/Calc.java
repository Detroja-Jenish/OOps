import java.util.Scanner;

public class Calc{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		int ans = sc.nextInt();
		char operator = sc.next().charAt(0);
		int a = sc.nextInt();

		switch(operator){
			case '+':
				ans = ans + a;
				break;
			case '-':
				ans = ans - a;
				break;
			case '*':
				ans = ans*a;
				break;
			case '/':
				ans = ans/a;
				break;
		}

		System.out.print(ans);


	}
}
