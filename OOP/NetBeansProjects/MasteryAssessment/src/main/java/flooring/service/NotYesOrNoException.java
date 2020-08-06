/*
Created by: Margaret Donin
Date created: 07/06/20
Date revised:
*/

package flooring.service;

public class NotYesOrNoException  extends Exception {

    public NotYesOrNoException(String message) {
        super(message);
    }
    
    public NotYesOrNoException(String message, Throwable cause) {
        super(message, cause);
    }
}
