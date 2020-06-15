/*
Created by: Margaret Donin
Date created:
Date revised:
*/

package M3.vendingmachine.service;

public class OutOfChangeException extends Exception {
    public OutOfChangeException(String message) {
        super(message);
    }
    
    public OutOfChangeException(String message, Throwable cause) {
        super(message, cause);
    }
}
