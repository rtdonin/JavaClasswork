/*
Created by: Margaret Donin
Date created: 04/27/20
Date revised:
Model a car as if the class were to be part of an inventory system for a car dealership.
*/

package ClassModeling.Car;

class Car0{
    private String plate;
    private String manufactorer;
    private int year;
    private int color; // in hexidecimal
    private boolean preOwned; // can't call it "new"
    private Engine engine;

    public Car0(String plate, String manufactorer, int year, int color, boolean preOwned, Engine engine) {
        this.plate = plate;
        this.manufactorer = manufactorer;
        this.year = year;
        this.color = color;
        this.preOwned = preOwned;
        this.engine = engine;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getManufactorer() {
        return manufactorer;
    }

    public void setManufactorer(String manufactorer) {
        this.manufactorer = manufactorer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isPreOwned() {
        return preOwned;
    }

    public void setPreOwned(boolean preOwned) {
        this.preOwned = preOwned;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return year + " " + color + " " + manufactorer + " with a " + engine + " engine";
    }    
}