/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:
*/

package flooring.dao;

import flooring.dto.Order;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FlooringExportDaoImpl implements FlooringExportDao {
    private final String BACKUP_FILE;
    private final String DELIMITER = ",";
    
    public FlooringExportDaoImpl(){
        this.BACKUP_FILE = "Backup/DataExprot.txt";
    }
    
    public FlooringExportDaoImpl(String fileName){
        this.BACKUP_FILE = fileName;
    }
    
    @Override
    public void createBackup(List<Order> allOrders) throws FlooringPersistenceException {
                PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(BACKUP_FILE));
        } catch (IOException e) {
            throw new FlooringPersistenceException("Could not save drawer.", e);
        }
        
        String newLine;
        out.println("OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total,OrderDate");
        out.flush();
        
        for(Order o : allOrders) {
            newLine = marshallData(o);
            out.println(newLine);
            out.flush();
        }
        
        out.close();
    }
    
    /**
     * Take an Order and converts it to a String for printing.
     * 
     * @param currentOrder
     * @return String
     */
    private String marshallData(Order currentOrder) {
        String currentLine = currentOrder.getId() + DELIMITER;
        currentLine += currentOrder.getName() + DELIMITER;
        currentLine += currentOrder.getState().getStateAbbreviation() + DELIMITER;
        currentLine += currentOrder.getState().getTaxRate().toPlainString() + DELIMITER;
        currentLine += currentOrder.getProduct().getProductType() + DELIMITER;
        currentLine += currentOrder.getArea().toPlainString() + DELIMITER;
        currentLine += currentOrder.getProduct().getCostPerSquareFoot().toPlainString() + DELIMITER;
        currentLine += currentOrder.getProduct().getLaborCostPerSquareFoot().toPlainString() + DELIMITER;
        currentLine += currentOrder.getMaterialCost().toPlainString() + DELIMITER;
        currentLine += currentOrder.getLaborCost().toPlainString() + DELIMITER;
        currentLine += currentOrder.getTax().toPlainString() + DELIMITER;
        currentLine += currentOrder.getTotal().toPlainString() + DELIMITER;
        currentLine += currentOrder.getDate().toString();
        
        return currentLine;
    }

}
