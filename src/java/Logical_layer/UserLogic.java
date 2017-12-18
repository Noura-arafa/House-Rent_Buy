/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logical_layer;

import Classes.Admin;
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

    public int getUserID(String userName) throws ClassNotFoundException, SQLException {
        int ID = userio.getUserID(userName);
        return ID;
    }

    public boolean Signup(User user) throws ClassNotFoundException, SQLException {
        if (userio.checkusers(user)) {
            userio.insertUser(user);
            return true;
        }
        return false;
    }

    public User UserLogin(String Uname, String pass) throws SQLException, ClassNotFoundException {
        User user = userio.getUser(Uname, pass);
        if (user == null) {
            return null;
        } else {
            return user;
        }
    }

    public Admin AdminLogin(String Uname, String pass) throws ClassNotFoundException, SQLException {
        return userio.checkAdmin(Uname, pass);
    }

    public void Createprofile(User user) {
        userio.updateuser(user);

    }

    public void Adminchangepassword(String Uname, String changedpassword) {
        userio.updatepassword(changedpassword, Uname);

    }

    public void Userchangepassword(String Uname, String changedpassword) {
        userio.updatepassword(changedpassword, Uname);
    }

    public Contactinformation RequestContactData(int Userid) {
        return userio.getContactData(Userid);
    }


    public void editfname(String Uname, String changedfirstname) {
        userio.updatefname(Uname, changedfirstname);
    }

    public void editlname(String Uname, String changedlastname) {
        userio.updatelname(Uname, changedlastname);
    }

    public void editaddress(String Uname, String changedaddress) {
        userio.updateaddress(Uname, changedaddress);
    }

    public void editemail(String Uname, String changedemail) {
        userio.updateemail(Uname, changedemail);
    }

    public void editphonenumber(String Uname, int phonenum) {
        userio.updatephonenum(Uname, phonenum);
    }

    //edit picture 
    public void editpicture(String Uname, InputStream photo) {
        userio.updatepicture(Uname, photo);
    }

    public void createAlert(String userName, Interest interest) throws ClassNotFoundException, SQLException {
        UserIO user = new UserIO();
        InterestIO interestIO = new InterestIO();
        int userID = user.getUserID(userName);
        int InterestID = -1;
        InterestID = interestIO.findInterest(interest);
        if (InterestID == -1) {
            interestIO.insertInterest(interest);
        }
        InterestID = interestIO.findInterest(interest);
        UserInterestIO userInterest = new UserInterestIO();
        userInterest.insert(userID, InterestID);
    }

}
