/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.Comment;
import Classes.House;
import Classes.User;
import Logical_layer.CommentLogic;
import Logical_layer.HouseLogic;
import Logical_layer.NotificationLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lenovo
 */
@WebServlet(name = "AddCommentServlet", urlPatterns = {"/AddCommentServlet"})
public class AddCommentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     public void AddComment(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ParseException, IOException{
        System.out.println("in addd coment");
        ArrayList<House> houses = (ArrayList<House>) request.getServletContext().getAttribute("AllHouses");
        CommentLogic commentlogic =new CommentLogic();
        int houseID= (int) request.getSession().getAttribute("adID");
   
        String content=request.getParameter("comment");
        HouseLogic houselogic=new HouseLogic();
        House house =houselogic.getHouseByID(houseID);
        User user = (User) request.getSession().getAttribute("TheUser");
        String username = user.getuserName();
        commentlogic.comment(house, content, username);
        NotificationLogic notification = new NotificationLogic();
        Comment comment= new Comment(content, user);
        int indx=0;
        notification.commentNotification(houseID,comment);
        for(int i=0; i<houses.size(); i++)
        {
            if(houses.get(i).getHouseID() == houseID)
            {
                indx = i;
                break;
            }
            
        }
        houses.get(indx).setComment(comment);
        response.sendRedirect("specificHouseJSP.jsp?id="+houseID);
   
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            AddComment(request, response);
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
             Logger.getLogger(AddCommentServlet.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(AddCommentServlet.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ParseException ex) {
             Logger.getLogger(AddCommentServlet.class.getName()).log(Level.SEVERE, null, ex);
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
             Logger.getLogger(AddCommentServlet.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(AddCommentServlet.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ParseException ex) {
             Logger.getLogger(AddCommentServlet.class.getName()).log(Level.SEVERE, null, ex);
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
