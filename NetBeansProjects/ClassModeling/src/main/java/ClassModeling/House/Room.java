/*
Created by: Margaret Donin
Date created: 04/27/20
Date revised:
*/

package ClassModeling.House;

class Room{
    private String purpose;
    private int windows;
    private double squareFootage;

    public Room(String purpose, int windows, double squareFootage) {
        this.purpose = purpose;
        this.windows = windows;
        this.squareFootage = squareFootage;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public int getWindows() {
        return windows;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public double getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(double squareFootage) {
        this.squareFootage = squareFootage;
    }
}



    