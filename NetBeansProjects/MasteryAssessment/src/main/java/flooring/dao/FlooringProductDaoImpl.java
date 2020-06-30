/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:

Map newMap = Collections.unmodifiableMap(map);

*/

package flooring.dao;

import flooring.dto.Product;
import java.util.HashMap;
import java.util.Map;

public class FlooringProductDaoImpl implements FlooringProductDao{
    private final Map<String, Product> allProducts = new HashMap<>();
    private final String STATE_FILE;
    private final String DELIMITER = ",";
    
    public FlooringProductDaoImpl(){
        this.STATE_FILE = "Data/products.txt";
    }
    
    public FlooringProductDaoImpl(String fileName){
        this.STATE_FILE = fileName;
    }
    
    @Override
    public Map<String, Product> getAllProducts() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Product getProduct(String productType) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private void loadFile() {
        throw new UnsupportedOperationException("Not supported yet.");
      
    }
    
    private Product unmarshallData(String currentLine) {
        throw new UnsupportedOperationException("Not supported yet.");        
    }

}
