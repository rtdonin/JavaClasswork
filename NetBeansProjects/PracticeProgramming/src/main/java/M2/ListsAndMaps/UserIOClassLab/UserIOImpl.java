/*
Created by: Margaret Donin
Date created: 05/04/20
Date revised:
 */

package M2.ListsAndMaps.UserIOClassLab;

import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import java.util.Scanner;

public class UserIOImpl implements UserIO{
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
    public int readInt(String prompt) {
        print(prompt);
        int input = parseInt(scanInput.nextLine());
        
        return input;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
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
    public double readDouble(String prompt) {
        print(prompt);
        double input = parseDouble(scanInput.nextLine());
        
        return input;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
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
    public float readFloat(String prompt) {
        print(prompt);
        float input = parseFloat(scanInput.nextLine());
        
        return input;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
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
    public long readLong(String prompt) {
        print(prompt);
        long input = parseLong(scanInput.nextLine());
        
        return input;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
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

}
