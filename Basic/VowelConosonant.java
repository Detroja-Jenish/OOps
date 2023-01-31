import java.util.Scanner;

public class  VowelConosonant{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter any alphabet character... : ");
		char chr = sc.next().charAt(0);

		if(chr == 'a' || chr == 'A' || chr == 'e' || chr == 'E' || chr == 'i' || chr == 'I' || chr == 'o' || chr == 'O' || chr == 'u' || chr == 'U'){

			System.out.println(chr + " is vowel");
		}else if((chr >= 'A' && chr <= 'Z') || (chr >='a' && chr <= 'z')){
			System.out.print(chr + " is consonant ");
		}else{
			System.out.print("Enter charector is not an english alphabet.");
		}
	}
}
