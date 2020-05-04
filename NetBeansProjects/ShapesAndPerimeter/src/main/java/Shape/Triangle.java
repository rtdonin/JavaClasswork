/*
Created by: Margaret Donin
Date created: 04/30/20
Date revised:
*/

public class Triangle extends Shape{
    private int sideA;
    private int sideB;
    private int angleC;
    private double perimeter;
    private double area;

    public Triangle(int sideA, int sideB, int angleC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.angleC = angleC;
    }
    
    // Law of Cosine was used.
    protected void setPerimeter() {
        this.perimeter = sideA + sideB + Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2) - 2 * sideA * sideB * Math.cos(angleC)
        );
    }
    
    @Override
    protected double getPerimeter() {
        return perimeter;
    }

    // Basic Trig for the Area of a triangle, used to minimize the variables we need from user.
    protected void setArea() {
        this.area = (0.5) * sideA * sideB * Math.sin(angleC);
    }

    @Override
    protected double getArea() {
        return area;
    }
}