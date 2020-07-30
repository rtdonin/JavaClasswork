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
    /**
     * Takes a LocalDate date and returns a List of Orders from that date.
     * If there are no orders from this date, the OrderDao will throw a persistence
     * exception.This exception is caught and the list if set to null. When the
     * value reaches the view the view will tell the user that there are no orders
     * from this date.
     * 
     * @param date
     * @return List
     */
    public List<Order> getDateOrders(LocalDate date);
    
    /**
     * Get an order by LocalDate date and Integer id
     * If there are no orders from this date, the OrderDao will throw a persistence
     * exception.This exception is caught later in the controller. The view will
     * then display there are no orders from this date. If there are orders from
     * this date, but nothing with this id, the view will inform the user that the
     * id was incorrect.
     * 
     * @param date
     * @param id
     * @return Order
     */
    public Order getOrder(LocalDate date, Integer id) throws FlooringPersistenceException;
    
    /**
     * Gets a new Integer id by adding '1' to the largest id.
     * 
     * @return Integer
     * @throws FlooringPersistenceException 
     */
    public Integer getNewId() throws FlooringPersistenceException;
    
    /**
     * Takes a new Order and adds it to the file.
     * Returns the added order.
     * 
     * @param newOrder
     * @return added Order
     * @throws FlooringPersistenceException 
     */
    public Order addOrder(Order newOrder) throws FlooringPersistenceException;
    
    /**
     * Validates an Order.
     * 
     * Checks that the name is a valid name and only contains alphanumeric values, commas, and periods.
     * Checks that the date is not null and is after today.
     * Checks that the Area is the greater than of equals to the minimum area
     * Checks that the product and state are not null.
     * @param order
     * @return
     * @throws InvalidAreaException, InvalidDateException, InvalidNameException, InvalidProductException, InvalidStateException
     */
    public Order validateOrder(Order order) throws InvalidAreaException, InvalidDateException, InvalidNameException, InvalidProductException, InvalidStateException;
    
    /**
     * Returns a map of all products/
     * 
     * @return Map
     * @throws FlooringPersistenceException 
     */
    public Map<String, Product> getAllProducts() throws FlooringPersistenceException ;
    
    /**
     * Returns a map of all states
     * 
     * @return Map
     * @throws FlooringPersistenceException 
     */
    public Map<String, State> getAllStates() throws FlooringPersistenceException;
    
    /**
     * Validates and recalculates the new edited Order
     * 
     * @param oldOrder
     * @param newOrder
     * @return
     * @throws InvalidAreaException
     * @throws InvalidDateException
     * @throws InvalidNameException
     * @throws InvalidProductException
     * @throws InvalidStateException 
     */
    public Order checkNewOrder(Order oldOrder, Order newOrder) throws InvalidAreaException, InvalidDateException, InvalidNameException, InvalidProductException, InvalidStateException;
    
    /**
     * Edits the order in the OrderDao.
     * 
     * @param editedOrder
     * @return editedOrder
     * @throws FlooringPersistenceException 
     */
    public Order editOrder(Order editedOrder) throws FlooringPersistenceException;
    
    /**
     * Removes the Order from the OrderDao
     * 
     * @param removeOrder
     * @return deleted Order
     * @throws FlooringPersistenceException 
     */
    public Order removeOrder(Order removeOrder) throws FlooringPersistenceException;
    
    /**
     * Exports all Orders from the OrderDao to the ExportDao
     * 
     * @throws FlooringPersistenceException 
     */
    public void export() throws FlooringPersistenceException;
    
    /**
     * Translates user input into boolean.
     * Yes and y in any case will return True.
     * No and n in any case will return False.
     * 
     * @param confirmation
     * @return boolean
     * @throws NotYesOrNoException 
     */
    public boolean compConfirmation(String confirmation) throws NotYesOrNoException;
}
