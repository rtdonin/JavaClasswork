/*
Created by: Margaret Donin
Date created: 04/27/20
Date revised:
Model a car as if the class were to be part of a video game.
*/

package ClassModeling.Car;

public class Car1{
    private int color; // in hexidecimal
    private Engine engine;
    private int speed;
    private char direction;

    public Car1(int color, Engine engine, int speed) {
        this.color = color;
        this.engine = engine;
        this.speed = speed;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }
    
    public void vroom(int speed, char direction){
        System.out.println("Vroom! Vroom! You're going at " + speed + " mph in the "
                + direction + "!");
    }
}