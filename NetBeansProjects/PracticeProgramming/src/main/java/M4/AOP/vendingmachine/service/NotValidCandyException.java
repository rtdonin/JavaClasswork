/*
Created by: Margaret Donin
Date created:
Date revised:
*/

package M4.AOP.vendingmachine.service;

public class NotValidCandyException extends Exception {
    public NotValidCandyException(String message) {
        super(message);
    }
    
    public NotValidCandyException(String message, Throwable cause) {
        super(message, cause);
    }
}
