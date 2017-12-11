/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.InputStream;

/**
 *
 * @author maryam
 */
public class Admin extends User {

    public Admin(String fN, String lN, String pw, int phN, String mail, String username, String address, InputStream photo) {
        super(fN, lN, pw, phN, mail, username, address, photo);
    }

    
}
