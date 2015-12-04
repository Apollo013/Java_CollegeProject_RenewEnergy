/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess.Concrete;

import Models.Concrete.Product;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class ProductDaoTest {
    
    public ProductDaoTest() {
    }
    /**
     * Test of getAll method, of class ProductDao.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        ProductDao instance = new ProductDao();
        List<Product> result = instance.getAll();
        Assert.assertNotSame(0, result.size());

    }

    /**
     * Test of getByKey method, of class ProductDao.
     */
    @Test
    public void testGetByKey() throws Exception {
        System.out.println("getByKey");
        int key = 5;
        ProductDao instance = new ProductDao();
        Product result = instance.getByKey(key);
        Assert.assertNotNull(result);

    }

    /**
     * Test of getBriefDetailsByCategoryKey method, of class ProductDao.
     */
    @Test
    public void testGetBriefDetailsByCategoryKey() throws Exception {
        System.out.println("getBriefDetailsByCategoryKey");
        int catID = 2;
        ProductDao instance = new ProductDao();
        List<Product> result = instance.getBriefDetailsByCategoryKey(catID);
        Assert.assertNotSame(0, result.size());
    }

    /**
     * Test of getBasicDetailsByCategoryKey method, of class ProductDao.
     */
    @Test
    public void testGetBasicDetailsByCategoryKey() throws Exception {
        System.out.println("getBasicDetailsByCategoryKey");
        int catID = 0;
        ProductDao instance = new ProductDao();
        List<Product> result = instance.getBasicDetailsByCategoryKey(catID);
        Assert.assertNotSame(0, result.size());
    }

    /**
     * Test of getPriceDetailsForOrders method, of class ProductDao.
     */
    @Test
    public void testGetPriceDetailsForOrders() throws Exception {
        System.out.println("getPriceDetailsForOrders");
        ProductDao instance = new ProductDao();
        List<Product> result = instance.getPriceDetailsForOrders();
        Assert.assertNotSame(0, result.size());
    }
    
}
