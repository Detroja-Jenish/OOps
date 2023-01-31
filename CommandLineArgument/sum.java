public class sum{
	public static void main(String args[]){
		int num, sum = 0;
		for(int i=0; i<args.length; i++){
			num = Integer.parseInt(args[i]);
			sum += num;
		}
		System.out.println("total = " + sum);
	}
}
