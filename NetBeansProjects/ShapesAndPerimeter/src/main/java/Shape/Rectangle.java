/*
Created by: Margaret Donin
Date created: 04/30/20
Date revised:
*/

public class Rectangle extends Shape{
    private int length;
    private int width;
    private int perimeter;
    private int area;

    public Square(int length, int width) {
        this.length = length;
        this.width = width;
    }
    
    public void setPerimeter() {
        this.perimeter = 2 * (length + width);
    }
    
    @Override
    public int getPerimeter() {
        return perimeter;
    }

    public void setArea() {
        this.area = length * width;
    }

    @Override
    public int getArea() {
        return area;
    }
}