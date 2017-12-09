/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.Comment;
import Classes.House;
import Classes.User;
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
    ///link / read to be handled ..and viewing al comment content
    public void commentNotification(int houseID,Comment comment) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/house_buy_rent";
        String username = "root";
        String password = "12345678a";
        ResultSet RS = null;
        User user= comment.getUser();
        String commentOwner=user.getuserName();
        String content=commentOwner+" added a comment on your advertisment";
        int advOwnerID=-1;
        Connection Con =  DriverManager.getConnection(url, username, password);
        String selsectTableSQL = "SELECT hUserID FROM house WHERE houseID="+"(?)";
        PreparedStatement preparedStatement = Con.prepareStatement(selsectTableSQL);
        preparedStatement.setInt(1, houseID);
        RS=preparedStatement.executeQuery();
        while(RS.next()){
            advOwnerID=RS.getInt("hUserID");
            
        }
        String insertTableSQL = "INSERT INTO notification "+ "(nUserID, content) VALUES" + "(?,?)";
        preparedStatement = Con.prepareStatement(insertTableSQL);
        preparedStatement.setInt(1, advOwnerID);
        preparedStatement.setString(2, content);
        preparedStatement .executeUpdate();

        
        
    }
    public void alertNotification(House house) throws ClassNotFoundException, SQLException{
        int size=house.getSize();
        String type=house.getType();
        String status= house.getStatus();
        int interestID = 0;
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/house_buy_rent";
        String user = "root";
        String password = "12345678a";
        ResultSet RS = null;
        Connection Con =(Connection) DriverManager.getConnection(url, user, password);
        String selsectTableSQL = "SELECT interestID FROM interest WHERE type="+"(?)"+"and size="+"(?)"+"and status="+"(?)";
        PreparedStatement preparedStatement = Con.prepareStatement(selsectTableSQL);
        preparedStatement.setString(1, type);
        preparedStatement.setInt(2, size);
        preparedStatement.setString(3, status);
        RS=preparedStatement.executeQuery();
        while (RS.next()){
            interestID=RS.getInt("interestID");
        }
        selsectTableSQL = "SELECT userID FROM userinterest WHERE interestID="+"(?)";
        preparedStatement = Con.prepareStatement(selsectTableSQL);
        preparedStatement.setInt(1, interestID);
        RS=preparedStatement.executeQuery();
        while(RS.next()){
            int userID=RS.getInt("userID");
            String content="there's new house that match your preferences in the website right now";
            String insertTableSQL = "INSERT INTO notification "+ "(nUserID, content) VALUES" + "(?,?)";
            preparedStatement = Con.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1, userID);
            preparedStatement.setString(2, content);
            preparedStatement .executeUpdate();
            
        }

        
    }
}
