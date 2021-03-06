/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:
*/

package flooring.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class State {
    private String stateAbbreviation;
    private String stateName;
    private BigDecimal taxRate;

    public State(String stateAbbreviation, String stateName, BigDecimal taxRate) {
        this.stateAbbreviation = stateAbbreviation;
        this.stateName = stateName;
        this.taxRate = taxRate;
    }

    public State(String stateAbbreviation, BigDecimal taxRate) {
        this.stateAbbreviation = stateAbbreviation;
        this.taxRate = taxRate;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public String toString() {
        String string = "State: ";
        
        if (stateName != null) {
            string += stateName + " ("+ stateAbbreviation + ") ";
        } else {
            string += stateAbbreviation + " ";
        }
        
        string += taxRate.toPlainString() + "% tax";
        
        return string;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.stateAbbreviation);
        hash = 97 * hash + Objects.hashCode(this.taxRate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final State other = (State) obj;
        if (!Objects.equals(this.stateAbbreviation, other.stateAbbreviation)) {
            return false;
        }
        if (!Objects.equals(this.taxRate, other.taxRate)) {
            return false;
        }
        return true;
    }
    
    
}
