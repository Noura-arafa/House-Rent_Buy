/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.House;
import Classes.Image;
import Logical_layer.HouseLogic;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lenovo
 */
public class viewPhotoServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
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
            
            HouseLogic houseLogic = new HouseLogic();
            ArrayList<House> aHouses = houseLogic.selectAllHouses();
            String adName = request.getParameter("adName");
            System.out.println("adNameee " + adName);
            int j = Integer.parseInt(request.getParameter("indx"));
            House house = new House();
            System.out.println("iiii " + j);
            for (int i = 0; i < aHouses.size(); i++) {
                if (aHouses.get(i).getAdName().equals(adName)) {
                    house = aHouses.get(i);
                    break;
                }
                
            }
            ArrayList<Image> images = house.getImages();
            if(images.size() !=0)
            {
            System.out.println("user image " + house.getImages().size());
            System.out.println("imagees " + images.size());
            OutputStream os = response.getOutputStream();
            Blob blob = images.get(j).getimageBlob();
            
            try {
                byte byteArray[] = blob.getBytes(1, (int) blob.length());
                response.setContentType("image/gif");
                os.write(byteArray);
               
                os.flush();
                os.close();
            } catch (SQLException ex) {
                Logger.getLogger(viewPhotoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(viewPhotoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(viewPhotoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
