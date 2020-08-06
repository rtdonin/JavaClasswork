/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M3.vendingmachine.dao;

public interface VendingMachineAuditDao {
    public void writeAuditEntry(String entry) throws VendingMachinePersistenceException; 
}
