/*
Created by: Margaret Donin
Date created: 05/11/20
Date revised: 06/15/20 FOR M4
*/

package M3.Testing.DVDlibrary;

import M3.Testing.DVDlibrary.controller.DVDLibraryController;
import M3.Testing.DVDlibrary.dao.DVDLibraryDaoException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) throws DVDLibraryDaoException {
        
//        UserIO myIO = new UserIOConsoleImpl();
//        DVDLibraryView myView = new DVDLibraryView(myIO);
//        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
//        DVDLibraryController controller = new DVDLibraryController(myDao, myView);

        ApplicationContext ctx = new ClassPathXmlApplicationContext("DVDLibraryAppContext.xml");
        DVDLibraryController controller = ctx.getBean("controller", DVDLibraryController.class);
        controller.run();
    }
}