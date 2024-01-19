/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl.data;

import java.sql.*;

/**
 *
 * @author vinu
 */
public class DBUtil {
    
    public static void closeStatement(Statement s) {
        try {
            if(s != null) {
                s.close();
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void closePreparedStatement(Statement ps) {
         try {
            if(ps != null) {
                ps.close();
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void closeResultSet(ResultSet rs) {
         try {
            if(rs != null) {
                rs.close();
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
