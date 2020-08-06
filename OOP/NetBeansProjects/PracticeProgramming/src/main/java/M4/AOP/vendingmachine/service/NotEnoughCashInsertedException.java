/*
Created by: Margaret Donin
Date created:
Date revised:
*/

package M4.AOP.vendingmachine.service;

public class NotEnoughCashInsertedException extends Exception {

    public NotEnoughCashInsertedException(String message) {
        super(message);
    }
    
    public NotEnoughCashInsertedException(String message, Throwable cause) {
        super(message, cause);
    }

}
