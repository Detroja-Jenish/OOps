import java.util.Scanner;

public class TimeDemo{
	public static void main(String args[]){
		Time t1 = new Time(14,30,40);
		t1.printTime();
		Time t2 = new Time(13,30,20);
		t2.printTime();
		Time t3 = t1.add(t2);
		t3.printTime();

		Scanner sc = new Scanner(System.in);

		System.out.println("\n\nObjects with array\n");
		int n =sc.nextInt();
		Time time[] = new Time[n];
		Time t = new Time(0,0,0);
		for(int i =0; i<n; i++){
			time[i] = new Time();
		}
		for(int i = 0; i<n; i++){
			t = t.add(time[i]);
		}
		t.printTime();
	}
}

class Time{
	int hour;
	int minute;
	int second;

	Time(){
		Scanner sc =new Scanner(System.in);
		System.out.print("hour : " );
		hour = sc.nextInt();
		System.out.print("minute : ");
		minute = sc.nextInt();
		System.out.print("second : ");
		second = sc.nextInt();
		System.out.println("\n");
	}

	Time(int hour, int minute, int second){
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	void printTime(){
		String time = String.format("time = %2d : %2d : %2d  in(hh:mm:ss).", hour, minute, second);
		System.out.println(time);
	}

	Time add(Time t){
		int hour = this.hour + t.hour;
		int minute = this.minute + t.minute;
		int second = this.second + t.second;

		if(second > 59){
			second -= 60;
			minute++;
		}
		if(minute > 59){
			minute -= 60;
			hour++;
		}
		if(hour > 23){
			hour = hour%24;
		}
		return new Time(hour, minute, second);
	}
}
