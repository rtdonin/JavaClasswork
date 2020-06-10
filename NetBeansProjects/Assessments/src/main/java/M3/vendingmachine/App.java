/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M3.vendingmachine;

import M3.vendingmachine.controller.VendingMachineController;
import M3.vendingmachine.dao.*;
import M3.vendingmachine.service.*;
import M3.vendingmachine.ui.*;

public class App {
    public static void main(String[] args) throws VendingMachinePersistenceException {
        // Instantiate the UserIO implementation
        UserIO myIo = new UserIOConsoleImpl();
        // Instantiate the View and wire the UserIO implmentation into it
        VendingMachineView myView = new VendingMachineView(myIo);
        // Instantiate the DAO
        VendingMachineDao myDao = new VendingMachineDaoImpl();
        // Instantiate the Audit DAO
        VendingMachineAuditDao myAuditDao = new VendingMachineAuditDaoImpl();
        // Instatiate the Service Layer and wire the DAO and Audit DAO into it
        VendingMachineServiceLayer myService = new VendingMachineServiceLayerImpl(myDao, myAuditDao);
        // Instantiate the Controller and wire the Service Layer into it
        VendingMachineController controller = new VendingMachineController(myService, myView);
        // Kick off the Controller
        controller.run();   
    }
}
