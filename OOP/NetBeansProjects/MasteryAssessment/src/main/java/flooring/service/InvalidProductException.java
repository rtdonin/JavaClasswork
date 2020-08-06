/*
Created by: Margaret Donin
Date created: 07/07/20
Date revised:
*/

package flooring.service;

public class InvalidProductException extends Exception {

    public InvalidProductException (String message) {
        super(message);
    }
    
    public InvalidProductException (String message, Throwable cause) {
        super(message, cause);
    }

}