/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl.data;

import hcl.business.Customer;
import hcl.vendors.Book;
import hcl.vendors.History;

import java.sql.*;

/**
 *
 * @author vinu
 */
public class PatientsDB {
    //get customer by id
    public static int getCustomerById(Customer cus){
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        
        Statement st = null;
        
        
        String getCustomer 
                = "SELECT cus_id, Fname, Lname, DOB, email, NIC, phone_number, gender, `line-1`, `line-2`, city, district, postal_code "
                + "FROM user_tbl WHERE cus_id = "+cus.getCusid()+"";
        
        try{
            st = con.createStatement();
            
            ResultSet rs = st.executeQuery(getCustomer);
            
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
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return 0;
        }finally{
            DBUtil.closeStatement(st);
            pool.freeConnection(con);
        }
    }
    
    //get bookings
    public static String getBookingList(int id){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
       
        Statement st = null;
        
        String cusbooking = "";
        
        
        String getBooking 
               = "SELECT "
                + "booking.booking_id, booking.cus_id, medical_officer.Fname, medical_officer.Lname,"
                + "medical_officer.phone_number, booking.price, booking.date, booking.time, booking.contact, "
                + "service.service_name, medical_officer.city, medical_officer.hospital "
                + "FROM ((booking "
                + "INNER JOIN medical_officer ON "
                + "booking.medic_id = medical_officer.medic_id) "
                + "INNER JOIN service "
                + "ON booking.service_id = service.service_id) "
                + "WHERE booking.cus_id = "+id+" AND booking.status = 'confirmed' "
                + "ORDER BY date DESC, time DESC";
        
        try{
            st = con.createStatement();
            
            ResultSet rs = st.executeQuery(getBooking);
                    
            cusbooking = Book.cusViewbookingbydateCard(rs);
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }finally{
            DBUtil.closeStatement(st);
            pool.freeConnection(con);
        }
        
        return cusbooking;
    }
    
    //get history
    public static String getHistoryList(int id){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String cusbookingHistory = "";
        
        
        String getHistory 
              = "SELECT "
                + "booking.booking_id, booking.cus_id, medical_officer.Fname, medical_officer.Lname, "
                + "medical_officer.phone_number, booking.price, booking.date, booking.time, "
                + "service.service_name, medical_officer.city, medical_officer.hospital  "
                + "FROM ((booking "
                + "INNER JOIN medical_officer ON "
                + "booking.medic_id = medical_officer.medic_id) "
                + "INNER JOIN service "
                + "ON booking.service_id = service.service_id) "
                + "WHERE booking.cus_id = "+id+" AND booking.status = 'done'"
                + "ORDER BY date DESC, time DESC";
        
        try{
            ps = con.prepareStatement(getHistory);
            ResultSet rs = ps.executeQuery();
                    
            cusbookingHistory = History.CustomerHistory(rs);
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(con);
        }
        
        return cusbookingHistory;
    }
    
    //get history
    public static String getReqList(int id){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String cusbookingHistory = "";
        
        
        String getHistory 
              = "SELECT "
                + "booking.booking_id, booking.cus_id, medical_officer.Fname, medical_officer.Lname, "
                + "medical_officer.phone_number, booking.price, booking.date, booking.time, booking.status, "
                + "service.service_name, medical_officer.city, medical_officer.hospital  "
                + "FROM ((booking "
                + "INNER JOIN medical_officer ON "
                + "booking.medic_id = medical_officer.medic_id) "
                + "INNER JOIN service "
                + "ON booking.service_id = service.service_id) "
                + "WHERE booking.cus_id = "+id+" AND (booking.status = 'pending' OR booking.status = 'cancelled')"
                + "ORDER BY date DESC, time DESC";
        
        try{
            ps = con.prepareStatement(getHistory);
            ResultSet rs = ps.executeQuery();
                    
            cusbookingHistory = History.CustomerRequest(rs);
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(con);
        }
        
        return cusbookingHistory;
    }
    
}
