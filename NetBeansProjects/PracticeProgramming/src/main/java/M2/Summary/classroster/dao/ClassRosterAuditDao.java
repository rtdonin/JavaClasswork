/*
Created by: Margaret Donin
Date created: 05/26/20
Date revised:

THIS IS M3 and is therefore in a new branch
There is no point to copy and paste a bunch
of code so I branched this off to work on M3.
*/

package M2.Summary.classroster.dao;

public interface ClassRosterAuditDao {
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException;
    
}
