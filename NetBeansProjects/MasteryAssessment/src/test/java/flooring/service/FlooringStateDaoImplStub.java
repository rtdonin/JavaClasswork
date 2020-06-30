/*
Created by: Margaret Donin
Date created: 06/26/20
Date revised:
*/

package flooring.service;

import flooring.dao.FlooringStateDao;
import flooring.dto.State;
import java.util.Map;

public class FlooringStateDaoImplStub implements FlooringStateDao{

    @Override
    public Map<String, State> getAllStates() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public State getState(String productType) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
