/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:
*/

package flooring.dao;

import flooring.dto.Order;
import flooring.dto.Product;
import flooring.dto.State;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FlooringOrderDaoImpl implements FlooringOrderDao {
    private Map<LocalDate, Map<Integer, Order>> allOrders = new HashMap<>();
    private Map<Integer, Order> orders = new HashMap<>();
    private String folderName;
    private final String DELIMITER = ",";

    public FlooringOrderDaoImpl() {
        this.folderName = ".//Orders";
    }
    
    public FlooringOrderDaoImpl(String folderName) {
        this.folderName = ".//" + folderName;
    }

    @Override
    public List<Order> getAllOrders(LocalDate date) throws FlooringPersistenceException{
        File fileName = getFileName(date);
        loadFile(fileName);
        List<Order> listOrders = new ArrayList<>();
        listOrders.addAll(orders.values());
        return listOrders;
    }

    @Override
    public Order getOrder(LocalDate date, Integer id) throws FlooringPersistenceException{
        File fileName = getFileName(date);
        loadFile(fileName);
        return orders.get(id);
    }

    @Override
    public Order addOrder(Order order) throws FlooringPersistenceException {
        File fileName = getFileName(order.getDate());
        Order added = orders.put(order.getId(), order);
        writeFile(fileName);
        return added;
    }

    @Override
    public Order editOrder(Order order) throws FlooringPersistenceException {
        File fileName = getFileName(order.getDate());
        loadFile(fileName);
        Order edited = orders.replace(order.getId(), order);
        writeFile(fileName);
        return edited;
    }

    @Override
    public Order removeOrder(Order order) throws FlooringPersistenceException {
        File fileName = getFileName(order.getDate());
        loadFile(fileName);
        Order removed = orders.remove(order.getId());
        writeFile(fileName);
        return removed;
    }

    @Override
    public List<Order> exportAll() throws FlooringPersistenceException{
        loadFolder();
        List<Order> listOrders = new ArrayList<>();
        Set<LocalDate> dates = allOrders.keySet();
        
        // iterate through keySet of dates
        // .values() returns a collection which we cast to List
        // we .addAll the elements in temp to listOrders
        
        for(LocalDate ld : dates){
            listOrders.addAll(allOrders.get(ld).values());
        }
        
        return listOrders;
    }
    
    private void loadFolder() throws FlooringPersistenceException{
        File folder = new File(folderName);
        File[] listOfFiles = folder.listFiles();
        
        allOrders = new HashMap<>();
        
        for(File f : listOfFiles){
            loadFile(f);
            String[] fileDate = f.toString().split("_|(.txt)");
            LocalDate ld = LocalDate.parse(fileDate[1], DateTimeFormatter.ofPattern("MMddyyyy"));

            allOrders.put(ld, orders);
        }

    }
        
    
    private void loadFile(File file) throws FlooringPersistenceException{
        Scanner scanner = null;
        
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(file)));
        } catch(FileNotFoundException e) {
            // do nothing.
        }
        
        String currentLine;
        Order currentOrder;
        this.orders = new HashMap<Integer, Order>();
        
        // skip the first line
        scanner.nextLine();
        
        while(scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentOrder = unmarshallData(currentLine);
            orders.put(currentOrder.getId(), currentOrder);
        }
        // close scanner
        scanner.close();
    }
    
    private void writeFile(File file) throws FlooringPersistenceException{
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(file));
        } catch (IOException e) {
            throw new FlooringPersistenceException("Could not save orders.", e);
        }
        
        Set<Integer> id = orders.keySet();
        out.println("OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total");
        out.flush();
        
        for (Integer i : id) {
            String line = marshallData(orders.get(i));
            out.println(line);
            out.flush();
        }

        out.close();
    }
    
    private String marshallData(Order currentOrder){
        String orderAsText = currentOrder.getId() + DELIMITER;
        orderAsText += currentOrder.getName() + DELIMITER;
        orderAsText += currentOrder.getState().getStateAbbreviation() + DELIMITER;
        orderAsText += currentOrder.getState().getTaxRate().toPlainString() + DELIMITER;
        orderAsText += currentOrder.getProduct().getProductType() + DELIMITER;
        orderAsText += currentOrder.getArea().toPlainString() + DELIMITER;
        orderAsText += currentOrder.getProduct().getCostPerSquareFoot().toPlainString() + DELIMITER;
        orderAsText += currentOrder.getProduct().getLaborCostPerSquareFoot().toPlainString() + DELIMITER;
        orderAsText += currentOrder.getMaterialCost().toPlainString() + DELIMITER;
        orderAsText += currentOrder.getLaborCost().toPlainString() + DELIMITER;
        orderAsText += currentOrder.getTax().toPlainString() + DELIMITER;
        orderAsText += currentOrder.getTotal().toPlainString();
        
        return orderAsText;
    }
    
    /**
     * 0. OrderNumber
     * 1. CustomerName
     * 2. State Abbreviation
     * 3. TaxRate
     * 4. ProductType
     * 5. Area
     * 6. CostPerSquareFoot
     * 7. LaborCostPerSquareFoot
     * 8. MaterialCost
     * 9. LaborCost
     * 10. Tax
     * 11. Total
     */
    
    private Order unmarshallData(String currentLine){
//        Must assume user is aweful and therefore can not use this:        
//        String[] tokens = currentLine.split(",(?=(?:[a-zA-Z0-9.s]))");
        
        String[] tokens  =  currentLine.split(DELIMITER);
        
        Integer id = parseInt(tokens[0]);
        Order order = new Order(id);
        
        int x = tokens.length - 12;
        String name = "";
        
        for (int i = 0; i <= x; i++){
            name += tokens [1+i];
        }
        
        order.setName(name);
        
        order.setState(new State(tokens[2 + x], new BigDecimal(tokens[3 + x])));
        order.setProduct(new Product(tokens[4 + x], new BigDecimal(tokens[6 + x]), new BigDecimal(tokens[7 + x])));
        order.setArea(new BigDecimal(tokens[5 + x]));
        order.setMaterialCost(new BigDecimal(tokens[8 + x]));
        order.setLaborCost(new BigDecimal(tokens[9 + x]));
        order.setTax(new BigDecimal(tokens[10 + x]));
        order.setTotal(new BigDecimal(tokens[11 + x]));
        
        return order;
    }

    private File getFileName(LocalDate date) {
        String fileName = folderName + "//Orders_";
        fileName += date.format(DateTimeFormatter.ofPattern("MMddyyyy"));
        fileName += ".txt";
        
        File file = new File(fileName);
        return file;
    }

}
