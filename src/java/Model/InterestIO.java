/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.House;
import Classes.Interest;
import java.sql.SQLException;
import java.sql.*;
import java.sql.DriverManager;
import java.io.InputStream;
import java.util.ArrayList;


/**
 *
 * @author lenovo
 */
public class InterestIO {
    
    String user = "root";
    String password = "12345678a";
    
    public int findInterest(Interest interest) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/house_buy_rent";
       
        ResultSet RS = null;
        Connection Con =(Connection) DriverManager.getConnection(url, user, password);
        String selsectTableSQL = "SELECT interestID FROM interest WHERE tadtype=(?) and size=(?) and floor=(?) and status=(?)and "
                + "type=(?)and location=(?) and rate=(?) and price=(?)";
        PreparedStatement preparedStatement = Con.prepareStatement(selsectTableSQL);
        preparedStatement.setString(1, interest.getAdType());
        preparedStatement.setInt(2, interest.getSize());
        preparedStatement.setInt(3, interest.getFloor());
        preparedStatement.setString(4, interest.getStatus());
        preparedStatement.setString(5, interest.getType());
        preparedStatement.setString(6, interest.getLocation());
        preparedStatement.setDouble(7, interest.getRate());
        preparedStatement.setDouble(8, interest.getPrice());
        RS=preparedStatement.executeQuery();
        int interestID=-1;
        if(RS!=null){
            while(RS.next()){
                interestID=RS.getInt("interestID");
            }
            
        }
        return interestID;
    }
    public  void insert(int size,String status,String type) throws ClassNotFoundException, SQLException{   
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/house_buy_rent";
        ResultSet RS = null;
        Connection Con =(Connection) DriverManager.getConnection(url, user, password);
        String insertTableSQL = "INSERT INTO interest "+ "(type, size,status) VALUES" + "(?,?,?)";
        PreparedStatement preparedStatement = Con.prepareStatement(insertTableSQL);
        preparedStatement.setString(1, type);
        preparedStatement.setInt(2, size);
        preparedStatement.setString(3, status);       
        preparedStatement .executeUpdate();
        
        }
    
    
    public ArrayList<Integer> select (House house) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/house_buy_rent";
        ResultSet RS = null;
        Connection Con =(Connection) DriverManager.getConnection(url, user, password);
        ArrayList<Integer> ids = new ArrayList<>();
      
        
        String selsectTableSQL = "SELECT interestID FROM interest WHERE "+
        "case" +
"	when adtype is null then adtype is null" +
"       else adtype = ? "+
"	end       "+
        "case"  +
"	when size is null then size is null" +
"       else size = ?" +
"	end" +
        "case" +
"	when floor is null then floor is null" +
"       else floor = ? "+
"	end "+
        "case" +
"	when status is null then status is null" +
"       else status = ? "+
"	end       "+
        "case" +
"	when type is null then type is null" +
"       else type = ? "+
"	end "+
        "case" +
"	when location is null then location is null" +
"       else location = ? "+
"	end       "+
        "case" +
"	when rate is null then rate is null" +
"       else rate = ? "+
"	end"+
        "case"+
"       when price is null then price is null" +
"       else price = ?"+
"       end";
                
               
        PreparedStatement prst = Con.prepareStatement(selsectTableSQL);
        prst.setString(1, house.getAdType());
        prst.setInt(2, house.getSize());
        prst.setInt(3, house.getFloor());
        prst.setString(4, house.getStatus());
        prst.setString(5, house.getType());
        prst.setString(6, house.getLocation());
        prst.setDouble(7, house.getRate());
        prst.setDouble(8, house.getPrice());
        
        RS=prst.executeQuery();
        int interestID=-1;
        if(RS!=null){
            while(RS.next()){
                interestID=RS.getInt("interestID");
                ids.add(interestID);
            }
            
        }
        
        return ids;
        
    }
    
    
        public void insertInterest(Interest interest) throws SQLException, ClassNotFoundException{
        
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/house_buy_rent";
        ResultSet RS = null;
        Connection Con =(Connection) DriverManager.getConnection(url, user, password);
        String insertTableSQL = "INSERT INTO interest (adtype, size, floor, status,"
                + "type, location, rate, price) VALUES" + "(?,?,?,?,?,?,?,?)";
        PreparedStatement prst = Con.prepareStatement(insertTableSQL);
        prst.setString(1, interest.getAdType());
        if (interest.getSize() == 0)
            prst.setNull(2, java.sql.Types.INTEGER);
        else prst.setInt(2, interest.getSize());
        if (interest.getFloor() == 0)
            prst.setNull(3, java.sql.Types.INTEGER);
        else prst.setInt(3, interest.getFloor());
        prst.setString(4, interest.getStatus());
        prst.setString(5, interest.getType());
        prst.setString(6, interest.getLocation());
        if (interest.getRate()== 0.0)
            prst.setNull(7, java.sql.Types.DOUBLE);
        else prst.setDouble(7, interest.getRate());
        if (interest.getPrice() == 0.0) prst.setNull(8, java.sql.Types.DOUBLE);
        else prst.setDouble(8, interest.getPrice());
        prst .executeUpdate();

        
    }
    
}
