/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl.vendors;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vinu
 */
public class Book {
    //agentBooking
     public static String agentViewbookingbydateCard(ResultSet rs) throws SQLException{
        StringBuilder crd = new StringBuilder();
        
        while(rs.next()){
            crd.append("<div class='card bg-light text-dark my-2 shadow'>");
            crd.append("<div class='card-body row'>");

            crd.append("<div class='col'>");
            crd.append("<p>Item Name</p>");
            crd.append("<p>").append(rs.getString("service_name")).append("</p>");
            crd.append("</div>");

            crd.append("<div class='col'");
            crd.append("<p>Customer</p>");
            crd.append("<p>").append(rs.getString("Fname")).append(" ").append(rs.getString("Lname")).append("</p>");
            crd.append("</div>");
            
            crd.append("<div class='col'>");
            crd.append("<p>Address</p>");
            crd.append("<p>").append(rs.getString("user_tbl.line-1")).append(" ").append(rs.getString("user_tbl.line-2")).append(", ").append(rs.getString("city")).append("</p>");
            crd.append("</div>");

            crd.append("<div class='col'");
            crd.append("<p>Contact</p>");
            crd.append("<p>").append(rs.getString("contact")).append("</p>");
            crd.append("</div>");

            crd.append("<div class='col'");
            crd.append("<p>Date</p>");
            crd.append("<p>").append(rs.getString("date")).append("</p>");
            crd.append("</div>");
            
            crd.append("<div class='col'");
            crd.append("<p>Time</p>");
            crd.append("<p>").append(rs.getString("time")).append("h").append("</p>");
            crd.append("</div>");

            crd.append("<div class='col'>");
            crd.append("<p>Price</p>");
            crd.append("<p class='card-text bold font-weight-bolder text-danger'>LKR ").append(rs.getString("price")).append("</p>");
            crd.append("</div>");

            crd.append("<div class='col'>");
            crd.append("<a href='/app/booking?q=confirmReq&id=").append(rs.getInt("booking.booking_id")).append("' class='text-light btn btn-block btn-primary' style=\"background-color: #1A237E; border:none\">Confirm</a>");
            crd.append("<a href='/app/booking?q=rejectReq&id=").append(rs.getInt("booking.booking_id")).append("' class='text-light btn btn-block btn-secondary'>REject</a>");
            crd.append("</div>");
            crd.append("</div>");
            crd.append("</div>");
        }
       return crd.toString();
        
    }
    
    //customerBooking
        public static String cusViewbookingbydateCard(ResultSet rs) throws SQLException{
        StringBuilder crd = new StringBuilder();
        
        while(rs.next()){
            crd.append("<div class='card bg-light text-dark my-2 shadow'>");
                crd.append("<div class='card-body row'>");
           
                    crd.append("<div class='col'>");
                    crd.append("<p>Item Name</p>");
                    crd.append("<p>").append(rs.getString("service_name")).append("</p>");
                    crd.append("</div>");

                    crd.append("<div class='col'");
                    crd.append("<p>Medical Assistant</p>");
                    crd.append("<p>").append(rs.getString("Fname")).append(" ").append(rs.getString("Lname")).append("</p>");
                    crd.append("<p>From ").append(rs.getString("city")).append("</p>");
                    crd.append("</div>");

                    crd.append("<div class='col'");
                    crd.append("<p>Contact</p>");
                    crd.append("<p>").append(rs.getString("phone_number")).append("</p>");
                    crd.append("<p>").append(rs.getString("hospital")).append("</p>");
                    crd.append("</div>");

                    crd.append("<div class='col'");
                    crd.append("<p>Date</p>");
                    crd.append("<p>").append(rs.getString("date")).append("</p>");
                    crd.append("</div>");
                    
                    crd.append("<div class='col'");
                    crd.append("<p>Time</p>");
                    crd.append("<p>").append(rs.getString("time")).append("h").append("</p>");
                    crd.append("</div>");

                    crd.append("<div class='col'>");
                    crd.append("<p>Price</p>");
                    crd.append("<p class='card-text bold font-weight-bold text-danger'>LKR ").append(rs.getString("price")).append("</p>");
                    crd.append("</div>");
                    
                    crd.append("<div class='col'>");
                    crd.append("<a href='/app/booking?q=confirmAttend&id=").append(rs.getInt("booking.booking_id")).append("' class='text-light btn btn-primary btn-block' style=\"background-color: #1A237E; border:none\">COnfirm Medical Officer Attendance</a>");
                    crd.append("</div>");
                crd.append("</div>");
            crd.append("</div>");
        }
        
       return crd.toString();
        
    }
    
    
    //adminBooking
    public static String bookingbydateCard(ResultSet rs) throws SQLException{
        StringBuilder crd = new StringBuilder();
        
        while(rs.next()){
            crd.append("<div class='booking'>");
            
            crd.append("<div class='col'");
            crd.append("<p>Item Name</p>");
            crd.append("<p>").append(rs.getString("service_name")).append("</p>");
            crd.append("</div>");
            
            crd.append("<div class='col'");
            crd.append("<p>Sample Type</p>");
            crd.append("<p>").append(rs.getString("type")).append("</p>");
            crd.append("</div>");
            
            crd.append("<div class='col'");
            crd.append("<p>Medical Assistant</p>");
            crd.append("<p>").append(rs.getString("Fname")).append("").append(rs.getString("Lname")).append("</p>");
            crd.append("</div>");
            
            crd.append("<div class='col'");
            crd.append("<p>Contact number</p>");
            crd.append("<p>").append(rs.getString("phone_number")).append("</p>");
            crd.append("</div>");
            
            crd.append("<div class='col'");
            crd.append("<p>Date</p>");
            crd.append("<p>").append(crd.append("date")).append("</p>");
            crd.append("</div>");
            
            crd.append("<div class='col'");
            crd.append("<p>Time</p>");
            crd.append("<p>").append(crd.append(rs.getString("time"))).append("</p>");
            crd.append("</div>");
            
            crd.append("<div class='col'");
            crd.append("<p>Status</p>");
            crd.append("<p>").append(crd.append(rs.getString("status"))).append("</p>");
            crd.append("</div>");
            
            //does admin refer the price?
            crd.append("<div class='col'");
            crd.append("<p>Price</p>");
            crd.append("<input type='submit' value= '").append(crd.append("price")).append("'/></p>");
            crd.append("<input type='submit' value= 'Cancel'/></p>");
            crd.append("</div>");
            
            crd.append("</div>");
        }
        return crd.toString();
    }
}
