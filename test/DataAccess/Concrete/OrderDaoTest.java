/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess.Concrete;

import DataAccess.Abstract.IOrderDao;
import DataAccess.Abstract.IOrderItemDao;
import Exceptions.DaoException;
import Models.Concrete.Order;
import Models.Concrete.OrderItem;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class OrderDaoTest {
    
    public OrderDaoTest() {
    }
    
    @Test
    public void testSearchAllOrders(){
                
        System.out.println("\nTESTING GET ALL ORDERS");    
        
        IOrderDao oDao = new OrderDao();
        List<Order> orders = null;
        try{
            orders = new ArrayList<Order>();
            orders = oDao.getAll();
            for(Order o : orders){
                System.out.println(o.toString());
            }
        }
        catch(DaoException daoe){
            System.out.println("ERROR: " + daoe.getMessage());
        }
        
        assertNotNull(orders);            
    }
    
    @Test
    public void testSearchOrderById(){
        System.out.println("\nTESTING GET ORDER 1");    
        
        IOrderDao oDao = new OrderDao();
        Order o = null;
        try {
             o = oDao.getByKey(1);
        } catch (DaoException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            Logger.getLogger(OrderDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(o.toString());
        assertNotNull(o);         
    }
    
    @Test
    public void testSearchOrderByCustomerId(){
        System.out.println("\nTESTING GET ORDER FOR CUSTOMER 1");    
        
        IOrderDao oDao = new OrderDao();
        List<Order> orders = null;

        try {
            orders = new ArrayList<Order>();
            orders = oDao.getUserOrders(1);
            for(Order o : orders){
                System.out.println(o.toString());
            }             
        } catch (DaoException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            Logger.getLogger(OrderDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        assertNotNull(orders);         
    }    
        
    // order items
    
    @Test
    public void testSearchAllOrdersItems(){
                
        System.out.println("\nTESTING GET ALL ORDER ITEMS");    
        
        IOrderItemDao oDao = new OrderItemDao();
        List<OrderItem> orderitems = null;
        try{
            orderitems = new ArrayList<OrderItem>();
            orderitems = oDao.getAll();
            for(OrderItem o : orderitems){
                System.out.println(o.toString());
            }
        }
        catch(DaoException daoe){
            System.out.println("ERROR: " + daoe.getMessage());
        }
        
        assertNotNull(orderitems);            
    }    
    
}
