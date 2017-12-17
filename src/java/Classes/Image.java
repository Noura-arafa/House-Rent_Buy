/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
/**
 *
 * @author lenovo
 */
public class Image {
    private InputStream photo;
    private OutputStream image;
    private Blob imageblob;
    public Image(){
        
    }
    public Image(InputStream photo) {
        this.photo = photo;
    }

    public void setPhoto(InputStream photo) {
        this.photo = photo;
    }

    public void setImage(OutputStream image) {
        this.image = image;
    }

    public void setimageBlob(Blob blob) {
        this.imageblob = blob;
    }
    
    public InputStream getPhoto() {
        return photo;
    }

    public OutputStream getImage() {
        return image;
    }

    public Blob getimageBlob() {
        return imageblob;
    }
    
    
    
    
}
