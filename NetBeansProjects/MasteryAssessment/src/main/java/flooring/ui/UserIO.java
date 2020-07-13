/*
Created by: Margaret Donin
Date created: 05/04/20
Date revised:
 */

package flooring.ui;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public interface UserIO {
    void print(String message);

    String readString(String prompt);

    int readInt(String prompt) throws NumberFormatException;

    int readInt(String prompt, int min, int max) throws NumberFormatException;

    double readDouble(String prompt) throws NumberFormatException;

    double readDouble(String prompt, double min, double max) throws NumberFormatException;

    float readFloat(String prompt) throws NumberFormatException;

    float readFloat(String prompt, float min, float max) throws NumberFormatException;

    long readLong(String prompt) throws NumberFormatException;

    long readLong(String prompt, long min, long max) throws NumberFormatException;
    
    BigDecimal readBigDecimal(String prompt) throws NumberFormatException;

    BigDecimal readBigDecimal(String prompt, BigDecimal min, BigDecimal max) throws NumberFormatException;
    
    LocalDate readLocalDate(String prompt) throws DateTimeParseException;
}
