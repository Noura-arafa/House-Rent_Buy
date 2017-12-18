/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.House;
import Logical_layer.HouseLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lenovo
 */
@WebServlet(name = "specificHouseServlet", urlPatterns = {"/specificHouseServlet"})
public class specificHouseServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            ServletContext application = request.getServletContext();
<<<<<<< HEAD
            HouseLogic houseLogic = new HouseLogic();
            String houseId =request.getParameter("houseID");
            int houseID = Integer.parseInt(houseId); 
            HouseLogic houseLogic = new HouseLogic();
            ArrayList<House> houses = houseLogic.selectAllHouses();
            application.setAttribute("AllHouses", houses);
            House house = houseLogic.getHouseByID(houseID);
            //application.setAttribute("house", house);
=======
            //dah el mafrod ely gylena mn el page ely feha kol el houses
           // int houseID=(int) request.getAttribute("houseID");
           
            //to be removed!!!
            String houseId =request.getParameter("houseID");
            
            int houseID = Integer.parseInt(houseId);            
            HouseLogic HouseLogic = new HouseLogic();
            
            House house = HouseLogic.getHouseByID(houseID);
         
            HouseLogic houseLogic = new HouseLogic();
            ArrayList<House> houses = houseLogic.selectAllHouses();
            application.setAttribute("AllHouses", houses);
            //String houseId =request.getParameter("houseID");
           // int houseID = 5;//Integer.parseInt(houseId);            
            application.setAttribute("house", house);
>>>>>>> 0ef281710e314aa0a72cf319485d54ab6bba8cc2
            response.sendRedirect("specificHouseJSP.jsp?id="+houseID);
   
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(specificHouseServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(specificHouseServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(specificHouseServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(specificHouseServlet.class.getName()).log(Level.SEVERE, null, ex);
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
