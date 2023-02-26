import java.util.Scanner;

public class StudentDemo2{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of student's  : " );
		Student.count = sc.nextInt();

		Student students[] = new Student[ Student.count ];

		for(int i=0; i<Student.count; i++){
			students[i] = new Student();
		}
		for(int i=0; i<Student.count; i++){
			students[i].display();
		}
	}
}

class Student{

	static int count = 0;
	String enrollmentNo;
	String name;
	String gender;
	int marks;

	Student(){
		Scanner sc = new Scanner(System.in);

		System.out.print("Name : ");
		name = sc.nextLine();

		System.out.print("enter 1 : male and 0 : female __ : ");
		int genderId = sc.nextInt();
		switch(genderId){
			case 1:
				gender = "male";
				break;
			case 0:
				gender = "female";
				break;
		}

		System.out.print("enrollmentNo : ");
		enrollmentNo = sc.next();

		System.out.print("mid exam's marks : ");
		marks = sc.nextInt();
	}

	void display(){
		System.out.println("\n\n\n");
		System.out.println("Number of Students : " + count);
		System.out.println("Name : " + name);
		System.out.println("gender : " + gender);
		System.out.println("enrollmentNo : " + enrollmentNo);
		System.out.println("mid exam's marks : " + marks);
	}
}
