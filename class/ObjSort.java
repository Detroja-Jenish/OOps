import java.util.Scanner;

public class ObjSort{
	public static void main(String args[]){
		Student s[] = new Student[6];
		for(int i = 0; i<6; i++){
			s[i] = new Student();
		}
	}
}

class Student{
	int spi;
	String name;

	Student(){
		Scanner sc =new Scanner(System.in);

		System.out.print("Enter name : ");
		name = sc.next();
		System.out.print("Enter spi : ");
		spi = sc.nextInt();
	}

	void display(){
		System.out.println(name + " : " + spi);
	}
}
