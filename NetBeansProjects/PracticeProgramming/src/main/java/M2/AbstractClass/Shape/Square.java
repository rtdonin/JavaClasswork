package M2.AbstractClass.Shape;

/*
Created by: Margaret Donin
Date created: 04/30/20
Date revised:
*/

public class Square extends Shape{
    private double side;
    private double perimeter;
    private double area;

    public Square(double side) {
        this.side = side;
    }
    
    protected void setPerimeter() {
        this.perimeter = 4 * side;
    }
    
    @Override
    protected double getPerimeter() {
        return perimeter;
    }

    protected void setArea() {
        this.area = side * side;
    }

    @Override
    protected double getArea() {
        return area;
    }
}