/*
Created by: Margaret Donin
Date created:
Date revised:
*/

package M2.Agile.AddressBook.dao;

import M2.Agile.AddressBook.dto.Address;
import java.util.List;

public class AddressBookDaoImpl implements AddressBookDao {
    private List<Address> allAddresses;
    private final String DELIMITER = "::";
    private final String ADDRESS_FILE = "AddressBook.txt";
    
    @Override
    public void addAddress(Address newAddress) {
        loadFile();
        allAddresses.add(newAddress);
        writeFile();
    }

    @Override
    public List<Address> getAllAddresses() {
        loadFile();
        return allAddresses;
    }

    @Override
    public Address getAddress(String first, String last) {
        loadFile();
        Address theOne = findAddress(first, last);
        return theOne;
    }

    @Override
    public Address removeAddress(String first, String last) {
        loadFile();
        Address toRemove = findAddress(first, last);
        allAddresses.remove(toRemove);
        writeFile();
        return toRemove;
    }

    @Override
    public void editAddress(String first, String last, Address edit) {
        loadFile();
        Address old = findAddress(first, last);
        allAddresses.remove(old);
        allAddresses.add(edit);
        writeFile();
    }

    @Override
    public int getTotalNumber() {
        loadFile();
        return allAddresses.size();
    }

    private void loadFile() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void writeFile() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private Address findAddress(String first, String last) {
        Address address = new Address();
        
        for (Address a : allAddresses) {
            if (a.getLastName().equals(last) && a.getFirstName().equals(first)) {
                address = a;
            }
        }
        
        return address;
    }

}
