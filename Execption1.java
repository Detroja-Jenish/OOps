public class Execption1{
	public static void main(String args[]){
		Age jenish = new Age( 17 );
	//	try{
			jenish.vote();
		//}catch(Exception e){
		//	System.out.print(e);
		//}
	}
}

class Age{
	int age;
	Age(int age){
		this.age = age;
	}
	
	void vote() throws Exception{
			if(age >= 18){
				System.out.println("you are eligible");
			}else{
				throw new Exception("you are not eligible");
			}
	}
}

