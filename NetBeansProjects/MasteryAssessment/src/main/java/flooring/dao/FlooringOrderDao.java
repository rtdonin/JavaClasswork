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
    
    /**
     * Takes in a date and returns a List of Orders from that date.
     * 
     * @param date
     * @return list of orders
     * @throws FlooringPersistenceException 
     */
    public List<Order> getAllOrders(LocalDate date) throws FlooringPersistenceException;
    
    /**
     * Looks for an order by id from a specific day.
     * 
     * @param date
     * @param id
     * @return Order
     * @throws FlooringPersistenceException 
     */
    public Order getOrder(LocalDate date, Integer id) throws FlooringPersistenceException;
    
    /**
     * Adds an order to Map of Orders with the key being the Integer id
     * 
     * @param order
     * @return added Order
     * @throws FlooringPersistenceException 
     */
    public Order addOrder(Order order) throws FlooringPersistenceException;
    
    /**
     * Edit an order in Map of orders. 
     *
     * @param order
     * @return the edited order
     * @throws FlooringPersistenceException 
     */
    public Order editOrder(Order order) throws FlooringPersistenceException;
    
    /**
     * Removes an order from the Map allOrders
     * If the Map is empty the associated file is deleted.
     * 
     * @param order
     * @return removed order
     * @throws FlooringPersistenceException 
     */
    public Order removeOrder(Order order) throws FlooringPersistenceException;
    
    /**
     * Takes all the orders in all the files and puts them in a List of Orders
     * 
     * @return list of all the orders.
     * @throws FlooringPersistenceException 
     */
    public List<Order> exportAll() throws FlooringPersistenceException;
}
