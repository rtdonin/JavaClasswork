/*
Created by: Margaret Donin
Date created: 06/26/20
Date revised:
*/

package flooring.service;

import flooring.dao.FlooringExportDao;
import flooring.dao.FlooringPersistenceException;
import flooring.dto.Order;
import java.util.List;

public class FlooringExportDaoImplStub implements FlooringExportDao {

    @Override
    public void createBackup(List<Order> allOrders) throws FlooringPersistenceException {
        // do nothing.
    }

}
