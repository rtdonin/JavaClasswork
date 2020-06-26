/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:
*/

package flooring.dao;

import flooring.dto.State;
import java.util.HashMap;
import java.util.Map;

public class FlooringStateDaoImpl implements FlooringStateDao{
    private final Map<String, State> allStates = new HashMap<>();
    private final String STATE_FILE;
    private final String DELIMITER = ",";

    public FlooringStateDaoImpl() {
        this.STATE_FILE = "Data/taxes.txt";
    }
    
    public FlooringStateDaoImpl(String fileName) {
        this.STATE_FILE = fileName;
    }
    
    @Override
    public Map<String, State> getAllStates() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public State getState(String stateType) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private void loadFile() {
        throw new UnsupportedOperationException("Not supported yet.");
      
    }
    
    private State unmarshallData(String currentLine) {
        throw new UnsupportedOperationException("Not supported yet.");        
    }

}
