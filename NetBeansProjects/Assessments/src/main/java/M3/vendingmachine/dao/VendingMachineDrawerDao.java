/*
Created by: Margaret Donin
Date created: 06/12/20
Date revised:
*/

package M3.vendingmachine.dao;

import M3.vendingmachine.dto.Coin;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineDrawerDao {
    private Map<Coin, Integer> changeInDrawer = new HashMap<>();
    private static final String DELIMITER = "::";
    private static final String DRAWER_FILE = "drawer.txt";
    private BigDecimal totalSales;
    
    public Map<Coin, Integer> getDrawer() throws VendingMachinePersistenceException {
        loadDrawer();
        return changeInDrawer;
    }
    
    public void editAmount(Map<Coin, Integer> given, BigDecimal sale) throws VendingMachinePersistenceException {
        loadDrawer();
        totalSales = totalSales.add(sale);
        
        for(Coin c : Coin.values()) {
            int amount = changeInDrawer.get(c) - given.get(c);
            changeInDrawer.put(c, amount);
        }
        
        writeDrawer();

    }
    
    public Map<Coin, Integer> restockDrawer(Map<Coin, Integer> additional) throws VendingMachinePersistenceException {
        loadDrawer();
        for(Coin c : Coin.values()) {
            int newAmount = changeInDrawer.get(c) + additional.get(c);
            
            changeInDrawer.put(c, newAmount);
        }
        writeDrawer();
        
        return changeInDrawer;
    }
    
    private void loadDrawer() throws VendingMachinePersistenceException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DRAWER_FILE)));
        } catch(FileNotFoundException e) {
            throw new VendingMachinePersistenceException("Could not load drawer :( ", e);
        }
               
        while(scanner.hasNextLine()) {
            if(scanner.hasNextBigDecimal()) {
                totalSales = new BigDecimal(scanner.nextLine());

            } else {
                String[] tokens = scanner.nextLine().split(DELIMITER);
                changeInDrawer.put(Coin.valueOf(tokens[0]), parseInt(tokens[1]));
            }
        }
        // close scanner
        scanner.close();
        
    }
    
    private void writeDrawer() throws VendingMachinePersistenceException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(DRAWER_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException("Could not save drawer.", e);
        }
        
        String newLine = totalSales.toString();
        out.println(newLine);
        out.flush();
        
        for(Coin c : Coin.values()) {
            newLine = c + DELIMITER + changeInDrawer.get(c);
            out.println(newLine);
            out.flush();
        }
        
        out.close();

    }

    public BigDecimal getTotalSales() throws VendingMachinePersistenceException {
        loadDrawer();
        return totalSales;
    }

    public void resetTotalSales() throws VendingMachinePersistenceException {
        loadDrawer();
        totalSales = BigDecimal.ZERO;
        writeDrawer();
    }

}
