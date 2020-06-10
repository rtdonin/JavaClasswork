/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M3.vendingmachine.dao;

import M3.vendingmachine.dto.Candy;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class VendingMachineDaoImpl implements VendingMachineDao {

    private Map<String, Candy> sugaryTreats = new HashMap<>();
    private final String SNACK_FILE;
    private static final String DELIMITER = "::";
    
    public VendingMachineDaoImpl() {
        SNACK_FILE = "snackfile.txt";
    }
    
    public VendingMachineDaoImpl(String snackFile) {
        SNACK_FILE = snackFile;
    }
    
    @Override
    public Map<String, Candy> getAllCandy() throws VendingMachinePersistenceException {
        loadInventory();
        return sugaryTreats;
    }

    @Override
    public Candy editCandy(Candy purchasedCandy) throws VendingMachinePersistenceException {
        loadInventory();
        sugaryTreats.remove(purchasedCandy.getName());
        sugaryTreats.put(purchasedCandy.getName(), purchasedCandy);
        writeInventory();
        return purchasedCandy;
    }

    @Override
    public void loadInventory() throws VendingMachinePersistenceException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(SNACK_FILE)));
        } catch(FileNotFoundException e) {
            throw new VendingMachinePersistenceException("Could not load sugary treats :( ", e);
        }
        
        String currentLine;
        Candy currentCandy;
        
        while(scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentCandy = unmarshallCandy(currentLine);
            sugaryTreats.put(currentCandy.getName(), currentCandy);
        }
        // close scanner
        scanner.close();
        
    }

    @Override
    public void writeInventory() throws VendingMachinePersistenceException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(SNACK_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException("Could not save yummy treats.", e);
        }
        
        Collection<Candy> treats = sugaryTreats.values();
        
        treats.stream()
                .forEach((c) -> { out.println(marshallCandy(c));
                                          out.flush();});

        out.close();
        
    }

    @Override
    public String marshallCandy(Candy candy) {
        String marshalledCandy = candy.getName() + DELIMITER;
        marshalledCandy += candy.getPrice() + DELIMITER;
        marshalledCandy += candy.getInventory();
        
        return marshalledCandy;
    }

    @Override
    public Candy unmarshallCandy(String marshalledCandy) {
        String[] candyTokens = marshalledCandy.split(DELIMITER);
        String name = candyTokens[0];
        BigDecimal price = new BigDecimal(candyTokens[1]);
        int inventory = parseInt(candyTokens[2]);
        
        Candy newCandy = new Candy(name, price, inventory);
        
        return newCandy;
    }

    @Override
    public Candy getCandy(String name) throws VendingMachinePersistenceException{
        loadInventory();
        return sugaryTreats.get(name);
    }

}
