package DataAccess.Concrete;

import DataAccess.Abstract.Dao;
import DataAccess.Abstract.IOrderItemDao;
import Exceptions.DaoException;
import Models.Concrete.OrderItem;
import Models.Concrete.Product;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class OrderItemDao extends Dao implements IOrderItemDao{

    @Override
    public int insert(OrderItem obj) throws DaoException {
        
        Connection          conn            = null;
        CallableStatement   cs              = null;    
        String              sql             = "{CALL sp_insert_order_item(?,?,?,?,?)}";      
        int                 newKey          = 0;
        
        //JOptionPane.showMessageDialog(null, String.valueOf(obj.getOrderNo()) + " - " + String.valueOf(obj.getProductId()), "alert", JOptionPane.ERROR_MESSAGE);
        
        try{
            conn = getConnection();
            
            cs = conn.prepareCall(sql);            
            cs.setInt(1, obj.getOrderNo());
            cs.setInt(2, obj.getProductId());
            cs.setInt(3, obj.getQuantity());            
            cs.setDouble(4, obj.getPrice()); 
            cs.registerOutParameter(5, java.sql.Types.INTEGER);
            
            cs.executeUpdate();            
            newKey = cs.getInt(5);  // Grab the newly created Primary Key
            
        }
        catch (SQLException sqe){
            throw new DaoException("OrderItemDao.insert(): " + sqe.getMessage());
        } 
        finally{
            freeResources("OrderItemDao.insert(): ", conn, cs, null);
        }               
        
        return newKey;
    }

    @Override
    public boolean update(OrderItem obj) throws DaoException {
        
        Connection          conn            = null;
        PreparedStatement   ps              = null;
        int                 rowsAffected    = 0;
        String              sql             = "{CALL sp_update_order_item(?,?,?)}";
        
        //String op = obj.getId() + " - " + obj.getOrderNo() + " - " + obj.getPrice() + " - " + obj.getQuantity() + " - " + obj.getProduct().getId();
        //JOptionPane.showMessageDialog(null,op ,"IO Error",JOptionPane.ERROR_MESSAGE); 
        
        try{
            conn = getConnection();      
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getQuantity());            
            ps.setDouble(2, obj.getPrice());     
            ps.setInt(3, obj.getId());
            
            rowsAffected = ps.executeUpdate();               
        }
        catch (SQLException sqe){
            throw new DaoException("OrderItemDao.update(), " + sqe.getMessage());
        } 
        finally{
            freeResources("OrderItemDao.update(), ", conn, ps, null);
        }               
        
        return rowsAffected == 1;
    }

    @Override
    public boolean delete(int key) throws DaoException {
        Connection          conn            = null;
        PreparedStatement   ps              = null;
        int                 rowsAffected    = 0;
        String              sql             = "{CALL sp_delete_order_item(?)}";
        
        try{
            conn = getConnection();            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, key);
            rowsAffected = ps.executeUpdate();   
        }
        catch (SQLException sqe){
            throw new DaoException("OrderItemDao.delete(): " + sqe.getMessage());
        } 
        finally{
            freeResources("OrderItemDao.delete(): ", conn, ps, null);
        }               
        
        return rowsAffected == 1;
    }

    @Override
    public List<OrderItem> getAll() throws DaoException {
        
        Connection          conn        = null;
        PreparedStatement   ps          = null;
        ResultSet           rs          = null;
        List<OrderItem>     orderItems  = new ArrayList<OrderItem>();
        String              query       = "{CALL sp_all_get_order_items()}"; 
        
        try{                        
            conn = getConnection();
            ps = conn.prepareStatement(query);            
            rs = ps.executeQuery();

            while(rs.next()){
                orderItems.add(new OrderItem(   rs.getInt("id"),
                                                rs.getInt("order_no"),
                                                rs.getInt("quantity"),
                                                rs.getDouble("price"),
                                                new Product(rs.getInt("product_id"),
                                                            rs.getString("name"),
                                                            rs.getDouble("product_price"),
                                                            rs.getInt("on_hand"))
                ));
            }
        } 
        catch (SQLException sqe){
            throw new DaoException("OrderItemDao.getAll(): " + sqe.getMessage());            
        }
        finally{
            freeResources("OrderItemDao.getAll(): ", conn, ps, rs);
        }
        
        return orderItems;
    }

    @Override
    public OrderItem getByKey(int key) throws DaoException {
        
        Connection          conn            = null;
        PreparedStatement   ps              = null;
        ResultSet           rs              = null;    
        OrderItem           orderItem       = null;
        String              query           = "{CALL sp_get_order_item_by_id(?)}";        
        
        try{
            conn = getConnection();            
            ps = conn.prepareStatement(query);
            ps.setInt(1, key);
            rs = ps.executeQuery();   
            
            if(rs.next()){
                orderItem = new OrderItem(  rs.getInt("id"),
                                            rs.getInt("order_no"),
                                            rs.getInt("quantity"),
                                            rs.getDouble("price"),
                                            new Product(rs.getInt("product_id"),
                                                        rs.getString("name"),
                                                        rs.getDouble("product_price"),
                                                        rs.getInt("on_hand"))
                );
            }            
        } 
        catch (SQLException sqe){
            throw new DaoException("OrderItemDao.getByKey(): " + sqe.getMessage());
        } 
        finally{
            freeResources("OrderItemDao.getByKey(): ",conn,ps,rs);
        }   
        
        return orderItem;        
    }

    @Override
    public List<OrderItem> getByOrderNo(int orderno) throws DaoException {
        Connection          conn        = null;
        PreparedStatement   ps          = null;
        ResultSet           rs          = null;
        List<OrderItem>     orderItems  = new ArrayList<OrderItem>();
        String              query       = "{CALL sp_get_order_items(?)}";  
        
        try{
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, orderno);
            rs = ps.executeQuery();           
            
            while(rs.next()){
                orderItems.add(new OrderItem(   rs.getInt("id"),
                                                rs.getInt("order_no"),
                                                rs.getInt("quantity"),
                                                rs.getDouble("price"),
                                                new Product(rs.getInt("product_id"),
                                                            rs.getString("name"),
                                                            rs.getDouble("product_price"),
                                                            rs.getInt("on_hand"))
                ));
            }
        }
        catch (SQLException sqe){
            throw new DaoException("OrderItemDao.getByOrderNo(): " + sqe.getMessage());
        }         
        finally{
            freeResources("OrderItemDao.getByOrderNo(): ", conn, ps, rs);
        }         
        
        return orderItems;
    }
    
    @Override
    public HashMap<Integer,OrderItem> getOrderItems(int orderno) throws DaoException {
        Connection                      conn        = null;
        PreparedStatement               ps          = null;
        ResultSet                       rs          = null;
        HashMap<Integer,OrderItem>      orderItems  = new HashMap<Integer,OrderItem>();
        String                          query       = "{CALL sp_get_order_items(?)}";  
        
        try{
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, orderno);
            rs = ps.executeQuery();           
            
            while(rs.next()){
                orderItems.put(rs.getInt("product_id"),new OrderItem(   rs.getInt("id"),
                                                rs.getInt("order_no"),
                                                rs.getInt("quantity"),
                                                rs.getDouble("price"),
                                                new Product(rs.getInt("product_id"),
                                                            rs.getString("name"),
                                                            rs.getDouble("product_price"),
                                                            rs.getInt("on_hand"))
                ));
            }
        }
        catch (SQLException sqe){
            throw new DaoException("OrderItemDao.getOrderItems(): " + sqe.getMessage());
        }         
        finally{
            freeResources("OrderItemDao.getOrderItems(): ", conn, ps, rs);
        }         
        
        return orderItems;
    }    

}
