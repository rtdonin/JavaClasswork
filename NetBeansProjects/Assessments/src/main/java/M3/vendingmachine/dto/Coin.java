/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M3.vendingmachine.dto;

import java.math.BigDecimal;

public enum Coin {
    QUARTER("25"),
    DIME("10"),
    NICKLE("5"),
    PENNY("1");
    
    public BigDecimal value;

    private Coin(String Value) {
        this.value = new BigDecimal(Value);
    }
}
