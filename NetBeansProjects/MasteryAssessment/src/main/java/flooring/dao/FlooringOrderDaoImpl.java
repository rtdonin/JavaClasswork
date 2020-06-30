/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:
*/

package flooring.dao;

import flooring.dto.Order;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class FlooringOrderDaoImpl implements FlooringOrderDao {

    private Map<LocalDate, Map<Integer, Order>> allOrders;
    private String orderFile;
    private final String DELIMITER = ",";
    
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

    private void loadFile(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private void writeFile(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private String marshallData(Order currentOrder){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private Order unmarshallData(String currentLine){
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
