/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:
*/

package flooring.service;

import flooring.dao.FlooringExportDao;
import flooring.dao.FlooringOrderDao;
import flooring.dao.FlooringPersistenceException;
import flooring.dao.FlooringProductDao;
import flooring.dao.FlooringStateDao;
import flooring.dto.Order;
import flooring.dto.Product;
import flooring.dto.State;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlooringServiceLayerImpl implements FlooringServiceLayer {

    FlooringExportDao exportDao;
    FlooringOrderDao orderDao;
    FlooringProductDao productDao;
    FlooringStateDao stateDao;

    public FlooringServiceLayerImpl(FlooringExportDao exportDao, FlooringOrderDao orderDao, FlooringProductDao productDao, FlooringStateDao stateDao) {
        this.exportDao = exportDao;
        this.orderDao = orderDao;
        this.productDao = productDao;
        this.stateDao = stateDao;
    }

    @Override
    public List<Order> getDateOrders(LocalDate date) {
        List<Order> orders = null;
        
        try {
            orders = orderDao.getAllOrders(date);
        } catch (FlooringPersistenceException ex) {
            // do nothing.
            // view will display "No orders from this date
        }
        
        return orders;
    }

    @Override
    public Order getOrder(LocalDate date, Integer id) throws FlooringPersistenceException{
        return orderDao.getOrder(date, id);
    }

    @Override
    public Integer getNewId() throws FlooringPersistenceException {
        Integer id = orderDao.exportAll().stream()
                .mapToInt((o) -> o.getId())
                .max().getAsInt();
        
        return id + 1;
    }

    @Override
    public Order addOrder(Order newOrder) throws FlooringPersistenceException {
        return orderDao.addOrder(newOrder);
    }

    @Override
    public Order validateOrder(Order order) throws InvalidAreaException, InvalidDateException, InvalidNameException, InvalidProductException, InvalidStateException {
        String name = order.getName();
        
        if (name == null || name.trim().length() == 0) {
            throw new InvalidNameException("Name is invalid.");
        } else {
            Pattern pName = Pattern.compile("[^a-zA-Z0-9,. ]");
            Matcher mName = pName.matcher(name);
            boolean b = mName.find();
        
            if (b) {
                throw new InvalidNameException("Name is invalid.");
            }
            
        }
        
        LocalDate today = LocalDate.now();
        LocalDate date = order.getDate();
        
        if(date == null || date.isBefore(today) || date.isEqual(today)){
            throw new InvalidDateException("Invalid date.");
        }
        
        BigDecimal area = order.getArea();
        
        if (area == null || area.compareTo(new BigDecimal("100")) == -1) {
            throw new InvalidAreaException("Area is less that 100 sq ft.");
        }
        
        if (order.getState() == null) {
            throw new InvalidStateException("Invalid state.");
        }
        
        if (order.getProduct() == null) {
            throw new InvalidProductException("Invalid product.");
        }
        
        return calculateProductCostTax(order);
    }

    @Override
    public Map<String, Product> getAllProducts() throws FlooringPersistenceException {
        return productDao.getAllProducts();
    }

    @Override
    public Map<String, State> getAllStates() throws FlooringPersistenceException {
        return stateDao.getAllStates();
    }

    @Override
    public Order checkNewOrder(Order oldOrder, Order newOrder) throws InvalidAreaException, InvalidDateException, InvalidNameException, InvalidProductException, InvalidStateException {
        newOrder.setDate(oldOrder.getDate());
        
        String newName = newOrder.getName();
        
        if (newName == null || newName.trim().length() == 0) {
            newOrder.setName(oldOrder.getName());
        }

        if (newOrder.getArea() == null){
            newOrder.setArea(oldOrder.getArea());
        }
        
        if (newOrder.getState() == null) {
           newOrder.setState(oldOrder.getState());
        }
        
        if (newOrder.getProduct() == null) {
           newOrder.setProduct(oldOrder.getProduct());
        }
        
        validateOrder(newOrder);
        
        calculateProductCostTax(newOrder);
           
        return newOrder;
    }

    @Override
    public Order editOrder(Order editedOrder) throws FlooringPersistenceException{
        return orderDao.editOrder(editedOrder);
    }

    @Override
    public Order removeOrder(Order removeOrder) throws FlooringPersistenceException{
        return orderDao.removeOrder(removeOrder);
    }

    @Override
    public void export() throws FlooringPersistenceException {
        List<Order> allOrders = orderDao.exportAll();
        exportDao.createBackup(allOrders);
    }
      
    @Override
    public boolean compConfirmation(String confirmation) throws NotYesOrNoException{
        confirmation = confirmation.toLowerCase();
        
        Pattern pYes = Pattern.compile("^y(es)?$");
        Matcher mYes = pYes.matcher(confirmation);

        Pattern pNo = Pattern.compile("^n(o)?$");
        Matcher mNo = pNo.matcher(confirmation);
        
        if (mYes.matches()){
            return true;
        } else if (mNo.matches()) {
            return false;
        } else {
            throw new NotYesOrNoException("Not a yes or no.");
        }
    }
    
    /**
     * Take an order and calculates the proper materials, labor, tax, and cost.
     * Returns the order with the correct values.
     * 
     * @param order
     * @return 
     */
    private Order calculateProductCostTax(Order order) {
//        MathContext mc = new MathContext(2, RoundingMode.HALF_UP);
        BigDecimal taxRate = order.getState().getTaxRate();
        taxRate = taxRate.divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
        
        BigDecimal laborCostPerSquareFoot = order.getProduct().getLaborCostPerSquareFoot();
        BigDecimal materialCostPerSquareFoot = order.getProduct().getCostPerSquareFoot();
        BigDecimal area = order.getArea();
        
        BigDecimal laborCost = laborCostPerSquareFoot.multiply(area).setScale(2);
        BigDecimal materialCost = area.multiply(materialCostPerSquareFoot).setScale(2);
        BigDecimal tax = (laborCost.add(materialCost)).multiply(taxRate).setScale(2);
        
        BigDecimal total = laborCost.add(materialCost).add(tax);
        
        order.setLaborCost(laborCost);
        order.setMaterialCost(materialCost);
        order.setTax(tax);
        order.setTotal(total);
        
        return order;
    }

}
