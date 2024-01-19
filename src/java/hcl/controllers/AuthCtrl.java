/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl.controllers;

import hcl.business.Admin;
import hcl.business.Agent;
import hcl.business.Customer;
import hcl.data.AuthDB;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
  @author vinu
 */
public class AuthCtrl extends HttpServlet {

    // <editor-fold defaultstate="expanded" desc="HttpServlet controllers. Click on the + sign on the left to edit the code.">
    
    // get register page
    private void getRegister(HttpServletRequest request, HttpServletResponse response, String role) throws IOException, ServletException {
        
        // customer registration
        if (role.equals("cus")) {
            getServletContext().getRequestDispatcher("/patientsRegister.jsp").forward(request, response);
        }
    }

    // get login page
    private void getLogin(HttpServletRequest request, HttpServletResponse response, String role) throws IOException, ServletException {
        
        // cus login
        if (role.equals("cus")) {
            getServletContext().getRequestDispatcher("/patientsLogin.jsp").forward(request, response);
        } 
        // agent login
        else if (role.equals("agent")) {
            getServletContext().getRequestDispatcher("/doctorLogin.jsp").forward(request, response);
        } 
        // admin login
        else if (role.equals("admin")) {
            getServletContext().getRequestDispatcher("/adminLogin.jsp").forward(request, response);
        }
    }

    // Signup controller for Agent
    private void signUp(HttpServletRequest request, HttpServletResponse response) throws IOException, NamingException, ServletException {

        String role = request.getParameter("role");

        //customer register
        if (role.equals("cus")) {

            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String DOB = request.getParameter("DOB");
            String email = request.getParameter("email");
            String NIC = request.getParameter("NIC");
            String gender = request.getParameter("gender");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            String addline1 = request.getParameter("add1");
            String addline2 = request.getParameter("add2");
            String city = request.getParameter("city");
            String district = request.getParameter("district");
            int postal = Integer.parseInt(request.getParameter("postal"));

            Customer cus = new Customer(fname, lname, DOB, email, NIC, gender, password, phone, addline1, addline2, city, district, postal);
            int flag = AuthDB.insertUser(cus);

            if (flag != 1) {
                request.setAttribute("msg", "Something went wrong");
                getServletContext().getRequestDispatcher("/patientsRegister.jsp").forward(request, response);
            }

            response.sendRedirect("/app/auth?q=login&role=cus");
            
        }
    }

    // Signin controller
    private void signIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String role = request.getParameter("role");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        // customer login
        if (role.equals("cus")) {

            Customer cus = new Customer();
            int flag = AuthDB.signUser(email, pass, cus);

            if (flag != 1) {
                request.setAttribute("msg", "Invalid credentials");
                getServletContext().getRequestDispatcher("/patientsLogin.jsp").forward(request, response);
            }

            // Create a new session
            HttpSession session = request.getSession();
            // setting customer object as a session
            session.setAttribute("user", cus);
            // setting role as a session
            session.setAttribute("role", "cus");
            // setting user id as a session
            session.setAttribute("id", cus.getCusid());
            // setting session expire time to 1hr
            session.setMaxInactiveInterval(60 * 60);
            
            request.setAttribute("msg", "Logged in");

            getServletContext().getRequestDispatcher("/patientsDashboard.jsp").forward(request, response);

        } 
        // agent login
        else if (role.equals("agent")) {

            Agent agent = new Agent();
            int flag = AuthDB.signAgent(email, pass, agent);

            if (flag != 1) {
                request.setAttribute("msg", "Invalid credentials");
                getServletContext().getRequestDispatcher("/doctorLogin.jsp").forward(request, response);
            } else {
                // Create a new session
            HttpSession session = request.getSession();
            // setting customer object as a session
            session.setAttribute("user", agent);
            // setting role as a session
            session.setAttribute("role", "agent");
            // setting user id as a session
            session.setAttribute("id", agent.getMedicid());
            // setting session expire time to 1hr
            session.setMaxInactiveInterval(60 * 60);

            getServletContext().getRequestDispatcher("/doctorDashboard.jsp").forward(request, response);
            }

            

        } 
        // admin login
        else if (role.equals("admin")) {

            Admin admin = new Admin();
            int flag = AuthDB.signAdmin(email, pass, admin);

            if (flag != 1) {
                request.setAttribute("msg", "Invalid credentials");
                getServletContext().getRequestDispatcher("/adminLogin.jsp").forward(request, response);
            } else {
                // Create a new session
            HttpSession session = request.getSession();
            // setting customer object as a session
            session.setAttribute("User", admin);
            // setting role as a session
            session.setAttribute("role", "admin");
            // setting user id as a session
            session.setAttribute("id", admin.getAdminId());
            // setting session expire time to 1hr
            session.setMaxInactiveInterval(60 * 60);

            getServletContext().getRequestDispatcher("/adminDashboard.jsp").forward(request, response);
            }

            

        }
    }

    // Signout controller
    private void signOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);

        String role = request.getParameter("role");

        if (session != null) {
            session.invalidate();
        }

        if (role.equals("cus")) {
            response.sendRedirect("/app/auth?q=login&role=cus");
        } else if (role.equals("agent")) {
            response.sendRedirect("/app/auth?q=login&role=agent");
        } else if (role.equals("admin")) {
            response.sendRedirect("/app/auth?q=login&role=admin");
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
        String role = request.getParameter("role");

        // registration
        if (act.equals("join")) {
            getRegister(request, response, role);
        } // signin 
        else if (act.equals("login")) {
            getLogin(request, response, role);
        } // singout
        else if (act.equals("leave")) {
            signOut(request, response);
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
        String role = request.getParameter("role");

        // Register
        if (act.equals("join")) {
            try {
                signUp(request, response);
            } catch (NamingException ex) {
                Logger.getLogger(AuthCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } // login
        else if (act.equals("login")) {
            signIn(request, response);
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
