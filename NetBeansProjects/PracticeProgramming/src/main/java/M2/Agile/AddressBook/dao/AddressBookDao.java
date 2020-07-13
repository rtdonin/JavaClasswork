/*
Created by: Margaret Donin
Date created:
Date revised:
*/

package M2.Agile.AddressBook.dao;

import M2.Agile.AddressBook.dto.Address;
import java.util.List;

public interface AddressBookDao {

    public void addAddress(Address newAddress);

    public List<Address> getAllAddresses();

    public Address getAddress(String first, String last);

    public Address removeAddress(String first, String last);

    public void editAddress(String first, String last, Address edit);

    public int getTotalNumber();

}
