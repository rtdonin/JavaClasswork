/*
Created by: Margaret Donin
Date created: 06/26/20
Date revised:
*/

package flooring.service;

import flooring.dao.FlooringPersistenceException;
import flooring.dao.FlooringStateDao;
import flooring.dto.State;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FlooringStateDaoImplStub implements FlooringStateDao {

    private State onlyState;
    
    public FlooringStateDaoImplStub() {
        this.onlyState = new State("NY", "New York", new BigDecimal("4.00"));;
    }
    
    public FlooringStateDaoImplStub(State state) {
        this.onlyState = state;
    }
    
    @Override
    public Map<String, State> getAllStates() throws FlooringPersistenceException {
        Map<String, State> allStates = new HashMap<>();
        allStates.put(onlyState.getStateAbbreviation(), onlyState);
        
        return allStates;
    }

    @Override
    public State getState(String stateAbbreviation) throws FlooringPersistenceException {
        if (onlyState.getStateAbbreviation().equals(stateAbbreviation)) {
            return onlyState;
        } else {
            return null;
        }
    }

    @Override
    public State addState(State newState) throws FlooringPersistenceException {
        if (newState.getStateName().equals(onlyState.getStateName())) {
            return onlyState;
        } else {
            return null;
        }
    }

    @Override
    public State editState(State editState) throws FlooringPersistenceException {
        if (editState.getStateName().equals(onlyState.getStateName())) {
            return onlyState;
        } else {
            return null;
        }
    }

    @Override
    public State removeState(State removeState) throws FlooringPersistenceException {
        if (removeState.getStateName().equals(onlyState.getStateName())) {
            return onlyState;
        } else {
            return null;
        }
    }

}
