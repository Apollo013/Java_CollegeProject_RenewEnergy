package Services;

// Retrieves a list of categories, products or services for storage in session variables.

import DataAccess.Abstract.ICategoryDao;
import DataAccess.Abstract.IOrderItemDao;
import DataAccess.Abstract.IProductDao;
import DataAccess.Abstract.IServiceDao;
import DataAccess.Abstract.IUserDao;
import DataAccess.Concrete.CategoryDao;
import DataAccess.Concrete.OrderItemDao;
import DataAccess.Concrete.ProductDao;
import DataAccess.Concrete.ServiceDao;
import DataAccess.Concrete.UserDao;
import Exceptions.DaoException;
import Models.Concrete.Category;
import Models.Concrete.Order;
import Models.Concrete.OrderItem;
import Models.Concrete.Product;
import Models.Concrete.Service;
import Models.Concrete.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

// These wil be used in products_sidebar.jspf & service_sidebar.jspf segments & drop down lists.

/**
 *
 * @author Paul Millar <D00152098>
 */
public class DataAccessService {

    public List<Category> loadCategoryNames() throws DaoException{
        List<Category> categories = new ArrayList<Category>();
        
        try{
            ICategoryDao catDAO = new CategoryDao();
            categories = catDAO.getBasicDetails();
        }
        catch(DaoException daoe){
            Logger.getLogger(DataAccessService.class.getName()).log(Level.SEVERE, null, daoe);          
        }
    
        return categories;
    }
    
    public List<Product> loadOrderProducts() throws DaoException{
        List<Product> products = new ArrayList<Product>();
        
        try{
            IProductDao proDAO = new ProductDao();
            products = proDAO.getPriceDetailsForOrders();
        }
        catch(DaoException daoe){
            Logger.getLogger(DataAccessService.class.getName()).log(Level.SEVERE, null, daoe);          
        }
    
        return products;
    }
    
    public List<User> loadOrderUsers() throws DaoException{
        List<User> users = new ArrayList<User>();
        
        try{
            IUserDao userDAO = new UserDao();
            users = userDAO.getAll();
        }
        catch(DaoException daoe){
            Logger.getLogger(DataAccessService.class.getName()).log(Level.SEVERE, null, daoe);          
        }
    
        return users;
    }
    
    public List<Service> loadServiceNames() throws DaoException{ 
        List<Service> services = new ArrayList<Service>();

        try{
             IServiceDao serDAO = new ServiceDao();
             services = serDAO.getBriefDetails();
        }
        catch(DaoException daoe){
            Logger.getLogger(DataAccessService.class.getName()).log(Level.SEVERE, null, daoe);
        }    
        return services;
    }        
          /*       
    public User getUser(int key) throws DaoException{
        User user = null;
        IUserDao udao = new UserDao();
        user = udao.getByKey(key);        
        return user;
    }    
        */
    public void insertOrderItem(OrderItem oi, Order order) throws DaoException{        
        IOrderItemDao ioDao = new OrderItemDao();
        // Insert the order item into the db and grab the newly created 
        int key = ioDao.insert(oi);
        // add it to the order
        oi.setId(key);
        order.addOrderItem(oi);      
    }
    
    public void changeOrderItem(OrderItem oi, Order order) throws DaoException{  
        // Change the order item in the db
        IOrderItemDao ioDao = new OrderItemDao();
        ioDao.update(oi);
    
    }    
    
    public void deleteOrderItem(int itemid) throws DaoException{  
        // delete the order item from the db
        IOrderItemDao ioDao = new OrderItemDao();
        ioDao.delete(itemid);
    
    }      
}
