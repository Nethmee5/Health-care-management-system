/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl.data;

import hcl.business.Admin;
import hcl.business.Agent;
import hcl.business.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vinu
 */
public class AdminDB {

    //addService
    //add both test and vaccine 
    public static int insertService(Service service) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;

        String insertService
                = "INSERT INTO service "
                + "(type,service_name,description,price,brand) "
                + "VALUES(?,?,?,?,?)";

        try {
            ps = con.prepareStatement(insertService);

            ps.setString(1, service.getType());
            ps.setString(2, service.getServiceName());
            ps.setString(3, service.getDescription());
            ps.setDouble(4, service.getPrice());
            ps.setString(5, service.getBrand());

            return ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(con);
        }
    }

    //insert new admin
    public static int insertAdmin(Admin admin) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;

        String insertion
                = "INSERT INTO admin_officer"
                + "(Fname, Lname,DOB,email, password, NIC, phone_number)"
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

            return ps.executeUpdate();

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(con);
        }
        return 0; //remove this

    }

    // insert agent
    public static int insertAgent(Agent agent) throws SQLException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;

        String insertion
                = "INSERT INTO medical_officer "
                + "(Fname,Lname,DOB,email,NIC,Hospital,gender,password,phone_number,`line-1`,`line-2`,city, district, postal_code) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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
            ps.setString(13, agent.getDistrict());
            ps.setInt(14, agent.getPostalCode());

            return ps.executeUpdate();

        } catch (SQLException ex) {
            ex.getMessage();
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(con);
        }
    }

    // TODO: admin profile
    //getBookingsbyDate
    public static String getBookingByDate(){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String BookingbyDate = "";
        
        String getBookingByDate 
                = "SELECT "
                + "booking.booking_id, booking.cus_id, medical_officer.Fname, medical_officer.Lname,"
                + " medical_officer.phone_number , booking.price, booking.date, booking.time ,booking.status, booking.address, booking.contact "
                + "FROM ((booking"
                + "INNER JOIN medical_officer ON"
                + "booking.medic_id = medical_officer.medic_id)"
                + "INNERJOIN service.type, service_name "
                + "ON booking.service_id = service.service_id)"
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
    public static String getAgent() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;

        String AgentCard = "";

        String viewAgents
                = "select "
                + "medic_id,Fname,Lname,DOB,email,NIC,Hospital,gender,phone_number,`line-1`,`line-2`,city,postal_Code "
                + "from medical_officer";
        try {
            ps = con.prepareStatement(viewAgents);
            ResultSet rs = ps.executeQuery();

//        AgentCard = CardsVendor.agentCard(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(con);
        }

        return AgentCard;

    }

    //getTestList
    public static String getTest() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;

        String TestCard = "";

        String viewTests
                = "select"
                + "service_id, service_name, description, price, brand, status, type"
                + "from service"
                + "where type = 'test'";
        try {
            ps = con.prepareStatement(viewTests);
            ResultSet rs = ps.executeQuery();

//        TestCard = CardsVendor.testCard(rs);  
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(con);
        }

        return TestCard;
    }

    //getVaccineList
    public static String getVaccine() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;

        String VaccineCard = "";

        String viewVaccines
                = "select"
                + "service_id, service_name, description, price, brand, status, type"
                + " from service"
                + " where type = 'vaccine'";
        try {
            ps = con.prepareStatement(viewVaccines);
            ResultSet rs = ps.executeQuery();

//           VaccineCard = CardsVendor.MedicineCard(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBUtil.closePreparedStatement(ps);

            pool.freeConnection(con);
        }

        return VaccineCard;

    }

    //getAdmin
    public static String getAdmin(Admin Admin) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        PreparedStatement ps = null;
        String AdminCard = "";
        String getAdminbyId
                = "SELECT"
                + " admin_officer,Fname,Lname,DOB,email,password, NIC, phone_number"
                + " FROM admin_officer"
                + "WHERE admin_officer = ?";
        try {
            ps = con.prepareStatement(getAdminbyId);
            ResultSet rs = ps.executeQuery();

//        AdminCard = CardsVendor.adminCard(rs);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(con);
        }

        return AdminCard;

    }

}
