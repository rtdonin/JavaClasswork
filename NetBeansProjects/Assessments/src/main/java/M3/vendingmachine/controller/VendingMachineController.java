/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M3.vendingmachine.controller;

import M3.vendingmachine.dto.Candy;
import M3.vendingmachine.service.VendingMachineServiceLayer;
import M3.vendingmachine.ui.VendingMachineView;
import java.util.Map;

public class VendingMachineController {
    VendingMachineServiceLayer service;
    VendingMachineView view;

    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }
    
    public void run() {
        boolean keepGoing = true;
        
        while(keepGoing){
            int menuSelection = getMenuSelection();
            if (menuSelection != 0){
                buyCandy(menuSelection);
            } else {
                keepGoing = false;
            }
        }
        
    }
    
    private int getMenuSelection(){
        Map<Integer, Candy> availableCandy = service.getAllCandyForSale();
        int selection = view.printMenuGetSelection(availableCandy);
        return selection;
    }
    
    private void buyCandy(int selection){
        
    }

    private void unknownCommand() {
        view.unknownCommand();
    }

}
