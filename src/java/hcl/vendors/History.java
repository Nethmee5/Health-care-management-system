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
public class History {

    //Agent History
    public static String getDoneTask(ResultSet rs) throws SQLException {
        StringBuilder crd = new StringBuilder();
        while (rs.next()) {
            crd.append("<div class='request'>");

            crd.append("<div class='col'");
            crd.append("<p>Book ID</p>");
            crd.append("<p>").append(rs.getString("book_id")).append("</p>");
            crd.append("</div>");

            crd.append("<div class='col'");
            crd.append("<p>Item Name</p>");
            crd.append("<p>").append(rs.getString("service_name")).append("</p>");
            crd.append("</div>");

            crd.append("<div class='col'");
            crd.append("<p>Sample Type</p>");
            crd.append("<p>").append(rs.getString("type")).append("</p>");
            crd.append("</div>");

            crd.append("<div class='col'");
            crd.append("<p>Customer</p>");
            crd.append("<p>").append(rs.getString("Fname")).append("").append(rs.getString("Lname")).append("</p>");
            crd.append("</div>");

            crd.append("<div class='col'");
            crd.append("<p>Contact number</p>");
            crd.append("<p>").append(crd.append("phone_number")).append("</p>");
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

            crd.append("<div class='col'");
            crd.append("<p>Price</p>");
            crd.append("<input type='submit' value= '").append(crd.append("price")).append("'/></p>");
            crd.append("</div>");

            crd.append("</div>");
        }
        return crd.toString();
    }

    //Agent Confirm
    public static String getConfirmedBookingd(ResultSet rs) throws SQLException {
        StringBuilder crd = new StringBuilder();
        while (rs.next()) {
            crd.append("<div class='request'>");

            crd.append("<div class='col'");
            crd.append("<p>Book ID</p>");
            crd.append("<p>").append(rs.getString("book_id")).append("</p>");
            crd.append("</div>");

            crd.append("<div class='col'");
            crd.append("<p>Item Name</p>");
            crd.append("<p>").append(rs.getString("service_name")).append("</p>");
            crd.append("</div>");

            crd.append("<div class='col'");
            crd.append("<p>Sample Type</p>");
            crd.append("<p>").append(rs.getString("type")).append("</p>");
            crd.append("</div>");

            crd.append("<div class='col'");
            crd.append("<p>Customer</p>");
            crd.append("<p>").append(rs.getString("Fname")).append("").append(rs.getString("Lname")).append("</p>");
            crd.append("</div>");

            crd.append("<div class='col'");
            crd.append("<p>Contact number</p>");
            crd.append("<p>").append(crd.append("phone_number")).append("</p>");
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

            crd.append("<div class='col'");
            crd.append("<p>Price</p>");
            crd.append("<input type='submit' value= '").append(crd.append("price")).append("'/></p>");
            crd.append("<input type='submit' value= 'ATTEND'/></p>");
            crd.append("<input type='submit' value= 'CANCEL'/></p>");
            crd.append("</div>");

            crd.append("</div>");
        }
        return crd.toString();
    }

    //agentRequest
    public static String agentBookings(ResultSet rs) throws SQLException {

        StringBuilder crd = new StringBuilder();
        while (rs.next()) {
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
            crd.append("<p class='card-text bold font-weight-bold text-danger' >LKR ").append(rs.getString("price")).append("</p>");
            crd.append("</div>");
            crd.append("</div>");
            crd.append("</div>");
        }

        return crd.toString();

    }

    //customerHistory
    public static String CustomerHistory(ResultSet rs) throws SQLException {
        StringBuilder crd = new StringBuilder();

        while (rs.next()) {
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
            crd.append("<p class='card-text bold font-weight-bolder text-info btn btn-light btn-block'>LKR ").append(rs.getString("price")).append("</p>");
            crd.append("<a href='' class='btn btn-primary mb-2 btn-block' style=\"background-color: #1A237E; border:none\">Book Same</a>");
            crd.append("</div>");
            crd.append("</div>");
            crd.append("</div>");
        }

        return crd.toString();

    }

    public static String CustomerRequest(ResultSet rs) throws SQLException {

        StringBuilder crd = new StringBuilder();

        while (rs.next()) {
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
            crd.append("<p class='card-text bold font-weight-bolder text-danger'>LKR ").append(rs.getString("price")).append("</p>");
            crd.append("</div>");

            crd.append("<div class='col'>");
            crd.append("<p class='card-text bold font-weight-bolder text-info'>").append(rs.getString("booking.status").toUpperCase()).append("</p>");
            crd.append("<a href='/app/booking?q=delReq&id=").append(rs.getInt("booking.booking_id")).append("' class='text-light btn btn-secondary'>Cancel Request</a>");
            crd.append("</div>");
            crd.append("</div>");
            crd.append("</div>");
        }

        return crd.toString();

    }
}
