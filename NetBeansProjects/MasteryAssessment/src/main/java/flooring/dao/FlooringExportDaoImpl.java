/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:
*/

package flooring.dao;

import flooring.dto.Order;
import java.time.LocalDate;
import java.util.Map;

public class FlooringExportDaoImpl implements FlooringExportDao {
    private final String BACKUP_FILE;
    private final String DELIMITER = ",";
    
    public FlooringExportDaoImpl(){
        this.BACKUP_FILE = "Backup/DataExprot.txt";
    }
    
    public FlooringExportDaoImpl(String fileName){
        this.BACKUP_FILE = fileName;
    }
    
    @Override
    public void createBackup(Map<LocalDate, Map<Integer, Order>> allOrders) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private String marshallData(Order currentOrder) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
