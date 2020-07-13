/*
Created by: Margaret Donin
Date created: 06/30/20
Date revised:
*/

package flooring.dao;

public interface FlooringAuditDao {
    /**
     * writes to the audit file all CRUD methods for the orders and all exceptions
     * @param entry
     * @throws FlooringPersistenceException 
     */
    public void writeAuditEntry(String entry) throws FlooringPersistenceException;
}
