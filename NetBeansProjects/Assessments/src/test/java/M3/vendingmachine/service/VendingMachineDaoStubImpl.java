/*
Created by: Margaret Donin
Date created: 06/09/20
Date revised:
*/

package M3.vendingmachine.service;

import M3.vendingmachine.dao.*;
import M3.vendingmachine.dto.Candy;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class VendingMachineDaoStubImpl implements VendingMachineDao {
    public Candy onlyCandy;
    
    public VendingMachineDaoStubImpl() {
        String name = "Whatchamacallit";
        BigDecimal price = new BigDecimal("1.23");
        int inventory = 2;
        onlyCandy = new Candy(name, price, inventory);
    }

    public VendingMachineDaoStubImpl(Candy testCandy) {
        this.onlyCandy = testCandy;
    }

    @Override
    public Map<String, Candy> getAllCandy() throws VendingMachinePersistenceException {
        Map<String, Candy> candyList = new HashMap<>();
        candyList.put(onlyCandy.getName(), onlyCandy);

        return candyList;
    }

    @Override
    public Candy editCandy(Candy purchasedCandy) throws VendingMachinePersistenceException {
        if (purchasedCandy.getName().equals(onlyCandy.getName())) {
            int oldInventory = purchasedCandy.getInventory();
            purchasedCandy.setInventory(oldInventory - 1);

            return purchasedCandy;
        } else {
            return null;
        }
    }

    @Override
    public void loadInventory() throws VendingMachinePersistenceException {
        // do nothing
    }

    @Override
    public void writeInventory() throws VendingMachinePersistenceException {
        // do nothing
    }

    @Override
    public String marshallCandy(Candy candyToMarshall) {
        // do nothing
        return null;
    }

    @Override
    public Candy unmarshallCandy(String marshalledCandy) {
        // do nothing
        return null;
    }

    @Override
    public Candy getCandy(String name) throws VendingMachinePersistenceException {
        if (name.equals(onlyCandy.getName())) {
            return onlyCandy;
        } else {
            return null;
        }
    }

}
