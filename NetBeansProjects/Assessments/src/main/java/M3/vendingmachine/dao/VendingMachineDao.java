/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M3.vendingmachine.dao;

import M3.vendingmachine.dto.Candy;
import java.util.Map;

public interface VendingMachineDao {

    /**
    
    @return List of Candy
    @throws VendingMachinePersistenceException
    */
    public Map<String, Candy> getAllCandy() throws VendingMachinePersistenceException ;
    public Candy editCandy(Candy purchasedCandy) throws VendingMachinePersistenceException;

    /**
    Loads all candy into List from file
    
    @throws VendingMachinePersistenceException 
    */
    public void loadInventory() throws VendingMachinePersistenceException ;

    /**
    Writes inventory to file
    
    @throws VendingMachinePersistenceException
    */
    public void writeInventory() throws VendingMachinePersistenceException;
    
    /**
    Marshalls data into strings
    
    @param candyToMarshall
    @return 
    */
    
    public String marshallCandy(Candy candyToMarshall);
    public Candy unmarshallCandy(String marshalledCandy);

    /*
     *@param name of Candy we want to retrieve
     *@return Candy
     *@throws VendingMachinePersistenceException
    */
    public Candy getCandy(String name) throws VendingMachinePersistenceException;

    public void adminAddCandyInventory(Map<String, Candy> updatedCandy) throws VendingMachinePersistenceException;
}
