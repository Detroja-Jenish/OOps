import java.util.*;
public class TaskAttendence{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Class D = new Class(sc);
		D.takeAttendence(sc);
		D.showAbesentStudent();
	}
}

class Class{
    
    private int classNo;
    private int isPresent[];
    private int noOfStudents;
    Class(Scanner sc){
        
        System.out.print("enter A = 1, B = 2, C = 3, D = 4 , H = 5 : ");
        classNo = sc.nextInt();
        System.out.println("enter number of students");
        noOfStudents = sc.nextInt();
        isPresent = new int[noOfStudents]
       
    }
    void takeAttendence(Scanner sc){
        for(int i=0; i<6; i++){
            System.out.print((i+1) + " : ");
            isPresent[i] = sc.nextInt();
        }
    }
    void showAbesentStudent(){
        for(int i = 0; i<6; i++){
            if(isPresent[i] == 0){
                System.out.println(((i+1) +(100*classNo)));
            }
        }
    }
    
}