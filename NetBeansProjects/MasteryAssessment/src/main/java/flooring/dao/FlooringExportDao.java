/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:
*/

package flooring.dao;

import flooring.dto.Order;
import java.util.List;
import java.util.Map;

public interface FlooringExportDao {
    public List<String> createBackup(Map<Integer, Order> allOrders);
}
