/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M3.vendingmachine.service;

import M3.vendingmachine.dao.VendingMachinePersistenceException;
import M3.vendingmachine.dto.Candy;
import M3.vendingmachine.dto.Coin;
import java.math.BigDecimal;
import java.util.Map;

public interface VendingMachineServiceLayer {
    public Map<Integer, Candy> getAllCandyForSale() throws VendingMachinePersistenceException;
    public boolean buyCandy(Candy purchasing, BigDecimal cashIn) throws VendingMachinePersistenceException;
    public Candy getCandy(Map<Integer, Candy> availableCandy, int menuSelection);
    public Map<Coin, Integer> getChange(Candy candySelected, BigDecimal cashInserted);
}
