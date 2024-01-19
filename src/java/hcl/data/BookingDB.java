/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl.data;
import java.sql.*;
import hcl.business.Booking;
import hcl.vendors.View;
//import hcl.business.Service;

/**
 *
 * @author vinu
 */
public class BookingDB {
    //getTests
    public static String getTests(){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        
        Statement st = null;
        
        String TestCard = "";
        
        String viewTests
                ="select "
                + "service_id, service_name, description, price, brand, status, type "
                + "from service "
                + "where type = 'test'";
        try{
            st = con.createStatement();
            ResultSet rs = st.executeQuery(viewTests);
          
            TestCard = View.testCard(rs);  
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DBUtil.closePreparedStatement(st);
            pool.freeConnection(con);
        }
       
        
      return TestCard; 
    }
    
    
    public static String getMedicine(){
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        
        Statement st = null;
        
        String VaccineCard = "";
        
        String viewVaccine
                ="select "
                + "service_id, service_name, description, price, brand, status, type "
                + "from service "
                + "where type = 'medicine'";
        try{
            st = con.createStatement();
            ResultSet rs = st.executeQuery(viewVaccine);
          
            VaccineCard = View.MedicineCard(rs);
            
        }catch(SQLException ex){
            System.out.println("BookingDB " + ex.getMessage());
        }finally{
            DBUtil.closePreparedStatement(st);
            pool.freeConnection(con);
        }
       
        
      return VaccineCard; 
    }
    
    
    
    
    
    
    public static String getAgents(){
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        
        Statement st = null;
        
        String AgentBookCard = "";
        
        String viewAgents
                ="select "
                + "medic_id, Fname, Lname, email, Hospital, phone_number, city, district "
                + "from medical_officer ";
        try{
            st = con.createStatement();
            ResultSet rs = st.executeQuery(viewAgents);
            
        AgentBookCard = View.agentbookCard(rs);
             
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DBUtil.closePreparedStatement(st);
            pool.freeConnection(con);
        }
       
        return AgentBookCard;
       
    }
    
    //addBooking
    //status not added to this
    public static int insertion(Booking booking){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();

        PreparedStatement ps = null;


        String insertion =
                "INSERT INTO booking "
                +"(cus_id, medic_id, service_id, price,date,time,address,contact) "
                +"VALUES (?,?,?,?,?,?,?,?)";

        try{
            ps = con.prepareStatement(insertion);
            ps.setInt(1, booking.getCusid());
            ps.setInt(2, booking.getMedicid());
            ps.setInt(3, booking.getServiceid());
            ps.setDouble(4, booking.getPrice());
            ps.setString(5, booking.getDate());
            ps.setString(6, booking.getTime());
            ps.setString(7, booking.getAddress());
            ps.setString(8, booking.getContact());

            return ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Coudn't add booking " + ex.getMessage());
            return 0;
        }finally{
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(con);
        }
            
    }
    
    
    public static int deleteReq(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();

        Statement st = null;

        String deletereq
                = "delete from "
                + "booking where booking_id = " + id + "";
        try {
            st = con.createStatement();

            return st.executeUpdate(deletereq);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        } finally {
            DBUtil.closePreparedStatement(st);
            pool.freeConnection(con);
        }  
            
    }
    
    //cancel - booking
    public static int rejectReq(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();

        Statement st = null;

        String deletereq
                = "update booking set status = 'cancelled' where booking_id = " + id + "";
        
        try {
            st = con.createStatement();

            return st.executeUpdate(deletereq);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        } finally {
            DBUtil.closePreparedStatement(st);
            pool.freeConnection(con);
        }  
            
    }
    
    
    //booking request - confirm
    public static int confirmReq(int id){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();

        Statement st = null;

        String deletereq
                = "update booking set status = 'confirmed' where booking_id = " + id + "";
        
        try {
            st = con.createStatement();

            return st.executeUpdate(deletereq);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        } finally {
            DBUtil.closePreparedStatement(st);
            pool.freeConnection(con);
        } 
    }
    
    //confirm agent attend
    public static int confirmAttend(int id){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();

        Statement st = null;

        String deletereq
                = "update booking set status = 'done' where booking_id = " + id + "";
        
        try {
            st = con.createStatement();

            return st.executeUpdate(deletereq);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        } finally {
            DBUtil.closePreparedStatement(st);
            pool.freeConnection(con);
        } 
    }
} 
    
    


































//    public static void insertService(Service service){
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection con = pool.getConnection();
//        PreparedStatement ps = null;
//        
//        try{
//            
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }finally{
//            DBUtil.closePreparedStatement(ps);
//            pool.freeConnection(con);
//        }
//    }
 
    
// 

 //customer cancel booking
    //bookid is the booking
//    public static void cancelBooking(Booking booking){
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection con = pool.getConnection();
//        PreparedStatement ps = null;
//        
//        String userCancelBooking 
//                    = "UPDATE BOOKING"
//                    + "SET status=?"
//                    + "WHERE id=?";
//        
//        try{
//            
//           ps = con.prepareStatement(userCancelBooking);
//           ps.setString(0, booking.getStatus());
//           ps.setString(1, bookid);
//            
//            
//        }catch(SQLException ex){
//            ex.getMessage();
//        }finally{
//            DBUtil.closePreparedStatement(ps);
//           pool.freeConnection(con);
//        }
//    }

 //Medical Agent confirm booking
//    public static void confirmBooking(Booking booking, String bookid){
//        ConnectionPool pool = ConnectionPool.getInstance();
//        Connection con = pool.getConnection();
//        PreparedStatement ps = null;
//        
//        String insertion =
//                    "UPDATE BOOKING"
//                    +"SET status=?"
//                    +"WHERE ID =?";
//    
//        try{
//           ps = con.prepareStatement(insertion);
//           ps.setString(1, booking.getStatus());
//           ps.setString(2, bookid);
//        }catch(SQLException Ex){
//            System.out.println(Ex.getMessage());
//        }finally{
//        DBUtil.closePreparedStatement(ps);
//        pool.freeConnection(con);
//    }
//    }
