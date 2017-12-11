/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logical_layer;

import Classes.House;
import Classes.User;
import Model.CommentIO;
import Model.HouseIO;
import Model.UserIO;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author lenovo
 */
public class CommentLogic {
    CommentIO commentIo = new CommentIO();
    HouseIO houseIo = new HouseIO();
    UserIO userIo = new UserIO();
    
    public void comment(House house,String content,String username) throws SQLException, ClassNotFoundException, ParseException{
        int houseID=houseIo.getHouseID(house);
        int userID=userIo.getUserID(username);
        java.util.Date date=new java.util.Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
        commentIo.comment(content, houseID, userID, sqlTime);
        
    }
    
    public  static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException{
      CommentLogic com=new CommentLogic();
      House house = new House("villa with garden", "rent" , 200, 1, 0 , "status", "villa", "6 octobar", 0, "first villa");
       //User user = new User("Noura", "Arafa", "noura95", 01113600147, "nouraarafa95@gmil.com", "nouraArafa");
       //com.comment(house, "7elw el 7elw", user.getuserName());
    }
}
