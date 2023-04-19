public class abstractDemo2{
	public static void main(String args[]){
		EventDemo ed = new EventDemo();
		ed.callAll();
	}
}

interface EventListner{
	void performEvent();
}

interface MouseListener extends EventListner{
	void mouseClicked();
	void mousePressed();
	void mouseReleased();
	void mouseMoved();
	void mouseDragged();
}

interface KeyListener extends EventListner{
	void keyPressed();
	void keyReleased();
}

class EventDemo implements MouseListener, KeyListener{
public	void performEvent(){ System.out.println("performEvent");}
public	void mouseClicked(){System.out.println("mouseClicked");}
public	void mousePressed(){System.out.println("mousePressed");}
public	void mouseReleased(){System.out.println("mouseReleased");}
public	void mouseMoved(){System.out.println("mouseMoved");}
public	void mouseDragged(){System.out.println("mouseDragged");}
public	void keyPressed(){System.out.println("keyPressed");}
public	void keyReleased(){System.out.println("keyReleased");}

	void callAll(){
		performEvent();
		mouseClicked();
		mousePressed();
		mouseReleased();
		mouseMoved();
		mouseDragged();
		keyPressed();
		keyReleased();
	}
}
