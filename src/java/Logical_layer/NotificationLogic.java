/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logical_layer;

import Classes.House;
import Classes.User;
import Classes.Comment;
import Classes.Notification;
import Model.InterestIO;
import Model.HouseIO;

import Model.NotificationIO;
import Model.UserIO;
import Model.UserInterestIO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class NotificationLogic {
    public void interestNotification(House house) throws SQLException, ClassNotFoundException{
        ArrayList <Integer>users = new ArrayList<>();
        UserInterestIO userintersetIO = new UserInterestIO();
        NotificationIO notificationIO =new NotificationIO();
        
        HouseIO houseIO = new HouseIO();
        int houseID = houseIO.getHouseID(house);
        InterestIO interestIO=new InterestIO();
        ArrayList <Integer> interestIDS=new ArrayList<>();
        interestIDS= interestIO.select(house);
        System.out.println("intersetIDSsize "+interestIDS.size());
        //int interestID =interestIO.findInterest(house.getSize(), house.getStatus(), house.getType());
        for(int i =0;i<interestIDS.size();i++){
            users = userintersetIO.getUser(interestIDS.get(i));
            System.out.println("userssizeee "+users.size());
            for(int j =0;j<users.size();j++){
                System.out.println("in the useer ");
                 notificationIO.interestNotification(users.get(j),houseID);
        }

        }
        
        
                
    }
    public void commentNotification(int houseID,Comment comment) throws ClassNotFoundException, SQLException{
        User user= comment.getUser();
        String commentOwner=user.getuserName();
        HouseIO houseIO =new HouseIO();
        int userID = houseIO.getUser(houseID);
        NotificationIO notificationIO =new NotificationIO();
        notificationIO.inrertCommentNotification(userID, commentOwner,houseID);
        
    }
    public ArrayList<Notification> selectNewNotification(User user) throws ClassNotFoundException, SQLException{
        UserIO userIO= new UserIO();
        
        int userID = userIO.getUserID(user.getuserName());
        System.out.println("IDDDDDDDDDDD"+userID);
        NotificationIO nio=new NotificationIO();
        ArrayList <Notification > newNotification = nio.selectNewNotification(userID);
        return newNotification;
        
    }
    public ArrayList<Notification> selectOldNotification(User user) throws ClassNotFoundException, SQLException{
        UserIO userIO= new UserIO();
        int userID = userIO.getUserID(user.getuserName());
        NotificationIO nio=new NotificationIO();
        ArrayList <Notification > oldNotification = nio.selectOldNotification(userID);
        return oldNotification;
        
    }
    public void updateNotification (User user) throws ClassNotFoundException, SQLException{
        UserIO userIO= new UserIO();
        int userID = userIO.getUserID(user.getuserName());
        NotificationIO nio=new NotificationIO();
        nio.UpdateNotification(userID);
        
    }
    
}
