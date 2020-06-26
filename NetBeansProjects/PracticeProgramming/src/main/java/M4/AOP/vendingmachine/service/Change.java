/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M4.AOP.vendingmachine.service;

import M4.AOP.vendingmachine.dao.VendingMachineDrawerDao;
import M4.AOP.vendingmachine.dao.VendingMachinePersistenceException;
import M4.AOP.vendingmachine.dto.Coin;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Change {
    public static int[] createChange(BigDecimal change) throws VendingMachinePersistenceException, OutOfChangeException {
        VendingMachineDrawerDao drawerDao = new VendingMachineDrawerDao();
        int[] changeToReturn = new int[4];
        int[] changeInDrawer;
        
        int[] denomination = {25, 10, 5, 1};

        try {
            changeInDrawer = drawerDao.getDrawer();
        } catch (VendingMachinePersistenceException ex) {
            return null;
        }
        // gets rid of decimal for easier math
        change = change.movePointRight(2);
        
        for (Coin c : Coin.values()) {
            // get value of coin
            int den = denomination[c.ordinal()];
            BigDecimal coinValue = new BigDecimal(den);
            
            // divide change by value of coin
            BigDecimal numCoinsNeeded = change.divide(coinValue, RoundingMode.FLOOR);
            
            // check we have enough
            BigDecimal numCoinsWeHave = new BigDecimal(changeInDrawer[c.ordinal()]);
            
            if (numCoinsWeHave.compareTo(numCoinsNeeded) < 0) {
                numCoinsNeeded = numCoinsWeHave;
            }
            
            // put into List
            changeToReturn[c.ordinal()] = numCoinsNeeded.intValue();
            
            // then set change to whats left
            change = change.subtract(numCoinsNeeded.multiply(coinValue));
        }
        
        if (change.equals(BigDecimal.ZERO)) {
            return changeToReturn;
        } else {
            throw new OutOfChangeException("e");
        }      
    }
}
