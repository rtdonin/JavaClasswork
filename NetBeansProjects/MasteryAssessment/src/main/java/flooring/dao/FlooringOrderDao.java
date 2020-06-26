/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:
*/

package flooring.dao;

import flooring.dto.Order;
import java.time.LocalDate;
import java.util.Map;

public interface FlooringOrderDao {
    public Map<LocalDate, Map<Integer, Order>> getAllOrders();
    public Order getOrder(String dateId);
    public Order addOrder(Order newOrder);
    public Order editOrder(Order editedOrder);
    public Order removeOrder(Order removeOrder);
}
