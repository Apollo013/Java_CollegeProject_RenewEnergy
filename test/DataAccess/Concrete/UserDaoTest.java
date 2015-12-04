/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccess.Concrete;

import DataAccess.Abstract.IUserDao;
import Exceptions.DaoException;
import Models.Concrete.User;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class UserDaoTest {
    
    public UserDaoTest() {
    }
    
    @Test
    public void testGetUserByKey(){
        
        System.out.println("\nTESTING USER GET KEY");    
        
        IUserDao udao = null;
        
        try{            
            udao = new UserDao();            
            User user = udao.getByKey(1);   
            System.out.println(user.toString());
        } 
        catch (DaoException daoe){
            System.out.println("ERROR: " + daoe.getMessage());            
        }        
    }
    
    @Test
    public void testGetAllUsers(){
        
        System.out.println("\nTESTING USER GET ALL");    
        
        IUserDao udao = null;
        List<User> users = null;
        
        try{            
            
            udao = new UserDao();
            users = udao.getAll();
            
            for(User u : users){
                System.out.println(u.toString());
            }

        } 
        catch (DaoException daoe){
            System.out.println("ERROR: " + daoe.getMessage());            
        }        
    }    
    
    @Test
    public void testGetUserLogin(){
        
        System.out.println("\nTESTING USER GET LOGIN");    
        
        IUserDao udao = null;
        
        try{            
            udao = new UserDao();            
            User user = udao.login("pm@gmail.com","password");   
            System.out.println(user.toString());
        } 
        catch (DaoException daoe){
            System.out.println("ERROR: " + daoe.getMessage());            
        }        
    }   
    
   
}
