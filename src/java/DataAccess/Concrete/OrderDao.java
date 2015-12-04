package DataAccess.Concrete;

import DataAccess.Abstract.Dao;
import DataAccess.Abstract.IOrderDao;
import DataAccess.Abstract.IOrderItemDao;
import Exceptions.DaoException;
import Models.Concrete.Order;
import Models.Concrete.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import static java.sql.Connection.TRANSACTION_SERIALIZABLE;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class OrderDao extends Dao implements IOrderDao{

    @Override
    public int insert(Order obj) throws DaoException {
        
        Connection          conn            = null;
        CallableStatement   cs              = null;        
        String              sql             = "{CALL sp_insert_order(?,?)}";
        int                 newKey          = 0;

        try{
            conn = getConnection();     
            
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(TRANSACTION_SERIALIZABLE);
            
            cs = conn.prepareCall(sql);
            cs.setInt(1, obj.getUser().getId());
            cs.registerOutParameter(2, java.sql.Types.INTEGER);
            cs.executeUpdate();            
            newKey = cs.getInt(2);    // Grab the newly created Primary Key   
            
            conn.commit();
        }
        catch (SQLException e){
            try {
                conn.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            throw new DaoException("OrderDao.insert(): " + e.getMessage());            
        }
        finally{
            freeResources("OrderDao.insert(): ", conn, cs, null);
        }         
        
        return newKey;
    }

    @Override
    public boolean update(Order obj) throws DaoException {
        
        Connection          conn            = null;
        PreparedStatement   ps              = null;
        int                 rowsAffected    = 0;
        String              sql             = "{CALL sp_update_order(?,?,?,?,?)}";
        
        try{
            conn = getConnection();
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getUser().getId());
            ps.setByte(2, obj.getStatus());
            ps.setInt(3, obj.getOrderNo());
            ps.setDate(4, obj.getShipDate());
            ps.setTimestamp(5, obj.getLastUpdated());
            
            rowsAffected = ps.executeUpdate();            
        }
        catch (SQLException sqe){
            throw new DaoException("OrderDao.update(), " + sqe.getMessage());
        } 
        finally{
            freeResources("OrderDao.update(), ", conn, ps, null);
        } 
        
        return rowsAffected == 1;
    }

    @Override
    public boolean delete(int key) throws DaoException {
        Connection          conn            = null;
        PreparedStatement   ps              = null;
        int                 rowsAffected    = 0;
        String              sql             = "{CALL sp_delete_order(?)}";
        
        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, key);
            rowsAffected = ps.executeUpdate();            
        }
        catch (SQLException sqe){
            throw new DaoException("OrderDao.delete(), " + sqe.getMessage());
        } 
        finally{
            freeResources("OrderDao.delete(), ", conn, ps, null);
        } 
        
        return rowsAffected == 1;
    }

    @Override
    public List<Order> getAll() throws DaoException {
        Connection          conn        = null;
        PreparedStatement   ps          = null;
        ResultSet           rs          = null;
        IOrderItemDao       oiDao       = null;         
        List<Order>         orders      = new ArrayList<Order>();
        String              query       = "{CALL sp_get_all_orders()}";  
        
        try{
            conn = getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();           
            
            oiDao = new OrderItemDao();
            while(rs.next()){
                orders.add(new Order(  rs.getInt("order_no"),
                                    rs.getByte("status"),
                                    rs.getDate("order_date"),
                                    rs.getDate("ship_date"),
                                    rs.getTimestamp("last_updated"),
                                    new User(   rs.getInt("user_id"), 
                                                rs.getString("fname"), 
                                                rs.getString("lname"), 
                                                rs.getString("address1"),
                                                rs.getString("address2"), 
                                                rs.getString("city"), 
                                                rs.getString("county"), 
                                                rs.getString("country"), 
                                                rs.getString("postcode"), 
                                                rs.getString("email")),
                                    oiDao.getOrderItems(rs.getInt("order_no"))
                ));
            }
        }
        catch (SQLException sqe){
            throw new DaoException("OrderItemDao.getAll(): " + sqe.getMessage());
        }         
        finally{
            freeResources("OrderItemDao.getAll(): ", conn, ps, rs);
        }           
        
        return orders;
    }

    @Override
    public Order getByKey(int key) throws DaoException {
        
        Connection          conn            = null;
        PreparedStatement   ps              = null;
        ResultSet           rs              = null; 
        Order               order           = null;
        IOrderItemDao       oiDao           = null; 
        String              query           = "{CALL sp_get_order_by_id(?)}";        
        
        try{
            conn = getConnection();            
            ps = conn.prepareStatement(query);
            ps.setInt(1, key);
            rs = ps.executeQuery();         
            
            oiDao = new OrderItemDao();
            if(rs.next()){
                order = new Order(  rs.getInt("order_no"),
                                    rs.getByte("status"),
                                    rs.getDate("order_date"),
                                    rs.getDate("ship_date"),
                                    rs.getTimestamp("last_updated"),
                                    new User(   rs.getInt("user_id"), 
                                                rs.getString("fname"), 
                                                rs.getString("lname"), 
                                                rs.getString("address1"),
                                                rs.getString("address2"), 
                                                rs.getString("city"), 
                                                rs.getString("county"), 
                                                rs.getString("country"), 
                                                rs.getString("postcode"), 
                                                rs.getString("email")),
                                    oiDao.getOrderItems(rs.getInt("order_no"))
                );
            }   
        }
        catch (SQLException sqe){
            throw new DaoException("OrderDao.getByKey(): " + sqe.getMessage());
        } 
        finally{
            freeResources("OrderDao.getByKey(): ",conn,ps,rs);
        }        
        return order;
    }

    @Override
    public List<Order> getUserOrders(int userId) throws DaoException {
        
        Connection          conn        = null;
        PreparedStatement   ps          = null;
        ResultSet           rs          = null;
        IOrderItemDao       oiDao       = null;         
        List<Order>         orders      = new ArrayList<Order>();
        String              query       = "{CALL sp_get_orders_by_user_id(?)}";  
        
        try{
            
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);            
            rs = ps.executeQuery();  
            
            oiDao = new OrderItemDao();
            while(rs.next()){
                orders.add(new Order(  rs.getInt("order_no"),
                                    rs.getByte("status"),
                                    rs.getDate("order_date"),
                                    rs.getDate("ship_date"),
                                    rs.getTimestamp("last_updated"),
                                    new User(   rs.getInt("user_id"), 
                                                rs.getString("fname"), 
                                                rs.getString("lname"), 
                                                rs.getString("address1"),
                                                rs.getString("address2"), 
                                                rs.getString("city"), 
                                                rs.getString("county"), 
                                                rs.getString("country"), 
                                                rs.getString("postcode"), 
                                                rs.getString("email")),
                                    oiDao.getOrderItems(rs.getInt("order_no"))
                ));
            }            
        }
        catch (SQLException sqe){
            throw new DaoException("OrderItemDao.searchUserOrders(), " + sqe.getMessage());
        }         
        finally{
            freeResources("OrderDao.searchUserOrders(): ",conn,ps,rs);
        }                   
        return orders;
    }
       
}
