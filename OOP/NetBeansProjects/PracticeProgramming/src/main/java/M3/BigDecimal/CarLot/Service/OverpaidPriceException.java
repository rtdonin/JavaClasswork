/*
Created by: Margaret Donin
Date created: 06/03/20
Date revised:
*/

package M3.BigDecimal.CarLot.Service;

public class OverpaidPriceException extends Exception {
    public OverpaidPriceException(String message) {
        super(message);
    }
    
    public OverpaidPriceException(String message, Throwable cause) {
        super(message, cause);
    }
}
