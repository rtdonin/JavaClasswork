/*
Created by: Margaret Donin
Date created:
Date revised:
*/

package M3.vendingmachine.service;

public class OutOfCandyException extends Exception {

    public OutOfCandyException(String message) {
        super(message);
    }
    
    public OutOfCandyException(String message, Throwable cause) {
        super(message, cause);
    }

}
