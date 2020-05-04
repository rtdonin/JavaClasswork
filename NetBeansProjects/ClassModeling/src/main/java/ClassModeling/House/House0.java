/*
Created by: Margaret Donin
Date created: 04/27/20
Date revised:
Model a house as if the class were to be part of a GPS mapping system.
*/

package ClassModeling.House;

class House0{
    private double latitude;
    private double longitude;
    private Address address;

    public House0(double latitude, double longitude, Address address) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    public double getLatitude(){
        return latitude;
    }
    
    public void setLatitude(double latitude){
        this.latitude = latitude;
    }
    
    public double getLongitude(){
        return longitude;
    }
    
    public void setLongitude(double longitude){
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "House address is at " + address;
    }
    
    
}