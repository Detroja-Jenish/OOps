import java.util.Scanner;

abstract class Vegetable{
	String name;
	String color;
	public String toString(){
		return "name of vegetable : " + name + "\nColor of vegetable : " + color;
	}
}

class Potato extends Vegetable{
	Potato(String name, String color){
		this.name = name;
		this.color = color;
	}

}
class Brinjal extends Vegetable{
	Brinjal(String name, String color){
		this.name = name;
		this.color = color;
	}

	public String toString(){
		return "name of vegetable : " + name + "\nColor of vegetable : " + color;
	}
}
class Tomato extends Vegetable{
	Tomato(String name, String color){
		this.name = name;
		this.color = color;
	}

	public String toString(){
		return "name of vegetable : " + name + "\nColor of vegetable : " + color;
	}
}

public class abstractDemo{
	public static void main(String[] args){
		Potato p = new Potato("potato","cream");
		Tomato t = new Tomato("tomato", "red");
		Vegetable b = new Brinjal("brinjal", "purple");
		Vegetable v = new Vegetable();
		System.out.println(p);
		System.out.println(t);
		System.out.println(b);

	}
}
