package Factories;

import DataAccess.Abstract.IGenericDao;
import DataAccess.Concrete.CategoryDao;
import DataAccess.Concrete.OrderDao;
import DataAccess.Concrete.OrderItemDao;
import DataAccess.Concrete.ProductDao;
import DataAccess.Concrete.ServiceDao;
import DataAccess.Concrete.UserDao;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class DaoFactory {
    
    private static DaoFactory daof = null;
    
    private DaoFactory(){}
    
    public synchronized static DaoFactory getInstance(){
        if(daof == null){
            daof = new DaoFactory();
        }
        return daof;
    }
    
    public synchronized IGenericDao createDataAccessObject(String type){
        
        if(type.equalsIgnoreCase("category")){
            //JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
            return new CategoryDao();
        } 
        else if(type.equalsIgnoreCase("product")){
            return new ProductDao();
        } 
        else if(type.equalsIgnoreCase("service")){
            return new ServiceDao();
        } 
        else if(type.equalsIgnoreCase("user")) {         
            return new UserDao();
        }
        else if(type.equalsIgnoreCase("order")) {         
            return new OrderDao();
        } 
        else if(type.equalsIgnoreCase("orderitem")) {         
            return new OrderItemDao();
        }          
        return null;
    }
}
