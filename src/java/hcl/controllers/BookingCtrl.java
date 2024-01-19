/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl.controllers;

import hcl.business.Booking;
import hcl.business.Customer;
import hcl.data.BookingDB;
import java.io.IOException;
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
public class BookingCtrl extends HttpServlet {

    // <editor-fold defaultstate="expanded" desc="HttpServlet controllers. Click on the + sign on the left to edit the code.">
    
    // DONE
    private void getTests(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String testCards = BookingDB.getTests();
        
        if (testCards.equals("")) {
            request.setAttribute("msg", "<h5 class=\"jumbotron m-4 text-center\" style=\"line-height: 1px;\">Sorry! Something went wrong. Try again later.</h5>");
            getServletContext().getRequestDispatcher("/sTests.jsp").forward(request, response);
        }

        request.setAttribute("testCards", testCards);
        getServletContext().getRequestDispatcher("/sTests.jsp").forward(request, response);
        
    }

    private void getMedicine(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String medicineCards = BookingDB.getMedicine();
        
        if (medicineCards.equals("")) {
            request.setAttribute("msg", "<h5 class=\"jumbotron m-4 text-center\" style=\"line-height: 1px;\">Sorry! Something went wrong. Try again later.</h5>");
            try {
                getServletContext().getRequestDispatcher("/sMedicines.jsp").forward(request, response);
            } catch (IOException ex) {
                Logger.getLogger(BookingCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            request.setAttribute("medicineCards", medicineCards);

            try {
                getServletContext().getRequestDispatcher("/sMedicines.jsp").forward(request, response);
            } catch (IOException ex) {
                Logger.getLogger(BookingCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }
    
    

    private void getAgents(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        
        HttpSession session = request.getSession(false);
        
        if(session  == null) System.out.println("No session found");
        
        Customer cus = new Customer();
        cus =(Customer) session.getAttribute("user");
        
        //String district = cus.getDistrict();
        
        String agentCards = BookingDB.getAgents();
        
        if (agentCards.equals("")) {
            request.setAttribute("msg", "<h5 class=\"jumbotron m-4 text-center\" style=\"line-height: 1px;\">Sorry! We couldn't find an agent from your district.</h5>");
            try {
                getServletContext().getRequestDispatcher("/sdoctors.jsp").forward(request, response);
            } catch (IOException ex) {
                Logger.getLogger(BookingCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{

        request.setAttribute("agentCards", agentCards);
        
        try {
            getServletContext().getRequestDispatcher("/sdoctors.jsp").forward(request, response);
        } catch (IOException ex) {
          Logger.getLogger(BookingCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    private void getDoctor_d(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        
        HttpSession session = request.getSession(false);
        
        if(session  == null) System.out.println("No session found");
        
        Customer cus = new Customer();
        cus =(Customer) session.getAttribute("user");
        
        //String district = cus.getDistrict();
        
        String agentCards = BookingDB.getAgents();
        
        if (agentCards.equals("")) {
            request.setAttribute("msg", "<h5 class=\"jumbotron m-4 text-center\" style=\"line-height: 1px;\">Sorry! We couldn't find an agent from your district.</h5>");
            try {
                getServletContext().getRequestDispatcher("/serviceDoctor.jsp").forward(request, response);
            } catch (IOException ex) {
                Logger.getLogger(BookingCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{

        request.setAttribute("agentCards", agentCards);
        
        try {
            getServletContext().getRequestDispatcher("/sdoctors.jsp").forward(request, response);
        } catch (IOException ex) {
          Logger.getLogger(BookingCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

    private void selectTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String testid = request.getParameter("id");
        String price = request.getParameter("price");
        String name = request.getParameter("name");
        
        HttpSession session = request.getSession(false);
        
        if(session == null) {
            System.out.println("No session found");
        }
        
        session.setAttribute("Bserviceid", testid);
        session.setAttribute("BsPrice", price);
        session.setAttribute("BsName", name);
        
        
        getServletContext().getRequestDispatcher("/ssammery.jsp").forward(request, response);
    }
    
     private void selectDoctor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String docid = request.getParameter("id");
        String name = request.getParameter("Fname");
        String sid = request.getParameter("sid");
        String price = request.getParameter("price");
        String sname = request.getParameter("name");
        
        HttpSession session = request.getSession(false);
        
        if(session == null) {
            System.out.println("No session found");
        }
        
        session.setAttribute("Bserviceid",sid);
        session.setAttribute("BsPrice", price);
        session.setAttribute("BsName", sname);
        session.setAttribute("Bmedicid", docid);
        session.setAttribute("Bmediname", name);
        
        
        getServletContext().getRequestDispatcher("/ssammery.jsp").forward(request, response);
    }


    private void selectMedicine(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        
        String vacid = request.getParameter("id");
        String price = request.getParameter("price");
        String name = request.getParameter("name");
        
        HttpSession session = request.getSession(false);
        
        if(session == null) {
            System.out.println("No session found");
        }
        
        session.setAttribute("Bserviceid", vacid);
        session.setAttribute("BsPrice", price);
        session.setAttribute("BsName", name);
        
        
        try {
            getServletContext().getRequestDispatcher("/ssammery.jsp").forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(BookingCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String contact = request.getParameter("contact");
        String address = request.getParameter("address");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        
         HttpSession session = request.getSession(false);
        
        if(session == null) {
            System.out.println("No session found");
        }
        
        session.setAttribute("BcusName", name);
        session.setAttribute("BcusContact", contact);
        session.setAttribute("BcusAddress", address);
        session.setAttribute("BcusDate", date);
        session.setAttribute("BcusTime", time);
        
        response.sendRedirect("/app/booking?q=agents");
        
    }

    private void addAgent(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        
        String medicid = request.getParameter("id");
        String mediName = request.getParameter("fname") + " " + request.getParameter("lname");
        
        HttpSession session = request.getSession(false);
        
        if(session == null) {
            System.out.println("No session found");
        }
        
        session.setAttribute("Bmedicid", medicid);
        session.setAttribute("Bmediname", mediName);
        
        try {
            response.sendRedirect("sConfirm.jsp");
        } catch (IOException ex) {
            Logger.getLogger(BookingCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void addDoctor_d(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        
        String medicid = request.getParameter("id");
        String mediName = request.getParameter("fname");
        
        HttpSession session = request.getSession(false);
        
        if(session == null) {
            System.out.println("No session found");
        }
        
        session.setAttribute("Bmedicid", medicid);
        session.setAttribute("Bmediname", mediName);
        
        try {
            response.sendRedirect("sConfirm.jsp");
        } catch (IOException ex) {
            Logger.getLogger(BookingCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Request(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cusId = Integer.parseInt(request.getParameter("cusId"));
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));
        int medicId = Integer.parseInt(request.getParameter("medicId"));
        Double price = Double.parseDouble(request.getParameter("price"));
        String time = request.getParameter("time");
        String date = request.getParameter("date");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");
        
        Booking book = new Booking(serviceId, cusId, medicId, date, time, address, contact, price);
        int flag = BookingDB.insertion(book);
        
        String msg = "Your booking has been placed successfully";
        
        if (flag != 1) {
            msg = "Sorry! We could't process your booking. Please try again after 5 minuites";
        }
            
        request.setAttribute("msg", msg);
        getServletContext().getRequestDispatcher("/appointmentDone.jsp").forward(request, response);
    }
    
    private void deleteReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("id"));
        
        int flag = BookingDB.deleteReq(bookId);
        
        HttpSession session = request.getSession(false);
        
        int cusid = (int) session.getAttribute("id");

        if (flag != 1) {
            response.sendRedirect("/app/cus?q=requests&id="+ cusid +"");
        }

        response.sendRedirect("/app/cus?q=requests&id="+ cusid +"");
    }
    
    private void rejectReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("id"));
        
        int flag = BookingDB.rejectReq(bookId);
        
        HttpSession session = request.getSession(false);
        
        int medid = (int) session.getAttribute("id");

        if (flag != 1) {
            response.sendRedirect("/app/agent?q=requests&id="+ medid +"");
        }

        response.sendRedirect("/app/agent?q=requests&id="+ medid +"");
    }
    
    private void confirmReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("id"));
        
        int flag = BookingDB.confirmReq(bookId);
        
        HttpSession session = request.getSession(false);
        
        int medid = (int) session.getAttribute("id");

        if (flag != 1) {
            response.sendRedirect("/app/agent?q=requests&id="+ medid +"");
        }

        response.sendRedirect("/app/agent?q=requests&id="+ medid +"");
    }
    
    private void confirmAttend(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("id"));
        
        int flag = BookingDB.confirmAttend(bookId);
        
        HttpSession session = request.getSession(false);
        
        int cusid = (int) session.getAttribute("id");

        if (flag != 1) {
            response.sendRedirect("/app/cus?q=bookings&id="+ cusid +"");
        }

        response.sendRedirect("/app/cus?q=bookings&id="+ cusid +"");
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

        switch (act) {

            case "tests":
                getTests(request, response);
                break;

            case "medicine":
                getMedicine(request, response);
                break;

            case "agents":
                getAgents(request, response);
                break;
                
            case "doctor_d":
                getDoctor_d(request, response);
                break;

            case "select_test":
                selectTest(request, response);
                break;

            case "select_medicine":
                selectMedicine(request, response);
                break;
            
            case "select_doc":
                selectDoctor(request, response);
                break;

            case "add_agent":
                addAgent(request, response);
                break;
                
            case "add_doctor_d":
                addDoctor_d(request, response);
                break;
                
            case "delReq":
                deleteReq(request, response);
                break;
                
            case "rejectReq":
                rejectReq(request, response);
                break;
                
            case "confirmReq":
                confirmReq(request, response);
                break;
                
            case "confirmAttend":
                confirmAttend(request, response);
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

        switch (act) {
            
            case "add_details":
                addDetails(request, response);
                break;
                
            case "add_req":
                Request(request, response);
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
