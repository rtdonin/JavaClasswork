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
import java.util.List;
import java.util.Map;

public interface VendingMachineServiceLayer {
    public Map<Integer, Candy> getAllCandyForSale() throws VendingMachinePersistenceException, OutOfCandyException;
    public boolean buyCandy(Candy purchasing, BigDecimal cashIn) throws VendingMachinePersistenceException;
    public Candy getCandy(Map<Integer, Candy> availableCandy, int menuSelection);
    public Map<Coin, Integer> getChange(Candy candySelected, BigDecimal cashInserted);
    public boolean doWeDispenseChange(Candy candySelected, BigDecimal cashInserted) throws NotEnoughCashInsertedException;

    public List<Candy> getAllCandy() throws VendingMachinePersistenceException ;

    public void adminAddedCandyInvetory(Map<Candy, Integer> newCandy) throws VendingMachinePersistenceException ;

    public Map<Coin, Integer> getDrawerInventory() throws VendingMachinePersistenceException;

    public void adminAddedChangeInventory(Map<Coin, Integer> addedChange) throws VendingMachinePersistenceException;

    public BigDecimal getTotalSales() throws VendingMachinePersistenceException;

    public void validateNewCandy(Candy createdCandy) throws NotValidCandyException;

    public void resetSales() throws VendingMachinePersistenceException;

}
