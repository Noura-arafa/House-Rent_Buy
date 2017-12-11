/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logical_layer;

import Classes.Contactinformation;
import Classes.House;
import Classes.User;
import Model.HouseIO;
import Model.UserIO;
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

    public boolean Signup(User user) throws ClassNotFoundException, SQLException {

        if (userio.checkusers(user)) {
            userio.insertUser(user);
            return true;
        }
        return false;
    }

    public boolean UserLogin(String Uname, String pass) throws SQLException, ClassNotFoundException {
        if (userio.getUser(Uname, pass)) {
            return true;
        }
        return false;
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
        House house = new House("villa with garden", "rent", 200, 1, 0, "status", "villa", "6 octobar", 0);
        House house1 = new House("roof with 2 bed rooms", "rent", 100, 1, 4, "status", "Roof", "Shekh Zaid", 0);
        //InputStream photo=null;
        //User user=new User("Menna", "Ali", "1234", 011411, "mennaali365@gmail.com","MennaAli","maddi",photo);
        houseio.addhouse(house1, user);
        //createprofile checked
        //userlogic.Createprofile(user);
        //adminchangespaasword checked
        //userlogic.Adminchangepassword("Admin", "helloyaMenna", "MennaAli");
        //userchangedpasswrod checked
        //userlogic.Userchangepassword("MennaAli", "helloMenna");
    }
}
