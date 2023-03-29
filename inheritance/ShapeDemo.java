import java.util.*;
public class ShapeDemo
{
    public static void main(String[] args)
    {
        Circle c1= new Circle(1);
        c1.getArea();
        c1.getPerimeter();

        Square s1 = new Square(2);
        s1.getArea();
    }
}
class Shape
{
    double area;
    double perimeter;

    void setArea(double area){
        this.area = area;
    }
    void getArea(){
        System.out.println("area= "+ area);
    }

    void setPerimeter(double perimeter)
    {
        this.perimeter=perimeter;
    }

    void getPerimeter(){
        System.out.println("perimeter= "+ perimeter);
    }
}
    

class Circle extends Shape
{
    double redious;
    Circle(double redious)
    {
        this.redious=redious;
        setArea( calcArea() );
        setPerimeter( calcPerimetre() );
        double area =
        super.setArea(area);
        double perimeter = 2 * Math.PI * redious;
        super.setPerimeter(perimeter);
    }

    double calcArea(){
        return Math.PI * redious * redious;
    }
    double calcPerimetre(){
        return 2 * Math.PI * redious;
    }

}

class Square extends Shape{
    double a;
    Square(double a)
    {
        this.a=a;
        setArea( calcArea() );
        setPerimeter( calcPerimetre() );
    }

    double calcArea(){
        return a * a;
    }
    double calcPerimetre(){
        return  4*a;
    }
}

class Triangle extends Shape{
    double l1;
    double l2;
    double l3;

    Triangle(double l1, double l2, double l3;){
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
        setArea( calcArea() );
        setPerimeter( calcPerimetre() );
    }

    double calcArea(){
        double s = (l1 + l2 + l3)/2;
        return Math.sqrt( s * (s - l1) * (s - l2) * (s - l3) );
    }
    double calcPerimetre(){
        return  (l1 + l2 + l3);
    }
}