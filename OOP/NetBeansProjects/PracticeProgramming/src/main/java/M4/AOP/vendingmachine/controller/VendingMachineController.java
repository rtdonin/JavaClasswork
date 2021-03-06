/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised: 06/17/20
*/

package M4.AOP.vendingmachine.controller;

import M4.AOP.vendingmachine.dao.VendingMachinePersistenceException;
import M4.AOP.vendingmachine.dto.Candy;
import M4.AOP.vendingmachine.service.NotEnoughCashInsertedException;
import M4.AOP.vendingmachine.service.NotValidCandyException;
import M4.AOP.vendingmachine.service.OutOfCandyException;
import M4.AOP.vendingmachine.service.OutOfChangeException;
import M4.AOP.vendingmachine.service.VendingMachineServiceLayer;
import M4.AOP.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// @Component
public class VendingMachineController {
    private final VendingMachineServiceLayer service;
    private final VendingMachineView view;

    // @Autowired
    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }
    
    public void run() throws VendingMachinePersistenceException {
        boolean keepGoing = true;
        
        try {
            while (keepGoing) {
                // get the List of Candy
                Map<Integer, Candy> availableCandy = service.getAllCandyForSale();
                String cashString = view.showMenuGetCash(availableCandy);
                
                if (cashString.equalsIgnoreCase("EXIT")){
                    view.displayGoodBye();
                    keepGoing = false;
                } else if (cashString.equalsIgnoreCase("admin")){
                    boolean keepGoingAdmin = true;
                    
                    while(keepGoingAdmin) {
                        int adminSelection = view.displayAdminMenu();

                        switch(adminSelection) {
                            case 1: checkCandyInventory();
                                break;
                            case 2: restockCandy();
                                break;
                            case 3: checkDrawerInventory();
                                break;
                            case 4: restockDrawer();
                                break;
                            case 5: totalSales();
                                break;
                            case 6: keepGoingAdmin = false;
                                break;
                        }
                    }
                } else {
                    // We got cash, now we need a candy selection
                    int candyChoice = view.getCandySelection(availableCandy.size());

                    // Get Candy selection
                    Candy candySelected = service.getCandy(availableCandy, candyChoice);
                    
                    BigDecimal cashIn = null; // inserted cash in this instance
                    BigDecimal totalCashIn = BigDecimal.ZERO; // total cash inserted
                    boolean isNotPurchased = true; // do we have enough cash?
                    boolean hasError = true; // could we create a BigDecimal

                    MathContext mc = new MathContext(2);

                    do {

                        do {

                            // NumberFormatException - Makes sure String can be used as BigDecimal
                            // ArrayIndexOutOfBoundsException - maked sure you didn't just hit enter
                            
                            try {
                                cashIn = new BigDecimal(cashString, mc);
                                hasError = false; // only false if no exception is thrown.
                            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                                hasError = true;
                                view.displayErrorMessage("You have not entered cash.");
                                cashString = view.getCashIn();
                            }

                            // Keep trying until there is no error.
                        } while (hasError);

                        // calculate total cash in
                        totalCashIn = totalCashIn.add(cashIn, mc);

                        // returns true (and converted to false) if we have enough cash to purchase the Candy
                        isNotPurchased = !service.buyCandy(candySelected, totalCashIn);
                        view.displayCashInserted(totalCashIn);

                        // if we still don't have enough cash ask for more
                        if (isNotPurchased) {
                            cashString = view.getMoreCashIn();
                        }

                        // go back up, check to make sure it's a String we can convert to BigDecimal
                        // add and check if we can purchase the Candy
                    } while (isNotPurchased);

                    boolean doWeGetChange = true;
                    
                    try {
                        // Do we need change?
                        doWeGetChange = service.doWeDispenseChange(candySelected, totalCashIn);
                    } catch (NotEnoughCashInsertedException e) {
                        view.displayErrorMessage("Something went wrong with our earlier calculations."
                                + "\nPlease take your returned chash.");
                        System.exit(1);

                    }
                    
                    if (doWeGetChange) {
                        
                        try {
                        
                            // Get change
                            int[] change = service.getChange(candySelected, totalCashIn);
                            
                            if(change == null) {
                                throw new OutOfChangeException("e");
                            }
                            
                            view.displayChange(change, candySelected);
                        } catch (OutOfChangeException e){
                            view.displayErrorMessage("Unfortunatly we do not have enough change, please take your $" + totalCashIn +  " below.");
                        }
                        
                    } else {
                        view.noChangeEnjoy(candySelected);
                    }
                }
            }
        } catch (VendingMachinePersistenceException e) {
            view.displayErrorMessage("Could not get menu.");
        } catch (OutOfCandyException e) {
            view.displayErrorMessage("We are out of Candy.");
            view.displayGoodBye();
        }
        
    }

    private void checkCandyInventory() throws VendingMachinePersistenceException {
        List<Candy> allCandy = service.getAllCandy();
        view.displayAllCandy(allCandy);
    }

    private void restockCandy() throws VendingMachinePersistenceException {
        List<Candy> allCandy = service.getAllCandy();
        Iterator iterator = allCandy.iterator();
        Map<Candy, Integer> updatedCandy = new HashMap<>();
        
        while(iterator.hasNext()) {
            Candy addedCandy = (Candy) iterator.next();
            int newInventory = view.adminAddedCandyInvetory(addedCandy);
            updatedCandy.put(addedCandy, newInventory);
        }
       boolean newCandy = true;
        
       while (newCandy) {
           String areWe = view.getAreWeAddingNewCandy();
           newCandy = areWe.equalsIgnoreCase("YES");

           if (newCandy) {
               try {
                    Candy createdCandy = view.createNewCandy();
                    service.validateNewCandy(createdCandy);
                    updatedCandy.put(createdCandy, 0);
               } catch (NotValidCandyException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    view.displayErrorMessage("Than was not a valid candy." + "\nPlease try again.");
               }
           }
       }
        service.adminAddedCandyInvetory(updatedCandy);
    }

    private void checkDrawerInventory() throws VendingMachinePersistenceException {
        int[] jingle = service.getDrawerInventory();
        view.displayCashInventory(jingle);
    }

    private void restockDrawer() throws VendingMachinePersistenceException {
        int[] addedChange = view.adminAddedChangeInventory();
        service.adminAddedChangeInventory(addedChange);
    }

    private void totalSales() throws VendingMachinePersistenceException {
        BigDecimal sales = service.getTotalSales();
        view.displayTotalSales(sales);
        String reset = view.getResetSales();
        
        if (reset.equalsIgnoreCase("Reset")) {
            service.resetSales();
            view.dislpayWasReset();
        }
    }

}
