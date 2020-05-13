/*
Created by: Margaret Donin
Date created: 
Date revised:
*/

package M2.DVDlibrary;

import M2.DVDlibrary.controller.DVDLibraryController;
import M2.DVDlibrary.dao.DVDLibraryDao;
import M2.DVDlibrary.dao.DVDLibraryDaoFileImpl;
import M2.DVDlibrary.ui.DVDLibraryView;
import M2.DVDlibrary.ui.UserIO;
import M2.DVDlibrary.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
        UserIO myIO = new UserIOConsoleImpl();
        DVDLibraryView myView = new DVDLibraryView(myIO);
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(myDao, myView);
        controller.run();
    }
}
