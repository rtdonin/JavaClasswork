/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:
*/

package flooring.dao;

import flooring.dto.Order;
import java.time.LocalDate;
import java.util.List;

public interface FlooringOrderDao {
    public List<Order> getAllOrders(LocalDate date) throws FlooringPersistenceException;
    public Order getOrder(LocalDate date, Integer id) throws FlooringPersistenceException;
    public Order addOrder(Order order) throws FlooringPersistenceException;
    public Order editOrder(Order order) throws FlooringPersistenceException ;
    public Order removeOrder(Order order) throws FlooringPersistenceException ;
    public List<Order> exportAll() throws FlooringPersistenceException;
}
