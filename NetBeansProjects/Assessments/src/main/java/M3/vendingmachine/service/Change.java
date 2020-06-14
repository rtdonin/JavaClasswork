/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M3.vendingmachine.service;

import M3.vendingmachine.dao.VendingMachineDrawerDao;
import M3.vendingmachine.dao.VendingMachinePersistenceException;
import M3.vendingmachine.dto.Coin;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Change {
    public static Map<Coin, Integer> createChange(BigDecimal change) throws VendingMachinePersistenceException {
        VendingMachineDrawerDao drawerDao = new VendingMachineDrawerDao();
        Map<Coin, Integer> changeToReturn = new HashMap<>();
        Map<Coin, Integer> changeInDrawer;
        
        try {
            changeInDrawer = drawerDao.getDrawer();
        } catch (VendingMachinePersistenceException ex) {
            return null;
        }
        // gets rid of decimal for easier math
        change = change.movePointRight(2);
        
        for (Coin c : Coin.values()) {
            // get value of coin
            BigDecimal coinValue = new BigDecimal(c.getCents());
            
            // divide change by value of coin
            BigDecimal numCoinsNeeded = change.divide(coinValue, RoundingMode.FLOOR);
            
            // check we have enough
            BigDecimal numCoinsWeHave = new BigDecimal(changeInDrawer.get(c));
            
            if (numCoinsWeHave.compareTo(numCoinsNeeded) < 0) {
                numCoinsNeeded = numCoinsWeHave;
            }
            
            // put into List
            changeToReturn.put(c, numCoinsNeeded.intValue());
            
            // then set change to whats left
            change = change.subtract(numCoinsNeeded.multiply(coinValue));
        }
        
        if (change.equals(BigDecimal.ZERO)) {
            return changeToReturn;
        } else {
            return null;
        }      
    }
}
