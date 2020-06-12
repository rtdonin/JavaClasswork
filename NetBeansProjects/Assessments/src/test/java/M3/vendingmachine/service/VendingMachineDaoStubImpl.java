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
    public Candy candyOne;
    public Candy candyTwo;
    
    public VendingMachineDaoStubImpl() {
        String name = "Whatchamacallit";
        BigDecimal price = new BigDecimal("1.26");
        int inventory = 2;
        candyOne = new Candy(name, price, inventory);

        name = "Snickers";
        price = new BigDecimal("0.73");
        inventory = 0;
        candyTwo = new Candy(name, price, inventory);
    }

    public VendingMachineDaoStubImpl(Candy testCandy) {
        this.candyOne = testCandy;
    }

    @Override
    public Map<String, Candy> getAllCandy() throws VendingMachinePersistenceException {
        Map<String, Candy> candyList = new HashMap<>();
        candyList.put(candyOne.getName(), candyOne);
        candyList.put(candyTwo.getName(), candyTwo);

        return candyList;
    }

    @Override
    public Candy editCandy(Candy purchasedCandy) throws VendingMachinePersistenceException {
        if (purchasedCandy.getName().equals(candyOne.getName())) {
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
        if (name.equals(candyOne.getName())) {
            return candyOne;
        } else if (name.equals(candyTwo.getName())){
            return candyTwo;
        } else {
            return null;
        }
    }

}
