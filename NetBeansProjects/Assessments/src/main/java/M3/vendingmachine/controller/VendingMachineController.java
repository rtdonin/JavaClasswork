/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M3.vendingmachine.controller;

import M3.vendingmachine.dao.VendingMachinePersistenceException;
import M3.vendingmachine.dto.*;
import M3.vendingmachine.service.NotEnoughCashInsertedException;
import M3.vendingmachine.service.VendingMachineServiceLayer;
import M3.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Map;

public class VendingMachineController {
    private final VendingMachineServiceLayer service;
    private final VendingMachineView view;

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
                                hasError = false; // only false if not exception is thrown.
                            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                                hasError = true;
                                view.displayErrorMessage("That was not cash.");
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
                        // Get change
                        Map<Coin, Integer> change = service.getChange(candySelected, totalCashIn);
                        // Display change
                        view.displayChange(change, candySelected);
                    } else {
                        view.noChangeEnjoy(candySelected);
                    }
                }
            }
        } catch (VendingMachinePersistenceException e) {
            throw new VendingMachinePersistenceException("Could not get menu.", e);
        }
        
    }

}
