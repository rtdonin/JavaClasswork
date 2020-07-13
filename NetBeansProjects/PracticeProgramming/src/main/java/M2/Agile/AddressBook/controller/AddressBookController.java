/*
Created by: Margaret Donin
/ate created: 07/02/20
D/ate revised:
*/

package M2.Agile.AddressBook.controller;

import M2.Agile.AddressBook.dao.AddressBookDao;
import M2.Agile.AddressBook.dto.Address;
import M2.Agile.AddressBook.ui.AddressBookView;
import java.util.List;

public class AddressBookController {

    private final AddressBookView view;
    private final AddressBookDao dao;
    
    public AddressBookController(AddressBookView view, AddressBookDao dao) {
        this.view = view;
        this.dao = dao;
    }

    public void run() {
        boolean keepGoing = true;
        
        while(keepGoing) {
            int menuSelection = view.displayGetMenu();
            
            switch(menuSelection){
                case 1: listAllAddress();
                    break;
                case 2: addAddress();
                    break;
                case 3: viewAddress();
                    break;
                case 4: deleteAddress();
                    break;
                case 5: editAddress();
                    break;
                case 6: numberOfAddress();
                    break;
                case 7: keepGoing = false;
                    break;
            }
        }
    }

    private void listAllAddress() {
        List<Address> allAddresses = dao.getAllAddresses();
        view.displayAllAddresses(allAddresses);
    }

    private void addAddress() {
        view.displayCreateAddressBanner();
        Address newAddress = view.getNewAddressInfo();
        dao.addAddress(newAddress);
        view.displayCreateAddressSuccessBanner();
    }

    private void viewAddress() {
        String first = view.getFirstName();
        String last = view.getLastName();
        Address address = dao.getAddress(first, last);
        view.displayAddress(address);
    }

    private void deleteAddress() {
        view.displayRemoveAddressBanner();
        String first = view.getFirstName();
        String last = view.getLastName();
        Address address = dao.removeAddress(first, last);
        view.displayRemoveAddressSuccessBanner(address);
    }

    private void editAddress() {
        boolean keepGoing = true;
        String first = view.getFirstName();
        String last = view.getLastName();
        Address address = dao.getAddress(first, last);
        
        while(keepGoing) {

            int menuSelection = view.displayGetEditMenu();
            String edit = "";
            String org = "";
            String change = "";
            
            switch(menuSelection){
                case 1:
                    edit = "first name";
                    org = address.getFirstName();
                    change = view.editAddress(edit, org);
                    address.setFirstName(change);
                    dao.editAddress(first, last, address);
                    break;
                case 2:
                    edit = "last name";
                    org = address.getLastName();
                    change = view.editAddress(edit, org);
                    address.setFirstName(change);
                    dao.editAddress(first, last, address);
                    break;
                case 3:
                    edit = "street address";
                    org = address.getStreetAddress();
                    change = view.editAddress(edit, org);
                    address.setFirstName(change);
                    dao.editAddress(first, last, address);
                    break;
                case 4:
                    edit = "city";
                    org = address.getCity();
                    change = view.editAddress(edit, org);
                    address.setFirstName(change);
                    dao.editAddress(first, last, address);
                    break;
                case 5:
                    edit = "state";
                    org = address.getState();
                    change = view.editAddress(edit, org);
                    address.setFirstName(change);
                    dao.editAddress(first, last, address);
                    break;
                case 6:
                    edit = "zip code";
                    org = address.getZip();
                    change = view.editAddress(edit, org);
                    address.setFirstName(change);
                    dao.editAddress(first, last, address);
                    break;
                case 7: keepGoing = false;
                    break;
            }
            
        }
    }

    private void numberOfAddress() {
        view.displayGettingNumberOfAddressesBannner();
        int total = dao.getTotalNumber();
        view.displayTotalNumberOfAddresses(total);
    }

}
