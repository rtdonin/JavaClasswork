/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:
*/

package flooring.dao;

import flooring.dto.Order;
import java.time.LocalDate;
import java.util.Map;

public interface FlooringExportDao {
    public void createBackup(Map<LocalDate, Map<Integer, Order>> allOrders);
}
