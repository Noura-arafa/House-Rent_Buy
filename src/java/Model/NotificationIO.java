/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class NotificationIO {
    public void inrertCommentNotification(int userID,String commentOwner ) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/house_buy_rent";
        String username = "root";
        String password = "12345678a";
        ResultSet RS = null;
        String content=commentOwner+" added a comment on your advertisment";
        Connection Con =  DriverManager.getConnection(url, username, password);
        String insertTableSQL = "INSERT INTO notification "+ "(nUserID, content) VALUES" + "(?,?)";
        PreparedStatement preparedStatement = Con.prepareStatement(insertTableSQL);
        preparedStatement.setInt(1, userID);
        preparedStatement.setString(2, content);
        preparedStatement .executeUpdate();

        
        
    }
    public void insert(int userID) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/house_buy_rent";
        String user = "root";
        String password = "12345678a";
        Connection Con =(Connection) DriverManager.getConnection(url, user, password);
        String content="there's new house that match your preferences in the website right now";
        String insertTableSQL = "INSERT INTO notification "+ "(nUserID, content) VALUES" + "(?,?)";
        PreparedStatement preparedStatement = Con.prepareStatement(insertTableSQL);
        preparedStatement.setInt(1, userID);
        preparedStatement.setString(2, content);
        preparedStatement .executeUpdate();
            
        

        
    }
    
}
