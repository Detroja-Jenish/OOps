import java.util.Scanner;

public class CandidateDemo{
	public static void main(String args[]){
		Candidate c1 = new Candidate();
		Candidate c2 = new Candidate();

		c1.getCandidateDetails();
		c2.getCandidateDetails();

		c1.displayCandidateDetails();
		c2.displayCandidateDetails();
	}
}

class Candidate{
	String Candidate_ID;
	String Candidate_Name;
	int Candidate_Age;
	float Candidate_Weight;
	float Candidate_Height;

	void getCandidateDetails(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n\n");

		System.out.print("Enter Candidate_Name : ");
		Candidate_Name = sc.nextLine();

		System.out.print("Enter Candidate_ID : " );
		Candidate_ID = sc.next();

		System.out.print("Enter Candidate_Age : ");
		Candidate_Age = sc.nextInt();

		System.out.print("Enter Candidate_Weight : ");
		Candidate_Weight = sc.nextFloat();

		System.out.print("Enter Candidate_Height : ");
		Candidate_Height = sc.nextFloat();
	}

	void displayCandidateDetails(){
		System.out.print("\n\n\n");
		System.out.println("Candidate_Name : " + Candidate_Name);
		System.out.println("Candidate_ID : " + Candidate_ID );
		System.out.println("Candidate_Age : " + Candidate_Age);
		System.out.println("Candidate_Weight : " + Candidate_Weight + " Kg");
		System.out.println("Candidate_Height : " + Candidate_Height + " feet");  
	}
}
