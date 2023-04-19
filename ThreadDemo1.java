public class ThreadDemo1{
	public static void main(String[] args){
		MyThread mt1 = new MyThread("hello world");
		MyThread mt2 = new MyThread("bye........");
		mt1.thread.start();
		mt2.thread.start();
	}
}

class MyThread implements Runnable{
	Thread thread;
	String message;
	MyThread(String message){
		thread = new Thread(this);
		this.message = message;
	}

	@Override
	public void run(){
		for(long i=0; i<60; i++){
			System.out.println( message + "  :  " + i);
			try{
				Thread.sleep(1000);
			}catch( Exception e ){
				System.out.println(e);
			}
		}
	}
}

