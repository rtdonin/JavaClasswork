package M2.AbstractClass.Shape;

/*
Created by: Margaret Donin
Date created: 04/30/20
Date revised:
*/

public class Rectangle extends Shape{
    private double length;
    private double width;
    private double perimeter;
    private double area;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    public void setPerimeter() {
        this.perimeter = 2 * (length + width);
    }
    
    @Override
    public double getPerimeter() {
        return perimeter;
    }

    public void setArea() {
        this.area = length * width;
    }

    @Override
    public double getArea() {
        return area;
    }
}