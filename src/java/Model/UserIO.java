/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.Interest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class UserIO {
    public int findUser(String userName) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/house_buy_rent";
        String user = "root";
        String password = "12345678a";
        ResultSet RS = null;
        Connection Con =(Connection) DriverManager.getConnection(url, user, password);
        String selsectTableSQL = "SELECT userID FROM user WHERE username="+"(?)";
        PreparedStatement preparedStatement = Con.prepareStatement(selsectTableSQL);
        preparedStatement.setString(1, userName);
        RS=preparedStatement.executeQuery();
        int userID=-1;
        if(RS!=null){
            while(RS.next()){
                userID=RS.getInt("userID");
            }
        }
        
        return userID;
    }
    
   
}
