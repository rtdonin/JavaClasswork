/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M3.vendingmachine.service;

import M3.vendingmachine.dao.VendingMachineAuditDao;
import M3.vendingmachine.dao.VendingMachineDao;
import M3.vendingmachine.dao.VendingMachinePersistenceException;
import M3.vendingmachine.dto.Candy;
import M3.vendingmachine.dto.Coins;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    private VendingMachineDao dao;
    private VendingMachineAuditDao auditDao;
    
    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public Map<Integer, Candy> getAllCandyForSale() throws VendingMachinePersistenceException {
        List<Candy> allCandy  = dao.getAllCandy();
        
        Map<Integer, Candy> availableCandy = new HashMap<>();
                
        allCandy.stream()
                .filter((candy) -> (candy.getInventory() > 0))
                .forEachOrdered((candy) -> {
                    availableCandy.put(availableCandy.size() + 1, candy);
                });
        
        return availableCandy;
        
    }

    @Override
    public Candy getCandy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Coins, Integer> getChange() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void checkValidity(Candy candy) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}