/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.User;
import Logical_layer.UserLogic;
import java.io.IOException;
import java.io.InputStream;
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
 * @author lenovo
 */
@WebServlet(name = "profileServlet", urlPatterns = {"/profileServlet"})
@MultipartConfig(maxFileSize = 16177215) 
public class profileServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void createprofile(HttpServletRequest request, HttpServletResponse response,UserLogic userlogic,User user) throws IOException, ServletException{
        String fname = request.getParameter("First Name");
        String lname = request.getParameter("Last Name");
        String address = request.getParameter("Address");
        String phonenumber=request.getParameter("phoneNumber");
        int phonenum=0;
        if(phonenumber.length()!=0)
         phonenum=Integer.parseInt(phonenumber);
        Part photo=request.getPart("photo");
        user.setAddress(address);
        user.setPhoto(photo.getInputStream());
        user.setfName(fname);
        user.setlName(lname);
        user.setphoneNumber(phonenum);
        userlogic.Createprofile(user);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             UserLogic userlogic=new UserLogic();
             HttpSession session=request.getSession();
             User theuser=(User) session.getAttribute("TheUser");
             createprofile(request,response,userlogic,theuser);
             response.sendRedirect("HomePage.jsp");
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
