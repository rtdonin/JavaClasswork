/*
Created by: Margaret Donin
Date created: 06/03/20
Date revised:
*/

package M3.BigDecimal.CarLot.Service;

public class NoSuchCarException extends Exception {
    public NoSuchCarException(String message) {
        super(message);
    }
    
    public NoSuchCarException(String message, Throwable cause) {
        super(message, cause);
    }
}
