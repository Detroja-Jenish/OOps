class ThisDemo{
	public static void main(String args[]){

		Box b1 = new Box();
		Box b2 = new Box();
		Box b3 = new Box();
		System.out.println("\ntotal box = "+b3.cnt);
		System.out.println("\ntotal box = "+b2.cnt);
		System.out.println("\ntotal box = "+b1.cnt);

	}
}

class Demo{
	static int a = 10;
	
}

class Box{
	static int cnt = 0;
	Box(){
		cnt++;
	}
}
