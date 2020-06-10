/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M3.vendingmachine.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class VendingMachineAuditDaoImpl implements VendingMachineAuditDao {

    public static final String AUDIT_FILE = "vendingmachineaudit.txt";
    
    @Override
    public void writeAuditEntry(String entry) throws VendingMachinePersistenceException {
           PrintWriter out;
        
    try {
        out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
    } catch (IOException e) {
        throw new VendingMachinePersistenceException("Could not persist audit information.", e);
    }

    LocalDateTime timestamp = LocalDateTime.now();
    out.println(timestamp.toString() + " : " + entry);
    out.flush();
    }
}
