/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess.Concrete;

import Models.Concrete.Category;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class CategoryDaoTest {
    
    public CategoryDaoTest() {
    }

    /**
     * Test of getAll method, of class CategoryDao.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("getAll");
        CategoryDao instance = new CategoryDao();
        List<Category> result = instance.getAll();
        Assert.assertNotSame(0, result.size());

        for (Category c : result){
            System.out.println(c.toString());
        }
    }

    /**
     * Test of getByKey method, of class CategoryDao.
     */
    @Test
    public void testGetByKey() throws Exception {
        System.out.println("getByKey");
        int key = 2;
        CategoryDao instance = new CategoryDao();
        Category result = instance.getByKey(key);
        Assert.assertNotNull(result);
        
    }

    /**
     * Test of getBasicDetails method, of class CategoryDao.
     */
    @Test
    public void testGetBasicDetails() throws Exception {
        System.out.println("getBasicDetails");
        CategoryDao instance = new CategoryDao();
        List<Category> result = instance.getBasicDetails();
        Assert.assertNotSame(0, result.size());        
    }
    
}
