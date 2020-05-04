/*
Created by: Margaret Donin
Date created: 04/27/20
Date revised:
Model a house as if the class were to be part of a 3-D design system.
*/

package M2.ClassModeling.House;

class House1{
    private double height;
    private double width;
    private double length;
    private Room[] room;

    public House1(double height, double width, double length, Room[] room) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.room = room;
    }

    public Room[] getRoom() {
        return room;
    }

    public void setRoom(Room[] room) {
        this.room = room;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    
    public void numberOfRooms(){
        System.out.println("There are " + room.length + "rooms!");
    }
}