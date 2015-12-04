/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess.Concrete;

import DataAccess.Abstract.IServiceDao;
import Exceptions.DaoException;
import Models.Concrete.Service;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class ServiceDaoTest {
    
    public ServiceDaoTest() {
    }
    

    /**
     * Test of getAll method, of class ServiceDao.
     */
    @Test
    public void testGetAll() throws Exception {
        System.out.println("\nTESTING SERVICE GET ALL ");        
        
        IServiceDao sdao = null;
        List<Service> services = null;
        
        try{
            sdao = new ServiceDao();
            services = sdao.getAll();
            
            for(Service s : services){
                System.out.println(s.toString());
            }
            
        } catch (DaoException daoe){
            System.out.println("ERROR: " + daoe.getMessage());            
        }
        Assert.assertNotNull(services);  
    }

    /**
     * Test of getByKey method, of class ServiceDao.
     */
    @Test
    public void testGetByKey() throws Exception {
        System.out.println("\nTESTING SERVICE GET BY KEY 14 ");  
        int key = 14;
        ServiceDao instance = new ServiceDao();
        Service result = instance.getByKey(key);
        Assert.assertNotNull(result);
        System.out.println(result.toString());
    }

    /**
     * Test of getBriefDetails method, of class ServiceDao.
     */
    @Test
    public void testGetBriefDetails() throws Exception {

        System.out.println("\nTESTING SERVICE GET BRIEF DETAILS ");          
        ServiceDao instance = new ServiceDao();
        List<Service> result = instance.getBriefDetails();
        Assert.assertNotSame(0, result.size());

        for(Service s: result){
            System.out.println(s.toString());
        }
    }
    
}
