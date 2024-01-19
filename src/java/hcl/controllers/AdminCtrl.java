/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl.controllers;

import hcl.business.Admin;
import hcl.business.Agent;
import hcl.business.Booking;
import hcl.business.Service;
import hcl.data.AdminDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vinu
 */
public class AdminCtrl extends HttpServlet {
    
    // <editor-fold defaultstate="expanded" desc="HttpServlet controllers. Click on the + sign on the left to edit the code.">
    
    // tests view
    private void getTestsList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        Service test = new Service();
        
        int res = 0;
        
        PrintWriter out = response.getWriter();
        
        switch (res) {
            case 1:
                out.println("Not worked " + Integer.toString(res));
                break;
            case 0:
                out.println("Testings: " + test.getServiceName());
                break;
            default:
                out.println("bleh");
                break;
        } 
    }
    
    // vaccines view
    private void getVaccinesList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Service vaccine = new Service();
        
        int res = 0;
        
        PrintWriter out = response.getWriter();
        
        switch (res) {
            case 1:
                out.println("Not worked " + Integer.toString(res));
                break;
            case 0:
                out.println("Testings: " + vaccine.getServiceName());
                break;
            default:
                out.println("bleh");
                break;
        }
    }
    
    // agents view
    private void getAgentsList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        Agent agent = new Agent();
        
        int res = 0;
        
        PrintWriter out = response.getWriter();
        
        switch (res) {
            case 1:
                out.println("Not worked " + Integer.toString(res));
                break;
            case 0:
                out.println("Testings: " + agent.getFname() + " " + agent.getLname());
                break;
            default:
                out.println("bleh");
                break;
        }
    }
    
    // bookings view
    private void getBookings(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
//        Booking booking = new Booking();
//        
//        int res = AdminDB;
//        
//        PrintWriter out = response.getWriter();
//        
//        switch (res) {
//            case 1:
//                out.println("Not worked " + Integer.toString(res));
//                break;
//            case 0:
//                out.println("Testings: " + agent.getFname() + " " + agent.getLname());
//                break;
//            default:
//                out.println("bleh");
//                break;
//        }
    }
    
     
    private void getAgentRegister(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        String role = request.getParameter("role");
        
        // customer registration
        if (role.equals("agent")) {
            getServletContext().getRequestDispatcher("/doctorRegister.jsp").forward(request, response);
        }
    }
    
    private void getAddService(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        HttpSession session = request.getSession(false);
        
        if(session.getAttribute("role") != null ) {
            String role = (String) session.getAttribute("role");
        
            // customer registration
            if (role.equals("admin")) {
                getServletContext().getRequestDispatcher("/aAddService.jsp").forward(request, response);
            }
            else {
                response.sendRedirect("/app");
            }
        } else {
            response.sendRedirect("/app");
        }
        
        
    }
    
    private void addService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String type = request.getParameter("type");
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        String desc = request.getParameter("desc");
        Double price = Double.parseDouble(request.getParameter("price"));
        
        
        
        
        Service service = new Service(name, brand, type, desc, price);
        int flag = AdminDB.insertService(service);
        
        if (flag != 1) {
            request.setAttribute("msg", "Something went wrong");
            getServletContext().getRequestDispatcher("/aAddService.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/adminDashboard.jsp").forward(request, response);
        }
            
        
        
    }
    
    private void addAgent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        
       String medicid = request.getParameter("medicid");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String DOB = request.getParameter("DOB");
        String email = request.getParameter("email");
        String NIC = request.getParameter("NIC");
        String hospital = request.getParameter("hospital");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String addline1 = request.getParameter("add1");
        String addline2 = request.getParameter("add2");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        int postal = Integer.parseInt(request.getParameter("postal"));

        Agent agent = new Agent(fname, lname, DOB, email, NIC, hospital, gender, password, phone, addline1, addline2, city, district, postal);
        int flag = AdminDB.insertAgent(agent);

        if (flag != 1) {
            request.setAttribute("msg", "Something went wrong");
            getServletContext().getRequestDispatcher("/doctorRegister.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/adminDashboard.jsp").forward(request, response);
        }

        
        
    }
    
    // </editor-fold>

    
    // <editor-fold defaultstate="expanded" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String act = request.getParameter("q");
        
        switch(act) {
            
            case "bookings":
                getBookings(request, response);
                break;
                
            case "addService":
                getAddService(request, response);
                break;
                
            case "regagent":
                getAgentRegister(request, response);
                break;
                
            case "tests":
                getTestsList(request, response);
                break;
                
            case "vaccine":
                getVaccinesList(request, response);
                break;
                
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String act = request.getParameter("q");
        
        switch(act) {
            
            case "addService":
                addService(request, response);
                break;
            
            case "addAgent":
                {
                    try {
                        addAgent(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminCtrl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
