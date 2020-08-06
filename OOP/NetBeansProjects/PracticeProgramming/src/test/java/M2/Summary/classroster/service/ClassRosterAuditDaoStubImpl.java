/*
Created by: Margaret Donin
Date created: 05/28/20
Date revised:
*/

package M2.Summary.classroster.service;

import M2.Summary.classroster.dao.ClassRosterAuditDao;
import M2.Summary.classroster.dao.ClassRosterPersistenceException;

public class ClassRosterAuditDaoStubImpl implements ClassRosterAuditDao {
    @Override
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException {
        // do nothing...
    }
}
