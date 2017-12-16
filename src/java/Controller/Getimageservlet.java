/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.User;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hassan ali
 */
@WebServlet(name = "Getimageservlet", urlPatterns = {"/Getimageservlet"})
public class Getimageservlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Getimageservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Getimageservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
         String url = "jdbc:mysql://localhost:3306/house_buy_rent";
        String theuser = "root";
        String password = "";
        String Line;
        Connection Con = null;
        Statement Stmt = null;
        ResultSet RS = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Getimageservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Con = DriverManager.getConnection(url, theuser, password);
        } catch (SQLException ex) {
            Logger.getLogger(Getimageservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Stmt = Con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Getimageservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        HttpSession thesession=(HttpSession) request.getServletContext().getAttribute("thesession"); 
        User Theuser=(User) thesession.getAttribute("TheUser");
        PreparedStatement statement = null;
        try {
            statement = Con.prepareStatement("select picture FROM user WHERE userName=?");
        } catch (SQLException ex) {
            Logger.getLogger(Getimageservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //System.out.println("theuser "+ Theuser.getuserName());
            statement.setString(1, Theuser.getuserName());
        } catch (SQLException ex) {
            Logger.getLogger(Getimageservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            RS = statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Getimageservlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if(RS.next()){
                System.out.println("the user picture ");
                Blob blob = RS.getBlob("picture");
                byte byteArray[] = blob.getBytes(1, (int)blob.length());
                response.setContentType("image/gif");
                OutputStream os = response.getOutputStream();
                os.write(byteArray);
                os.flush();
                os.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Getimageservlet.class.getName()).log(Level.SEVERE, null, ex);
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
