/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.Admin;
import Classes.User;
import Logical_layer.UserLogic;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author hassan ali
 */
@WebServlet(name = "EditProfileServlet", urlPatterns = {"/EditProfileServlet"})
@MultipartConfig
public class EditProfileServlet extends HttpServlet {

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
         UserLogic userlogic=new UserLogic();
          User user=(User) request.getSession().getAttribute("TheUser");
          String fname=request.getParameter("First Name");
          String lname=request.getParameter("Last Name");
          String address=request.getParameter("Address");
          String phonenumber=request.getParameter("phoneNumber");
          Part photo=request.getPart("photo");
          int phonenum=0;
          if(!phonenumber.equals("")){
              phonenum=Integer.parseInt(phonenumber);
          }
            if(!fname.equals("")){
                userlogic.editfname(user.getuserName(), fname);
                user.setfName(fname);
            }
            if(!lname.equals("")){
                userlogic.editlname(user.getuserName(), lname);
                user.setlName(lname);
            }
            if(!address.equals("")){
                userlogic.editaddress(user.getuserName(), address);
                user.setAddress(address);
            }
            if(!phonenumber.equals("")){
                userlogic.editphonenumber(user.getuserName(), phonenum);
                user.setphoneNumber(phonenum);
            }
            if(photo!=null){
                userlogic.editpicture(user.getuserName(), photo.getInputStream());
                user.setPhoto(photo.getInputStream());
                        
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
        processRequest(request, response);
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
