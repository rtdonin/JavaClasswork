/*
Created by: Margaret Donin
Date created: 06/03/20
Date revised:
*/

package M3.BigDecimal.CarLot.Service;

public class UnderpaidPriceException extends Exception {
    public UnderpaidPriceException(String message) {
        super(message);
    }
    
    public UnderpaidPriceException(String message, Throwable cause) {
        super(message, cause);
    }
}
