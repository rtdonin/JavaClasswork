/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:
*/

package flooring.dao;

import flooring.dto.Product;
import java.util.Map;

public interface FlooringProductDao {
    public Map<String, Product> getAllProducts() throws FlooringPersistenceException;
    public Product getProduct(String productType) throws FlooringPersistenceException;
    public Product addProduct(Product newProduct) throws FlooringPersistenceException;
    public Product editProduct(Product editProduct) throws FlooringPersistenceException;
    public Product removeProduct(Product removeProduct) throws FlooringPersistenceException;
}
