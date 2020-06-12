/*
Created by: Margaret Donin
Date created:
Date revised:
*/

package M3.vendingmachine.service;

public class NotEnoughCashInsertedException extends Exception {

    public NotEnoughCashInsertedException(String message) {
        super(message);
    }
    
    public NotEnoughCashInsertedException(String message, Throwable cause) {
        super(message, cause);
    }

}
