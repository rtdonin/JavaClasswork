/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M3.vendingmachine.dao;

import M3.vendingmachine.dto.Candy;
import java.util.List;

public interface VendingMachineDao {

    /*
    
    @return List of Candy
    @throws VendingMachinePersistenceException
    */
    public List<Candy> getAllCandy() throws VendingMachinePersistenceException ;
    public Candy editCandy(Candy purchasedCandy) throws VendingMachinePersistenceException;

    /*
    Loads all candy into List from file
    
    @return List of Candy
    @throws VendingMachinePersistenceException 
    */
    public void loadInventory() throws VendingMachinePersistenceException ;

    /*
    Writes inventory to file
    
    @throws VendingMachinePersistenceException
    */
    public void writeInventory() throws VendingMachinePersistenceException;
    public String marshallCandy(Candy candyToMarshall);
    public Candy unmarshallCandy(String marshalledCandy);
}
