/*
Created by: Margaret Donin
Date created: 05/11/20
Date revised: 
*/

package M3.Testing.DVDlibrary;

import M3.Testing.DVDlibrary.controller.DVDLibraryController;
import M3.Testing.DVDlibrary.dao.DVDLibraryDao;
import M3.Testing.DVDlibrary.dao.DVDLibraryDaoException;
import M3.Testing.DVDlibrary.dao.DVDLibraryDaoFileImpl;
import M3.Testing.DVDlibrary.ui.DVDLibraryView;
import M3.Testing.DVDlibrary.ui.UserIO;
import M3.Testing.DVDlibrary.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) throws DVDLibraryDaoException {
        UserIO myIO = new UserIOConsoleImpl();
        DVDLibraryView myView = new DVDLibraryView(myIO);
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(myDao, myView);
        controller.run();
    }
}