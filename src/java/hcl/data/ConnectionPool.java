/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl.data;

import java.sql.*;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author vinu
 */

// Implements the connection pool
public class ConnectionPool {
    
    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;
    
    private ConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/app");
        } catch(NamingException ex) {
            System.out.println("Connection pool-1: " + ex.getMessage());
        }
    }
    
    public static synchronized ConnectionPool getInstance() {
        if(pool==null) {
            pool = new ConnectionPool();
        }
        
        return pool;
    }
    
    public Connection getConnection() {
        try {
            System.out.println("Connection pool - gotcon");
            return dataSource.getConnection();
        } catch(SQLException ex) {
            System.out.println("Connection pool-getcon: " + ex.getMessage());
            return null;
        }
    }
    
    public void freeConnection(Connection c) {
        try {
            c.close();
        } catch(SQLException ex) {
            System.out.println("Connection pool-freecon: " + ex.getMessage());
        }
    }
}
