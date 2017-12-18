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
    String password = "n33333";
    
    public  int findInterest(Interest interest) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/house_buy_rent";
       
        ResultSet RS = null;
        System.out.println("interessssttt "+interest.getSize() +"tpe "+interest.getType()+"  status "+interest.getStatus());
        Connection Con =(Connection) DriverManager.getConnection(url, user, password);
        String selsectTableSQL = "select interestID FROM interest WHERE "+
                 "adtype = (?) and size = (?) and floor  = (?) "+
                "and status = (?) and type = (?) and location = (?)"+
                " and rate = (?) and price = (?)";
        PreparedStatement prst = Con.prepareStatement(selsectTableSQL);
        
        
        if (interest.getAdType() == null)
            prst.setString(1, "adtype");
        else prst.setString(1, interest.getAdType());
        if (interest.getSize() == 0)
            prst.setInt(2, -1);
        else prst.setInt(2, interest.getSize());
        if (interest.getFloor() == 0)
            prst.setInt(3, -1);
        else prst.setInt(3, interest.getFloor());
        if(interest.getStatus() == null)
            prst.setString(4, "status");
        else prst.setString(4, interest.getStatus());
        if (interest.getType() == null)
            prst.setString(5, "type");
        else prst.setString(5, interest.getType());
        if (interest.getLocation() == null)
                prst.setString(6, "location");
        else prst.setString(6, interest.getLocation());
        if (interest.getRate()== 0.0)
            prst.setDouble(7, -1);
        else prst.setDouble(7, interest.getRate());
        if (interest.getPrice() == 0.0) 
            prst.setDouble(8, -1);
        else prst.setDouble(8, interest.getPrice());
        
        RS = prst.executeQuery();
        int interestID=-1;
        if(RS!=null){
            while(RS.next()){
                System.out.println("heeeeey");
                interestID=RS.getInt("interestID");
            }
            
        }
        return interestID;
    }

   
    public ArrayList<Integer> select (House house) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/house_buy_rent";
        ResultSet RS = null;
        Connection Con =(Connection) DriverManager.getConnection(url, user, password);
        ArrayList<Integer> ids = new ArrayList<>();
      
        
        String selsectTableSQL = "SELECT interestID FROM interest WHERE "+
        "case" +
"	when adtype = 'adtype' then adtype = 'adtype' " +
"       else adtype = ? "+
"	end     and   "+
        "case"  +
"	when size = -1 then size = -1" +
"       else size = ?" +
"	end and " +
        "case" +
"	when floor = -1 then floor = -1" +
"       else floor = ? "+
"	end and "+
        "case" +
"	when status = 'status' then status = 'status'" +
"       else status = ? "+
"	end  and "+
        "case" +
"	when type = 'type' then type = 'type' " +
"       else type = ? "+
"	end  and "+
        "case" +
"	when location = 'location' then location = 'location'" +
"       else location = ? "+
"	end and      "+
        "case" +
"	when rate = -1 then rate = -1 " +
"       else rate = ? "+
"	end and "+
        "case"+
"       when price = -1 then price = -1" +
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
        if (interest.getAdType() == null)
            prst.setString(1, "adtype");
        else prst.setString(1, interest.getAdType());
        if (interest.getSize() == 0)
            prst.setInt(2, -1);
        else prst.setInt(2, interest.getSize());
        if (interest.getFloor() == 0)
            prst.setInt(3, -1);
        else prst.setInt(3, interest.getFloor());
        if(interest.getStatus() == null)
            prst.setString(4, "status");
        else prst.setString(4, interest.getStatus());
        if (interest.getType() == null)
            prst.setString(5, "type");
        else prst.setString(5, interest.getType());
        if (interest.getLocation() == null)
                prst.setString(6, "location");
        else prst.setString(6, interest.getLocation());
        if (interest.getRate()== 0.0)
            prst.setDouble(7, -1);
        else prst.setDouble(7, interest.getRate());
        if (interest.getPrice() == 0.0) 
            prst.setDouble(8, -1);
        else prst.setDouble(8, interest.getPrice());
        prst .executeUpdate();

        
    }
        public static void main(String args[]) throws SQLException, ClassNotFoundException{
            Interest in =new Interest(null, 100, 0, "finished", "va", null, 0.0,0.0);
            House house = new House("bla", "bla", 200, 1, 100, "finished", "villa", "bla", 5.0, "ay 7aga", 100.0);
            
            
            //Interest  i = new Interest(adType, 0, 0, status, type, location, Double.NaN, Double.NaN)
            InterestIO n= new InterestIO();
            ArrayList<Integer> ids = n.select(house);
            for (int i = 0; i < ids.size(); i++)
                System.out.println("ids: " + ids.get(i));
            
            
            int ID=n.findInterest(in);
            System.out.println("wWWWWWWWWWWWWWWWW  "+ID);
        }
    
}
