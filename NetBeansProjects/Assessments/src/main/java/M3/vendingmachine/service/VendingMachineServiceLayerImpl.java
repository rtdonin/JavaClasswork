/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M3.vendingmachine.service;

import M3.vendingmachine.dao.*;
import M3.vendingmachine.dto.Candy;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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
        boolean enoughCash = (cashIn.compareTo(price) >= 0);
        
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
        return availableCandy.get(menuSelection);
    }

    @Override
    public List<BigDecimal> getChange(Candy candySelected, BigDecimal cashInserted) {
        MathContext mc = new MathContext(2);
        BigDecimal jingle = cashInserted.subtract(candySelected.getPrice(), mc);
        
        return Change.createChange(jingle);
        
    }
      
}