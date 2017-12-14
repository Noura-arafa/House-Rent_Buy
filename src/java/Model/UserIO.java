/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.Contactinformation;
import Classes.User;
import java.io.InputStream;
import java.sql.*;
import java.sql.DriverManager;

/**
 *
 * @author lenovo
 */
public class UserIO {

    String url = "jdbc:mysql://localhost:3306/house_buy_rent";
    String sqluser = "root";
    String pass = "n33333";
    


 


    public int getUserID(String userName) throws ClassNotFoundException, SQLException
    {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, sqluser, pass);
        PreparedStatement pstmt = conn.prepareStatement("Select userId FROM user WHERE userName = ?");
        pstmt.setString(1, userName);
        ResultSet rs = pstmt.executeQuery();
        int id = -1;
        if (rs.first()) {
            id = rs.getInt(1);
        }

        rs.close();
        pstmt.close();
        conn.close();
        return id;

    }

    public boolean checkusers(User user) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/house_buy_rent";
        String theuser = "root";
        String password = "12345678a";
        String Line;
        Connection Con = null;
        Statement Stmt = null;
        ResultSet RS = null;
        Class.forName("com.mysql.jdbc.Driver");
        Con = DriverManager.getConnection(url, theuser, password);
        Stmt = Con.createStatement();
        RS = Stmt.executeQuery("SELECT * FROM user;");
        while (RS.next()) {
            
            String Uname = RS.getString("userName");
           // System.out.println("Uname " + Uname+" the user name"+user.getuserName());
            if (user.getuserName().equals(Uname)) {
                return false;
            }
        }
        RS.close();
        Con.close();
        return true;
    }

    public User getUser(String Uname, String thepassword) {
        try {
          //  System.out.println("");
            String url = "jdbc:mysql://localhost:3306/house_buy_rent";
            String theuser = "root";
            String password = "12345678a";
            String Line;
            Connection Con = null;
            Statement Stmt = null;
            ResultSet RS = null;
            if (Uname.equals("Admin")) {
                return null;
            }
            Class.forName("com.mysql.jdbc.Driver");
            Con = DriverManager.getConnection(url, theuser, password);
            Stmt = Con.createStatement();
            RS = Stmt.executeQuery("SELECT * FROM user;");
            while (RS.next()) {
                //change
                String theusername = RS.getString("userName");
                //change
                String thepass = RS.getString("pass");
                if (theusername.equals(Uname) && thepass.equals(thepassword)) {
                   User user=new User(RS.getString("fName"), RS.getString("lName"),RS.getString("pass"), RS.getInt("phoneNum"), RS.getString("email"), RS.getString("username"),RS.getString("address"), (InputStream) RS.getBlob("picture"));
                   return user;
                }
            }
            RS.close();
            Con.close();
        } catch (Exception cnfe) {
            System.err.println("Exception: " + cnfe);
            System.out.println("tryagain");
        }
        return null;
    }

    public Contactinformation getContactData(String Uname) {
        String url = "jdbc:mysql://localhost:3306/house_buy_rent";
        String theuser = "root";
        String password = "";
        String Line;
        Connection Con = null;
        Statement Stmt = null;
        ResultSet RS = null;
        Contactinformation contactinfo = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Con = DriverManager.getConnection(url, theuser, password);
            Stmt = Con.createStatement();
            RS = Stmt.executeQuery("SELECT * FROM user;");
            while (RS.next()) {
                String username = RS.getString("userName");
                if (username.equals(Uname)) {
                    String email = RS.getString("email");
                    int phonenumber = RS.getInt("phoneNum");
                    contactinfo = new Contactinformation(Uname, email, phonenumber);
                }
            }
            RS.close();
            Con.close();
        } catch (Exception cnfe) {
            System.err.println("Exception: " + cnfe);
            System.out.println("tryagain");
        }
        return contactinfo;
    }

    public void insertUser(User user) throws SQLException, ClassNotFoundException {
        System.out.println("in insert user");
        String url = "jdbc:mysql://localhost:3306/house_buy_rent";
        String theuser = "root";
        String password = "12345678a";
        String Line;
        Connection Con = null;
        Statement Stmt = null;
        ResultSet RS = null;
        Class.forName("com.mysql.jdbc.Driver");
        Con = DriverManager.getConnection(url, theuser, password);
        Stmt = Con.createStatement();
       // System.out.println("the user"+user.getpass());
       //change
        String query = "INSERT INTO user (fName,LName,pass,phoneNum,email,userName,picture,address)"
                + "VALUES(?,?,?,?,?,?,?,?);";
        PreparedStatement preparedStmt = Con.prepareStatement(query);
        preparedStmt.setString(1, user.getfName());
        preparedStmt.setString(2, user.getlName());
        preparedStmt.setString(3, user.getpass());
        preparedStmt.setInt(4, user.getphoneNumber());
        preparedStmt.setString(5, user.getemail());
        preparedStmt.setString(6, user.getuserName());
        preparedStmt.setBlob(7, user.getPhoto());
        preparedStmt.setString(8, user.getAddress());
        preparedStmt.executeUpdate();
        //RS.close();
        //preparedStmt.close();
        //Con.close();
    }

    public void updateuser(User user) {
        String url = "jdbc:mysql://localhost:3306/house_buy_rent";
        String theuser = "root";
        String password = "12345678a";
        String Line;
        Connection Con = null;
        Statement Stmt = null;
        ResultSet RS = null;
        //System.out.println("user "+user.getfName());
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Con = DriverManager.getConnection(url, theuser, password);
            Stmt = Con.createStatement();
            //change
            String query = "UPDATE user set fName=?,lName=?,pass=?,phoneNum=?,email=?,userName=?,address = ?,picture=? WHERE userName = ?";
            PreparedStatement preparedStmt = Con.prepareStatement(query);
           preparedStmt.setString(1, user.getfName());
            preparedStmt.setString(2, user.getlName());
            preparedStmt.setString(3, user.getpass());
            preparedStmt.setInt(4, user.getphoneNumber());
            preparedStmt.setString(5, user.getemail());
            preparedStmt.setString(6, user.getuserName());
            preparedStmt.setString(7, user.getAddress());
            preparedStmt.setBlob(8, user.getPhoto());
            preparedStmt.setString(9, user.getuserName());
            preparedStmt.executeUpdate();
           // RS.close();
            preparedStmt.close();
            Con.close();

        } catch (Exception cnfe) {
            System.err.println("Exception: " + cnfe);
            System.out.println("tryagain");
        }
    }
    public void updatefname(String Uname,String changedfirstname){
        String url = "jdbc:mysql://localhost:3306/house_buy_rent";
        String theuser = "root";
        String password = "";
        String Line;
        Connection Con = null;
        Statement Stmt = null;
        ResultSet RS = null;
        //System.out.println("user "+user.getfName());
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Con = DriverManager.getConnection(url, theuser, password);
            Stmt = Con.createStatement();
            //change
            String query = "UPDATE user set fName=? WHERE userName = ?";
            PreparedStatement preparedStmt = Con.prepareStatement(query);
           preparedStmt.setString(1, changedfirstname);
            preparedStmt.setString(2, Uname);
              preparedStmt.close();
            Con.close();
        }
        catch (Exception cnfe) {
            System.err.println("Exception: " + cnfe);
            System.out.println("tryagain");
        }
        
    }
    public void updatelname(String Uname,String changedlastname){
                String url = "jdbc:mysql://localhost:3306/house_buy_rent";
        String theuser = "root";
        String password = "";
        String Line;
        Connection Con = null;
        Statement Stmt = null;
        ResultSet RS = null;
        //System.out.println("user "+user.getfName());
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Con = DriverManager.getConnection(url, theuser, password);
            Stmt = Con.createStatement();
            //change
            String query = "UPDATE user set lName=? WHERE userName = ?";
            PreparedStatement preparedStmt = Con.prepareStatement(query);
           preparedStmt.setString(1, changedlastname);
            preparedStmt.setString(2, Uname);
              preparedStmt.close();
            Con.close();
        }
        catch (Exception cnfe) {
            System.err.println("Exception: " + cnfe);
            System.out.println("tryagain");
        }
    }
    public void updateaddress(String Uname,String changedaddress){
                String url = "jdbc:mysql://localhost:3306/house_buy_rent";
        String theuser = "root";
        String password = "";
        String Line;
        Connection Con = null;
        Statement Stmt = null;
        ResultSet RS = null;
        //System.out.println("user "+user.getfName());
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Con = DriverManager.getConnection(url, theuser, password);
            Stmt = Con.createStatement();
            //change
            String query = "UPDATE user set address=? WHERE userName = ?";
            PreparedStatement preparedStmt = Con.prepareStatement(query);
           preparedStmt.setString(1, changedaddress);
            preparedStmt.setString(2, Uname);
              preparedStmt.close();
            Con.close();
        }
        catch (Exception cnfe) {
            System.err.println("Exception: " + cnfe);
            System.out.println("tryagain");
        }
    }
    public void updateemail(String Uname,String changedemail){
                  String url = "jdbc:mysql://localhost:3306/house_buy_rent";
        String theuser = "root";
        String password = "";
        String Line;
        Connection Con = null;
        Statement Stmt = null;
        ResultSet RS = null;
        //System.out.println("user "+user.getfName());
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Con = DriverManager.getConnection(url, theuser, password);
            Stmt = Con.createStatement();
            //change
            String query = "UPDATE user set email=? WHERE userName = ?";
            PreparedStatement preparedStmt = Con.prepareStatement(query);
           preparedStmt.setString(1, changedemail);
            preparedStmt.setString(2, Uname);
              preparedStmt.close();
            Con.close();
        }
        catch (Exception cnfe) {
            System.err.println("Exception: " + cnfe);
            System.out.println("tryagain");
        }
    }
    public void updatepassword(String changedpassword, String changeduser) {
        String url = "jdbc:mysql://localhost:3306/house_buy_rent";
        String theuser = "root";
        String password = "";
        String Line;
        Connection Con = null;
        Statement Stmt = null;
        ResultSet RS = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Con = DriverManager.getConnection(url, theuser, password);
            Stmt = Con.createStatement();
            String query = "UPDATE User set pass=? WHERE userName = ?";
            PreparedStatement preparedStmt = Con.prepareStatement(query);
            preparedStmt.setString(1, changedpassword);
            preparedStmt.setString(2, changeduser);
            preparedStmt.executeUpdate();
            //RS.close();
            preparedStmt.close();
            Con.close();
        } catch (Exception cnfe) {
            System.err.println("Exception: " + cnfe);
            System.out.println("tryagain");
        }
    }
    
    
    public User selectUser (int userID) throws ClassNotFoundException, SQLException{
         String url = "jdbc:mysql://localhost:3306/house_buy_rent";
        String theuser = "root";
        String password = "";
        Connection Con = null;
        Statement Stmt = null;
        ResultSet RS = null;
        Class.forName("com.mysql.jdbc.Driver");
        Con = DriverManager.getConnection(url, theuser, password);
        Stmt = Con.createStatement();
         PreparedStatement statement = Con.prepareStatement("select * FROM user WHERE  userID = ?");
        statement.setInt(1, userID);
        RS = statement.executeQuery();
        User user = null;
        while(RS.next()){
            user =new User(RS.getString("fName"),RS.getString("lName"),RS.getString("pass"),RS.getInt("phoneNum"),RS.getString("email"),RS.getString("userName"),RS.getString("address"), (InputStream) RS.getObject("picture"));
        }
        return user;
    }

}
