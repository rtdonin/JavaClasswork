package M2.AbstractClass.Shape;

/*
Created by: Margaret Donin
Date created: 04/30/20
Date revised:
*/

public abstract class Shape {
    public String color;

    public abstract int getPerimeter();
    public abstract int getArea();
    
}


/*
    The abstract base class — Shape —
    will have a property called color and the two methods
    getArea() and getPerimeter(), but they will be empty.

    They are designed to be overridden by inherited shapes,
    so make sure that any shape that inherits from the
    base class implements their own versions of getArea()
    and getPerimeter() based on the type of shape it is.

    It is suggested you start with a square because this
    should be the easiest to implement.

    Create a Shape base class, inherit a square from it,
    and override the two methods.

    If you have done this correctly, it should
    give you the idea for the others.
*/