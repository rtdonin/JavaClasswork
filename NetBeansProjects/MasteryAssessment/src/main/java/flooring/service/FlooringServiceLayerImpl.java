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
    public List<Order> getDateOrders(LocalDate date) throws FlooringPersistenceException {
        return orderDao.getAllOrders(date);
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
    public Order validateOrder(Order order) throws InvalidAreaException, InvalidDateException, InvalidNameException {
        if (order.getArea() == null || order.getArea().compareTo(new BigDecimal("100")) == -1) {
            throw new InvalidAreaException("Area is less that 100 sq ft.");
        }
        
        Pattern pName = Pattern.compile("[^a-zA-Z0-9,. ]");
        Matcher mName = pName.matcher(order.getName());
        
        if (order.getName() == null || order.getName().trim().length() == 0 || mName.matches()) {
            throw new InvalidNameException("Name is invalid.");
        }
        
        LocalDate today = LocalDate.now();
        
        if(order.getDate() == null || order.getDate().isBefore(today)){
            throw new InvalidDateException("Invalid date.");
        }
        
        return order;
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
    public Order checkNewOrder(Order oldOrder, Order newOrder) throws InvalidAreaException, InvalidDateException, InvalidNameException {
        
        if (newOrder.getName() == null || newOrder.getName().trim().length() == 0) {
            newOrder.setName(oldOrder.getName());
        }
        
        if (newOrder.getArea() == null || newOrder.getArea().compareTo(new BigDecimal("100")) == -1){
            newOrder.setArea(oldOrder.getArea());
        }
        
        validateOrder(newOrder);
        
        newOrder = calculateProductCostTax(newOrder);
           
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
    
    private Order calculateProductCostTax(Order order) {
        BigDecimal taxRate = order.getState().getTaxRate();
        taxRate = taxRate.divide(new BigDecimal("100"));
        
        BigDecimal laborCostPerSquareFoot = order.getProduct().getLaborCostPerSquareFoot();
        BigDecimal materialCostPerSquareFoot = order.getProduct().getCostPerSquareFoot();
        BigDecimal area = order.getArea();
        
        BigDecimal laborCost = area.multiply(laborCostPerSquareFoot);
        BigDecimal materialCost = area.multiply(materialCostPerSquareFoot);
        BigDecimal tax = (laborCost.add(materialCost)).multiply(taxRate);
        
        BigDecimal total = laborCost.add(materialCost).add(tax);
        
        order.setLaborCost(laborCost);
        order.setMaterialCost(materialCost);
        order.setTax(tax);
        order.setTotal(total);
        
        return order;
    }

}
