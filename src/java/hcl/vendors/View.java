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
public class View {
    
    //customer view agent and book
   public static String agentbookCard(ResultSet rs) throws SQLException{
        StringBuilder crd = new StringBuilder();
        while(rs.next()){
            crd.append("<div class=\"card col-3 mb-2\" style=\"width: 18rem;\">");
            crd.append("<img src=\"Images/ds.jpg\" class=\"card-img-top py-2\" alt=\"...\">");
            crd.append("<div class=\"card-body\">");
            crd.append("<h5 class=\"card-title text-center\">");
            crd.append(rs.getString("Fname")).append(" ").append(rs.getString("Lname")).append("</h5>");
            crd.append("<p class=\"card-text\">Email:").append(" ").append(rs.getString("email")).append("</p>");
            crd.append("<p class=\"card-text\">Contact:").append(" ").append(rs.getString("phone_number")).append("</p>");
            crd.append("<p class=\"card-text\">Hospital:").append(" ").append(rs.getString("hospital")).append("</p>");
            crd.append("<p class=\"card-text\">Location:").append(" ").append(rs.getString("city")).append(", ").append(rs.getString("district")).append("</p>");
            crd.append("<a href='/app/booking?q=add_agent&id=").append(rs.getString("medic_id")).append("&fname=").append(rs.getString("Fname")).append("&lname=").append(rs.getString("Lname")).append("' class=\"btn btn-primary col-6 m-1\" style=\"background-color: #1A237E; border:none\">Hire Me</a>");
            crd.append("<a href='").append(rs.getInt("medic_id")).append("' class=\"btn btn-secondary col-5 m-1\">Call</a>");
            crd.append("</div></div>");
        }
        return crd.toString();
    }   
   
   
   public static String doc_dbookCard(ResultSet rs) throws SQLException{
        StringBuilder crd = new StringBuilder();
        while(rs.next()){
            crd.append("<div class=\"card col-3 mb-2\" style=\"width: 18rem;\">");
            crd.append("<img src=\"Images/m.png\" class=\"card-img-top py-2\" alt=\"...\">");
            crd.append("<div class=\"card-body\">");
            crd.append("<h5 class=\"card-title text-center\">");
            crd.append(rs.getString("Fname")).append(" ").append(rs.getString("Lname")).append("</h5>");
            crd.append("<p class=\"card-text\">Email:").append(" ").append(rs.getString("email")).append("</p>");
            crd.append("<p class=\"card-text\">Contact:").append(" ").append(rs.getString("phone_number")).append("</p>");
            crd.append("<p class=\"card-text\">Hospital:").append(" ").append(rs.getString("hospital")).append("</p>");
            crd.append("<p class=\"card-text\">Location:").append(" ").append(rs.getString("city")).append(", ").append(rs.getString("district")).append("</p>");
            crd.append("<a href='/app/booking?q=add_doctor_d&id=").append(rs.getString("medic_id")).append("&fname=").append(rs.getString("Fname")).append("&lname=").append(rs.getString("Lname")).append("&sid=").append("03").append("&price=").append("1500.00").append("&name=").append("Channeling").append("' class=\"btn btn-primary col-6 m-1\">Hire Me</a>");
            crd.append("<a href='").append(rs.getInt("medic_id")).append("' class=\"btn btn-secondary col-5 m-1\">Call</a>");
            crd.append("</div></div>");
        }
        return crd.toString();
    }
   //View Vaccine
    public static String MedicineCard(ResultSet rs) throws SQLException{
        
        StringBuilder crd = new StringBuilder();
        while(rs.next()){
            crd.append("<div class=\"card mb-3 col-3 py-4\" style=\"max-width: 540px;\">");
            crd.append("<div class=\"row\"><div class=\"col-12 text-center\"><i class=\"fas fa-vial fa-3x\"></i>");
            crd.append("</div><div class=\"col-12\"><div class=\"card-body text-center\">");
            crd.append("<h5 class=\"card-title\">").append(rs.getString("service_name")).append("</h5>");
            crd.append("<h6 class=\"card-title\">from").append(" ").append(rs.getString("brand")).append("</h6>");
            crd.append("<p class=\"card-text\">").append(rs.getString("description")).append("</p>");
            crd.append("<a href='/app/booking?q=select_medicine&id=").append(rs.getInt("service_id")).append("&price=").append(rs.getDouble("price")).append("&name=").append(rs.getString("service_name")).append("' class=\"btn btn-primary\" style=\"background-color: #1A237E; border:none\">").append(rs.getDouble("price")).append("0 LKR</a>");
            crd.append("</div></div></div></div>");
        }
        return crd.toString();
    }
    
    //ViewTestCards
    public static String testCard(ResultSet rs) throws SQLException{
        StringBuilder crd = new StringBuilder();
        
        while(rs.next()){
            crd.append("<div class=\"card mb-3 col-3 py-4\" style=\"max-width: 540px;\">");
            crd.append("<div class=\"row\"><div class=\"col-12 text-center\"><i class=\"fas fa-vial fa-3x\"></i>");
            crd.append("</div><div class=\"col-12\"><div class=\"card-body text-center\">");
            crd.append("<h5 class=\"card-title\">").append(rs.getString("service_name")).append("</h5>");
            crd.append("<h6 class=\"card-title\">from").append(" ").append(rs.getString("brand")).append("</h6>");
            crd.append("<p class=\"card-text\">").append(rs.getString("description")).append("</p>");
            crd.append("<a href='/app/booking?q=select_test&id=").append(rs.getInt("service_id")).append("&price=").append(rs.getDouble("price")).append("&name=").append(rs.getString("service_name")).append("' class=\"btn btn-primary\" style=\"background-color: #1A237E; border:none\">").append(rs.getDouble("price")).append("0 LKR</a>");
            crd.append("</div></div></div></div>");
        }
        return crd.toString();
        
    }
    
    //Admin view Agent
    public static String agentCard(ResultSet rs) throws SQLException{
       StringBuilder crd = new StringBuilder();
        while(rs.next()){
            crd.append("<div class='viewAgent'>");
            
            crd.append("<div class='col'");
            crd.append("<p>Medical ID</p>");
            crd.append("<p>").append(rs.getString("medic_id")).append("</p>");
            crd.append("</div>");
            
            crd.append("<div class='col'");
            crd.append("<p>Medical Assistant</p>");
            crd.append("<p>").append(rs.getString("Fname")).append(" ").append(rs.getString("Lname")).append("</p>");
            crd.append("</div>");
            
            crd.append("<div class='col'");
            crd.append("<p>DOB</p>");
            crd.append("<p>").append(rs.getString("DOB")).append("</p>");
            crd.append("</div>");
            
            crd.append("<div class='col'");
            crd.append("<p>Email</p>");
            crd.append("<p>").append(rs.getString("email")).append("</p>");
            crd.append("</div>");
            
            crd.append("<div class='col'");
            crd.append("<p>NIC</p>");
            crd.append("<p>").append(rs.getString("NIC")).append("</p>");
            crd.append("</div>");
            
            crd.append("<div class='col'");
            crd.append("<p>Gender</p>");
            crd.append("<p>").append(crd.append("gender")).append("</p>");
            crd.append("</div>");
            
            crd.append("<div class='col'");
            crd.append("<p>Contact number</p>");
            crd.append("<p>").append(crd.append("phone_number")).append("</p>");
            crd.append("</div>");
            
            crd.append("<div class='col'");
            crd.append("<p>Hospital</p>");
            crd.append("<p>").append(crd.append(rs.getString("hosptal"))).append("</p>");
            crd.append("</div>");
            
            crd.append("<div class='col'");
            crd.append("<p>Address</p>");
            crd.append("<p>")
                    .append(crd.append("AdLine1"))
                    .append("").append(crd.append("AdLine2"))
                    .append(rs.getString("city"))
                    .append(rs.getString("postalCode"))
                    .append("</p>");
            crd.append("</div>");
            
            crd.append("<div class='col'");
            crd.append("<p>City</p>");
            crd.append("<p>").append(crd.append(rs.getString("city"))).append("</p>");
            crd.append("</div>");
            
//            
            crd.append("</div>");
        }
        return crd.toString();
    }
}
