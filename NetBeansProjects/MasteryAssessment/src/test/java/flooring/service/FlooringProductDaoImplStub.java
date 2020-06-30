/*
Created by: Margaret Donin
Date created: 06/26/20
Date revised:
*/

package flooring.service;

import flooring.dao.FlooringProductDao;
import flooring.dto.Product;
import java.util.Map;

public class FlooringProductDaoImplStub implements FlooringProductDao {

    @Override
    public Map<String, Product> getAllProducts() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Product getProduct(String productType) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
