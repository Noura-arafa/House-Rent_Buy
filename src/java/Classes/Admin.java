/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author maryam
 */
public class Admin extends User {

    private ArrayList<House> suspendedHouses;


    public ArrayList<House> getSuspendedHouses() {
        return suspendedHouses;
    }

    public void setSuspendedHouses(ArrayList<House> suspendedHouses) {
        this.suspendedHouses = suspendedHouses;
    }


    public Admin(String fN, String lN, String pw, int phN, String mail, String username) {
        super(fN, lN, pw, phN, mail, username);
    }

}
