import java.util.Scanner;

public class StudentDemo{
	public static void main(String args[]){
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();

		s1.display();
		s2.display();
//		s3.dispaly();
		System.out.print(Student.count + " " );
	}
}

class Student{

	static int count = 0;
	String enrollmentNo;
	String name;
	String gender;
	int marks;

	Student(){
		count++;
		Scanner sc = new Scanner(System.in);

		System.out.println("\n\n\nEnter student-" + count + "'s details");
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
