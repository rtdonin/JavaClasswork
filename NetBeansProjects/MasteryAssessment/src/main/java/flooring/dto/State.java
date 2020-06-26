/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:
*/

package flooring.dto;

import java.math.BigDecimal;

public class State {
    private final String stateAbbreviation;
    private final String stateName;
    private final BigDecimal taxRate;

    public State(String stateAbbreviation, String stateName, BigDecimal taxRate) {
        this.stateAbbreviation = stateAbbreviation;
        this.stateName = stateName;
        this.taxRate = taxRate;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public String getStateName() {
        return stateName;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }
    
}
