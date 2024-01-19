/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl.data;

import hcl.business.Admin;
import hcl.business.Agent;
import hcl.business.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;

/**
 *
 * @author vinu
 */
public class AuthDB {
    //signup

    // admin SignUp
    public static int insertAdmin(Admin admin) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        int flag = 0;

        String insertion
                = "INSERT INTO admin_officer (Fname, Lname,DOB,email, password, NIC, phone_number)"
                + "VALUES (?,?,?,?,?,?,?)";

        //insertion
        try {
            ps = con.prepareStatement(insertion);

            ps.setString(1, admin.getFname());
            ps.setString(2, admin.getLname());
            ps.setString(3, admin.getDOB());
            ps.setString(4, admin.getEmail());
            ps.setString(5, admin.getPassword());
            ps.setString(6, admin.getNIC());
            ps.setString(7, admin.getPhone());

            ps.executeUpdate();
            flag = 1;

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(con);
        }
        return flag; //remove this

    }

    //1. customer signup
    public static int insertUser(Customer customer) throws NamingException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        
        String insertion
                = "INSERT INTO user_tbl"
                + "(Fname, Lname, DOB, email, password, NIC, phone_number, gender, `line-1`, `line-2`, city, district, postal_code)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(insertion);

            ps.setString(1, customer.getFname());
            ps.setString(2, customer.getLname());
            ps.setString(3, customer.getDOB());
            ps.setString(4, customer.getEmail());
            ps.setString(5, customer.getPassword());
            ps.setString(6, customer.getNIC());
            ps.setString(7, customer.getPhone());
            ps.setString(8, customer.getGender());
            ps.setString(9, customer.getAdLine1());
            ps.setString(10, customer.getAdLine2());
            ps.setString(11, customer.getCity());
            ps.setString(12, customer.getDistrict());
            ps.setInt(13, customer.getPostalCode());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Couldn't add user " + ex.getMessage());
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(con);
        }
    }

    //2. Agent Sign up
    public static int insertAgent(Agent agent) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        int flag = 0;
        String insertion
                = "INSERT INTO AGENT"
                + "(Fname,Lname,DOB,email,NIC,Hospital,gender,password,phone,AdLine1,Adline2,city,postalCode)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(insertion);
            ps.setString(1, agent.getFname());
            ps.setString(2, agent.getLname());
            ps.setString(3, agent.getDOB());
            ps.setString(4, agent.getEmail());
            ps.setString(5, agent.getNIC());
            ps.setString(6, agent.getHospital());
            ps.setString(7, agent.getGender());
            ps.setString(8, agent.getPassword());
            ps.setString(9, agent.getPhone());
            ps.setString(10, agent.getAdLine1());
            ps.setString(11, agent.getAdLine2());
            ps.setString(12, agent.getCity());
            ps.setInt(13, agent.getPostalCode());
            ps.executeUpdate();
            flag = 1;

        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(con);
        }
        return flag;

    }

    //signin 
    public static int signUser(String email, String pass, Customer cus) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        Statement st = null;
        
        String getUser
                = "SELECT cus_id, Fname, Lname, DOB, email, NIC, phone_number, gender, `line-1`, `line-2`, city, district, postal_code "
                + "FROM user_tbl WHERE email = '"+ email +"' and password = '"+ pass +"'";
        
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(getUser);
            
            if(rs.next() == false) {
                return 0;
            }
            else {
                do {
                    cus.setCusid(rs.getInt("cus_id"));
                    cus.setFname(rs.getString("Fname"));
                    cus.setLname(rs.getString("Lname"));
                    cus.setDOB(rs.getString("DOB"));
                    cus.setEmail(rs.getString("email"));
                    cus.setNIC(rs.getString("NIC"));
                    cus.setPhone(rs.getString("phone_number"));
                    cus.setGender(rs.getString("gender"));
                    cus.setAdLine1(rs.getString("line-1"));
                    cus.setAdLine2(rs.getString("line-2"));
                    cus.setCity(rs.getString("city"));
                    cus.setDistrict(rs.getString("district"));
                    cus.setPostalCode(rs.getInt("postal_code"));
                }while(rs.next());
            }
            
            rs.close();
            
            return 1;
            
        } catch (SQLException ex) {
            System.out.println("Cant get user " + ex.getMessage());
            return 0;
        } finally {
            DBUtil.closeStatement(st);
            pool.freeConnection(con);
        }
    }
    
    public static int signAgent(String email, String pass, Agent agent) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        Statement st = null;
        
        String getUser
                = "SELECT medic_id, Fname, Lname, DOB, email, NIC, phone_number, gender, hospital, `line-1`, `line-2`, city, district, postal_code "
                + "FROM medical_officer WHERE email = '"+ email +"' and password = '"+ pass +"'";
        
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(getUser);
            
            if(rs.next() == false) {
                return 0;
            }
            else {
                do {
                    agent.setMedicid(rs.getInt("medic_id"));
                    agent.setFname(rs.getString("Fname"));
                    agent.setLname(rs.getString("Lname"));
                    agent.setDOB(rs.getString("DOB"));
                    agent.setEmail(rs.getString("email"));
                    agent.setNIC(rs.getString("NIC"));
                    agent.setPhone(rs.getString("phone_number"));
                    agent.setGender(rs.getString("gender"));
                    agent.setHospital(rs.getString("hospital"));
                    agent.setAdLine1(rs.getString("line-1"));
                    agent.setAdLine2(rs.getString("line-2"));
                    agent.setCity(rs.getString("city"));
                    agent.setDistrict(rs.getString("district"));
                    agent.setPostalCode(rs.getInt("postal_code"));
                }while(rs.next());
            }
            
            rs.close();
            
            return 1;
            
        } catch (SQLException ex) {
            System.out.println("Cant get user " + ex.getMessage());
            return 0;
        } finally {
            DBUtil.closeStatement(st);
            pool.freeConnection(con);
        }

        
    }
    
    public static int signAdmin(String email, String pass, Admin admin) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        Statement st = null;
        
        String getUser
                = "SELECT admin_id, Fname, Lname, DOB, email, NIC, phone_number "
                + "FROM admin_officer WHERE email = '"+ email +"' and password = '"+ pass +"'";
        
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(getUser);
            
            if(rs.next() == false) {
                return 0;
            }
            else {
                do {
                    admin.setAdminId(rs.getInt("admin_id"));
                    admin.setFname(rs.getString("Fname"));
                    admin.setLname(rs.getString("Lname"));
                    admin.setDOB(rs.getString("DOB"));
                    admin.setEmail(rs.getString("email"));
                    admin.setNIC(rs.getString("NIC"));
                    admin.setPhone(rs.getString("phone_number"));
                }while(rs.next());
            }
            
            rs.close();
            
            return 1;
            
        } catch (SQLException ex) {
            System.out.println("Cant get user " + ex.getMessage());
            return 0;
        } finally {
            DBUtil.closeStatement(st);
            pool.freeConnection(con);
        }

        
    }
    
    
    //signout
}
