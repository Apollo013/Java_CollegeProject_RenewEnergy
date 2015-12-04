/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess.Concrete;

import Models.Concrete.OrderItem;
import java.util.HashMap;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class OrderItemDaoTest {
    
    public OrderItemDaoTest() {
    }

    /**
     * Test of getAll method, of class OrderItemDao.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("\nTESTING GET ALL");
        
        OrderItemDao instance = new OrderItemDao();
        List<OrderItem> result = instance.getAll();
        Assert.assertNotSame(0, result.size());

        for(OrderItem i : result){
            System.out.println(i.toString());
        }        
    }

    /**
     * Test of getByKey method, of class OrderItemDao.
     */
    @Test
    public void testGetByKey() throws Exception {

        System.out.println("\nTESTING GET BY KEY NO 1");  
        
        int key = 1;
        OrderItemDao instance = new OrderItemDao();
        OrderItem result = instance.getByKey(key);
        Assert.assertNotNull(result);
        
        System.out.println(result.toString());
        
    }

    /**
     * Test of getByOrderNo method, of class OrderItemDao.
     */
    @Test
    public void testGetByOrderNo() throws Exception {
        System.out.println("\nTESTING GET BY ORDER NO 1");   
        
        int orderno = 1;
        OrderItemDao instance = new OrderItemDao();
        List<OrderItem> result = instance.getByOrderNo(orderno);
        Assert.assertNotSame(0, result.size());

        for(OrderItem i : result){
            System.out.println(i.toString());
        }
    }

    /**
     * Test of getOrderItems method, of class OrderItemDao.
     */
    @Test
    public void testGetOrderItems() throws Exception {
        System.out.println("\nTESTING GET BY ORDER NO 1 (HASHMAP)"); 
        int orderno = 1;
        OrderItemDao instance = new OrderItemDao();
        HashMap<Integer, OrderItem> result = instance.getOrderItems(orderno);
        Assert.assertNotSame(0, result.size());

    }
    
}
