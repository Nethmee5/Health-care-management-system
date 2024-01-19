/*
/ * To change this license header, choose License Headers in Project Properties.
/* To change this template file, choose Tools | Templates
/* and open the template in the editor.
*/
package hcl.controllers;

import hcl.business.Agent;
import hcl.data.DoctorDB;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vinu
 */
public class DoctorCtrl extends HttpServlet {

    // <editor-fold defaultstate="expanded" desc="HttpServlet controllers. Click on the + sign on the left to edit the code.">
    
    // get profile
    private void getAgent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        Agent agent = new Agent();
        agent.setMedicid(id);

        int flag = DoctorDB.getAgentById(agent);

        if (flag != 1) {
            request.setAttribute("msg", "Oops! We couldn't fulfill your request");
            getServletContext().getRequestDispatcher("/doctorDashboard.jsp").forward(request, response);
        } else {
            request.setAttribute("agent", agent);
            getServletContext().getRequestDispatcher("/doctorProfile.jsp").forward(request, response);
        }

      

    }

    // get current requests
    private void getRequests(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        int id = Integer.parseInt(request.getParameter("id"));

        String cards = DoctorDB.getPendingRequest(id);

        if (cards.equals("")) {
            request.setAttribute("msg", "<h5 class=\"jumbotron m-4 text-center\" style=\"line-height: 1px;\">Currently there is no Requests!</h5>");
            try {
                getServletContext().getRequestDispatcher("/appointmentRequests.jsp").forward(request, response);
            } catch (IOException ex) {
                Logger.getLogger(DoctorCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        request.setAttribute("cards", cards);
        
        try {
            getServletContext().getRequestDispatcher("/appointmentRequests.jsp").forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger(DoctorCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getBookings(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        String cards = DoctorDB.getConfirmedRequest(id);

        if (cards.equals("")) {
            request.setAttribute("msg", "<h5 class=\"jumbotron m-4 text-center\" style=\"line-height: 1px;\">Currently there are no bookings!</h5>");
            getServletContext().getRequestDispatcher("/dBookings.jsp").forward(request, response);
        } else {
            request.setAttribute("cards", cards);
            getServletContext().getRequestDispatcher("/dBookings.jsp").forward(request, response);
        }
        
    }

    private void acceptRequest(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
    }

    private void acceptDone(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
    }

    private void acceptPayment(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
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

            case "profile":
                getAgent(request, response);
                break;

            case "bookings":
                getBookings(request, response);
                break;

            case "requests":
                getRequests(request, response);
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
            case "resRequest":
                acceptRequest(request, response);
                break;

            case "resDone":
                acceptDone(request, response);
                break;

            case "resPayment":
                acceptPayment(request, response);
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
