/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.Comment;
import Classes.House;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author lenovo
 */
public class CommentIO {
     String url ="jdbc:mysql://localhost:3306/house_buy_rent";
    String sqluser = "root";
    String password = "n33333";
    
    public void comment(String content,int houseID,int userID, java.sql.Timestamp date) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection Con =DriverManager.getConnection(url, sqluser, password);
        Statement Stmt = Con.createStatement();
        String insertTableSQL = "Insert into comment (comment, date, cHouseID ,cUserID) VALUES(?, ?, ?, ?)";
        PreparedStatement preparedStatement = Con.prepareStatement(insertTableSQL);
        preparedStatement.setString(1, content);
        preparedStatement.setTimestamp(2, date);
        preparedStatement.setInt(3, houseID);
        preparedStatement.setInt(4, userID);
        preparedStatement .executeUpdate();
    }
  
    
}
