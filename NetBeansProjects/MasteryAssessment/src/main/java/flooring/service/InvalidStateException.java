/*
Created by: Margaret Donin
Date created: 07/07/20
Date revised:
*/

package flooring.service;

public class InvalidStateException extends Exception {

    public InvalidStateException (String message) {
        super(message);
    }
    
    public InvalidStateException (String message, Throwable cause) {
        super(message, cause);
    }

}