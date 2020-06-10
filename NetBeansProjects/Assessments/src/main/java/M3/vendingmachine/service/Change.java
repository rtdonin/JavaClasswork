/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M3.vendingmachine.service;

import M3.vendingmachine.dto.Coin;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;

public class Change {
    public static List<BigDecimal> createChange(BigDecimal change){
        List<BigDecimal> changeToReturn = new LinkedList<>();
        
        // gets rid of decimal for easier math
        change = change.movePointRight(2);
        
        for (Coin c : Coin.values()) {
            // divide change by value fo coin, then set change to whats left
            BigDecimal numCoins = change.divide(c.value, 0, RoundingMode.FLOOR);
            changeToReturn.add(numCoins);
            change = change.remainder(c.value);
        }
        
        return changeToReturn;        
    }
}
