/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:
*/

package flooring.dao;

import flooring.dto.State;
import java.util.Map;

public interface FlooringStateDao {
    public Map<String, State> getAllStates();
    public State getState(String productType);
}
