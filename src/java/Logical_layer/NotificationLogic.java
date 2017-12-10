/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logical_layer;

import Classes.House;
import Classes.User;
import Classes.Comment;
import Model.InterestIO;
import Model.HouseIO;

import Model.NotificationIO;
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
        int size=house.getSize();
        String type=house.getType();
        String status= house.getStatus();
        InterestIO interestIO=new InterestIO();
        int interestID =interestIO.findInterest(house.getSize(), house.getStatus(), house.getType());
        users = userintersetIO.getUser(interestID);
        for (int i =0; i<users.size();i++){
        }
        for(int i =0;i<users.size();i++){
            notificationIO.insert(users.get(i));
        }
        
    }
    public void commentNotification(int houseID,Comment comment) throws ClassNotFoundException, SQLException{
        User user= comment.getUser();
        String commentOwner=user.getuserName();
        HouseIO houseIO =new HouseIO();
        int userID = houseIO.getUser(houseID);
        NotificationIO notificationIO =new NotificationIO();
        notificationIO.inrertCommentNotification(userID, commentOwner);
        
    }
    
}
