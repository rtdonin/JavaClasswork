/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:

Map newMap = Collections.unmodifiableMap(map);

*/

package flooring.dao;

import flooring.dto.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FlooringProductDaoImpl implements FlooringProductDao{
    private final Map<String, Product> allProducts = new HashMap<>();
    private final String PRODUCT_FILE;
    private final String DELIMITER = ",";
    
    public FlooringProductDaoImpl(){
        this.PRODUCT_FILE = "Data/products.txt";
    }
    
    public FlooringProductDaoImpl(String fileName){
        this.PRODUCT_FILE = fileName;
    }
    
    @Override
    public Map<String, Product> getAllProducts() throws FlooringPersistenceException {
        loadFile();
        return allProducts;
    }

    @Override
    public Product getProduct(String productType) throws FlooringPersistenceException {
        loadFile();
        return allProducts.get(productType);
    }
    
    @Override
    public Product addProduct(Product newProduct) throws FlooringPersistenceException {
        loadFile();
        allProducts.put(newProduct.getProductType(), newProduct);
        writeFile();
        return newProduct;
    }

    @Override
    public Product editProduct(Product editProduct) throws FlooringPersistenceException {
        loadFile();
        allProducts.replace(editProduct.getProductType(), editProduct);
        writeFile();
        return editProduct;
    }

    @Override
    public Product removeProduct(Product removeProduct) throws FlooringPersistenceException {
        loadFile();
        allProducts.remove(removeProduct.getProductType());
        writeFile();
        return removeProduct;
    }
    
    private void loadFile() throws FlooringPersistenceException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(PRODUCT_FILE)));
        } catch(FileNotFoundException e) {
            throw new FlooringPersistenceException("Could not load products.", e);
        }
        
        String currentLine;
        Product currentProduct;
        scanner.nextLine();
        
        while(scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentProduct = unmarshallData(currentLine);
            allProducts.put(currentProduct.getProductType(), currentProduct);
        }
        // close scanner
        scanner.close();
    }
    
    private void writeFile() throws FlooringPersistenceException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(PRODUCT_FILE));
        } catch (IOException e) {
            throw new FlooringPersistenceException("Could not save product data.", e);
        }
        
        String productAsText;
        Set<String> abbreviations = allProducts.keySet();
        
        out.println("ProductType,CostPerSquareFoot,LaborCostPerSquareFoot");
        out.flush();
        
        for (String s : abbreviations) {
            productAsText = marshallData(allProducts.get(s));
            out.println(productAsText);
            out.flush();
        }
        
        out.close();
    }
        
    private Product unmarshallData(String currentLine) {
        String[] tokens = currentLine.split(DELIMITER);
        String productType = tokens[0];
        BigDecimal costPerSquareFoot = new BigDecimal(tokens[1]);
        BigDecimal laborCostPerSquareFoot = new BigDecimal(tokens[2]);
        
        Product currentProduct = new Product(productType, costPerSquareFoot, laborCostPerSquareFoot);
        
        return currentProduct;
    }
    
    private String marshallData(Product currentProduct) {
        String marshalledProduct = currentProduct.getProductType() + DELIMITER;
        marshalledProduct += currentProduct.getCostPerSquareFoot() + DELIMITER;
        marshalledProduct += currentProduct.getLaborCostPerSquareFoot();
        
        return marshalledProduct;
    }
    
}
