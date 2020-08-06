/*
Created by: Margaret Donin
Date created:
Date revised:
*/

package M3.vendingmachine.service;

public class NotValidCandyException extends Exception {
    public NotValidCandyException(String message) {
        super(message);
    }
    
    public NotValidCandyException(String message, Throwable cause) {
        super(message, cause);
    }
}
