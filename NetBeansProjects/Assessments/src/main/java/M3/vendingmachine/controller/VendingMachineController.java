/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M3.vendingmachine.controller;

import M3.vendingmachine.dao.VendingMachinePersistenceException;
import M3.vendingmachine.dto.*;
import M3.vendingmachine.service.VendingMachineServiceLayer;
import M3.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
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
            while(keepGoing){
                Map<Integer, Candy> availableCandy = getMenu();
                String cash = getCashOrExit(availableCandy).toUpperCase();
                if (cash.equals("EXIT")){
                    view.displayGoodBye();
                    keepGoing = false;
                } else {
                    int candyChoice = view.getCandySelection(availableCandy.size());
                    buyCandy(availableCandy, candyChoice, cash);
                }
            }
        } catch (VendingMachinePersistenceException e) {
            throw new VendingMachinePersistenceException("Could not get menu.", e);
        }
        
    }
    
    private Map<Integer, Candy> getMenu() throws VendingMachinePersistenceException{
        Map<Integer, Candy> availableCandy = service.getAllCandyForSale();
        return availableCandy;
    }

    private String getCashOrExit(Map<Integer, Candy> availableCandy) {
        return view.showMenuGetCash(availableCandy);
    }

    private void buyCandy(Map<Integer, Candy> availableCandy, int candyChoice, String cashString) throws VendingMachinePersistenceException {
        Candy candySelected = service.getCandy(availableCandy, candyChoice);
        BigDecimal cashIn = null;
        BigDecimal totalCashIn = BigDecimal.ZERO;
        boolean isNotPurchased = true;
        MathContext mc = new MathContext(2);
        
        do {
            boolean hasError = true;

            do {
                try {
                    cashIn = new BigDecimal(cashString, mc);
                    hasError = false;
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    hasError = true;
                    view.displayErrorMessage("That was not cash.");
                    cashString = view.getCashIn();
                }
                
            } while (hasError);
            
            totalCashIn = totalCashIn.add(cashIn, mc);
            isNotPurchased = !service.buyCandy(candySelected, totalCashIn);
            view.displayCashInserted(totalCashIn);

            if(isNotPurchased) {
                cashString = view.getMoreCashIn();
            }
                        
        } while (isNotPurchased);
        
        List<BigDecimal> change = service.getChange(candySelected, totalCashIn);
        view.displayChange(change, candySelected);
        
    }

}
