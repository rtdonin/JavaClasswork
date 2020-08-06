/*
Created by: Margaret Donin
Date created: 06/26/20
Date revised:
*/

package flooring.service;

import flooring.dao.FlooringOrderDao;
import flooring.dao.FlooringPersistenceException;
import flooring.dto.Order;
import flooring.dto.Product;
import flooring.dto.State;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlooringOrderDaoImplStub implements FlooringOrderDao {

    private Order onlyOrder;
    
    public FlooringOrderDaoImplStub(){
        this.onlyOrder = new Order(1);
        onlyOrder.setName("Acme Inc.");
        onlyOrder.setArea(new BigDecimal("200"));
        onlyOrder.setDate(LocalDate.of(2020, 7, 10));
        onlyOrder.setState(new State("NY", "New York", new BigDecimal("4.00")));
        onlyOrder.setProduct(new Product("Stone", new BigDecimal("3.50"), new BigDecimal("4.00")));
    }

    public FlooringOrderDaoImplStub(Order onlyOrder) {
        this.onlyOrder = onlyOrder;
    }
    
    
    @Override
    public List<Order> getAllOrders(LocalDate date) throws FlooringPersistenceException {
        List<Order> allOrders = null;

        if (date.equals(onlyOrder.getDate())) {
            allOrders= new ArrayList<>();
            allOrders.add(onlyOrder);
        } else {
            throw new FlooringPersistenceException("");
        }
        
        return allOrders;
    }

    @Override
    public Order getOrder(LocalDate date, Integer id) throws FlooringPersistenceException {
        if (date.equals(onlyOrder.getDate()) && id.equals(onlyOrder.getId())) {
            return onlyOrder;
        } if (!date.equals(onlyOrder.getDate())) {
            throw new FlooringPersistenceException("ex");
        } else {
            return null;
        }
    }

    @Override
    public Order addOrder(Order newOrder) {
        return newOrder;
    }

    @Override
    public Order editOrder(Order editedOrder) {
        return editedOrder;
    }

    @Override
    public Order removeOrder(Order removeOrder) {
        LocalDate date = removeOrder.getDate();
        Integer id = removeOrder.getId();
        
        if (date.equals(onlyOrder.getDate()) && id.equals(onlyOrder.getId())) {
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public List<Order> exportAll() {
        List<Order> allOrders = new ArrayList<>();
        allOrders.add(onlyOrder);
        
        return allOrders;
    }

}
