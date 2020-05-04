/*
Created by: Margaret Donin
Date created: 04/27/20
Date revised:
Model an airplane as if the class were to be part of a flight simulator.
*/

package ClassModeling.Airplane;

class Airplane1{
    private Airplane airplane;
    private float altitude;
    private float speed;
    private char direction;

    public Airplane1(Airplane airplane, float altitude, float speed, char direction) {
        this.airplane = airplane;
        this.altitude = altitude;
        this.speed = speed;
        this.direction = direction;
    }
    
    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }
    
    public boolean stillFlying(float altitude){
        boolean flying = altitude > 0;
        return flying;
    }
}