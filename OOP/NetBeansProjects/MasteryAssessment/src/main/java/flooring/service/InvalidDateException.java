/*
Created by: Margaret Donin
Date created: 07/07/20
Date revised:
*/

package flooring.service;

public class InvalidDateException extends Exception {

    public InvalidDateException (String message) {
        super(message);
    }
    
    public InvalidDateException (String message, Throwable cause) {
        super(message, cause);
    }

}