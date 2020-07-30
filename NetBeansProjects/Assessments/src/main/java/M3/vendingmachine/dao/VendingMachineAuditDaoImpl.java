/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised: 06/17/20
*/

package M3.vendingmachine.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

// @Component
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
        String formatted = timestamp.format(DateTimeFormatter.ofPattern("MM-dd-yy HH:mm:ss"));
        out.println(formatted + " : " + entry + "\n");
        out.flush();
    }
}
