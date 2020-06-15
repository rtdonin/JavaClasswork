/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M3.vendingmachine.dto;

public enum Coin {
    QUARTER("25"),
    DIME("10"),
    NICKLE("5"),
    PENNY("1");
    
    private String cents;
    
    public String getCents(){
        return this.cents;
    }

    private Coin(String cents) {
        this.cents = cents;
    }
}
