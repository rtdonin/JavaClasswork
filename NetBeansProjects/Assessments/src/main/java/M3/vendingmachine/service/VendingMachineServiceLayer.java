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
    public Map<Integer, Candy> getAllCandyForSale() throws VendingMachinePersistenceException, OutOfCandyException;
    public boolean buyCandy(Candy purchasing, BigDecimal cashIn) throws VendingMachinePersistenceException;
    public Candy getCandy(Map<Integer, Candy> availableCandy, int menuSelection);
    public int[] getChange(Candy candySelected, BigDecimal cashInserted);
    public boolean doWeDispenseChange(Candy candySelected, BigDecimal cashInserted) throws NotEnoughCashInsertedException;

    public List<Candy> getAllCandy() throws VendingMachinePersistenceException ;

    public void adminAddedCandyInvetory(Map<Candy, Integer> newCandy) throws VendingMachinePersistenceException ;

    public int[] getDrawerInventory() throws VendingMachinePersistenceException;

    public void adminAddedChangeInventory(int[] addedChange) throws VendingMachinePersistenceException;

    public BigDecimal getTotalSales() throws VendingMachinePersistenceException;

    public void validateNewCandy(Candy createdCandy) throws NotValidCandyException;

    public void resetSales() throws VendingMachinePersistenceException;

}
