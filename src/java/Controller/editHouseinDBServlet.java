/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.House;
import Classes.User;
import Logical_layer.HouseLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lenovo
 */
@WebServlet(name = "editHouseinDBServlet", urlPatterns = {"/editHouseinDBServlet"})
public class editHouseinDBServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    public void editHouse (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        House house = new House();
        HouseLogic houselogic = new HouseLogic();
        house.setAdName(request.getParameter("adname"));
        String adtype = request.getParameter("adType");
        house.setAdType(adtype);
        house.setSize(Integer.parseInt(request.getParameter("size")));
        house.setFloor(Integer.parseInt(request.getParameter("floor")));
        house.setDescription(request.getParameter("description"));
        house.setStatus(request.getParameter("Status"));
        house.setPrice(Double.parseDouble(request.getParameter("Price")));
        house.setType(request.getParameter("housetype"));
        house.setLocation(request.getParameter("Location"));
        
        
        houselogic.editProp(house);
        ArrayList<House> houses = (ArrayList<House>)request.getServletContext().getAttribute("AllHouses");
        int hID = houselogic.getHouseID(house);
        int indx = 0;
        for(int i=0; i<houses.size(); i++)
        {
            if(houses.get(i).getHouseID() == hID)
            {
                indx = i;
                break;
            }
        }
        houses.set(indx, house);
        request.getSession().setAttribute("houseID", hID);
        String photo_descission = request.getParameter("addPhoto");    
        if(photo_descission.equals("Yes"))
            response.sendRedirect("AddPhoto.jsp");
        else
            response.sendRedirect("UserAdsServlet");
        
        
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            editHouse(request, response);
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
            Logger.getLogger(editHouseinDBServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(editHouseinDBServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(editHouseinDBServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(editHouseinDBServlet.class.getName()).log(Level.SEVERE, null, ex);
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
