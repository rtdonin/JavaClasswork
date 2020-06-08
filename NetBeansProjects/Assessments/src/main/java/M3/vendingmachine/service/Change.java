/*
Created by: Margaret Donin
Date created:
Date revised:
*/

package M3.vendingmachine.service;

import M3.vendingmachine.dto.Coins;
import static M3.vendingmachine.dto.Coins.*;
import java.math.BigDecimal;
import java.math.MathContext;
import static java.math.RoundingMode.DOWN;
import java.util.HashMap;
import java.util.Map;

public class Change {
    public Map<Coins, BigDecimal> createChange(BigDecimal change){
        Map<Coins, BigDecimal> changeToReturn = new HashMap<>();

        MathContext mc = new MathContext(0, DOWN);
        
        BigDecimal quarter = new BigDecimal("25");
        BigDecimal dime = new BigDecimal("10");
        BigDecimal nickle = new BigDecimal("5");
        BigDecimal penny = new BigDecimal("1");

        // gets rid of decimal for easier math
        change = change.movePointRight(2);
        
        // divide change by value fo coin, then set change to whats left
        BigDecimal numQuarters = change.divide(quarter, mc);
        changeToReturn.put(QUARTER, numQuarters);
        change = change.remainder(quarter);
        
        BigDecimal numDimes = change.divide(dime, mc);
        changeToReturn.put(DIME, numDimes);
        change = change.remainder(dime);
        
        BigDecimal numNickles = change.divide(nickle, mc);
        changeToReturn.put(NICKLE, numNickles);
        change = change.remainder(nickle);
        
        BigDecimal numPennies = change.divide(penny, mc);
        changeToReturn.put(PENNY, numPennies);
        
        return changeToReturn;        
    }
}
