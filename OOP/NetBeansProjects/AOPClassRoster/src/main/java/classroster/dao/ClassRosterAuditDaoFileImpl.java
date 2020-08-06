/*
Created by: Margaret Donin
Date created: 05/26/20
Date revised:

THIS IS M3 and is therefore in a new branch
There is no point to copy and paste a bunch
of code so I branched this off to work on M3.
*/

package classroster.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class ClassRosterAuditDaoFileImpl implements ClassRosterAuditDao {

    public static final String AUDIT_FILE = "audit.txt";
    
    // The M3 code along forgot to mention to override this method.
    @Override
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new ClassRosterPersistenceException("Could not persist audit information.", e);
        }
        
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
    }
}
