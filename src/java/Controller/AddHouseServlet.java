/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.House;
import Classes.User;
import Logical_layer.HouseLogic;
import java.awt.BorderLayout;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lenovo
 */
@WebServlet(name = "AddHouseServlet", urlPatterns = {"/AddHouseServlet"})
@MultipartConfig(maxFileSize = 16177215) 
public class AddHouseServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void addHouse(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException
    {
        ServletContext application = request.getServletContext();
        ArrayList<House> houses = (ArrayList<House>) application.getAttribute("Houses");
        House house = new House();
        HouseLogic houselogic = new HouseLogic();
        house.setAdName(request.getParameter("adname"));
        String adtype = request.getParameter("adType");
        String adsType;
        if(adtype.equals("Rent"))
            adsType = "Rent";
        else
            adsType = "Sell";
        house.setAdType(adsType);
        house.setSize(Integer.parseInt(request.getParameter("size")));
        house.setFloor(Integer.parseInt(request.getParameter("floor")));
        house.setDescription(request.getParameter("description"));
        house.setStatus(request.getParameter("Status"));
        house.setPrice(Double.parseDouble(request.getParameter("Price")));
        house.setType(request.getParameter("housetype"));
        house.setLocation(request.getParameter("Location"));
        User user = new User("Noura", "Arafa", "noura95", 01113600147, "nouraarafa95@gmil.com", "nouraArafa","El mmm", null);
       
        houselogic.addHouse(house, user);
        houses.add(house);
        application.setAttribute("Houses", houses);
        String photo_descission = request.getParameter("addPhoto");    
        
        if(photo_descission.equals("Yes"))
            response.sendRedirect("AddPhoto.jsp");
        else
            System.out.println("Nooo");  // go to home
        
        
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            addHouse(request, response);
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
            Logger.getLogger(AddHouseServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddHouseServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddHouseServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddHouseServlet.class.getName()).log(Level.SEVERE, null, ex);
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
