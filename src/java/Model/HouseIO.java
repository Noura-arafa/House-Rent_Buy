/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Classes.User;
import Classes.House;
import java.sql.*;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */


public class HouseIO {
    String url ="jdbc:mysql://localhost:3306/house_buy_rent";
    String sqluser = "root";
    String password = "n33333";
    
    protected int gethouseID(House house) throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, sqluser, password);
        UserIO userio = new UserIO();
        PreparedStatement prst = conn.prepareStatement("Select houseID FROM house WHERE description = ? AND adType = ? "
                + "AND size = ? AND active = ? AND floor = ? AND status = ? AND type = ? AND location = ? AND rate = ?");
        prst.setString(1, house.getDescription());
        prst.setString(2, house.getAdType());
        prst.setInt(3, house.getSize());
        prst.setInt(4, house.getActive());
        prst.setInt(5, house.getFloor());
        prst.setString(6, house.getStatus());
        prst.setString(7, house.getType());
        prst.setString(8, house.getLocation());
        prst.setInt(9, house.getRate());
        prst.executeQuery();
        
        ResultSet rs = prst.executeQuery();
        int id =0;
        if(rs.first())
          id = rs.getInt(1);
        
        rs.close();
        prst.close();
        conn.close();
        return id;
    }
    protected void addhouse(House house, User user) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, sqluser, password); 
        UserIO uio = new UserIO();
        int userid = uio.getUserID(user.getuserName()) ;
        int testid = gethouseID(house);
        if (testid != 0)
        {
            System.out.println("exist");
            return ;
        }
        
        String insertQuery = "Insert INTO house "
                + "(description, adtype, size, active, floor, status, type, location, rate, hUserID)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement prst = conn.prepareStatement(insertQuery);
        prst.setString(1, house.getDescription());
        prst.setString(2, house.getAdType());
        prst.setInt(3, house.getSize());
        prst.setInt(4, house.getActive());
        prst.setInt(5, house.getFloor());
        prst.setString(6, house.getStatus());
        prst.setString(7, house.getType());
        prst.setString(8, house.getLocation());
        prst.setInt(9, house.getRate());
        prst.setInt(10, userid);
        prst.executeUpdate();
        
       prst.close();
       conn.close();
    }
    protected void edit(ArrayList<String> newprop, ArrayList<String> propName, int houseId) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, sqluser, password); 
         
        for(int i=0; i<newprop.size(); i++)
        {
            if(propName.get(i).equals("description"))
            {
                PreparedStatement pstmt = conn.prepareStatement("UPDATE house set description = ? WHERE houseID = ?");
                pstmt.setString(1, newprop.get(i));
                pstmt.setInt(2, houseId);
                pstmt.executeUpdate();
                pstmt.close();
            }
            else if(propName.get(i).equals("adType"))
            {
                PreparedStatement pstmt = conn.prepareStatement("UPDATE house set adType = ? WHERE houseID = ?");
                pstmt.setString(1, newprop.get(i));
                pstmt.setInt(2, houseId);
                pstmt.executeUpdate();
                pstmt.close();
            }
            else if(propName.get(i).equals("size"))
            {
                System.out.println("Hellloooo");
                PreparedStatement pstmt = conn.prepareStatement("UPDATE house set size = ? WHERE houseID = ?");
                pstmt.setInt(1, Integer.parseInt(newprop.get(i)));
                pstmt.setInt(2, houseId);
                pstmt.executeUpdate();
                pstmt.close();

            }
            else if(propName.get(i).equals("active"))
            {
                PreparedStatement pstmt = conn.prepareStatement("UPDATE house set active = ? WHERE houseID = ?");
                pstmt.setInt(1, Integer.parseInt(newprop.get(i)));
                pstmt.setInt(2, houseId);
                pstmt.executeUpdate();
                pstmt.close();
            }
            else if(propName.get(i).equals("floor"))
            {
                PreparedStatement pstmt = conn.prepareStatement("UPDATE house set floor = ? WHERE houseID = ?");
                pstmt.setInt(1, Integer.parseInt(newprop.get(i)));
                pstmt.setInt(2, houseId);
                pstmt.executeUpdate();
                pstmt.close();
                
            }
            else if(propName.get(i).equals("status"))
            {
                PreparedStatement pstmt = conn.prepareStatement("UPDATE house set status = ? WHERE houseID = ?");
                pstmt.setString(1, newprop.get(i));
                pstmt.setInt(2, houseId);
                pstmt.executeUpdate();
                pstmt.close();
            }
            else if(propName.get(i).equals("type"))
            {
                PreparedStatement pstmt = conn.prepareStatement("UPDATE house set type = ? WHERE houseID = ?");
                pstmt.setString(1, newprop.get(i));
                pstmt.setInt(2, houseId);
                pstmt.executeUpdate();
                pstmt.close();

            }
            else if(propName.get(i).equals("location"))
            {
                PreparedStatement pstmt = conn.prepareStatement("UPDATE house set location = ? WHERE houseID = ?");
                pstmt.setString(1, newprop.get(i));
                pstmt.setInt(2, houseId);
                pstmt.executeUpdate();
                pstmt.close();

            }
        }
        conn.close();
    }
    

    public  static void main(String[] args) throws ClassNotFoundException, SQLException{
        HouseIO houseio = new HouseIO();
        House house = new House("villa with garden", "rent" , 200, 1, 0 , "status", "villa", "6 octobar", 0);
        House house1 = new House("roof with 2 bed rooms", "rent" , 100, 1, 4 , "status", "Roof", "Shekh Zaid", 0);
        User user = new User("Noura", "Arafa", "noura95", 01113600147, "nouraarafa95@gmil.com", "nouraArafa");
        houseio.addhouse(house1, user);
        /*ArrayList<String> newpr = new ArrayList<>();
        ArrayList<String> pr = new ArrayList<>();
        newpr.add("villa with garden");
        pr.add("description");
        
        newpr.add("buy");
        pr.add("adtype");
        
        newpr.add("villa");
        pr.add("type");
        
        newpr.add("0");
        pr.add("floor");
        
        houseio.edit(newpr, pr, 3);*/
       // System.out.println(houseio.gethouseID(house));
        
    }
   
}