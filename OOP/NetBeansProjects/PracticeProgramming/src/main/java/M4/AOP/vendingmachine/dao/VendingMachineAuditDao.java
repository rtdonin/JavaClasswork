/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M4.AOP.vendingmachine.dao;

public interface VendingMachineAuditDao {
    public void writeAuditEntry(String entry) throws VendingMachinePersistenceException; 
}
