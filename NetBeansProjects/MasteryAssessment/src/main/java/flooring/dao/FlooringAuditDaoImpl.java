/*
Created by: Margaret Donin
Date created: 06/30/20
Date revised:
*/

package flooring.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FlooringAuditDaoImpl implements FlooringAuditDao {

    private String AUDIT_FILE;

    public FlooringAuditDaoImpl() {
        this.AUDIT_FILE = "audit.txt";
    }

    public FlooringAuditDaoImpl(String fileName) {
        this.AUDIT_FILE = fileName;
    }
        
    @Override
    public void writeAuditEntry(String entry) throws FlooringPersistenceException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new FlooringPersistenceException("Could not persist audit information.", e);
        }

        LocalDateTime timestamp = LocalDateTime.now();
        String formatted = timestamp.format(DateTimeFormatter.ofPattern("MM-dd-yy HH:mm:ss"));
        out.println(formatted + " : " + entry + "\n");
        out.flush();
    }

}
