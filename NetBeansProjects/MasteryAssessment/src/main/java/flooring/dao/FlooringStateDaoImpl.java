/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised: 06/29/20 method implemintation and exceptions.
*/

package flooring.dao;

import flooring.dto.State;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FlooringStateDaoImpl implements FlooringStateDao{
    private Map<String, State> allStates = new HashMap<>();
    private final String STATE_FILE;
    private final String DELIMITER = ",";

    public FlooringStateDaoImpl() {
        this.STATE_FILE = "Data//taxes.txt";
    }
    
    public FlooringStateDaoImpl(String fileName) {
        this.STATE_FILE = fileName;
    }
    
    @Override
    public Map<String, State> getAllStates() throws FlooringPersistenceException {
        loadFile();
        return allStates;
    }

    @Override
    public State getState(String stateAbbreviation) throws FlooringPersistenceException {
        loadFile();
        State state = null;
        
        if (allStates.containsKey(stateAbbreviation)) {
            
            state = allStates.get(stateAbbreviation);
        }
        
        return state;
    }

    @Override
    public State addState(State newState) throws FlooringPersistenceException {
        loadFile();
        allStates.put(newState.getStateAbbreviation(), newState);
        writeFile();
        
        return newState;
    }

    @Override
    public State editState(State editState) throws FlooringPersistenceException {
        loadFile();
        allStates.replace(editState.getStateAbbreviation(), editState);
        writeFile();
        
        return editState; 
    }

    @Override
    public State removeState(State removeState) throws FlooringPersistenceException {
        loadFile();
        allStates.remove(removeState.getStateAbbreviation());
        writeFile();
        
        return removeState;
    }
    
    /**
     * Laods the file and populares the Map allStates.
     * 
     * @throws FlooringPersistenceException 
     */
    private void loadFile() throws FlooringPersistenceException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(STATE_FILE)));
        } catch(FileNotFoundException e) {
            throw new FlooringPersistenceException("Could not load states.", e);
        }
        
        String currentLine;
        State currentState;
        scanner.nextLine();
        
        while(scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentState = unmarshallData(currentLine);
            allStates.put(currentState.getStateAbbreviation(), currentState);
        }
        // close scanner
        scanner.close();
    }
    
    /**
     * Takes no variables, returns no variables. Writes Map allStates to the file.
     * 
     * @throws FlooringPersistenceException 
     */
    private void writeFile() throws FlooringPersistenceException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(STATE_FILE));
        } catch (IOException e) {
            throw new FlooringPersistenceException("Could not save state data.", e);
        }
        
        String stateAsText;
        Set<String> abbreviations = allStates.keySet();
        out.println("State,StateName,TaxRate");
        out.flush();
        
        for (String s : abbreviations) {
            stateAsText = marshallData(allStates.get(s));
            out.println(stateAsText);
            out.flush();
        }
        
        out.close();
    }

    /**
     * Takes a String and creates a State with the information.
     * 
     * @param currentLine
     * @return State
     */
    private State unmarshallData(String currentLine) {
        String[] tokens = currentLine.split(DELIMITER);
        String stateAbbreviation = tokens[0];
        String stateName = tokens[1];
        BigDecimal taxRate = new BigDecimal(tokens[2]);
        
        State currentState = new State(stateAbbreviation, stateName, taxRate);
        
        return currentState;
    }
    
    /**
     * Takes state and converts it to string for writing to the file
     * 
     * @param currentState
     * @return String
     */
    private String marshallData(State currentState) {
        String marshalledState = currentState.getStateAbbreviation() + DELIMITER;
        marshalledState += currentState.getStateName() + DELIMITER;
        marshalledState += currentState.getTaxRate().toPlainString();
        
        return marshalledState;
    }

}
