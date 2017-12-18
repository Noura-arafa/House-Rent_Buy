/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author hassan ali
 */
public class Contactinformation {
     private int Userid;
    private String email;
    private int phonenumber;

    public Contactinformation(int Userid, String email, int phonenumber) {
        this.Userid = Userid;
        this.email = email;
        this.phonenumber = phonenumber;
    }

    public int getUserid() {
        return Userid;
    }

    public void setUserid(int Userid) {
        this.Userid = Userid;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }
}
