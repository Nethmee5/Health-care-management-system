/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl.data;
import hcl.business.Agent;
import hcl.business.Booking;
import hcl.vendors.Book;
import hcl.vendors.History;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author vinu
 */
public class DoctorDB {
    //get agent
    public static int getAgentById(Agent agent){
        int flag = 0;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        
        Statement st = null;
        
        String getAgent 
                = "SELECT "
                + "medic_id, Fname,Lname, DOB, email, NIC, phone_number, gender, hospital, `line-1`, `line-2`, city, district, postal_code "
                + "FROM medical_officer WHERE medic_id = "+agent.getMedicid()+"";
        
        try{
            st = con.createStatement();
            
            ResultSet rs = st.executeQuery(getAgent);
            
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
                    agent.setGender(rs.getString("hospital"));
                    agent.setAdLine1(rs.getString("line-1"));
                    agent.setAdLine2(rs.getString("line-2"));
                    agent.setCity(rs.getString("city"));
                    agent.setDistrict(rs.getString("district"));
                    agent.setPostalCode(rs.getInt("postal_code"));
                }while(rs.next());
            }
            
            rs.close();
            
            return 1;
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return 0;
        }finally{
            DBUtil.closePreparedStatement(st);
            pool.freeConnection(con);
        }
    }
    
    
   //request - pending
    public static String getPendingRequest(int id){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String agentRequest = "";
        
        String pendingRequest 
                = "SELECT "
                + "booking.booking_id, booking.cus_id, booking.date, booking.time, booking.price, booking.contact, booking.status, "
                + "user_tbl.Fname, user_tbl.Lname, user_tbl.`line-1`, user_tbl.`line-2`, user_tbl.city, "
                + "service.service_name "
                + "FROM ((booking "
                + "INNER JOIN user_tbl ON "
                + "booking.cus_id = user_tbl.cus_id) "
                + "INNER JOIN service ON "
                + "booking.service_id = service.service_id) "
                + "WHERE booking.medic_id = "+id+" AND booking.status = 'pending' "
                + "ORDER BY date DESC, time DESC";
        
        try{
            
            ps = con.prepareStatement(pendingRequest);
            ResultSet rs = ps.executeQuery();
            
            agentRequest = Book.agentViewbookingbydateCard(rs);
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(con);
        }
        
        
        return agentRequest ;
    }
    
    
    //retrive confirmed  --->History 
    public static String getConfirmedRequest(int id){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        
        Statement st = null;
        
        String agentConfirm = "";
        
        String ConfirmRequest 
                = "SELECT "
                + "booking.booking_id, booking.cus_id, booking.date, booking.time, booking.price, booking.contact, "
                + "user_tbl.Fname, user_tbl.Lname, user_tbl.city, user_tbl.`line-1`, user_tbl.`line-2`, "
                + "service.service_name "
                + "FROM ((booking "
                + "INNER JOIN user_tbl ON "
                + "booking.cus_id = user_tbl.cus_id) "
                + "INNER JOIN service ON "
                + "booking.service_id = service.service_id) "
                + "WHERE booking.medic_id = "+id+" AND booking.status = 'confirmed' "
                + "ORDER BY date DESC, time DESC";
        
        try{
            
            st = con.createStatement();
            
            ResultSet rs = st.executeQuery(ConfirmRequest);
            
            agentConfirm = History.agentBookings(rs);
            
        }catch(SQLException ex){
            System.out.println("from DoctorDB " + ex.getMessage());
        }finally{
            DBUtil.closePreparedStatement(st);
            pool.freeConnection(con);
        }
        
        
        return agentConfirm ;
    }
    
    //retrive Done TASK by agent -->History
    public static String getDoneBookings(){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String agentTastDone = "";
        
        String ConfirmRequest 
                = "SELECT"
                + "( booking.book_id,booking.cus_id,user_tbl.Fname, user_tbl.Lname, user_tbl.gender, user_tbl.phone_number, service.type, service.service_name, booking.date, booking.time,booking.price, )"
                + "FROM ((booking"
                + "INNER JOIN booking ON"
                + "booking.cus_id = user_tbl.cus_id)"
                + "INNER JOIN service "
                + "booking.service_id = service.service_id)"
                + "WHERE staus = DONE "
                + "ORDER BY date DESC, time DESC";
        
        try{
            
            ps = con.prepareStatement(ConfirmRequest);
            ResultSet rs = ps.executeQuery();
            agentTastDone = History.getDoneTask(rs);
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(con);
        }
        
        
        return agentTastDone ;
    }
    
    
}