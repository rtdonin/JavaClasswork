/*
Created by: Margaret Donin
Date created: 05/11/20
Date revised: 06/05/20
*/

package M3.LambdasAndStreams.DVDlibrary;

import M3.LambdasAndStreams.DVDlibrary.controller.DVDLibraryController;
import M3.LambdasAndStreams.DVDlibrary.dao.DVDLibraryDao;
import M3.LambdasAndStreams.DVDlibrary.dao.DVDLibraryDaoException;
import M3.LambdasAndStreams.DVDlibrary.dao.DVDLibraryDaoFileImpl;
import M3.LambdasAndStreams.DVDlibrary.ui.DVDLibraryView;
import M3.LambdasAndStreams.DVDlibrary.ui.UserIO;
import M3.LambdasAndStreams.DVDlibrary.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) throws DVDLibraryDaoException {
        UserIO myIO = new UserIOConsoleImpl();
        DVDLibraryView myView = new DVDLibraryView(myIO);
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(myDao, myView);
        controller.run();
    }
}