/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl.data;

//import hcl.vendor.CardsVendor;
import hcl.business.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import hcl.business.Service;

/**
 *
 * @author vinu
 */
public class test {
    
    
    //addService
    //add both test and vaccine 
    public static int insertService(Service service){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        int flag = 0;
        String insertService
                ="INSERT INTO SERVICE"
                +"(type,service_name,description,price,brand,status)"
                +"VALUES(?,?,?,?,?,?,?)";
        
        try{
            ps = con.prepareStatement(insertService);
            
            ps.setString(1, service.getType());
            ps.setString(2, service.getServiceName());
            ps.setString(3, service.getDescription());
            ps.setDouble(4, service.getPrice());
            ps.setString(5, service.getBrand());
            ps.setString(6, service.getStatus());
            ps.executeQuery();
            
            flag = 1;
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(con);
        }
        return flag;
    }
    
    
    
    //getBookingsbyDate
    public static String getBookingByDate(){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String BookingbyDate = "";
        
        String getBookingByDate 
                = "SELECT "
                + "booking_id, cus_id, medic_id, Service_id, price, date, time ,status,address, contact "
                + "FROM booking"
                + "ORDER BY date DESC, time DESC"
                + "LIMIT 20";
                
                try{
                    ps = con.prepareStatement(getBookingByDate);
                    ResultSet rs = ps.executeQuery();
                    
//                    BookingbyDate = CardsVendor.bookingbydateCard(rs);
                    
                }catch(SQLException ex){
                    ex.getMessage();
                }finally{
                    DBUtil.closePreparedStatement(ps);
                    pool.freeConnection(con);
                }
        
        
        return BookingbyDate;
    }
    //get agents
    public static String getAgent(){
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        
        String AgentCard = "";
        
        String viewAgents
                ="select "
                + "medic_id,Fname,Lname,DOB,email,NIC,Hospital,gender,password,phone,AdLine1,Adline2,city,postalCode "
                + "from medical_officer";
        try{
            ps = con.prepareStatement(viewAgents);
            ResultSet rs = ps.executeQuery();
            
//        AgentCard = CardsVendor.agentCard(rs);
             
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(con);
        }
       
        return AgentCard;
       
    }
    
    //getTestList
    public static String getTest(){
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        
        String TestCard = "";
        
        String viewTests
                ="select "
                + "service_id, service_name, description, price, brand, status, type "
                + "from service "
                + "where type = 'test'";
        try{
            ps = con.prepareStatement(viewTests);
            ResultSet rs = ps.executeQuery();
          
//        TestCard = CardsVendor.testCard(rs);  
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(con);
        }
       
        
      return TestCard; 
    }
    
    //getVaccineList
    public static String getVaccine(){
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        
        String VaccineCard = "";
        
        String viewVaccines
                ="select "
                + "service_id, service_name, description, price, brand, status, type"
                + " from service"
                + " where type = 'vaccine'";
        try{
            ps = con.prepareStatement(viewVaccines);
           ResultSet rs = ps.executeQuery(); 
           
//           VaccineCard = CardsVendor.MedicineCard(rs);
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DBUtil.closePreparedStatement(ps);
            
            pool.freeConnection(con);
        }
       
        return VaccineCard;
       
    }
    
    //getAdmin
    public static String getAdmin(Admin Admin){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String AdminCard = "";
        String getAdminbyId 
                = "SELECT"
                + " admin_officer,Fname,Lname,DOB,email,password, NIC, phone_number"
                + " FROM admin_officer"
                + "WHERE admin_officer = ?";
        try{
            ps = con.prepareStatement(getAdminbyId);
            ResultSet rs = ps.executeQuery();
            
//        AdminCard = CardsVendor.adminCard(rs);
             
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(con);
        }
        
        return AdminCard;
        
    }
    
    
    
    
    
    
    
}
