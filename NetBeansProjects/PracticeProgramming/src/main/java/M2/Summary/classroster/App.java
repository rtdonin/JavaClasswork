/*
Created by: Margaret Donin
Date created: 05/10/20
Date revised:
 */

package M2.Summary.classroster;
import M2.Summary.classroster.controller.ClassRosterController;
import M2.Summary.classroster.dao.ClassRosterDao;
import M2.Summary.classroster.dao.ClassRosterDaoFileImpl;
import M2.Summary.classroster.ui.ClassRosterView;
import M2.Summary.classroster.ui.UserIO;
import M2.Summary.classroster.ui.UserIOConsoleImpl;

public class App{
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();        
        ClassRosterController controller = new ClassRosterController(myDao, myView);
        controller.run();
    }
}
