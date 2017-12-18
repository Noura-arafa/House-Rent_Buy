/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.Notification;
import Classes.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class NotificationIO {
    String url = "jdbc:mysql://localhost:3306/house_buy_rent";
        String username = "root";
        String password = "12345678a";
    public ArrayList<Notification> selectNewNotification(int userID) throws ClassNotFoundException, SQLException{
        ArrayList <Notification> notifications = new ArrayList();
        Class.forName("com.mysql.jdbc.Driver");
        
        ResultSet RS=null;
        Connection Con =  DriverManager.getConnection(url, username, password);
        String selsectTableSQL = "SELECT * FROM notification WHERE nUserID="+"(?) and notification.read = "+"(?)";
        PreparedStatement preparedStatement = Con.prepareStatement(selsectTableSQL);
        preparedStatement.setInt(1, userID);
        preparedStatement.setInt(2, 0);
        RS=preparedStatement.executeQuery();
        while(RS.next()){
            Notification notification = new Notification(RS.getInt("notification.read"), RS.getString("content"), RS.getInt("link"));
            notifications.add(notification);
            
        }
        return notifications;

        
    }
    
    public ArrayList<Notification> selectOldNotification(int userID) throws ClassNotFoundException, SQLException{
        ArrayList <Notification> notifications = new ArrayList();
        Class.forName("com.mysql.jdbc.Driver");
        ResultSet RS=null;
        Connection Con =  DriverManager.getConnection(url, username, password);
        String selsectTableSQL = "SELECT * FROM notification WHERE nUserID="+"(?) and notification.read = "+"(?)";
        PreparedStatement preparedStatement = Con.prepareStatement(selsectTableSQL);
        preparedStatement.setInt(1, userID);
        preparedStatement.setInt(2, 1);
        RS=preparedStatement.executeQuery();
        while(RS.next()){
            Notification notification = new Notification(RS.getInt("notification.read"), RS.getString("content"), RS.getInt("link"));
            notifications.add(notification);
            
        }
        return notifications;

        
    }
    
    public void inrertCommentNotification(int userID,String commentOwner ,int houseID) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        String content=commentOwner+" added a comment on your advertisment";
        Connection Con =  DriverManager.getConnection(url, username, password);
        String insertTableSQL = "INSERT INTO notification (nUserID, notification.read, content,link) VALUES" + "(?,?,?,?)";
        PreparedStatement preparedStatement = Con.prepareStatement(insertTableSQL);
        preparedStatement.setInt(1, userID);
        preparedStatement.setInt(2, 0);
        preparedStatement.setString(3, content);
        preparedStatement.setInt(4, houseID);
        preparedStatement .executeUpdate();

        
        
    }
    public void interestNotification(int userID,int houseID) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection Con =(Connection) DriverManager.getConnection(url, username, password);
        HouseIO houseIO =new HouseIO();
        int hUserID= houseIO.getUser(houseID);
        UserIO userIO = new UserIO();
        User user=userIO.selectUser(hUserID);
        String content=user.getuserName()+" added new House, Go check it:)";
        String insertTableSQL = "INSERT INTO notification "+ "(nUserID, notification.read, content,link) VALUES" + "(?,?,?,?)";
        PreparedStatement preparedStatement = Con.prepareStatement(insertTableSQL);
        preparedStatement.setInt(1, userID);
        preparedStatement.setInt(2, 0);
        preparedStatement.setString(3, content);
        preparedStatement.setInt(4, houseID);
        preparedStatement .executeUpdate();

    }
    public void UpdateNotification(int userID) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection Con =  DriverManager.getConnection(url, username, password);
        String updateTableSQL = "UPDATE  notification SET  notification.read =1 Where nUserID=?";
        PreparedStatement preparedStatement = Con.prepareStatement(updateTableSQL);
        preparedStatement.setInt(1, userID);
        preparedStatement .executeUpdate();

        
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        NotificationIO n = new NotificationIO();
        ArrayList <Notification>arr =n.selectNewNotification(5);
        for (int i =0 ;i<arr.size();i++){
            System.out.println("conteeentt    "+arr.get(i).getContent());
        }
}
}
