/*
Created by: Margaret Donin
Date created: 04/27/20
Date revised:
Model ice cream as if the class were to be part of the control system at the dairy that makes the ice cream.
*/

package ClassModeling.IceCream;

public class IceCream0{
    private String baseFlavor;
    private float kgOfSugar;
    private float litersOfCream;
    private String[] mixIns;
    private int eggYolks;
    private int gramsOfSalt;

    public IceCream0(String baseFlavor, float kgOfSugar, float litersOfCream, String[] mixIns, int eggYolks, int gramsOfSalt) {
        this.baseFlavor = baseFlavor;
        this.kgOfSugar = kgOfSugar;
        this.litersOfCream = litersOfCream;
        this.mixIns = mixIns;
        this.eggYolks = eggYolks;
        this.gramsOfSalt = gramsOfSalt;
    }

    public String getBaseFlavor() {
        return baseFlavor;
    }

    public void setBaseFlavor(String baseFlavor) {
        this.baseFlavor = baseFlavor;
    }

    public float getKgOfSugar() {
        return kgOfSugar;
    }

    public void setKgOfSugar(float kgOfSugar) {
        this.kgOfSugar = kgOfSugar;
    }

    public float getLitersOfCream() {
        return litersOfCream;
    }

    public void setLitersOfCream(float litersOfCream) {
        this.litersOfCream = litersOfCream;
    }

    public String[] getMixIns() {
        return mixIns;
    }

    public void setMixIns(String[] mixIns) {
        this.mixIns = mixIns;
    }

    public int getEggYolks() {
        return eggYolks;
    }

    public void setEggYolks(int eggYolks) {
        this.eggYolks = eggYolks;
    }

    public int getGramsOfSalt() {
        return gramsOfSalt;
    }

    public void setGramsOfSalt(int gramsOfSalt) {
        this.gramsOfSalt = gramsOfSalt;
    }

    public void flavor(String baseFlavor, String[] mixIns){
        System.out.print(baseFlavor + " with");
        for(String ingredient : mixIns){
            System.out.println(ingredient + " ");
        }
    }
}