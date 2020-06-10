/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M3.vendingmachine.service;

import M3.vendingmachine.dao.VendingMachinePersistenceException;
import M3.vendingmachine.dto.Candy;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface VendingMachineServiceLayer {
    public Map<Integer, Candy> getAllCandyForSale() throws VendingMachinePersistenceException;
    public boolean buyCandy(Candy purchasing, BigDecimal cashIn) throws VendingMachinePersistenceException;
    public Candy getCandy(Map<Integer, Candy> availableCandy, int menuSelection);
    public List<BigDecimal> getChange(Candy candySelected, BigDecimal cashInserted);
}
