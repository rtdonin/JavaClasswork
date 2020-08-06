/*
Created by: Margaret Donin
Date created:  05/08/20
Date revised:
*/

package M2.DataMarshalingAndUnmarshaling.StateCapitals3;

import java.io.BufferedReader;
import java.io.FileReader;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StateCapitalsApp{
    public static void main(String[] args) throws Exception {
        Scanner fileScanner = new Scanner(new BufferedReader(new FileReader("MoreStateCapitals.txt")));
        Scanner input = new Scanner(System.in);
        
        // key is the state value is the capital
        Map<String, Capital> stateCapitals = new HashMap<>();
        
        int limit;
        final String DELIMITER = "::";
                
        while(fileScanner.hasNextLine()){
            String currentLine = fileScanner.nextLine();
            String[] state = currentLine.split(DELIMITER);
            stateCapitals.put(state[0], new Capital(state[1], parseInt(state[2]), parseFloat(state[3])));
        }
        
        // contains the capitals
        Set<String> states = stateCapitals.keySet();

        // how many object were created
        System.out.println(stateCapitals.size() + " STATES AND CAPITALS LOADED.");
        System.out.println("=======");
        
        // print them
        for (String current : states) {
            System.out.print(current);
            stateCapitals.get(current).getCapitalData();
        }
        
        // specify population
        System.out.print("\nPlease enter the lower limit for capital city population: ");
        limit = parseInt(input.nextLine());
        
        System.out.println("LISTING CAPITALS WITH POPULATIONS GREATER THAN " + limit + ":");
        
        for (String current : states) {
            if(stateCapitals.get(current).getPopulation() <= limit){
                System.out.print(current);
                stateCapitals.get(current).getCapitalData();
            }
        }
        
        // specify square mileage
        System.out.print("\nPlease enter the lower limit for capital city sq mileage: ");
        limit = parseInt(input.nextLine());
        
        System.out.println("LISTING CAPITALS WITH AREAS LESS THAN " + limit + ":");
        
        for (String current : states) {
            if(stateCapitals.get(current).getSquareMileage() <= limit){
                System.out.print(current);
                stateCapitals.get(current).getCapitalData();
            }
        }

    }
}