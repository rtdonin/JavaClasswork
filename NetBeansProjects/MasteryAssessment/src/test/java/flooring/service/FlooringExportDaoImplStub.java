/*
Created by: Margaret Donin
Date created: 06/26/20
Date revised:
*/

package flooring.service;

import flooring.dao.FlooringExportDao;
import flooring.dto.Order;
import java.util.List;
import java.util.Map;

public class FlooringExportDaoImplStub implements FlooringExportDao {

    @Override
    public List<String> createBackup(Map<Integer, Order> allOrders) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
