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
import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
    Scanner scanInput = new Scanner(System.in);

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
            input = readInt(prompt);
            
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
            input = readInt(prompt);
            
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
            input = readInt(prompt);
            
            if(input >= min && input <= max) {
                inRange = true;
            }
        } while (!inRange);
        
        return input;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt) throws NumberFormatException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BigDecimal readBigDecimal(String prompt, long min, long max) throws NumberFormatException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
