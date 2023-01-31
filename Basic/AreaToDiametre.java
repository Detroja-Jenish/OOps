import java.util.Scanner;

public class AreaToDiametre{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter area of circle : ");
		float area = sc.nextFloat();
		float d2 = (4.0f*area)/3.14f;
		float d = (float) Math.sqrt(d2);	
		System.out.println("/nDiameter of circle = " + d);
	}
}
