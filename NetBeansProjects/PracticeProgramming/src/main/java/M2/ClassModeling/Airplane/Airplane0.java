/*
Created by: Margaret Donin
Date created: 04/27/20
Date revised:
Model an airplane as if the class were to be part of an air traffic control system.
*/

package M2.ClassModeling.Airplane;

class Airplane0{
    private char gate;
    private int runway;
    private int departureTime;
    private int arrivalTime;
    private int delay;
    private Airplane airplane;

    public Airplane0(char gate, int runway, int departureTime, int arrivalTime, int delay, Airplane airplane) {
        this.gate = gate;
        this.runway = runway;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.delay = delay;
        this.airplane = airplane;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public char getGate() {
        return gate;
    }

    public void setGate(char gate) {
        this.gate = gate;
    }

    public int getRunway() {
        return runway;
    }

    public void setRunway(int runway) {
        this.runway = runway;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
    
    public boolean makeOriginalDepartureTime(int arrivalTime, int delay, int departureTime){
        boolean makeTime = departureTime >= arrivalTime + delay;
        return makeTime;
    }
}