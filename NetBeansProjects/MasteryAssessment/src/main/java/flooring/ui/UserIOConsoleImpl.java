/*
Created by: Margaret Donin
Date created: 05/04/20
Date revised: 06/17/20
 */

package flooring.ui;

import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.aspectj.util.ConfigParser.ParseException;

public class UserIOConsoleImpl implements UserIO {
    Scanner scanInput = new Scanner(System.in);

    public UserIOConsoleImpl() {
    
    }
    

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        print(prompt);
        String input = scanInput.nextLine();
        
        return input;
    }

    @Override
    public int readInt(String prompt) throws NumberFormatException {
        int input = 0;
        
        try {
            print(prompt);
            input = parseInt(scanInput.nextLine());
        } catch(NumberFormatException ex) {
            print("Could not read number.");
        }
        
        return input;
    }

    @Override
    public int readInt(String prompt, int min, int max) throws NumberFormatException {
        boolean inRange = false;
        int input;
        
        do{
            input = readInt(prompt);
            
            if(input >= min && input <= max) {
                inRange = true;
            }
        } while (!inRange);
        
        return input;
    }

    @Override
    public double readDouble(String prompt) throws NumberFormatException {
        double input = 0;
        
        try {
            print(prompt);
            input = parseDouble(scanInput.nextLine());
        } catch(NumberFormatException ex) {
            print("Could not read number.");
        }
        
        return input;
    }

    @Override
    public double readDouble(String prompt, double min, double max) throws NumberFormatException {
        boolean inRange = false;
        double input;
        
        do{
            input = readDouble(prompt);
            
            if(input >= min && input <= max) {
                inRange = true;
            }
        } while (!inRange);
        
        return input;
    }

    @Override
    public float readFloat(String prompt) throws NumberFormatException {
        float input = 0;
        
        try {
            print(prompt);
            input = parseFloat(scanInput.nextLine());
        } catch(NumberFormatException ex) {
            print("Could not read number.");
        }
        
        return input;
    }

    @Override
    public float readFloat(String prompt, float min, float max) throws NumberFormatException {
        boolean inRange = false;
        float input;
        
        do{
            input = readFloat(prompt);
            
            if(input >= min && input <= max) {
                inRange = true;
            }
        } while (!inRange);
        
        return input;
    }

    @Override
    public long readLong(String prompt) throws NumberFormatException {
        long input = 0;
        
        try {
            print(prompt);
            input = parseLong(scanInput.nextLine());
        } catch(NumberFormatException ex) {
            print("Could not read number.");
        }
        
        return input;
    }

    @Override
    public long readLong(String prompt, long min, long max) throws NumberFormatException {
        boolean inRange = false;
        long input;
        
        do{
            input = readLong(prompt);
            
            if(input >= min && input <= max) {
                inRange = true;
            }
        } while (!inRange);
        
        return input;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt) throws NumberFormatException {
        BigDecimal input = BigDecimal.ZERO;
        
        try {
            print(prompt);
            input = new BigDecimal(scanInput.nextLine());
        } catch(NumberFormatException ex) {
            print("Could not read number.");
        }
        
        return input;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt, BigDecimal min, BigDecimal max) throws NumberFormatException {
        boolean inRange = false;
        BigDecimal input = BigDecimal.ZERO;
  
        do{
            input = readBigDecimal(prompt);
            
            if(input.compareTo(min) == 1 && input.compareTo(max) == -1) {
                inRange = true;
            }
        } while (!inRange);
        
        return input;
    }

    @Override
    public LocalDate readLocalDate(String prompt) throws DateTimeParseException {
        LocalDate input = null;
        print(prompt);
        String toFormat = scanInput.nextLine();
        
        List<String> formats = Arrays.asList("M/d/y", "M-d-y");

        for (String s : formats) {
            try{
                input = LocalDate.parse(toFormat, DateTimeFormatter.ofPattern(s));
            } catch (DateTimeParseException ex) {
                // do nothing
            }
        }    
        return input;
    }

}
