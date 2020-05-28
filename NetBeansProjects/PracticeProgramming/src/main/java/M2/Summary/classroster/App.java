/*
Created by: Margaret Donin
Date created: 05/10/20
Date revised: 05/26/20 For M3
*/

package M2.Summary.classroster;
import M2.Summary.classroster.controller.ClassRosterController;
import M2.Summary.classroster.dao.ClassRosterAuditDao;
import M2.Summary.classroster.dao.ClassRosterAuditDaoFileImpl;
import M2.Summary.classroster.dao.ClassRosterDao;
import M2.Summary.classroster.dao.ClassRosterDaoFileImpl;
import M2.Summary.classroster.ui.ClassRosterView;
import M2.Summary.classroster.ui.UserIO;
import M2.Summary.classroster.ui.UserIOConsoleImpl;
import M2.Summary.classroster.service.ClassRosterServiceLayer;
import M2.Summary.classroster.service.ClassRosterServiceLayerImpl;

public class App{
    public static void main(String[] args) {
        // Instantiate the UserIO implementation
        UserIO myIo = new UserIOConsoleImpl();
        // Instantiate the View and wire the UserIO implmentation into it
        ClassRosterView myView = new ClassRosterView(myIo);
        // Instantiate the DAO
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        // Instantiate the Audit DAO
        ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
        // Instatiate the Service Layer and wire the DAO and Audit DAO into it
        ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao);
        // Instantiate the Controller and wire the Service Layer into it
        ClassRosterController controller = new ClassRosterController(myService, myView);
        // Kick off the Controller
        controller.run();
    }
}
