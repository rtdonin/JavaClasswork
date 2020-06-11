/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M3.vendingmachine.service;

import M3.vendingmachine.dto.Coin;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Change {
    public static Map<Coin, Integer> createChange(BigDecimal change){
        Map<Coin, Integer> changeToReturn = new HashMap<>();
        
        // gets rid of decimal for easier math
        change = change.movePointRight(2);
        
        for (Coin c : Coin.values()) {
            // get value of coin
            BigDecimal coinValue = new BigDecimal(c.getCents());
            
            // divide change by value of coin
            BigDecimal numCoins = change.divide(coinValue, 0, RoundingMode.FLOOR);
            
            // put into List
            changeToReturn.put(c, numCoins.intValue());
            
            // then set change to whats left
            change = change.remainder(coinValue);
        }
        
        return changeToReturn;        
    }
}
