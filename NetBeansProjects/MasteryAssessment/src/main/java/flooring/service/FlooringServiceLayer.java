/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:
*/

package flooring.service;

import flooring.dto.Order;
import flooring.dto.Product;
import flooring.dto.State;
import java.time.LocalDate;
import java.util.Map;

public interface FlooringServiceLayer {
    public void getAllOrdera(Map<LocalDate, Map<Integer, Order>> allOrders);
    public Map<Integer, Order> getDateOrders(LocalDate date);
    public Order getOrder(Map<Integer, Order> ordersFromDate, Integer id);
    public Integer getNewId();
    public Order calculateProductCostTax(Order order);
    public Order addOrder(Order newOrder);
    public void ValidateOrder(Order order);
    public Map<String, Product> getAllProducts();
    public Product getProducts(String productType);
    public Map<String, State> getAllStates();
    public State getState(String stateAbbreviation);
    public Order editOrder(Order editOrder);
    public Order removeOrder(Order removeOrder);
    public void export();
}
