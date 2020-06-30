/*
Created by: Margaret Donin
Date created: 06/26/20
Date revised:
*/

package flooring.service;

import flooring.dao.FlooringOrderDao;
import flooring.dto.Order;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class FlooringOrderDaoImplStub implements FlooringOrderDao {

    @Override
    public Map<Integer, Order> getAllOrders(LocalDate date) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Order getOrder(String dateId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Order addOrder(Order newOrder) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Order editOrder(Order editedOrder) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Order removeOrder(Order removeOrder) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Order> exportAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    

}
