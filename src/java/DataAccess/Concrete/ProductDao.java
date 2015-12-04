package DataAccess.Concrete;

import DataAccess.Abstract.Dao;
import DataAccess.Abstract.IProductDao;
import Exceptions.DaoException;
import Models.Concrete.Product;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class ProductDao extends Dao implements IProductDao{

    /**
     * Inserts a product into the database
     * @param obj
     * @return the newly generated primary key
     * @throws DaoException
     */
    @Override
    public int insert(Product obj) throws DaoException {
        
        Connection          conn            = null;
        CallableStatement   cs              = null; 
        String              sql             = "{CALL sp_insert_product(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";      
        int                 newKey          = 0;
        
        try{
            conn = getConnection();
            
            cs = conn.prepareCall(sql);           
            cs.setInt(1, obj.getCategoryID());
            cs.setString(2,obj.getName());
            cs.setString(3,obj.getIntroduction());
            cs.setString(4,obj.getOverview());
            cs.setString(5,obj.getOverviewImage());   
            cs.setString(6,obj.getBannerImage());
            cs.setString(7,obj.getListitemImage());
            cs.setString(8,obj.getBrochureFile());
            cs.setString(9,obj.getFaqsFile());              
            cs.setString(10,obj.getSavingsText());
            cs.setString(11,obj.getSavingsValues());
            cs.setDouble(12, obj.getPrice());
            cs.setInt(13, obj.getOnHand());
            cs.registerOutParameter(14, java.sql.Types.INTEGER);            
            
            cs.executeUpdate();     
            
            newKey = cs.getInt(14);  // Grab the newly created Primary Key        
            
        } 
        catch (SQLException sqe){
            throw new DaoException("ProductDao.insert(): " + sqe.getMessage());
        } 
        finally{
            freeResources("ProductDao.insert(): ", conn, cs, null);
        }
        
        return newKey;
        
    }

    /**
     * Updates a product in the database
     * @param obj
     * @return boolean true if the update succeeded, otherwise false
     * @throws DaoException
     */
    @Override
    public boolean update(Product obj) throws DaoException {
        
        Connection          conn            = null;
        CallableStatement   cs              = null;
        int                 rowsAffected    = 0;
        String              sql             = "{CALL sp_update_product(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        
        try{
            conn = getConnection();
            
            cs = conn.prepareCall(sql);
            cs.setInt(1, obj.getCategoryID());
            cs.setString(2,obj.getName());
            cs.setString(3,obj.getIntroduction());
            cs.setString(4,obj.getOverview());
            cs.setString(5,obj.getOverviewImage());   
            cs.setString(6,obj.getBannerImage());
            cs.setString(7,obj.getListitemImage());
            cs.setString(8,obj.getBrochureFile());
            cs.setString(9,obj.getFaqsFile());            
            cs.setString(10,obj.getSavingsText());
            cs.setString(11,obj.getSavingsValues());
            cs.setDouble(12, obj.getPrice());
            cs.setInt(13,obj.getOnHand());
            cs.setInt(14,obj.getId());
            cs.setTimestamp(15,obj.getLastUpdated());
            
            rowsAffected = cs.executeUpdate();            
        } 
        catch (SQLException sqe){
            throw new DaoException("ProductDao.update(): " + sqe.getMessage());
        } 
        finally{
            freeResources("ProductDao.update(): ", conn, cs, null);
        }
        
        return rowsAffected == 1 ;
        
    }

    /**
     * Removes a product from the database
     * @param key
     * @return boolean true if the delete succeeded, otherwise false
     * @throws DaoException
     */
    @Override
    public boolean delete(int key) throws DaoException {
        
        Connection          conn            = null;
        CallableStatement   cs              = null;
        int                 rowsAffected    = 0;
        String              sql             = "{CALL sp_delete_product(?)}";
        
        try{
            conn = getConnection();
            
            cs = conn.prepareCall(sql);
            cs.setInt(1, key);

            rowsAffected = cs.executeUpdate();            
        } 
        catch (SQLException sqe){
            throw new DaoException("ProductDao.delete(): " + sqe.getMessage());
        } 
        finally{
            freeResources("ProductDao.delete(): ", conn, cs, null);
        }
        
        return rowsAffected == 1;
        
    }

    /**
     * Searches for and returns all products (subset of data only).
     * @return
     * @throws DaoException
     */
    @Override
    public List<Product> getAll() throws DaoException {
        Connection          conn            = null;
        CallableStatement   cs              = null;
        ResultSet           rs              = null;        
        List<Product>       products        = new ArrayList<Product>();        
        String              query           = "{CALL sp_get_all_products()}";
        
        try{
            conn = getConnection();            
            cs = conn.prepareCall(query);
            rs = cs.executeQuery();         
            
            while(rs.next()){
                products.add(new Product(   rs.getInt("id"),
                                            rs.getString("name"),
                                            rs.getDouble("price"),
                                            rs.getInt("on_hand"),
                                            rs.getTimestamp("last_updated"),
                                            rs.getString("category_name")));
            }            
        } 
        catch (SQLException sqe){
            throw new DaoException("ProductDao.getAll(): " + sqe.getMessage());
        } 
        finally{
            freeResources("ProductDao.getAll(): ",conn,cs,rs);
        }
        
        return products;
    }

    /**
     * Searches for and returns a product by its unique key (all data).
     * @param key
     * @return
     * @throws DaoException
     */
    @Override
    public Product getByKey(int key) throws DaoException {
                   
        Connection          conn            = null;
        CallableStatement   cs              = null;
        ResultSet           rs              = null;        
        Product             product         = null;        
        String              query           = "{CALL sp_get_product_by_key(?)}";
        
        try{
            conn = getConnection();            
            cs = conn.prepareCall(query);
            cs.setInt(1, key);
            rs = cs.executeQuery();         
             
            if(rs.next()){
                product = new Product(  rs.getInt("id"),
                                        rs.getInt("cat_id"),
                                        rs.getString("name"),
                                        rs.getString("introduction"),
                                        rs.getString("overview"),
                                        rs.getString("overview_image"),  
                                        rs.getString("banner_image"),
                                        rs.getString("listitem_image"),                 
                                        rs.getString("brochure_file"),
                                        rs.getString("faqs_file"),                         
                                        rs.getString("savings_Text"),
                                        rs.getString("savings_values"),                        
                                        rs.getDouble("price"),
                                        rs.getInt("on_hand"),
                                        rs.getTimestamp("last_updated"));
            }     

        } 
        catch (SQLException sqe){
            throw new DaoException("ProductDao.getByKey(): " + sqe.getMessage());
        } 
        finally{
            freeResources("ProductDao.getByKey(): ",conn,cs,rs);
        }
        
        return product;     // could return null
    }

    /**
     * Searches for and returns products (subset of data only) related to a specific category
     * @param catID
     * @return
     * @throws DaoException
     */
    @Override
    public List<Product> getBriefDetailsByCategoryKey(int catID) throws DaoException{
        
        Connection          conn                = null;
        CallableStatement   cs                  = null;
        ResultSet           rs                  = null;
        List<Product>       categoryProducts    = new ArrayList<Product>();
        String              query               = "{CALL sp_get_brief_product_details_by_category_key(?)}";   
        
        try{
            conn = getConnection();
            cs = conn.prepareCall(query);
            cs.setInt(1, catID);
            rs = cs.executeQuery();
            
            while(rs.next()){
                categoryProducts.add(new Product(   rs.getInt("id"),
                                                    rs.getInt("cat_id"),
                                                    rs.getString("name"),
                                                    rs.getString("introduction"),
                                                    rs.getString("listitem_image"),
                                                    rs.getDouble("price"),
                                                    rs.getInt("on_hand")));
            }
        }
        catch(SQLException sqe){
            throw new DaoException("ProductDao.getBriefDetailsByCategoryKey(): " + sqe.getMessage());
        }
        finally{
            freeResources("ProductDao.getBriefDetailsByCategoryKey(): ",conn,cs,rs);
        }
                
        return categoryProducts;        
    }

    /**
     * Searches for and returns only the id & name fields of products related to a specific category
     * @param catID
     * @return
     * @throws DaoException
     */    
    @Override
    public List<Product> getBasicDetailsByCategoryKey(int catID) throws DaoException {
        
        Connection          conn                = null;
        CallableStatement   cs                  = null;
        ResultSet           rs                  = null;
        List<Product>       categoryProducts    = new ArrayList<Product>();
        String              query               = "{CALL sp_get_basic_product_details_by_category_key(?)}";   
        
        try{
            conn = getConnection();
            cs = conn.prepareCall(query);
            cs.setInt(1, catID);
            rs = cs.executeQuery();
            
            while(rs.next()){
                categoryProducts.add(new Product(   rs.getInt("id"),
                                                    rs.getString("name")));
            }
        }
        catch(SQLException sqe){
            throw new DaoException("ProductDao.getBasicDetailsByCategoryKey(): " + sqe.getMessage());
        }
        finally{
            freeResources("ProductDao.getBasicDetailsByCategoryKey(): ",conn,cs,rs);
        }
                
        return categoryProducts; 
    }

    @Override
    public List<Product> getPriceDetailsForOrders() throws DaoException {
        Connection          conn            = null;
        CallableStatement   cs              = null;
        ResultSet           rs              = null;
        List<Product>       products        = new ArrayList<Product>();              
        String              query           = "{CALL sp_get_product_price_details_for_orders()}";
        
        try{                        
            conn = getConnection();
            cs = conn.prepareCall(query);            
            rs = cs.executeQuery();

            while(rs.next()){
                products.add(new Product(   rs.getInt("id"),
                                            rs.getString("name"),
                                            rs.getDouble("price"),
                                            rs.getInt("on_hand")
                ));
            }
        } 
        catch (SQLException sqe){
            throw new DaoException("ProductDao.getPriceDetailsForOrders(): " + sqe.getMessage());            
        }
        finally{
            freeResources("ProductDao.getPriceDetailsForOrders(): ", conn, cs, rs);
        }
        
        return products;
    }

}
