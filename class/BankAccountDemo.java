import java.util.Scanner;

public class BankAccountDemo{
	public static void main(String args[]){
		BankAccount a1 = new BankAccount();
		BankAccount a2 = new BankAccount();

		a1.getAccountDetails();
		a2.getAccountDetails();

		a1.displayAccountDetails();
		a2.displayAccountDetails();
	}
}

class BankAccount{
	int accountNo;
	String userName;
	String email;
	String accountType;
	int accountBalance;

	void getAccountDetails(){
		Scanner sc = new Scanner(System.in);

		System.out.println("\n\n");

		System.out.print("Enter User Name : ");
		userName = sc.nextLine();

		System.out.print("Enter accountNo : ");
		accountNo = sc.nextInt();

		System.out.print("Enter accountType (1) saving, (2) current, (3) student : " );
		int choice = sc.nextInt();

		switch(choice){
			case 1:
				accountType = "saving";
				break;
			
			case 2:
				accountType = "cuurent";
				break;

			case 3:
				accountType = "student";
				break;
		}

		System.out.print("Enter email : ");
		email = sc.next();

		System.out.print("Enter balance : ");
		accountBalance = sc.nextInt();
	}	 

	void displayAccountDetails(){
		System.out.print("\n\n"+ userName + "'s account details : \n" + "accountNo : " + accountNo + "\nemail : " + email + "\naccountType : " + accountType + "\naccountBalance : " + accountBalance);
	}

}	
