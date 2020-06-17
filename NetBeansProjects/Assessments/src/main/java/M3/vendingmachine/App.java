/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised: 06/17/20

Revised for M4 assessment

Commented out will be the annotation implementation in all relevent files.
The current state of the program uses xml configuration
imports might need to be fixed with a CTRL + SHIFT + I in some files.
*/

package M3.vendingmachine;

import M3.vendingmachine.controller.VendingMachineController;
import M3.vendingmachine.dao.VendingMachinePersistenceException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) throws VendingMachinePersistenceException {
//        // Instantiate the UserIO implementation
//        UserIO myIo = new UserIOConsoleImpl();
//        // Instantiate the View and wire the UserIO implmentation into it
//        VendingMachineView myView = new VendingMachineView(myIo);
//        // Instantiate the DAO
//        VendingMachineDao myDao = new VendingMachineDaoImpl();
//        // Instantiate the Audit DAO
//        VendingMachineAuditDao myAuditDao = new VendingMachineAuditDaoImpl();
//        // Instatiate the Service Layer and wire the DAO and Audit DAO into it
//        VendingMachineServiceLayer myService = new VendingMachineServiceLayerImpl(myDao, myAuditDao);
//        // Instantiate the Controller and wire the Service Layer into it
//        VendingMachineController controller = new VendingMachineController(myService, myView);

        // Annotation driven:
//        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
//            appContext.scan("M3.vendingmachine");
//            appContext.refresh();
//            
//            VendingMachineController controller = appContext.getBean("vendingMachineController", VendingMachineController.class);

        // DI from XML
        ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:appContextFile.xml");
        
        VendingMachineController controller = appContext.getBean("controller", VendingMachineController.class);
        // Kick off the Controller
        controller.run();   
    }
}
