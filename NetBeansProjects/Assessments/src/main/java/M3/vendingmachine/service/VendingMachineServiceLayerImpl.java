/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M3.vendingmachine.service;

import M3.vendingmachine.dao.*;
import M3.vendingmachine.dto.*;
import static M3.vendingmachine.dto.Coin.PENNY;
import java.math.BigDecimal;
import java.math.MathContext;
import static java.math.RoundingMode.HALF_DOWN;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {
    private final VendingMachineDrawerDao drawerDao = new VendingMachineDrawerDao();
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

        try {
            Map<Coin, Integer> returnJingle = Change.createChange(jingle);
            
            candySelected.setInventory(candySelected.getInventory() -1);
            dao.editCandy(candySelected);
            drawerDao.editAmount(returnJingle, candySelected.getPrice());
            
            String entry = "Purchasing " + candySelected.getName();
            entry += " for " + candySelected.getPrice() + ".";    
            entry += "\n\t\tUpdated Inventory: " + candySelected.toString();
            entry += "\n\t\tDispensed: ";
            
            for (Coin c : Coin.values()) {
                entry += returnJingle.get(c) + " - " + c;
                
                if (!c.equals(PENNY)){
                    entry += ", ";
                }
            }
            
            auditDao.writeAuditEntry(entry);
            
            return returnJingle;
        } catch (VendingMachinePersistenceException ex) {
            return null;
        }
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

    public List<Candy> getAllCandy() throws VendingMachinePersistenceException {
        Map<String, Candy> allCandy = dao.getAllCandy();
        Set<String> candyName = allCandy.keySet();
        List<Candy> candyList = new ArrayList<>();
        
        candyName.stream()
                .map((s) -> allCandy.get(s))
                .forEachOrdered(
                        (candy) -> { candyList.add(candy);}
                    );
        
        return candyList;
    }

    @Override
    public void adminAddedCandyInvetory(Map<Candy, Integer> newCandy) throws VendingMachinePersistenceException {
        Map<String, Candy> updatedCandy = new HashMap<>();
        Set<Candy> justCandy = newCandy.keySet();

        justCandy.stream()
                .map((c) -> { int newInventory = c.getInventory() + newCandy.get(c);
                            return c; })
                .forEachOrdered((c) -> { updatedCandy.put(c.getName(), c); });
        
        dao.adminAddCandyInventory(updatedCandy);
    }

    @Override
    public Map<Coin, Integer> getDrawerInventory() throws VendingMachinePersistenceException {
        return drawerDao.getDrawer();
    }

    @Override
    public void adminAddedChangeInventory(Map<Coin, Integer> addedChange) throws VendingMachinePersistenceException{
        drawerDao.restockDrawer(addedChange);
    }
    

    @Override
    public BigDecimal getTotalSales() throws VendingMachinePersistenceException {
        return drawerDao.getTotalSales();
    }

    @Override
    public void validateNewCandy(Candy candy) throws NotValidCandyException{
        if(candy.getName() == null
                || candy.getName().trim().length() == 0
                || candy.getPrice().compareTo(BigDecimal.ZERO) != 1) {
        
            throw new NotValidCandyException("e");
        }
    }

    @Override
    public void resetSales() throws VendingMachinePersistenceException {
        drawerDao.resetTotalSales();
    }
      
}