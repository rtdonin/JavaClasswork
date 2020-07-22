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
    private List<Map<Integer, Order>> allOrders = new ArrayList<>();
    private Map<Integer, Order> orders = new HashMap<>();
    private final String folderName;
    private LocalDate date;
    private final String DELIMITER = ",";
    private final String REPLACEMENT = "::";

    public FlooringOrderDaoImpl() {
        this.folderName = "Orders";
    }
    
    public FlooringOrderDaoImpl(String folderName) {
        this.folderName = folderName;
    }

    @Override
    public List<Order> getAllOrders(LocalDate date) throws FlooringPersistenceException {
        this.date = date;
        File fileName = getFileName();
        loadFile(fileName);
        List<Order> listOrders = new ArrayList<>();
        listOrders.addAll(orders.values());
        return listOrders;
    }

    @Override
    public Order getOrder(LocalDate date, Integer id) throws FlooringPersistenceException{
        this.date = date;
        File fileName = getFileName();
        Order order = null;

        if (fileName.exists()) {
            loadFile(fileName);
            order = orders.get(id);
        }
        
        return order;
    }

    @Override
    public Order addOrder(Order order) throws FlooringPersistenceException {
        this.orders = new HashMap<>();
        this.date = order.getDate();
        File fileName = getFileName();
        
        if (!fileName.exists()) {
            try {
                fileName.createNewFile();
            } catch (IOException ex) {
                throw new FlooringPersistenceException("Could not create file.");
            }
            
        } else {
            loadFile(fileName);
        }
        
        orders.put(order.getId(), order);
        writeFile(fileName);

        return order;
    }

    @Override
    public Order editOrder(Order order) throws FlooringPersistenceException {
        this.date = order.getDate();
        File fileName = getFileName();
        loadFile(fileName);
        orders.replace(order.getId(), order);
        writeFile(fileName);
        return order;
    }

    @Override
    public Order removeOrder(Order order) throws FlooringPersistenceException {
        this.date = order.getDate();
        File fileName = getFileName();
        loadFile(fileName);
        Order removed = orders.remove(order.getId());
        
        if (orders.isEmpty()) {
            fileName.delete();
        } else {
            writeFile(fileName);
        }
        return removed;
    }

    @Override
    public List<Order> exportAll() throws FlooringPersistenceException{
        loadFolder();
        List<Order> listOrders = new ArrayList<>();
        
        for(Map<Integer, Order> o : allOrders){
            listOrders.addAll(o.values());
        }
        
        return listOrders;
    }
    
    /**
     * Loads the folder where all the files are and walks through the folder.
     * 
     * @throws FlooringPersistenceException 
     */
    private void loadFolder() throws FlooringPersistenceException{
        File folder = new File(folderName);
        File[] listOfFiles = folder.listFiles();
        
        for(File f : listOfFiles){
            String[] fileDate = f.toString().split("_|(.txt)");
            LocalDate ld = LocalDate.parse(fileDate[1], DateTimeFormatter.ofPattern("MMddyyyy"));
            this.date = ld;
            
            loadFile(f);
            allOrders.add(orders);
        }

    }
        
    /**
     * Loads the File file, clears orders from the map, and then populates map orders
     * 
     * @param file
     * @throws FlooringPersistenceException 
     */
    private void loadFile(File file) throws FlooringPersistenceException{
        Scanner scanner = null;
        
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(file)));
        } catch(FileNotFoundException e) {
            this.orders = null;
        }
        
        String currentLine;
        Order currentOrder;
        
        // creates a new map of for listings.
        this.orders = new HashMap<>();
        
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
    
    /**
     * Writes to a File file the Map orders.
     * 
     * @param file
     * @throws FlooringPersistenceException 
     */
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

        // clears listings
        this.orders = new HashMap<>();
        out.close();
    }
    
    /**
     * Takes an Order and converts it to a string for printing.
     * 
     * @param currentOrder
     * @return 
     */
    private String marshallData(Order currentOrder){
        String orderAsText = currentOrder.getId() + DELIMITER;
        orderAsText += currentOrder.getName().replace(DELIMITER, REPLACEMENT) + DELIMITER;
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
     * Takes a String and converts it to an Order
     * 
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
     * 
     * @param currentLine
     * @return 
     */
    
    private Order unmarshallData(String currentLine){
//        Must assume user is aweful and therefore can not use this:        
//        String[] tokens = currentLine.split(",(?=(?:[a-zA-Z0-9.s]))");
        
        String[] tokens  =  currentLine.split(DELIMITER);
        
        Integer id = parseInt(tokens[0]);
        Order order = new Order(id);

        String name  = tokens[1].replace(REPLACEMENT, DELIMITER);
        
        order.setName(name);
        order.setState(new State(tokens[2], new BigDecimal(tokens[3])));
        order.setProduct(new Product(tokens[4], new BigDecimal(tokens[6]), new BigDecimal(tokens[7])));
        order.setArea(new BigDecimal(tokens[5]));
        order.setMaterialCost(new BigDecimal(tokens[8]));
        order.setLaborCost(new BigDecimal(tokens[9]));
        order.setTax(new BigDecimal(tokens[10]));
        order.setTotal(new BigDecimal(tokens[11]));
        order.setDate(date);
        
        return order;
    }

    /**
     * Using the LocalDate date creates the correct file name.
     * 
     * @return 
     */
    private File getFileName() {
        String fileName = folderName + "//Orders_";
        fileName += date.format(DateTimeFormatter.ofPattern("MMddyyyy"));
        fileName += ".txt";
        
        File file = new File(fileName);
        return file;
    }

}
