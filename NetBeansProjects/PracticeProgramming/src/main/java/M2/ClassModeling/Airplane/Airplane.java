/*
Created by: Margaret Donin
Date created: 04/27/20
Date revised:
Model a house as if the class were to be part of a 3-D design system.
*/

package M2.ClassModeling.Airplane;

class Airplane{
    private int numberOfEngines;
    private float gallonsHas;
    private float gallonsMax;
    private float gallonsNeeded;
    private int nummberOfPassengers;

    public Airplane(int numberOfEngines, float gallonsHas, float gallonsMax, int nummberOfPassengers) {
        this.numberOfEngines = numberOfEngines;
        this.gallonsHas = gallonsHas;
        this.gallonsMax = gallonsMax;
        this.nummberOfPassengers = nummberOfPassengers;
    }

    public int getNumberOfEngines() {
        return numberOfEngines;
    }

    public void setNumberOfEngines(int numberOfEngines) {
        this.numberOfEngines = numberOfEngines;
    }

    public float getGallonsHas() {
        return gallonsHas;
    }

    public void setGallonsHas(float gallonsHas) {
        this.gallonsHas = gallonsHas;
    }

    public float getMaxGallons() {
        return gallonsMax;
    }

    public void setMaxGallons(float gallonsMax) {
        this.gallonsMax = gallonsMax;
    }

    public float getGallonsNeeded(float gallonsMax, float gallonsHas){
         return gallonsNeeded;
    }
    
    public void setGallonsNeeded(float gallonsNeeded) {
        this.gallonsNeeded = gallonsNeeded;
    }

    public int getNummberOfPassengers() {
        return nummberOfPassengers;
    }

    public void setNummberOfPassengers(int nummberOfPassengers) {
        this.nummberOfPassengers = nummberOfPassengers;
    }
}