/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import Models.Concrete.Category;
import Models.Concrete.Product;
import Models.Concrete.Service;
import Models.Concrete.User;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class DataAccessServiceTest {
    
    public DataAccessServiceTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of loadCategoryNames method, of class DataAccessService.
     */
    @Test
    public void testLoadCategoryNames() throws Exception {
        System.out.println("loadCategoryNames");
        DataAccessService instance = new DataAccessService();
        List<Category> result = instance.loadCategoryNames();
        Assert.assertNotSame(0, result.size());
    }

    /**
     * Test of loadOrderProducts method, of class DataAccessService.
     */
    @Test
    public void testLoadOrderProducts() throws Exception {
        System.out.println("\nloadOrderProducts");
        DataAccessService instance = new DataAccessService();
        List<Product> result = instance.loadOrderProducts();
        Assert.assertNotSame(0, result.size());

    }

    /**
     * Test of loadOrderUsers method, of class DataAccessService.
     */
    @Test
    public void testLoadOrderUsers() throws Exception {
        System.out.println("\nloadOrderUsers");
        DataAccessService instance = new DataAccessService();
        List<User> result = instance.loadOrderUsers();
        Assert.assertNotSame(0, result.size());
    }

    /**
     * Test of loadServiceNames method, of class DataAccessService.
     */
    @Test
    public void testLoadServiceNames() throws Exception {
        System.out.println("loadServiceNames");
        DataAccessService instance = new DataAccessService();
        List<Service> result = instance.loadServiceNames();
        Assert.assertNotSame(0, result.size());
    }

}
