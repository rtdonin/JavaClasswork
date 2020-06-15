/*
Created by: Margaret Donin
Date created: 05/10/20
Date revised: 05/26/20 For M3
Date revised: 06/15/20 For M4
*/

package M2.Summary.classroster;

import M2.Summary.classroster.controller.ClassRosterController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App{
    public static void main(String[] args) {
//        // Instantiate the UserIO implementation
//        UserIO myIo = new UserIOConsoleImpl();
//        // Instantiate the View and wire the UserIO implmentation into it
//        ClassRosterView myView = new ClassRosterView(myIo);
//        // Instantiate the DAO
//        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
//        // Instantiate the Audit DAO
//        ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
//        // Instatiate the Service Layer and wire the DAO and Audit DAO into it
//        ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao);
//        // Instantiate the Controller and wire the Service Layer into it
//        ClassRosterController controller = new ClassRosterController(myService, myView);
//        // Kick off the Controller
//        controller.run();

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassRosterController controller = ctx.getBean("controller", ClassRosterController.class);
        controller.run();
    }
}
