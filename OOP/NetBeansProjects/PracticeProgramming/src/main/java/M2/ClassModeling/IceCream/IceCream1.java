/*
Created by: Margaret Donin
Date created: 04/27/20
Date revised:
Model ice cream as if the class were to be part of the stocking system
at a grocery store.
*/

package M2.ClassModeling.IceCream;

public class IceCream1{
    private long barcode;
    private String brand;
    private String name;
    private String flavor;
    private float price;

    public IceCream1(long barcode, String brand, String name, String flavor, float price) {
        this.barcode = barcode;
        this.brand = brand;
        this.name = name;
        this.flavor = flavor;
        this.price = price;
    }

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return brand + "'s " + name + " " + flavor + " icecream for $" + price;
    }  
}