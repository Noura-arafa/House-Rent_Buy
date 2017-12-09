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
public class UserInterestIO {
    public void insert(int userID,int interestID) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/house_buy_rent";
        String user = "root";
        String password = "12345678a";
        ResultSet RS=null;
        System.out.println("RRRRRRRRRRRRRRRRRRRRR  "+RS);
        Connection Con =(Connection) DriverManager.getConnection(url, user, password);
        String selsectTableSQL = "SELECT interestID FROM userinterest WHERE userID="+"(?)"+"and interestID="+"(?)";
        PreparedStatement preparedStatement = Con.prepareStatement(selsectTableSQL);
        preparedStatement.setInt(1, userID);
        preparedStatement.setInt(2, interestID);
        System.out.println("ssssssssssssssssssssssssssss  "+interestID);
        RS=preparedStatement.executeQuery();
        boolean exist=false;
        while(RS.next()){
            exist=true;  
        }
        if(exist==false){
            String insertTableSQL = "INSERT INTO userinterest "+ "(userID, interestID) VALUES" + "(?,?)";
            preparedStatement = Con.prepareStatement(insertTableSQL);
            preparedStatement.setInt(1, userID);
            preparedStatement.setInt(2, interestID);
            preparedStatement .executeUpdate();
        }
        
      }
        
    }
    

