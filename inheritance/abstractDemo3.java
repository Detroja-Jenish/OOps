public class abstractDemo3{
	public static void main(String args[]){
		Animal a[] = new Animal[4];
		a[0] = new Tiger();
		a[1] = new Camel();
		a[2] = new Deer();
		a[3] = new Donkey();

		for(int i=0; i<4; i++){
			if( a[i] instanceof Transport && a[i] instanceof Camel){
				((Camel)a[i]).deliver();
			}else if( a[i] instanceof Transport && a[i] instanceof Donkey){
				((Donkey)a[i]).deliver();
			}else{
				System.out.println("not implemented transport interface\n");
			}
		}

	}
}

interface Transport{
	void deliver();
}

abstract class Animal{
}

class Tiger extends Animal{
}

class Camel extends Animal implements Transport{
	public void deliver(){
		System.out.println("implemented deliver method in camel class\n");
	}
}

class Deer extends Animal{
}

class Donkey extends Animal implements Transport{
	public void deliver(){
		System.out.println("implemented deliver method in donkey class\n");
	}
}
