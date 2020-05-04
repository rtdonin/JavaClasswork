/*
Created by: Margaret Donin
Date created: 04/30/20
Date revised:
*/

public class Circle extends Shape{
    private int diameter;
    private double perimeter;
    private double area;

    public Circle(int diameter) {
        this.diameter = diameter;
    }
    
    protected void setPerimeter() {
        this.perimeter = diameter * Math.PI;
    }
    
    @Override
    protected double getPerimeter() {
        return perimeter;
    }

    protected void setArea() {
        this.area = Math.pow((diamter / 2), 2) * Math.PI;
    }

    @Override
    protected double getArea() {
        return area;
    }
}