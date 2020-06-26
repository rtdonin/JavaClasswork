/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:
*/

package flooring.service;

import flooring.dao.FlooringOrderDao;
import flooring.dao.FlooringProductDao;
import flooring.dao.FlooringStateDao;
import flooring.dto.Order;
import flooring.dto.Product;
import flooring.dto.State;
import java.time.LocalDate;
import java.util.Map;

public class FlooringServiceLayerImpl implements FlooringServiceLayer {

    FlooringOrderDao orderDao;
    FlooringProductDao productDao;
    FlooringStateDao stateDao;
    
    public FlooringServiceLayerImpl(FlooringOrderDao orderDao, FlooringProductDao productDao, FlooringStateDao stateDao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void getAllOrdera(Map<LocalDate, Map<Integer, Order>> allOrders) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Map<Integer, Order> getDateOrders(LocalDate date) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Order getOrder(Map<Integer, Order> ordersFromDate, Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Integer getNewId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Order calculateProductCostTax(Order order) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Order addOrder(Order newOrder) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void ValidateOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Map<String, Product> getAllProducts() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Product getProducts(String productType) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Map<String, State> getAllStates() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public State getState(String stateAbbreviation) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Order editOrder(Order editOrder) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Order removeOrder(Order removeOrder) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void export() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
