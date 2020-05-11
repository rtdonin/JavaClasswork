/*
Created by: Margaret Donin
Date created:  05/07/20
Date revised:
*/

package M2.DataMarshalingAndUnmarshaling.StateCapitals2;

import java.io.BufferedReader;
import java.io.FileReader;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class StateCapitals2{
    public static void main(String[] args) throws Exception {
        Scanner fileScanner = new Scanner(new BufferedReader(new FileReader("StateCapitals.txt")));
        Scanner input = new Scanner(System.in);
        Random ranNum = new Random();
        
        final String DELIMITER = "::";
        
        
        // key is the state value is the capital
        Map<String, String> stateCapitals = new HashMap<>();
        List<String> states = new ArrayList<>();
        Set<String> statesAsked = new HashSet<>();
        
        while(fileScanner.hasNextLine()){
            String currentLine = fileScanner.nextLine();
            String[] state = currentLine.split(DELIMITER);
            stateCapitals.put(state[0], state[1]);
            states.add(state[0]);
        }
        
        
        
        System.out.println(stateCapitals.size() + " STATES AND CAPITALS LOADED.");
        System.out.println("=======");
        
        Iterator state = states.iterator();
        
        while (state.hasNext()){
            System.out.print(state.next());
            
            if (state.hasNext()){
                System.out.print(", ");
            }
        }
        
        System.out.println("\nHow many states do you want to guess?");
        int numQuestions = parseInt(input.nextLine());
        
        int score = 0;
        
        for (int i = 0; i < numQuestions; i++){
            
            String ranState;
            
            do{
                
                ranState = states.get(ranNum.nextInt(states.size()));
            }
            
            while(statesAsked.contains(ranState));
            
            statesAsked.add(ranState);
            
            System.out.println("\nWhat is the capital of " + ranState + "?");
            String answer = input.nextLine();
            

            if (answer.toLowerCase().equals(stateCapitals.get(ranState).toLowerCase())){
                System.out.println("\nNice work! " + stateCapitals.get(ranState) + " is correct!");
                score++;
            } else{
                System.out.println("\nSorry, but you're wrong. " + stateCapitals.get(ranState) + " was the answer.");
                score--;
            }
        }
        
        System.out.println("Score: " + score);
     }
}