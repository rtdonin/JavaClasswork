/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:
*/

package flooring.service;

import flooring.dao.FlooringPersistenceException;
import flooring.dto.Order;
import flooring.dto.Product;
import flooring.dto.State;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface FlooringServiceLayer {
    public List<Order> getDateOrders(LocalDate date) throws FlooringPersistenceException;
    public Order getOrder(LocalDate date, Integer id) throws FlooringPersistenceException;
    public Integer getNewId() throws FlooringPersistenceException;
    public Order addOrder(Order newOrder) throws FlooringPersistenceException;
    public Order validateOrder(Order order) throws InvalidAreaException, InvalidDateException, InvalidNameException;
    public Map<String, Product> getAllProducts() throws FlooringPersistenceException ;
    public Map<String, State> getAllStates() throws FlooringPersistenceException;
    public Order checkNewOrder(Order oldOrder, Order newOrder) throws InvalidAreaException, InvalidDateException, InvalidNameException;
    public Order editOrder(Order editedOrder) throws FlooringPersistenceException;
    public Order removeOrder(Order removeOrder) throws FlooringPersistenceException;
    public void export() throws FlooringPersistenceException;
    public boolean compConfirmation(String confirmation) throws NotYesOrNoException;
}
