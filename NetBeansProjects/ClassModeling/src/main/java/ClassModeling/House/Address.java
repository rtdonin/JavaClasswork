/*
Created by: Margaret Donin
Date created: 04/27/20
Date revised:
*/

package ClassModeling.House;

class Address{
    private String street;
    private int streetNumber;
    private int zipCode;

    public Address(String street, int streetNumber, int zipCode) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.zipCode = zipCode;
    }
    
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return streetNumber + " " + street + " " + zipCode;
    }
    
    
}