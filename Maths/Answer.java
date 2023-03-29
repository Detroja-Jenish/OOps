public class Answer{
	public static void main(String ars[]){
		Euler e1 = new Euler(0, 1, 0.05,5, 0.2 );
		System.out.println(e1.answer());
	}
}

class Question{
	double X0;
	double Y0;
	double h;
	double n;
	double X;
	double x,y; // dummy use
	Question(double X0, double Y0, double h, double n, double X){
		this.X0 = X0;
		this.Y0 = Y0;
		this.h = h;
		this.n = n;
		this.X = X;
		this.x = X0;
		this.y = Y0;
	}

	double function(double x, double y){
		return x + y;
	}
}

class Euler extends Question{

	Euler(double X0, double Y0, double h, double n, double X){
		super(X0, Y0, h, n, X);
	}
	double answer(){
		while( x < X ){
			y = y + ( h * function(x,y));
			x = x + h;
		}
		return y;
	}
}
