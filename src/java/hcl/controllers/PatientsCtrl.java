/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcl.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hcl.business.Customer;
import hcl.data.PatientsDB;

/**
 *
 * @author vinu
 */
public class PatientsCtrl extends HttpServlet {

    // DONE
    private void getProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Customer cus = new Customer();
        cus.setCusid(id);

        int flag = PatientsDB.getCustomerById(cus);

        if (flag != 1) {
            request.setAttribute("msg", "Oops! We couldn't fulfill your request");
            getServletContext().getRequestDispatcher("/patientsDashboard.jsp").forward(request, response);
        }

        request.setAttribute("customer", cus);

        getServletContext().getRequestDispatcher("/patientsProfile.jsp").forward(request, response);

    }

    //DONE
    private void getBookings(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        String cards = PatientsDB.getBookingList(id);

        if (cards.equals("")) {
            request.setAttribute("msg", "<h5 class=\"jumbotron m-4 text-center\" style=\"line-height: 1px;\">Currently there are no bookings!</h5>");
            getServletContext().getRequestDispatcher("/patientsBookings.jsp").forward(request, response);
        }else{        
            request.setAttribute("cards", cards);        
            getServletContext().getRequestDispatcher("/patientsBookings.jsp").forward(request, response);}
        
    }

    // DONE
    private void getHistory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        String cards = PatientsDB.getHistoryList(id);

        if (cards.equals("")) {
            request.setAttribute("msg", "<h5 class=\"jumbotron m-4 text-center\" style=\"line-height: 1px;\">Currently there is no History!</h5>");
            getServletContext().getRequestDispatcher("/patientsappointmentHistory.jsp").forward(request, response);
        }

        request.setAttribute("cards", cards);
        
        getServletContext().getRequestDispatcher("/patientsappointmentHistory.jsp").forward(request, response);
    }
    
    private void getReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        String cards = PatientsDB.getReqList(id);

        if (cards.equals("")) {
            request.setAttribute("msg", "<h5 class=\"jumbotron m-4 text-center\" style=\"line-height: 1px;\">Currently there is no Requests!</h5>");
            getServletContext().getRequestDispatcher("/patientsRequests.jsp").forward(request, response);
        }

        request.setAttribute("cards", cards);
        
        getServletContext().getRequestDispatcher("/patientsRequests.jsp").forward(request, response);
    }

//    // TODO
//    private void getTests(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//    }
//
//    // TODO
//    private void geetVaccines(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//    }

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
            case "profile":
                getProfile(request, response);
                break;

            case "bookings":
                getBookings(request, response);
                break;

            case "history":
                getHistory(request, response);
                break;
                
            case "requests":
                getReq(request, response);
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
