/*
Created by: Margaret Donin
Date created: 07/07/20
Date revised:
*/

package flooring.service;

public class InvalidNameException extends Exception {

    public InvalidNameException (String message) {
        super(message);
    }
    
    public InvalidNameException (String message, Throwable cause) {
        super(message, cause);
    }

}