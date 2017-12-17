/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.House;
import Classes.Interest;
import Classes.User;
import Logical_layer.HouseLogic;
import Logical_layer.UserLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lenovo
 */
public class searchServlet extends HttpServlet {

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
            ServletContext application = request.getServletContext();
            
        //HttpSession session = (HttpSession) request.getServletContext().getAttribute("thesession");
        //User user =(User) session.getAttribute("TheUser");
        User user=new User("khadega", "osman", "123", 0100, "bla", "khadegaosman", "dd", null);
        House house = new House();
        String adName = request.getParameter("adname");
        String adtype = request.getParameter("adType");
        String adsType = null;
        String size = request.getParameter("size");
        String floor = request.getParameter("floor");
        String rate = request.getParameter("rate");
        String status = request.getParameter("Status");
        String price = request.getParameter("Price");
        String houseType = request.getParameter("housetype");
        String location = request.getParameter("Location");
        String alert = request.getParameter("createAlert");
        if (adtype != null){
            if(adtype.equals("Rent"))
                adsType = "Rent";
            else if (adtype.equals("Sell"))
                adsType = "Sell";
        }
        house.setAdType(adsType);
        if (size.length() != 0) house.setSize(Integer.parseInt(size));
        else house.setSize(0);
        if (floor.length() != 0) house.setFloor(Integer.parseInt(floor));
        else house.setFloor(0);
        if (rate.length() != 0) house.setRate(Double.parseDouble(rate));
        else house.setRate(0.0);
        if (status.length() != 0) house.setStatus(status);
        else house.setStatus(null);
        if (price.length() != 0) house.setPrice(Double.parseDouble(price));
        else house.setPrice(0.0);
        if (houseType.length() != 0) house.setType(houseType);
        else house.setType(null);
        if (location.length() != 0) house.setLocation(location);
        else house.setLocation(null);
        if (adName.length() != 0) house.setAdName(adName);
        else house.setAdName(null);
        
         if (alert != null){
            if (alert.equals("yes")){
                System.out.println("yeeeeesssssss");
                Interest interest = new Interest(house.getAdType(), house.getSize(), 
                        house.getFloor(), house.getStatus(), house.getType(), 
                        house.getLocation(), house.getRate(), house.getPrice());
                UserLogic userLogic = new UserLogic();
                userLogic.createAlert(user.getuserName(), interest);
                
             }
         }
        HouseLogic houseLogic = new HouseLogic();
        ArrayList<House> houses = houseLogic.search(house);
            System.out.println("f "+houses.size());
        for(int i=0;i<houses.size();i++){
               System.out.println("housesname "+houses.get(i).getAdName());
        }
          
            
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
            Logger.getLogger(searchServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(searchServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(searchServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(searchServlet.class.getName()).log(Level.SEVERE, null, ex);
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
