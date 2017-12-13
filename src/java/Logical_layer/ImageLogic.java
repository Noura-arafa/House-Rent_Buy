/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logical_layer;

import Classes.Image;
import Model.ImageIO;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class ImageLogic {
    
    ImageIO imageIo = new ImageIO();
    public void addImage(Image image, int houseId) throws ClassNotFoundException, SQLException
    {
        System.out.println("add image in logic");
        imageIo.addImage(image, houseId);
    }
}
