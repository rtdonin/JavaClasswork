/*
Created by: Margaret Donin
Date created:
Date revised:
*/

package M2.Agile.AddressBook.ui;

import M2.Agile.AddressBook.dto.Address;
import M2.ListsAndMaps.UserIOClassLab.UserIO;
import java.util.List;

public class AddressBookView {

    private UserIO io;
    
    public AddressBookView(UserIO io) {
        this.io = io;
    }

    public int displayGetMenu() {
        io.print("Main Menu");
        io.print("1. List all addresses");
        io.print("2. Add address");
        io.print("3. View address");
        io.print("4. Delete an address");
        io.print("5. Edit an address");
        io.print("6. Total number of addresses");
        io.print("7. Exit");
        
        return io.readInt("Please choose one of the above options.", 1, 7);
    }
    
    public void displayCreateAddressBanner() {
        io.print("CREATING NEW ADDRESS");
    }
    
    public Address getNewAddressInfo() {
        String firstName = io.readString("Please enter the first name:");
        String lastName = io.readString("Please enter the last name:");
        String streetAddress = io.readString("Please enter the street address:");
        String city = io.readString("Please enter a city:");
        String state = io.readString("Please enter a state:");
        String zip = io.readString("Please enter a zip code:");
        
        Address address = new Address(firstName, lastName, streetAddress);
        
        address.setCity(city);
        address.setState(state);
        address.setZip(zip);
        
        return address;
    }

    public void displayCreateAddressSuccessBanner() {
        io.print("NEW ADDRESS CREATED SUCCESSFULLY");
        io.readString("Please hit enter to continue.");
    }

    public void displayAllAddresses(List<Address> allAddresses) {
        io.print("Listing all addresses:");
        
        for (Address a : allAddresses){
            io.print(a.getLastName() + " " + a.getFirstName() + " " + a.getStreetAddress());
        }
        
        io.readString("Please hit enter to continue.");
    }

    public String getFirstName() {
        return io.readString("Please enter a first name:");
    }

    public String getLastName() {
        return io.readString("Please enter a last name:");
    }

    public void displayAddress(Address address) {
        io.print(address.getLastName() + ", " + address.getFirstName());
        io.print(address.getStreetAddress());
        io.print(address.getCity() + ", " + address.getState() + address.getZip());
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveAddressBanner() {
        io.print("DELETE AN ADDRESS");
    }

    public void displayRemoveAddressSuccessBanner(Address address) {
        io.print("DELETED ADDRESS SUCCESSFULLY");
        io.print(address.getLastName() + ", " + address.getFirstName());
        io.print(address.getStreetAddress());
        io.print(address.getCity() + ", " + address.getState() + address.getZip());
        
        io.readString("Please hit enter to continue");
    }

    public void editAddressBanner() {
        io.print("EDIT AN ADDRESS");
    }

    public int displayGetEditMenu() {
        io.print("Edit Menu");
        io.print("1. Edit first name");
        io.print("2. Edit last name");
        io.print("3. Edit street address");
        io.print("4. Edit city");
        io.print("5. Edit state");
        io.print("6. Edit zip code");
        io.print("7. Exit edit menu");
        
        return io.readInt("Please choose one of the above options.", 1, 7);
    }
    
    public String editAddress(String edit, String org) {
        return io.readString("Please enter the new " + edit + " (" + org + "):");
    }

    public void editAddressSuccessBanner() {
        io.print("EDIT ADDRESS SUCCESS");
        io.readString("Please hit enter to continue.");
    }

    public void displayGettingNumberOfAddressesBannner() {
        io.print("Getting the total number of addresses.");
    }

    public void displayTotalNumberOfAddresses(int total) {
        io.print("There are " + total + " number of addresses.");
        io.readString("Please hit enter to continue.");
    }

}
