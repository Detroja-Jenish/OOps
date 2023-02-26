import java.util.Scanner;

public class Complex{
	public static void main(String[] args){
		ComplexNumber a = new ComplexNumber();
		ComplexNumber b = new ComplexNumber(3,7);
		ComplexNumber c = a.add( b );

		a.print();
		b.print();
		c.print();
	}
}

class ComplexNumber{
	int realPart;
	int imaginaryPart;

	ComplexNumber(){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter real part of Complex Number : ");
		realPart = sc.nextInt();
		
		System.out.print("Enter imaginary part of Complex Number : ");
		imaginaryPart = sc.nextInt();
	}

	ComplexNumber(int realPart, int imaginaryPart){
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}

	void print(){
		System.out.println( realPart + " + " + imaginaryPart + "i");

	}

	ComplexNumber add(ComplexNumber p){
		ComplexNumber q = new ComplexNumber(this.realPart + p.realPart, this.imaginaryPart + p.imaginaryPart);
		return q;
	}
}
