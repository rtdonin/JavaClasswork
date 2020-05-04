package M2.AbstractClass.Shape;

/*
Created by: Margaret Donin
Date created: 04/30/20
Date revised:
*/

public class Square extends Shape{
    private int side;
    private int perimeter;
    private int area;

    public Square(int side) {
        this.side = side;
    }
    
    protected void setPerimeter() {
        this.perimeter = 4 * side;
    }
    
    @Override
    protected int getPerimeter() {
        return perimeter;
    }

    protected void setArea() {
        this.area = side * side;
    }

    @Override
    protected int getArea() {
        return area;
    }
}