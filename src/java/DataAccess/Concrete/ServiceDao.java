package DataAccess.Concrete;

import DataAccess.Abstract.Dao;
import DataAccess.Abstract.IServiceDao;
import Exceptions.DaoException;
import Models.Concrete.Service;
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
public class ServiceDao extends Dao implements IServiceDao{

    /**
     * Inserts a service into the database
     * @param obj
     * @return the newly generated primary key
     * @throws DaoException
     */
    @Override
    public int insert(Service obj) throws DaoException {
        Connection          conn            = null;
        CallableStatement   cs              = null; 
        String              sql             = "{CALL sp_insert_service(?,?,?,?,?,?,?,?)}";       
        int                 newKey          = 0;
        
        try{
            conn = getConnection();
            cs = conn.prepareCall(sql);
                       
            cs.setString(1,obj.getName());
            cs.setString(2,obj.getOverview());
            cs.setString(3,obj.getOverviewImage());   
            cs.setString(4,obj.getBannerImage());
            cs.setString(5,obj.getListitemImage());             
            cs.setDouble(6,obj.getPrice()); 
            cs.setInt(7,obj.getOnHand());            
            cs.registerOutParameter(8, java.sql.Types.INTEGER);
            
            cs.executeUpdate();
            newKey  = cs.getInt(9);  // Grab the newly created Primary Key                        

        } 
        catch (SQLException sqe){
            throw new DaoException("ServiceDao.insert(): " + sqe.getMessage());
        } 
        finally{
            freeResources("ServiceDao.insert(): ", conn, cs, null);
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
    public boolean update(Service obj) throws DaoException {
        Connection          conn            = null;
        CallableStatement   cs              = null;
        int                 rowsAffected    = 0;
        String              sql             = "{CALL sp_update_service(?,?,?,?,?,?,?,?,?)}";
        
        try{
            conn = getConnection();
            cs = conn.prepareCall(sql);
                        
            cs.setString(1,obj.getName());
            cs.setString(2,obj.getOverview());
            cs.setString(3,obj.getOverviewImage());   
            cs.setString(4,obj.getBannerImage());
            cs.setString(5,obj.getListitemImage());             
            cs.setDouble(6,obj.getPrice()); 
            cs.setInt(7,obj.getOnHand());             
            cs.setInt(8,obj.getId());
            cs.setTimestamp(9,obj.getLastUpdated());
            
            rowsAffected = cs.executeUpdate();            
        } 
        catch (SQLException sqe){
            throw new DaoException("ServiceDao.update(): " + sqe.getMessage());
        }
        finally{
            freeResources("ServiceDao.update(): ", conn, cs, null);
        }        
        
        return rowsAffected == 1;
    }

    /**
     * Removes a service from the database
     * @param key
     * @return boolean true if the update succeeded, otherwise false
     * @throws DaoException
     */
    @Override
    public boolean delete(int key) throws DaoException {
        
        Connection          conn            = null;
        CallableStatement   cs              = null;
        int                 rowsAffected    = 0;
        String              sql             = "{CALL sp_delete_service(?)}";
        
        try{
            conn = getConnection();
            
            cs = conn.prepareCall(sql);
            cs.setInt(1, key);

            rowsAffected = cs.executeUpdate();            
        } 
        catch (SQLException sqe){
            throw new DaoException("ServiceDao.delete(): " + sqe.getMessage());
        } 
        finally{
            freeResources("ServiceDao.delete(): ", conn, cs, null);
        }
        
        return rowsAffected == 1;
    }

    /**
     * Searches for and returns all services (subset of data only).
     * @return
     * @throws DaoException
     */
    @Override
    public List<Service> getAll() throws DaoException {
        
        Connection          conn        = null;
        CallableStatement   cs          = null;
        ResultSet           rs          = null;
        List<Service>       services    = new ArrayList<Service>();
        String              query       = "{CALL sp_get_all_services()}"; 
        
        try{            
            
            conn = getConnection();
            cs = conn.prepareCall(query);            
            rs = cs.executeQuery();

            while(rs.next()){
                services.add( new Service(  rs.getInt("id"),                        
                                        rs.getString("name"),
                                        rs.getString("overview"),
                                        rs.getString("overview_image"),  
                                        rs.getString("banner_image"),
                                        rs.getString("listitem_image"),                          
                                        rs.getDouble("price"),      
                                        rs.getInt("on_hand"),                        
                                        rs.getTimestamp("last_updated")));
            } 
        } 
        catch (SQLException sqe){
            throw new DaoException("ServiceDao.getAll(): " + sqe.getMessage());            
        }

        finally{
            freeResources("ServiceDao.getAll(): ", conn, cs, rs);
        }
        
        return services;

    }

    /**
     * Searches for and returns all services by primary key.
     * @param key
     * @return
     * @throws DaoException
     */
    @Override
    public Service getByKey(int key) throws DaoException {
       
        Connection          conn            = null;
        CallableStatement   cs              = null;
        ResultSet           rs              = null;        
        Service             service         = null;    
        String              query           = "{CALL sp_get_service_by_key(?)}";
        
        try{
            conn = getConnection();            
            cs = conn.prepareCall(query);
            cs.setInt(1, key);
            rs = cs.executeQuery();         
            
            if(rs.next()){
                service = new Service(  rs.getInt("id"),                        
                                        rs.getString("name"),
                                        rs.getString("overview"),
                                        rs.getString("overview_image"),  
                                        rs.getString("banner_image"),
                                        rs.getString("listitem_image"),                          
                                        rs.getDouble("price"),      
                                        rs.getInt("on_hand"),                        
                                        rs.getTimestamp("last_updated"));
            }            
        } 
        catch (SQLException sqe){
            throw new DaoException("ServiceDao.getByKey(): " + sqe.getMessage());
        } 
        finally{
            freeResources("ServiceDao.getByKey(): ",conn,cs,rs);
        }
        
        return service;     // could return null

    }

    /**
     * Searches for and returns all services (subset of data only).
     * @return
     * @throws DaoException
     */
    @Override
    public List<Service> getBriefDetails() throws DaoException {
        
        Connection          conn        = null;
        CallableStatement   cs          = null;
        ResultSet           rs          = null;
        List<Service>       services    = new ArrayList<Service>();
        String              query       = "{CALL sp_get_brief_service_details()}"; 
        
        try{            
            
            conn = getConnection();
            cs = conn.prepareCall(query);            
            rs = cs.executeQuery();

            while(rs.next()){
                services.add(new Service(   rs.getInt("id"),
                                            rs.getString("name"),
                                            rs.getString("listitem_image")));
            }
        } 
        catch (SQLException sqe){
            throw new DaoException("ServiceDao.getBriefDetails(): " + sqe.getMessage());            
        }

        finally{
            freeResources("ServiceDao.getBriefDetails(): ", conn, cs, rs);
        }
        
        return services;


    }
    
}
