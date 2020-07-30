/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M4.AOP.vendingmachine.dao;

public class VendingMachinePersistenceException extends Exception {
    public VendingMachinePersistenceException(String message) {
        super(message);
    }
    
    public VendingMachinePersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
