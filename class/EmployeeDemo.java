import java.util.Scanner;

public class EmployeeDemo{
	public static void main(String args[]){
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		
		e1.getEmployeeDetails("12ab45", "Viral Chauhan", "Co-fonder", 18, 2000000000);
		e2.getEmployeeDetails();

		e1.displayEmpolyeeDetails();
		e2.displayEmpolyeeDetails();	
	}
}

class Employee{
	String employeeID;
	String employeeName;
	String designation;
	int age;
	int salary;

	void getEmployeeDetails(String employeeID, String employeeName, String designation, int age, int salary){
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.designation = designation;
		this.age = age;
		this.salary = salary;
	}

	void getEmployeeDetails(){
		Scanner sc = new Scanner(System.in);
		Scanner scInt = new Scanner(System.in);

		System.out.print("Enter employeeID : ");
		employeeID = sc.next();

		System.out.print("Enter employeeName : ");
		employeeName = sc.nextLine();

		System.out.print("Enter designation : ");
		designation = sc.next();

		System.out.print("Enter age : ");
		age = scInt.nextInt();

		System.out.print("Enter Salary : ");
		salary = scInt.nextInt();
	}

	void displayEmpolyeeDetails(){
		System.out.println("\n\nEmployee " + this.employeeName + "'s details" );
		System.out.println("employeeID : " + employeeID );
		System.out.println("designation : "+ designation);
		System.out.println("age : "+ age);
		System.out.println("salary : " + salary);
	}
}
