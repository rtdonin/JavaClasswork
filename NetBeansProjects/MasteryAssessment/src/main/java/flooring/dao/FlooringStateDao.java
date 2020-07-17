/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised: 06/29/20 exceptions
*/

package flooring.dao;

import flooring.dto.State;
import java.util.Map;

public interface FlooringStateDao {
    
    /**
     * Retrieves all states from file
     * 
     * @return Map of States with a the abbreviation as the key.
     * @throws FlooringPersistenceException 
     */
    public Map<String, State> getAllStates() throws FlooringPersistenceException;
    
    /**
     * Returns state corresponding with stateAbbreviation
     * 
     * @param stateAbbreviation
     * @return State
     * @throws FlooringPersistenceException 
     */
    public State getState(String stateAbbreviation) throws FlooringPersistenceException;
    
    /**
     * Adds a new State to state file
     * 
     * @param newState
     * @return addedState
     * @throws FlooringPersistenceException 
     */
    public State addState(State newState) throws FlooringPersistenceException;
    
    /**
     * Changed the state in the file to the edited State
     * 
     * @param editState
     * @return editedState
     * @throws FlooringPersistenceException 
     */
    public State editState(State editState) throws FlooringPersistenceException;
    
    /**
     * Deletes a state from the file
     * 
     * @param removeState
     * @return removedState
     * @throws FlooringPersistenceException 
     */
    public State removeState(State removeState) throws FlooringPersistenceException;
}
