/*
Created by: Margaret Donin
Date created: 07/07/20
Date revised:
*/

package flooring.service;

public class InvalidAreaException extends Exception {

    public InvalidAreaException (String message) {
        super(message);
    }
    
    public InvalidAreaException (String message, Throwable cause) {
        super(message, cause);
    }

}