/*
Created by: Margaret Donin
Date created:  05/08/20
Date revised:
*/

package M2.DataMarshalingAndUnmarshaling.StateCapitals3;

public class Capital{
    private String name;
    private int population;
    private float squareMileage;

    public Capital(String name, int population, float squareMileage) {
        this.name = name;
        this.population = population;
        this.squareMileage = squareMileage;
    }

    public int getPopulation() {
        return population;
    }

    public float getSquareMileage() {
        return squareMileage;
    }
    
    public void getCapitalData(){
        System.out.println(" - " + name + " | Pop: " + population
                + " | Area: " + squareMileage + " sq mi");
    }
    
    
}


