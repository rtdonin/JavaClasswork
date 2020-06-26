/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:
*/

package flooring.dao;

import flooring.dto.Product;
import java.util.Map;

public interface FlooringProductDao {
    public Map<String, Product> getAllProducts();
    public Product getProduct(String productType);
}
