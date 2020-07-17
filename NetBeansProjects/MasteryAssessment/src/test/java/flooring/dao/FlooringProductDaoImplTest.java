/*
Created by: Margaret Donin
Date created: 06/26/20
Date revised:
*/

package flooring.dao;

import flooring.dto.Product;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FlooringProductDaoImplTest {
    
    FlooringProductDao testDao;
    
    public FlooringProductDaoImplTest() {
        
    }
    
    @BeforeEach
    public void setUp() throws Exception {
        String testFile = "TestFile//ProductTest.txt";
        String header = "ProductType,CostPerSquareFoot,LaborCostPerSquareFoot";

        PrintWriter out = new PrintWriter(new FileWriter(testFile));
        out.println(header);
        out.flush();
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
        this.testDao = ctx.getBean("productDao", FlooringProductDao.class);
    }

    @Test
    public void getAllProductsTest() throws Exception {
        String typeOne = "Tile";
        Product productOne = new Product(typeOne, new BigDecimal("3.50"), new BigDecimal("4.00"));
        
        String typeTwo = "Wood";
        Product productTwo = new Product(typeTwo, new BigDecimal("1.00"), new BigDecimal("2.00"));
        
        testDao.addProduct(productOne);
        testDao.addProduct(productTwo);
        
        Map<String, Product> received = testDao.getAllProducts();
        
        assertNotNull(received, "Map should not be null.");
        assertEquals(received.size(), 2, "There should only be two products on the list.");
        assertEquals(received.get(typeOne), productOne, "Tile should be in the map.");
        assertEquals(received.get(typeTwo), productTwo, "Wood should be in the map.");
    }
    
    @Test
    public void getProductTest() throws Exception {
        String typeOne = "Tile";
        Product productOne = new Product(typeOne, new BigDecimal("3.50"), new BigDecimal("4.00"));
        
        testDao.addProduct(productOne);
        
        Product received = testDao.getProduct(typeOne);
        
        assertNotNull(received, "Should be not null.");
        assertEquals(received, productOne, "Both products should be Tile.");
        assertEquals(received.getProductType(), productOne.getProductType(), "Checking product type.");
        assertEquals(received.getCostPerSquareFoot(), productOne.getCostPerSquareFoot(), "Checking materials cost.");
        assertEquals(received.getLaborCostPerSquareFoot(), productOne.getLaborCostPerSquareFoot(), "Checking labor cost.");

    }
    
    @Test
    public void addProductTest() throws Exception {
        String typeOne = "Tile";
        Product productOne = new Product(typeOne, new BigDecimal("3.50"), new BigDecimal("4.00"));
        
        Product received = testDao.getProduct(typeOne);
        
        assertNull(received, "Should be null.");
        
        testDao.addProduct(productOne);
        received = testDao.getProduct(typeOne);
        
        assertNotNull(received, "Should be not null.");
        assertEquals(received, productOne, "Both products should be Tile.");
        assertEquals(received.getProductType(), productOne.getProductType(), "Checking product type.");
        assertEquals(received.getCostPerSquareFoot(), productOne.getCostPerSquareFoot(), "Checking materials cost.");
        assertEquals(received.getLaborCostPerSquareFoot(), productOne.getLaborCostPerSquareFoot(), "Checking labor cost.");
        
        

    }
    
    @Test
    public void editProductTest() throws Exception {
        String typeOne = "Tile";
        Product productOne = new Product(typeOne, new BigDecimal("3.50"), new BigDecimal("4.00"));
        
        testDao.addProduct(productOne);
        
        Product received = testDao.getProduct(typeOne);
        
        assertNotNull(received, "Should be not null.");
        assertEquals(received, productOne, "Both products should be Tile.");
        assertEquals(received.getProductType(), productOne.getProductType(), "Checking product type.");
        assertEquals(received.getCostPerSquareFoot(), productOne.getCostPerSquareFoot(), "Checking materials cost.");
        assertEquals(received.getLaborCostPerSquareFoot(), productOne.getLaborCostPerSquareFoot(), "Checking labor cost.");

        productOne.setCostPerSquareFoot(new BigDecimal("1.50"));
        received = testDao.editProduct(productOne);
        
        assertNotNull(received, "Should be not null.");
        assertEquals(received, productOne, "Both products should be the same.");
        assertEquals(received.getCostPerSquareFoot(), productOne.getCostPerSquareFoot(), "Checking materials cost.");
        
        received = testDao.getProduct(typeOne);
        
        assertNotNull(received, "Should be not null.");
        assertEquals(received, productOne, "Both products should be the same.");
        assertEquals(received.getCostPerSquareFoot(), productOne.getCostPerSquareFoot(), "Checking materials cost.");
    }
    
    @Test
    public void removeProductTest() throws Exception {
        String typeOne = "Tile";
        Product productOne = new Product(typeOne, new BigDecimal("3.50"), new BigDecimal("4.00"));
        
        String typeTwo = "Wood";
        Product productTwo = new Product(typeTwo, new BigDecimal("1.00"), new BigDecimal("2.00"));
        
        testDao.addProduct(productOne);
        testDao.addProduct(productTwo);
        
        Map<String, Product> received = testDao.getAllProducts();
        
        assertNotNull(received, "Map should not be null.");
        assertEquals(received.size(), 2, "There should only be two products on the list.");
        assertEquals(received.get(typeOne), productOne, "Tile should be in the map.");
        assertEquals(received.get(typeTwo), productTwo, "Tile should be in the map.");
        
        Product receivedProduct = testDao.removeProduct(productOne);
        
        assertNotNull(receivedProduct, "Should be not null.");
        assertEquals(receivedProduct, productOne, "Both products should be Tile.");
        assertEquals(receivedProduct.getProductType(), typeOne, "Checking product type.");
        assertEquals(receivedProduct.getCostPerSquareFoot(), productOne.getCostPerSquareFoot(), "Checking materials cost.");
        assertEquals(receivedProduct.getLaborCostPerSquareFoot(), productOne.getLaborCostPerSquareFoot(), "Checking labor cost.");
        
        received = testDao.getAllProducts();
        
        assertNotNull(received, "Map should not be null.");
        assertEquals(received.size(), 1, "There should only be one products on the list.");
        assertNull(received.get(typeOne), "Tile should not be in the map.");
        assertEquals(received.get(typeTwo), productTwo, "Wood should be in the map.");
    }
    
}
