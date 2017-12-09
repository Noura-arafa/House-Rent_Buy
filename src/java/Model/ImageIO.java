/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Classes.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;



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
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, sqluser, password); 
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO image photo, houseID VALUES(?, ?)");
        pstmt.setBlob(1, image.getPhoto());
        pstmt.setInt(2, houseId);
        pstmt.executeUpdate();
        
        conn.close();
    }
}
