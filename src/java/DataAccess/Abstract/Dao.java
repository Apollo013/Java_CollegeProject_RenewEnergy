/* 
 * Copyright (c) 2014, Climote
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, 
 * this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation 
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE 
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 * POSSIBILITY OF SUCH DAMAGE.
 */

package DataAccess.Abstract;

import Exceptions.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;  

/**
 *
 * @author Paul Millar <D00152098>
 */
public class Dao {

    static final Logger logger = LogManager.getLogger(Dao.class.getName());
                    
    private DataSource datasource;
  
    
    public Dao()
    {
        Connection con = null;
        String DATASOURCE_CONTEXT = "jdbc/millar_paul_sd1_project1";
        try {
            Context initialContext = new InitialContext();
            DataSource ds = (DataSource)initialContext.lookup("java:comp/env/" + DATASOURCE_CONTEXT);
            if(ds != null){
                datasource = ds;
            }
            else{
		System.out.println(("Failed to lookup datasource."));
            }
        }catch (NamingException ex ){
            System.out.println("Cannot get connection: " + ex);
        }
    }
    
    public Connection getConnection() throws DaoException
    {
        Connection conn = null;
        try{
            if (datasource != null) {
                conn = datasource.getConnection();
            }else {
                logger.fatal("Failed To Lookup Datasource.");
            }
        }catch (SQLException ex2){
            logger.fatal("Get Connection Failed");            
        }
        return conn;
    }
    
    /**
     * Creates a new connection object for the database
     * @return a new connection object for the database
     * @throws DaoException
     * @throws java.lang.ClassNotFoundException
     */
    /*public Connection getOldeConnection() throws DaoException {

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/renewenergy";
        String username = "root";
        String password = "apollo013"; //
        
        Connection conn = null;
        
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } 
        catch (ClassNotFoundException cnfe) {     
            try {
                //Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, cnfe);
                throw new ClassNotFoundException("Failed To Find Driver Class:\n" + cnfe.getMessage());
            } catch (ClassNotFoundException ex) {
                //Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        catch (SQLException sqle) {   
            //Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, sqle);
            throw new DaoException("Connection Failed:\n" + sqle.getMessage());
        }
        return conn;
    }
    */
    /**
     * Closes & Frees a Connection object
     * @param conn Connection object to free.
     * @throws DaoException
     */
    public void freeConnection(Connection conn) throws DaoException {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException sqle) {
            throw new DaoException(sqle.getMessage());
        }
    }
    
    /**
     * Closes & Frees a Statement object.
     * @param ps Prepared Statement object to free
     * @throws Exceptions.DaoException
     */
    public void freePreparedStatement(PreparedStatement ps) throws DaoException {
        try{
            if(ps != null){
                ps.close();
                ps = null;
            }
        } 
        catch(SQLException sqle){
            throw new DaoException(sqle.getMessage());
        }
    } 

    /**
     * Closes & Frees a ResultSet object.
     * @param rs
     * @throws DaoException
     */
    public void freeResultSet(ResultSet rs) throws DaoException {
        try{
            if(rs != null){
                rs.close();
                rs = null;
            }            
        }
        catch(SQLException sqle){
            throw new DaoException(sqle.getMessage());
        }        
    }
       
    /**
     * Closes & Frees all connection resource object.
     * @param errMessageTitle Title of the error message to be displayed (if one occurs)
     * @param conn Connection
     * @param ps PreparedStatement
     * @param rs ResultSet
     * @throws DaoException
     */
    public void freeResources(String errMessageTitle,Connection conn,PreparedStatement ps,ResultSet rs) throws DaoException{
        try {
            if (rs != null) {
                freeResultSet(rs);
            }
            if (ps != null) {
                freePreparedStatement(ps);
            }
            if (conn != null) {
                freeConnection(conn);
            }
        } catch(SQLException e) {
            throw new DaoException(errMessageTitle + e.getMessage());
        }        
    }
        
}
