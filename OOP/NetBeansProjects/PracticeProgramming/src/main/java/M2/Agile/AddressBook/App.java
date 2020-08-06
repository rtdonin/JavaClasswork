/*
Created by: Margaret Donin
Date created: 07/02/20
Date revised:
*/

package M2.Agile.AddressBook;

import M2.Agile.AddressBook.controller.AddressBookController;
import M2.Agile.AddressBook.dao.AddressBookDao;
import M2.Agile.AddressBook.dao.AddressBookDaoImpl;
import M2.Agile.AddressBook.ui.AddressBookView;
import M2.ListsAndMaps.UserIOClassLab.UserIO;
import M2.ListsAndMaps.UserIOClassLab.UserIOImpl;

public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOImpl();
        AddressBookView view = new AddressBookView(io);
        AddressBookDao dao = new AddressBookDaoImpl();
        AddressBookController controller = new AddressBookController(view, dao);
        
        controller.run();
    }
}
