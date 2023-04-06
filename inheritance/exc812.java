import java.util.Scanner;

public class exc812{
	public static void main(String[] args){
	//	System.out.println(" Person Object");
	//	Person p = new Person();
	//	p.getDetails();

	//	System.out.println("Employee Object");
	//	Employee e = new Employee();
	//	e.getDetails();

	//	System.out.println("Teacher Object");
	//	Teacher t = new Teacher();
	//	t.getDetails();

	//	System.out.println("\n\nDetails of Person");
	//	p.displayDetails();
	//	System.out.println("\n\nDetails of Emplyoee");
	//	e.displayDetails();
	//	System.out.println("\n\nDetails of Teacher");
	//	t.displayDetails();
	
		int n;
		Scanner sc = new Scanner( System.in );
		System.out.print( "Enter n : ");
		n = sc.nextInt();
		Teacher teachers[] = new Teacher[n];
		for(int i=0; i<n; i++){
			teachers[i] = new Teacher();
			teachers[i].getDetails();
		}
		for(int i=0; i<n; i++){
			teachers[i].displayDetails();
		}
	}
}

class Person{
	int pid;
	String name;
	int age;
	Scanner sc = new Scanner( System.in );
	 void getDetails(){
		 System.out.print("Enter PersonID : ");
		 pid = sc.nextInt();
		 System.out.print("Enter name : ");
		 name = sc.next();
		 System.out.print("Enter age : ");
		 age = sc.nextInt();
	 }

	 void displayDetails(){
		 System.out.print("\nPersonId = "+pid+"\nname = "+name+"\nage = "+age);
	 }
}

class Employee extends Person{
	int eid;
	long salary;
	String designation;

	void getDetails(){
		super.getDetails();
		System.out.print("\nEnter EmployeeId : ");
		eid = sc.nextInt();
		System.out.print("Enter salary : ");
		salary = sc.nextLong();
		System.out.print("Enter designation : ");
		designation = sc.next();
	
	}

	void displayDetails(){
		 super.displayDetails();
		 System.out.print("\nEmployeeId = "+eid+"\nsalary = "+salary+"\ndesignation = "+designation);
	}
}

class Teacher extends Employee{
	int tid;
	int exp;
	String subject;

	void getDetails(){
		super.getDetails();
		System.out.print("\nEnter TeacherId : ");
		tid = sc.nextInt();
		System.out.print("Enter experience : ");
		exp = sc.nextInt();
		System.out.print("Enter subject : ");
		subject = sc.next();
	}

	void displayDetails(){
		super.displayDetails();
		System.out.print("\nTeacherId = "+tid+"\nexpirence = "+exp+"\nsubject = "+subject);
	}
}



