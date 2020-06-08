/*
Created by: Margaret Donin
Date created:
Date revised:
*/

package M3.vendingmachine.service;

import M3.vendingmachine.dao.VendingMachinePersistenceException;
import M3.vendingmachine.dto.Candy;
import M3.vendingmachine.dto.Coins;
import java.util.Map;

public interface VendingMachineServiceLayer {

    /*
    gets only candy for sale
  
    @return Map of integers and Candy
    @throws VendingMachinePersistenceException
    */
    public Map<Integer, Candy> getAllCandyForSale() throws VendingMachinePersistenceException;
    public Candy getCandy();
    public Map<Coins, Integer> getChange();
    public void checkValidity(Candy candy);
}
