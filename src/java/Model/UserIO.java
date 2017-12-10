/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
import java.sql.DriverManager;
/**
 *
 * @author lenovo
 */
public class UserIO {
    String url = "jdbc:mysql://localhost:3306/house_buy_rent";
    String sqluser = "root";
    String pass = "n33333";
    
    protected int getUserID(String userName) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, sqluser, pass);
        PreparedStatement pstmt = conn.prepareStatement("Select userId FROM user WHERE userName = ?");
        pstmt.setString(1, userName);
        ResultSet rs = pstmt.executeQuery();
        int id = 0;
        if (rs.first())
          id = rs.getInt(1);
        
        rs.close();
        pstmt.close();
        conn.close();
        return id;
                        
    }
}
