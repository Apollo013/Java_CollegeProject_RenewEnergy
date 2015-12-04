package DataAccess.Concrete;

import DataAccess.Abstract.Dao;
import DataAccess.Abstract.IUserDao;
import Exceptions.DaoException;
import Models.Concrete.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager; 	
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class UserDao extends Dao implements IUserDao{

    static final Logger logger = LogManager.getLogger(UserDao.class.getName());
        
    @Override
    public int insert(User obj) throws DaoException {
        Connection          conn            = null;
        CallableStatement   cs              = null; 
        String              sql             = "{CALL sp_insert_user(?,?,?,?,?,?,?,?,?,?,?,?)}";     
        int                 newKey          = 0;
        
        try{
            conn = getConnection();
            cs = conn.prepareCall(sql); 
            cs.setString(1, obj.getFirstName());
            cs.setString(2, obj.getLastName());
            cs.setString(3, obj.getAddress1());
            cs.setString(4, obj.getAddress2());
            cs.setString(5, obj.getCity());
            cs.setString(6, obj.getCounty());
            cs.setString(7, obj.getCountry());
            cs.setString(8, obj.getPostCode());
            cs.setString(9, obj.getEmail());
            cs.setString(10, obj.getPassword());
            cs.setByte(11, obj.getUserType());        
            cs.registerOutParameter(12, java.sql.Types.INTEGER);
            
            cs.executeUpdate();     
            newKey = cs.getInt(12);  // Grab the newly created Primary Key   
            logger.debug("UserDao Insert Success: email:{} ",obj.getEmail());            
        }
        catch (SQLException sqe){
            logger.error("UserDao Insert Exception: email:{} ",obj.getEmail());
            throw new DaoException("UserDao.insert(), " + sqe.getMessage());
        }
        finally{
            freeResources("UserDao.insert()", conn, cs, null);
        }
        
        return newKey;
    }

    @Override
    public boolean update(User obj) throws DaoException {

        //JOptionPane.showMessageDialog(null,obj.getPostCode(),"IO Error",JOptionPane.ERROR_MESSAGE);
        Connection          conn            = null;
        PreparedStatement   ps              = null;
        int                 rowsAffected    = 0;
        String              sql             = "{CALL sp_update_user(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        
        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getFirstName());
            ps.setString(2, obj.getLastName());
            ps.setString(3, obj.getAddress1());
            ps.setString(4, obj.getAddress2());
            ps.setString(5, obj.getCity());
            ps.setString(6, obj.getCounty());
            ps.setString(7, obj.getCountry());
            ps.setString(8, obj.getPostCode());
            ps.setString(9, obj.getEmail());
            ps.setString(10, obj.getPassword());
            ps.setByte(11, obj.getUserType());        
            ps.setTimestamp(12,new java.sql.Timestamp(obj.getLastUpdated().getTime()));            
            ps.setInt(13,obj.getId());
            
            rowsAffected = ps.executeUpdate();
        }
        catch (SQLException sqe){
            throw new DaoException("UserDao.update(), " + sqe.getMessage());
        }
        finally{
            freeResources("UserDao.update(): ", conn, ps, null);
        }
        
        return rowsAffected == 1;
    }

    @Override
    public boolean delete(int key) throws DaoException {
        Connection          conn            = null;
        PreparedStatement   ps              = null;
        int                 rowsAffected    = 0;
        String              sql             = "{CALL sp_delete_user(?)}";
        
        try{
            conn = getConnection();
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, key);

            rowsAffected = ps.executeUpdate();            
        } 
        catch (SQLException sqe){
            throw new DaoException("UserDao.delete(): " + sqe.getMessage());
        } 
        finally{
            freeResources("UserDao.delete(): ", conn, ps, null);
        }
        
        return rowsAffected == 1;
    }

    @Override
    public List<User> getAll() throws DaoException {
       
        Connection          conn            = null;
        PreparedStatement   ps              = null;
        ResultSet           rs              = null;        
        List<User>          users           = new ArrayList<User>();    
        String              query           = "{CALL sp_get_all_users()}";
        
        try{
            conn = getConnection();            
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();         
            
            while(rs.next()){
                users.add( new User(rs.getInt("id"),
                                rs.getString("fname"),
                                rs.getString("lname"),
                                rs.getString("email"),                      
                                rs.getByte("user_type")));
            }            
        } 
        catch (SQLException sqe){
            throw new DaoException("UserDao.getAll(): " + sqe.getMessage());
        } 
        finally{
            freeResources("UserDao.getAll(): ",conn,ps,rs);
        }
        
        return users;     // could return null
    }

    @Override
    public User getByKey(int key) throws DaoException {
       
        Connection          conn            = null;
        PreparedStatement   ps              = null;
        ResultSet           rs              = null;        
        User                user            = null;    
        String              query           = "{CALL sp_get_user_by_id(?)}";
        
        try{
            conn = getConnection();            
            ps = conn.prepareStatement(query);
            ps.setInt(1, key);
            rs = ps.executeQuery();         
            
            if(rs.next()){
                user = new User(rs.getInt("id"),
                                rs.getString("fname"),
                                rs.getString("lname"),
                                rs.getString("address1"),
                                rs.getString("address2"),
                                rs.getString("city"),
                                rs.getString("county"),
                                rs.getString("country"),
                                rs.getString("postcode"),
                                rs.getString("email"),  
                                getStringFromInputStream(rs.getBinaryStream("password")),
                                rs.getByte("user_type"),                        
                                rs.getTimestamp("last_updated"));
            }            
        } 
        catch (SQLException sqe){
            throw new DaoException("UserDao.getByKey(): " + sqe.getMessage());
        } 
        finally{
            freeResources("UserDao.getByKey(): ",conn,ps,rs);
        }
        
        return user;     // could return null

    }

    @Override
    public User login(String email, String password) throws DaoException {
       
        Connection          conn            = null;
        PreparedStatement   ps              = null;
        ResultSet           rs              = null;        
        User                user            = null;    
        String              query           = "{CALL sp_get_user_login(?,?)}";
        
        try{
            conn = getConnection();            
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password); // Encrypt here
            rs = ps.executeQuery();         
            
            if(rs.next()){
                user = new User(rs.getInt("id"),
                                rs.getString("fname"),
                                rs.getString("lname"),
                                rs.getString("address1"),
                                rs.getString("address2"),
                                rs.getString("city"),
                                rs.getString("county"),
                                rs.getString("country"),
                                rs.getString("postcode"),
                                rs.getString("email"), 
                                getStringFromInputStream(rs.getBinaryStream("password")),
                                rs.getByte("user_type"),                        
                                rs.getTimestamp("last_updated"));
            }            
        } 
        catch (SQLException sqe){
            throw new DaoException("UserDao.login(): " + sqe.getMessage());
        } 
        finally{
            freeResources("UserDao.login(): ",conn,ps,rs);
        }
        
        return user;     // could return null

    }
        
    private String getStringFromInputStream(InputStream is) {

        // Thanks to http://www.mkyong.com/java/how-to-convert-inputstream-to-string-in-java/ for this code

        // Converts our binary encoded password to a string
        
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
                e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }    
    
}
