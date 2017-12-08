/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class User {
    private String fName, lName, userName, pass, email;
    private int phoneNumber;
    private ArrayList <House> houses;
    private ArrayList <Notification> notifications;
    private ArrayList <Interest> interests;
    
    public User(String fN, String lN, String pw, int phN, String mail, String username)
    {
        fName = fN;
        lName = lN;
        pass = pw;
        phoneNumber = phN;
        email = mail;
        userName = username;
        
    }
    
    //Setters
    public void setfName(String fn)
    {
        fName = fn;
    }
    
    public void setlName(String ln)
    {
        lName = ln ;
    }
    public void  setuserName(String uName)
    {
        userName= uName;
    }
    public void setpass(String pss)
    {
        pass = pss;
    }
    public void  setemail(String mail)
    {
        email = mail;
    }
    public void setphoneNumber(int phNumber)
    {
        phoneNumber = phNumber;
    }

    public void setHouse(House house) {
        this.houses.add(house);
    }

    public void setNotification(Notification notification) {
        this.notifications.add(notification);
    }

    public void setInterest(Interest interest) {
        this.interests.add(interest);
    }
    
    
    //Getters
    public String getfName()
    {
        return fName;
    }
    
    public String getlName()
    {
        return lName;
    }
    public String getuserName()
    {
        return userName;
    }
    public String getpass()
    {
        return pass;
    }
    public String getemail()
    {
        return email;
    }
    public int getphoneNumber()
    {
        return phoneNumber;
    }

    public ArrayList<House> getHouses() {
        return houses;
    }

    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    public ArrayList<Interest> getInterests() {
        return interests;
    }
    
    
    
}
