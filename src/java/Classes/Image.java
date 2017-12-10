/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.InputStream;
/**
 *
 * @author lenovo
 */
public class Image {
    private InputStream photo;

    public Image(InputStream photo) {
        this.photo = photo;
    }

    public void setPhoto(InputStream photo) {
        this.photo = photo;
    }

    public InputStream getPhoto() {
        return photo;
    }
    
    
}
