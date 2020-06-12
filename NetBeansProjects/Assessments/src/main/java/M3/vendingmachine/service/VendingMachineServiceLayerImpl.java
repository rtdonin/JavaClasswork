/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M3.vendingmachine.service;

import M3.vendingmachine.dao.*;
import M3.vendingmachine.dto.Candy;
import M3.vendingmachine.dto.Coin;
import java.math.BigDecimal;
import java.math.MathContext;
import static java.math.RoundingMode.HALF_DOWN;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    private final VendingMachineDao dao;
    private final VendingMachineAuditDao auditDao;
    
    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public Map<Integer, Candy> getAllCandyForSale() throws VendingMachinePersistenceException {
        Map<String, Candy> allCandy  = dao.getAllCandy();
        
        Collection<Candy> justCandy = allCandy.values();
        
        Map<Integer, Candy> availableCandy = new HashMap<>();
                
        justCandy.stream()
                .filter((candy) -> (candy.getInventory() > 0))
                .forEachOrdered((candy) -> {availableCandy.put(availableCandy.size() + 1, candy);});
        
        return availableCandy;
    }

    @Override
    public boolean buyCandy(Candy candyToPurchase, BigDecimal cashIn) throws VendingMachinePersistenceException {
        BigDecimal price = candyToPurchase.getPrice();
        int comparison = cashIn.compareTo(price);
        boolean enoughCash = comparison >= 0;
        
        if (enoughCash) {
            String entry = "Purchasing " + candyToPurchase.getName();
            entry += " for " + candyToPurchase.getPrice() + ".";
            auditDao.writeAuditEntry(entry);
            
            candyToPurchase.setInventory(candyToPurchase.getInventory() -1);
            
            try {
                dao.editCandy(candyToPurchase);
            } catch (VendingMachinePersistenceException e) {
                throw new VendingMachinePersistenceException ("Had trouble updating inventory.", e);
            }
            
            entry = "Updated Inventory: " + candyToPurchase.toString();
            auditDao.writeAuditEntry(entry);
                    
        }
        
        return enoughCash;
    }

    @Override
    public Candy getCandy(Map<Integer, Candy> availableCandy, int menuSelection) {
        Candy selected = availableCandy.get(menuSelection);
        if (selected != null) {
            return selected;
        } else {
            // really shouldn't happen at all.
            // Like ever. Because of the IO class.
            // But you never know
            return null;
        }
    }

    @Override
    public Map<Coin, Integer> getChange(Candy candySelected, BigDecimal cashInserted) {
        MathContext mc = new MathContext(2, HALF_DOWN);
        BigDecimal price = candySelected.getPrice();
        BigDecimal jingle = cashInserted.subtract(price, mc);
        
        return Change.createChange(jingle);
        
    }

    @Override
    public boolean doWeDispenseChange(Candy candySelected, BigDecimal cashInserted) throws NotEnoughCashInsertedException {
        boolean returnChange = candySelected.getPrice().equals(cashInserted);
        
        BigDecimal price = candySelected.getPrice();
        boolean enoughCash = (cashInserted.compareTo(price) >= 0);
        
        if (!returnChange && !enoughCash) {
            throw new NotEnoughCashInsertedException("Something went terribly wrong with our calculations.");
        }
        
        // if it's true -> no change
        // if it's false -> change
        return !returnChange;
    }
      
}