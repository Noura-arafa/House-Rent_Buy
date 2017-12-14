/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logical_layer;

import Classes.Contactinformation;
import Classes.House;
import Classes.Interest;
import Classes.User;
import Model.HouseIO;
import Model.InterestIO;
import Model.UserIO;
import Model.UserInterestIO;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lenovo
 */
public class UserLogic {

    UserIO userio = new UserIO();
    
     public int getUserID(String userName) throws ClassNotFoundException, SQLException
    {
       int ID = userio.getUserID(userName);
       return ID;
    }

    public boolean Signup(User user) throws ClassNotFoundException, SQLException {
         System.out.println("username "+user.getuserName());
        if (userio.checkusers(user)) {
            System.out.println("in checkusers ");
            userio.insertUser(user);
            return true;
        }
        return false;
    }

    public User UserLogin(String Uname, String pass) throws SQLException, ClassNotFoundException {
        User user=userio.getUser(Uname, pass);
        if(user==null)
            return null;
        else
            return user;
    }

    public boolean AdminLogin(String Uname, String pass) {
        if (Uname.equals("Admin") && pass.equals("1234")) {
            return true;
        } else {
            return false;
        }
    }

    public void Createprofile(User user) {
        userio.updateuser(user);
        //return user
    }

    public void Adminchangepassword(String Uname, String changedpassword, String changeduser) {
        if (Uname.equals("Admin")) {
            userio.updatepassword(changedpassword, changeduser);
        }
    }

    public void Userchangepassword(String Uname, String changedpassword) {
        userio.updatepassword(changedpassword, Uname);
    }

    public Contactinformation RequestContactData(String Uname) {
        return userio.getContactData(Uname);
    }
    public void createAlert(String userName,Interest interest) throws ClassNotFoundException, SQLException{
        UserIO user =new UserIO();
        InterestIO interestIO=new InterestIO();
        int userID=user.getUserID(userName);
        int InterestID=-1;
        InterestID=interestIO.findInterest(interest.getSize(),interest.getStatus(),interest.getType());
        if(InterestID==-1){
            interestIO.insert(interest.getSize(),interest.getStatus(),interest.getType());
        }
        InterestID=interestIO.findInterest(interest.getSize(),interest.getStatus(),interest.getType());
        UserInterestIO userInterest=new UserInterestIO();
        userInterest.insert(userID, InterestID);
        
        
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        InputStream photo = null;
        User user = new User("Menna", "Ali", "1234", 011411, "mennaali365@gmail.com", "MennaAli", "maddi", photo);
        UserLogic userlogic = new UserLogic();
        //sign up checked 
        /*if(userlogic.Signup(user))
             System.out.println("successed");
         else
             System.out.println("failed");
         //loginuser checked*/
    /*  if(userlogic.UserLogin("MennaAli", "1234"))
             System.out.println("successed");
         else
             System.out.println("failed");*/
        System.out.println("glagla");
        HouseIO houseio = new HouseIO();
        //House house = new House("villa with garden", "rent", 200, 1, 0, "status", "villa", "6 octobar", 0);
        //House house1 = new House("roof with 2 bed rooms", "rent", 100, 1, 4, "status", "Roof", "Shekh Zaid", 0);
        //InputStream photo=null;
        //User user=new User("Menna", "Ali", "1234", 011411, "mennaali365@gmail.com","MennaAli","maddi",photo);
       // houseio.addhouse(house1, user);
        //createprofile checked
        //userlogic.Createprofile(user);
        //adminchangespaasword checked
        //userlogic.Adminchangepassword("Admin", "helloyaMenna", "MennaAli");
        //userchangedpasswrod checked
        //userlogic.Userchangepassword("MennaAli", "helloMenna");
    }
}
