/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Classes.House;
import Classes.Image;
import static Model.HouseIO.url;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;



/**
 *
 * @author lenovo
 */
public class ImageIO {
    String url ="jdbc:mysql://localhost:3306/house_buy_rent";
    String sqluser = "root";
    String password = "n33333";
    
    public void addImage(Image image, int houseId) throws ClassNotFoundException, SQLException
    {
        System.out.println("add image in IO");
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, sqluser, password); 
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO image (photo, houseID) VALUES(?, ?)");
        pstmt.setBlob(1, image.getPhoto());
        pstmt.setInt(2, houseId);
        pstmt.executeUpdate();
        
        conn.close();
    }
    
    public ArrayList<Image> selectImages(int houseID) throws SQLException, ClassNotFoundException{
        
        ArrayList<Image> images = new ArrayList<>();
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, sqluser, password);

        if (conn == null) System.out.println("conn is not working");
        
        String sql = "select photo from image where houseID = ? ";
        PreparedStatement prst = conn.prepareStatement(sql);
        prst.setInt(1, houseID);
        ResultSet rs = prst.executeQuery();
        System.out.println("before while in image IO " + houseID);
    
        
        while (rs.next()){
            System.out.println("here image Io ");
            Image image = new Image();
            Blob b = rs.getBlob("photo");
            image.setimageBlob(b);
            images.add(image);
            
        }
        
        prst.close();
        conn.close();
        
        return images;
        
    }
}
