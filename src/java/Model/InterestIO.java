/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class InterestIO {
    
    public int findInterest(int size,String status,String type) throws SQLException, ClassNotFoundException{
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
        int interestID=-1;
        if(RS!=null){
            while(RS.next()){
                interestID=RS.getInt("interestID");
            }
            
        }
        return interestID;
    }
    public  void insertInterest(String userName,int size,String status,String type) throws ClassNotFoundException, SQLException{   
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/house_buy_rent";
        String user = "root";
        String password = "12345678a";
        ResultSet RS = null;
        Connection Con =(Connection) DriverManager.getConnection(url, user, password);
        UserIO u =new UserIO();
        int userID = u.findUser(userName);
        int InterestID=findInterest(size,status,type);
        
        if(InterestID==-1){
            
            String insertTableSQL = "INSERT INTO interest "+ "(type, size,status) VALUES" + "(?,?,?)";
            PreparedStatement preparedStatement = Con.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, type);
            preparedStatement.setInt(2, size);
            preparedStatement.setString(3, status);       
            preparedStatement .executeUpdate();
            InterestID=findInterest(size,status,type);
        }
        UserInterestIO userInterest=new UserInterestIO();
        userInterest.insert(userID, InterestID);
        
        
        
        
        

    }
    
    
}
