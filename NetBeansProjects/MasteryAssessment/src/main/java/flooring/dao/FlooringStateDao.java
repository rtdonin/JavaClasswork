/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised: 06/29/20 exceptions
*/

package flooring.dao;

import flooring.dto.State;
import java.util.Map;

public interface FlooringStateDao {
    public Map<String, State> getAllStates() throws FlooringPersistenceException;
    public State getState(String stateAbbreviation) throws FlooringPersistenceException;
    public State addState(State newState) throws FlooringPersistenceException;
    public State editState(State editState) throws FlooringPersistenceException;
    public State removeState(State removeState) throws FlooringPersistenceException;
}
