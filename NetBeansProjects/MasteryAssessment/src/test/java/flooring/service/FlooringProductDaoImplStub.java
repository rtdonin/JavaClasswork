/*
Created by: Margaret Donin
Date created: 06/26/20
Date revised:
*/

package flooring.service;

import flooring.dao.FlooringPersistenceException;
import flooring.dao.FlooringProductDao;
import flooring.dto.Product;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FlooringProductDaoImplStub implements FlooringProductDao {

    private Product onlyProduct;
    
    public FlooringProductDaoImplStub() {
        this.onlyProduct = new Product("Stone", new BigDecimal("3.50"), new BigDecimal("4.00"));
    }
    
    public FlooringProductDaoImplStub(Product product) {
        this.onlyProduct = product;
    }
    
    @Override
    public Map<String, Product> getAllProducts() throws FlooringPersistenceException {
        Map<String, Product> allProducts = new HashMap<>();
        allProducts.put(onlyProduct.getProductType(), onlyProduct);
        
        return allProducts;
    }

    @Override
    public Product getProduct(String productType) throws FlooringPersistenceException {
        if (onlyProduct.getProductType().equals(productType)) {
            return onlyProduct;
        } else {
            return null;
        }
    }

    @Override
    public Product addProduct(Product newProduct) throws FlooringPersistenceException {
        if (newProduct.getProductType().equals(onlyProduct.getProductType())) {
            return onlyProduct;
        } else {
            return null;
        }
    }

    @Override
    public Product editProduct(Product editProduct) throws FlooringPersistenceException {
        if (editProduct.getProductType().equals(onlyProduct.getProductType())) {
            return onlyProduct;
        } else {
            return null;
        }
    }

    @Override
    public Product removeProduct(Product removeProduct) throws FlooringPersistenceException {
        if (removeProduct.getProductType().equals(onlyProduct.getProductType())) {
            return onlyProduct;
        } else {
            return null;
        }
    }

}
