package DataAccess.Concrete;

import DataAccess.Abstract.Dao;
import DataAccess.Abstract.ICategoryDao;
import DataAccess.Abstract.IProductDao;
import Exceptions.DaoException;
import Models.Concrete.Category;
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
public class CategoryDao extends Dao implements ICategoryDao{

    /**
     * Inserts a category into the database
     * @param obj
     * @return boolean true if the insert succeeded, otherwise false
     * @throws DaoException
     */
    @Override
    public int insert(Category obj) throws DaoException {

        Connection          conn            = null;
        CallableStatement   cs              = null;  
        String              sql             = "{CALL sp_insert_category(?,?,?,?,?,?,?,?,?,?,?)}";    
        int                 newKey          = 0;
        
        try{
            conn = getConnection();
            
            cs = conn.prepareCall(sql);
            
            cs.setString(1,obj.getName());
            cs.setString(2,obj.getIntroduction());
            cs.setString(3,obj.getOverview());
            cs.setString(4,obj.getOverviewImage());   
            cs.setString(5,obj.getBannerImage());
            cs.setString(6,obj.getListitemImage());
            cs.setString(7,obj.getHowImage()); 
            cs.setString(8,obj.getBrochureFile());
            cs.setString(9,obj.getFaqsFile());            
            cs.setString(10,obj.getVideoUrl());                        
            cs.registerOutParameter(11, java.sql.Types.INTEGER);
            
            cs.executeUpdate();
             
            newKey = cs.getInt(11);    // Grab the newly created Primary Key                  

        } 
        catch (SQLException sqe){
            throw new DaoException("CategoryDao.insert(): " + sqe.getMessage());
        } 
        finally{
            freeResources("CategoryDao.insert(): ", conn, cs, null);
        }
        
        return newKey;
        
    }

    /**
     * Updates a category in the database
     * @param obj
     * @return boolean true if the update succeeded, otherwise false
     * @throws DaoException
     */
    @Override
    public boolean update(Category obj) throws DaoException {
        
        Connection          conn            = null;
        CallableStatement   cs              = null;
        int                 rowsAffected    = 0;
        String              sql             = "{CALL sp_update_category(?,?,?,?,?,?,?,?,?,?,?,?)}";
        
        try{
            conn = getConnection();
            
            cs = conn.prepareCall(sql);
            
            cs.setString(1,obj.getName());
            cs.setString(2,obj.getIntroduction());
            cs.setString(3,obj.getOverview());
            cs.setString(4,obj.getOverviewImage());   
            cs.setString(5,obj.getBannerImage());
            cs.setString(6,obj.getListitemImage());
            cs.setString(7,obj.getHowImage()); 
            cs.setString(8,obj.getBrochureFile());
            cs.setString(9,obj.getFaqsFile());
            cs.setString(10,obj.getVideoUrl());             
            cs.setInt(11,obj.getId());
            cs.setTimestamp(12,obj.getLastUpdated());
            
            rowsAffected = cs.executeUpdate();            
        } 
        catch (SQLException sqe){
            throw new DaoException("CategoryDao.update(): " + sqe.getMessage());
        }
        finally{
            freeResources("CategoryDao.update(): ", conn, cs, null);    
        }        
        
        return rowsAffected == 1;
        
    }

    /**
     * Removes a category from the database
     * @param key
     * @return boolean true if the delete succeeded, otherwise false
     * @throws DaoException
     */
    @Override
    public boolean delete(int key) throws DaoException {
        
        Connection          conn            = null;
        CallableStatement   cs              = null;
        int                 rowsAffected    = 0;
        String              sql             = "{CALL sp_delete_category(?)}";
        
        try{
            conn = getConnection();            
            cs = conn.prepareCall(sql);
            cs.setInt(1, key);
            rowsAffected = cs.executeUpdate();            
        } 
        catch (SQLException sqe){
            throw new DaoException("CategoryDao.delete(): " + sqe.getMessage());
        } 
        finally{
            freeResources("CategoryDao.delete(): ", conn, cs, null);            
        }
        
        return rowsAffected == 1;
        
    }

    /**
     * Searches for and returns all product categories
     * @return An Array list of product categories and a sub-set of information of their related products
     * @throws DaoException
     */
    @Override
    public List<Category> getAll() throws DaoException {
        
        Connection          conn        = null;
        CallableStatement   cs          = null;
        ResultSet           rs          = null;
        List<Category>      categories  = new ArrayList<Category>();
        String              query       = "{CALL sp_get_brief_category_details()}"; 
        
        try{            
            
            conn = getConnection();
            cs = conn.prepareCall(query);            
            rs = cs.executeQuery();

            while(rs.next()){
                categories.add(new Category(rs.getInt("id"),
                                            rs.getString("name"),
                                            rs.getString("introduction"),
                                            rs.getString("listitem_image"),
                                            rs.getTimestamp("last_updated")));
            }
        } 
        catch (SQLException sqe){
            throw new DaoException("CategoryDao.getAll(): " + sqe.getMessage());            
        }

        finally{
            freeResources("CategoryDao.getAll(): ", conn, cs, rs);
        }
        
        return categories;
    }

    /**
     * Searches for and returns a category by its unique key.
     * @param key
     * @return a category object (all data)
     * @throws DaoException
     */
    @Override
    public Category getByKey(int key) throws DaoException {
        
        Connection          conn            = null;
        CallableStatement   cs              = null;
        ResultSet           rs              = null;        
        Category            category        = null;    
        IProductDao         productDao      = new ProductDao();
        String              query           = "{CALL sp_get_category_by_key(?)}";
        
        try{
            conn = getConnection();            
            cs = conn.prepareCall(query);
            cs.setInt(1, key);
            rs = cs.executeQuery();         
            
            if(rs.next()){
                category = new Category(rs.getInt("id"),
                                        rs.getString("name"),
                                        rs.getString("introduction"),
                                        rs.getString("overview"),
                                        rs.getString("overview_image"),  
                                        rs.getString("banner_image"),
                                        rs.getString("listitem_image"),
                                        rs.getString("how_image"),                     
                                        rs.getString("brochure_file"),
                                        rs.getString("faqs_file"), 
                                        rs.getString("video_url"),                           
                                        rs.getTimestamp("last_updated"),
                                        productDao.getBriefDetailsByCategoryKey(rs.getInt("id")));
            }            
        } 
        catch (SQLException sqe){
            throw new DaoException("CategoryDao.getByKey(): " + sqe.getMessage());
        } 
        finally{
            freeResources("CategoryDao.getByKey(): ",conn,cs,rs);
        }
        
        return category;     // could return null

    }

    /**
     * Searches for and returns the id and names of all categories.
     * @return
     * @throws DaoException
     */
    @Override
    public List<Category> getBasicDetails() throws DaoException  {
        
        Connection          conn            = null;
        CallableStatement   cs              = null;
        ResultSet           rs              = null;
        List<Category>      categories      = new ArrayList<Category>();        
        IProductDao         productDao      = new ProductDao();        
        String              query           = "{CALL sp_get_basic_category_details()}";
        
        try{                        
            conn = getConnection();
            cs = conn.prepareCall(query);            
            rs = cs.executeQuery();

            while(rs.next()){
                categories.add(new Category(rs.getInt("id"),
                                            rs.getString("name"),
                                            productDao.getBasicDetailsByCategoryKey(rs.getInt("id"))));
            }
        } 
        catch (SQLException sqe){
            throw new DaoException("CategoryDao.getBasicDetails(): " + sqe.getMessage());            
        }
        finally{
            freeResources("CategoryDao.getBasicDetails(): ", conn, cs, rs);
        }
        
        return categories;
    }

}
