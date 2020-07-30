/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:
*/

package flooring.dao;

import flooring.dto.Product;
import java.util.Map;

public interface FlooringProductDao {
    /**
     * Retrieves all products in the file
     * 
     * @return Map of Products with the Key being the productType
     * @throws FlooringPersistenceException 
     */
    public Map<String, Product> getAllProducts() throws FlooringPersistenceException;
    
    /**
     * Take a String product type and returns the corresponding product value.
     * 
     * @param productType
     * @return product
     * @throws FlooringPersistenceException 
     */
    public Product getProduct(String productType) throws FlooringPersistenceException;
    
    /**
     * Take a product to add and adds it to the Map.
     * 
     * @param newProduct
     * @return addedProduct
     * @throws FlooringPersistenceException 
     */
    public Product addProduct(Product newProduct) throws FlooringPersistenceException;
    
    /**
     * Takes the Product that needs to be edited and replaces the old one with it.
     * 
     * @param editProduct
     * @return editedProduct
     * @throws FlooringPersistenceException 
     */
    public Product editProduct(Product editProduct) throws FlooringPersistenceException;
    
    /**
     * Deletes the Product selected.
     * 
     * @param removeProduct
     * @return deletedProduct
     * @throws FlooringPersistenceException 
     */
    public Product removeProduct(Product removeProduct) throws FlooringPersistenceException;
}
