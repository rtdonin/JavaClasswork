/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:
*/

package flooring.dao;

import flooring.dto.Order;
import java.util.List;

public interface FlooringExportDao {
    /**
     * 
     * @param allOrders
     * @throws FlooringPersistenceException 
     */
    public void createBackup(List<Order> allOrders) throws FlooringPersistenceException ;
}
