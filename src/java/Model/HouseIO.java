/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Classes.Comment;
import Classes.User;
import Classes.House;
import Classes.Image;
import java.io.InputStream;
import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */

public class HouseIO {
        static String url = "jdbc:mysql://localhost:3306/house_buy_rent";
        static String sqluser = "root";
        static String password = "12345678a";
    

    
    public int getUser(int houseID) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        ResultSet RS = null;
        int userID=-1;
        Connection Con =  DriverManager.getConnection(url, sqluser, password);
        String selsectTableSQL = "SELECT hUserID FROM house WHERE houseID="+"(?)";
        PreparedStatement preparedStatement = Con.prepareStatement(selsectTableSQL);
        preparedStatement.setInt(1, houseID);
        RS=preparedStatement.executeQuery();
        while(RS.next()){
            userID=RS.getInt("hUserID");
            
        }
        return userID;
    }
    public static int getHouseID(House house) throws SQLException, ClassNotFoundException

    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, sqluser, password);
        PreparedStatement prst = conn.prepareStatement("Select houseID FROM house WHERE adName = ? ");
        prst.setString(1, house.getAdName());
        prst.executeQuery();
       
        ResultSet rs = prst.executeQuery();
        int id = -1;
        if(rs.first())
          id = rs.getInt(1);
        
        rs.close();
        prst.close();
        conn.close();
        return id;
    }
    public void addhouse(House house, User user) throws ClassNotFoundException, SQLException
    {
        System.out.println("bla " + house.getPrice());
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, sqluser, password);
        UserIO uio = new UserIO();
        int userid = uio.getUserID(user.getuserName()) ;
        
        String insertQuery = "Insert INTO house "
                + "(description, adtype, size, active, floor, status, type, location, hUserID, adName, price, rate)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement prst = conn.prepareStatement(insertQuery);
        prst.setString(1, house.getDescription());
        prst.setString(2, house.getAdType());
        prst.setInt(3, house.getSize());
        prst.setInt(4, house.getActive());
        prst.setInt(5, house.getFloor());
        prst.setString(6, house.getStatus());
        prst.setString(7, house.getType());
        prst.setString(8, house.getLocation());
        prst.setInt(9, userid);
        prst.setString(10, house.getAdName());
        prst.setDouble(11, house.getPrice());
        prst.setDouble(12, 0.0);

        prst.executeUpdate();
        
       
       prst.close();
       conn.close();
    }
    public void edit(House house) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection(url, sqluser, password);
       
        String query = "update house set "
                + "description = ?, adtype = ?, size = ?, floor = ?, status = ?, type = ?, "
                + "location = ?, adName = ?, price = ?"
                + "where houseID = ?";
        int id = getHouseID(house);
        System.out.println("houseId" + id);
        PreparedStatement prst = conn.prepareStatement(query);
        prst.setString(1, house.getDescription());
        prst.setString(2, house.getAdType());
        prst.setInt(3, house.getSize());
        prst.setInt(4, house.getFloor());
        prst.setString(5, house.getStatus());
        prst.setString(6, house.getType());
        prst.setString(7, house.getLocation());
        prst.setString(8, house.getAdName());
        prst.setDouble(9, house.getPrice());
        prst.setInt(10, id);
        prst.executeUpdate();

        prst.close();
        conn.close();
 

        
    }
    
    public ArrayList<House> search(House house) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection Con =DriverManager.getConnection(url, sqluser, password);
        Statement Stmt = Con.createStatement();
        ResultSet rs = null;
        ArrayList<House> houses = new ArrayList<>();
        
        PreparedStatement prst = Con.prepareStatement("select * FROM house WHERE " +
"                 rate = IFNULL (?,rate) and adtype = IFNULL(?,adtype) and" +
"                 size = IFNULL(?,size) and active = 1 and floor  = IFNULL(?,floor) and status = IFNULL(?,status)and" +
"                 type = IFNULL(?,type)and location = IFNULL(?,location)and" +
"                adName = IFNULL(?,adName) and price = IFNULL (?, price)");
        
        
        
        if (house.getRate() == 0.0) prst.setNull(1, java.sql.Types.DOUBLE);
        else prst.setDouble(1, house.getRate());
        
        prst.setString(2, house.getAdType());
        
        if (house.getSize() == 0)
            prst.setNull(3, java.sql.Types.INTEGER);
        else prst.setInt(3, house.getSize());
        
        if (house.getFloor() == 0)
            prst.setNull(4, java.sql.Types.INTEGER);
        else prst.setInt(4, house.getFloor());
        
        prst.setString(5, house.getStatus());
        prst.setString(6, house.getType());
        prst.setString(7, house.getLocation());
        prst.setString(8, house.getAdName());
        
        if (house.getPrice() == 0.0) prst.setNull(9, java.sql.Types.DOUBLE);
        else prst.setDouble(9, house.getPrice());

        rs = prst.executeQuery();
        
        ImageIO imageIO = new ImageIO();
        CommentIO commentIO = new CommentIO();
        
        while(rs.next()){
                
            House newHouse = new House();
            ArrayList<Comment> comments = new ArrayList<Comment>();
            ArrayList<Image> images = new ArrayList<Image>();
            int houseID = rs.getInt("houseID");
            newHouse.setAdName(rs.getString("adName"));
            newHouse.setRate(rs.getDouble("rate"));
            newHouse.setAdType(rs.getString("adtype"));
            newHouse.setSize(rs.getInt("size"));
            newHouse.setActive(rs.getInt("active"));
            newHouse.setFloor(rs.getInt("floor"));
            newHouse.setStatus(rs.getString("status"));
            newHouse.setType(rs.getString("type"));
            newHouse.setLocation(rs.getString("location"));
            newHouse.setRate(rs.getDouble("rate"));
            newHouse.setCountRate(rs.getInt("countRate"));
            newHouse.setTotalRates(rs.getInt("totalRates"));
            newHouse.setPrice(rs.getDouble("price"));
            comments = commentIO.selectAllComments(houseID);
            images = imageIO.selectImages(houseID);
            newHouse.setHouseID(houseID);
            newHouse.setComments(comments);
            newHouse.setImages(images);
            
            houses.add(newHouse);

        }
        
        return houses;

    }
    
    public void rate(Double rate,int houseID, int totalRate, int countRate) throws ClassNotFoundException, SQLException{
        Connection Con =DriverManager.getConnection(url, sqluser, password);
        Statement Stmt =Con.createStatement();
        String insertTableSQL = "UPDATE house set rate =? , totalRates =?  , countRate = ? where houseID = ?";
        PreparedStatement preparedStatement = Con.prepareStatement(insertTableSQL);
        preparedStatement.setDouble(1, rate);
        preparedStatement.setInt(2, totalRate);
        preparedStatement.setInt(3, countRate);
        preparedStatement.setInt(4, houseID);
        preparedStatement .executeUpdate();
    }
    
    

    public  static void main(String[] args) throws ClassNotFoundException, SQLException{
        HouseIO houseio = new HouseIO();
        //House house = new House("villa with garden", "rent" , 200, 1, 0 , "status", "villa", "6 octobar", 0, "first villa");
        //House house1 = new House("roof with 2 bed rooms", "rent" , 100, 1, 4 , "status", "Roof", "Shekh Zaid", 0);
        //User user = new User("Noura", "Arafa", "noura95", 01113600147, "nouraarafa95@gmil.com", "nouraArafa");
       // houseio.addhouse(house, user);
       
       
       /*MArwa 
       ResultSet r=houseio.search(true, "Area", "200");
       while(r.next()){
           String des=r.getString("description");
                    System.out.println(des);
                    int floor=r.getInt("floor");  
                    System.out.println(floor);
                    String status=r.getString("status");
                    System.out.println(status);
                    String type=r.getString("type");
                    System.out.println(type);
       }
        System.out.println("House: "+houseio.search(true, "Area", "200"));
      
        houseio.rate(1, 5);
       */
    }
    
    public void deleteHouse(String adName) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, sqluser, password);
        String query = "delete from house where adName = ? ";
                
               
        PreparedStatement prst = conn.prepareStatement(query);
        prst.setString(1, adName);
        prst.executeUpdate();
        prst.close();
        conn.close();

    }

    public void suspendHouse(String adName) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, sqluser, password);
        PreparedStatement prst = conn.prepareStatement("Select houseID FROM house WHERE adName = ? ");
        prst.setString(1, adName);
        prst.executeQuery();
       
        ResultSet rs = prst.executeQuery();
        int id = -1;
        if(rs.first())
          id = rs.getInt(1);
        System.out.println("suspend house fun" + id);
        String query = "update house set active = 0 where houseID = ?";
        prst = conn.prepareStatement(query);
        prst.setInt(1, id);
        prst.executeUpdate();
        prst.close();
        conn.close();
    }
    public void unSuspendHouse(String adName) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, sqluser, password);
        PreparedStatement prst = conn.prepareStatement("Select houseID FROM house WHERE adName = ? ");
        prst.setString(1, adName);
        prst.executeQuery();
       
        ResultSet rs = prst.executeQuery();
        int id = -1;
        if(rs.first())
          id = rs.getInt(1);
        System.out.println("suspend house fun" + id);
        String query = "update house set active = 1 where houseID = ?";
        prst = conn.prepareStatement(query);
        prst.setInt(1, id);
        prst.executeUpdate();
        prst.close();
        conn.close();
    }
    
    public ArrayList<House> selectSuspendedHouses() throws ClassNotFoundException, SQLException{
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, sqluser, password);

        ArrayList<House> houses = new ArrayList<>();
        CommentIO commentIO = new CommentIO();
        ImageIO imageIO = new ImageIO();

        if (conn == null) System.out.println("conn is not working");

        Statement stmt = conn.createStatement();
        String sql = "select houseID, adName, description, adtype, size, active, floor, status, type,"
                + " location, rate, countRate, totalRates, price  from house where active = 0";
        ResultSet rs =stmt.executeQuery(sql);
        
        while(rs.next()){
                
            House house = new House();
            ArrayList<Comment> comments = new ArrayList<Comment>();
            ArrayList<Image> images = new ArrayList<Image>();
            int houseID = rs.getInt("houseID");
            house.setAdName(rs.getString("adName"));
            house.setDescription(rs.getString("description"));
            house.setAdType(rs.getString("adtype"));
            house.setSize(rs.getInt("size"));
            house.setActive(rs.getInt("active"));
            house.setFloor(rs.getInt("floor"));
            house.setStatus(rs.getString("status"));
            house.setType(rs.getString("type"));
            house.setLocation(rs.getString("location"));
            house.setRate(rs.getDouble("rate"));
            house.setCountRate(rs.getInt("countRate"));
            house.setTotalRates(rs.getInt("totalRates"));
            house.setPrice(rs.getDouble("price"));
            comments = commentIO.selectAllComments(houseID);
            images = imageIO.selectImages(houseID);
            house.setComments(comments);
            house.setImages(images);
            house.setHouseID(houseID);
            
            houses.add(house);

        }
        stmt.close();
        conn.close();
        
        return houses;
        
    }
    
    public void updateHouse (House house) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, sqluser, password);
        String query = "update house set "
                + "description = ?, adtype = ?, size = ?, active = ?, floor = ?, status = ?, "
                + "type = ?, location = ?, rate = ?"
                + "where houseID = ?";
        int id = getHouseID(house);
        PreparedStatement prst = conn.prepareStatement(query);
        prst.setString(1, house.getDescription());
        prst.setString(2, house.getAdType());
        prst.setInt(3, house.getSize());
        prst.setInt(4, house.getActive());
        prst.setInt(5, house.getFloor());
        prst.setString(6, house.getStatus());
        prst.setString(7, house.getType());
        prst.setString(8, house.getLocation());
        prst.setDouble(9, house.getRate());
        prst.setInt(10, id);
        prst.executeUpdate();

        prst.close();
        conn.close();


    }
    
    public ArrayList<House> selectUserHouse(int userID) throws SQLException, ClassNotFoundException{
        System.out.println("user id " + userID);
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, sqluser, password);
        CommentIO commentIO = new CommentIO();
        ImageIO imageIO = new ImageIO();
        ArrayList<House> userHouses = new ArrayList<>();
        String sql = "SELECT * FROM house WHERE hUserID = ?";
        PreparedStatement pr = conn.prepareStatement(sql);
        pr.setInt(1, userID);
        ResultSet rs =pr.executeQuery();
        while(rs.next())
        {
            House house = new House();
            ArrayList<Comment> comments = new ArrayList<Comment>();
            ArrayList<Image> images = new ArrayList<Image>();
            house.setAdName(rs.getString("adName"));
            house.setDescription(rs.getString("description"));
            house.setAdType(rs.getString("adtype"));
            house.setSize(rs.getInt("size"));
            house.setActive(rs.getInt("active"));
            house.setFloor(rs.getInt("floor"));
            house.setStatus(rs.getString("status"));
            house.setType(rs.getString("type"));
            house.setLocation(rs.getString("location"));
            house.setRate(rs.getDouble("rate"));
            house.setCountRate(rs.getInt("countRate"));
            house.setTotalRates(rs.getInt("totalRates"));
            house.setPrice(rs.getDouble("price"));
            comments = commentIO.selectAllComments(rs.getInt("houseID"));
            images = imageIO.selectImages(rs.getInt("houseID"));
            house.setHouseID(rs.getInt("houseID"));
            house.setComments(comments);
            house.setImages(images);
            
            userHouses.add(house);
        }
        return userHouses;
    }

    public ArrayList<House> selectAllHouses () throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, sqluser, password);

        ArrayList<House> houses = new ArrayList<>();
        CommentIO commentIO = new CommentIO();
        ImageIO imageIO = new ImageIO();

        if (conn == null) System.out.println("conn is not working");

        Statement stmt = conn.createStatement();
        String sql = "select houseID, adName, description, adtype, size, active, floor, status, type,"
                + " location, rate, countRate, totalRates, price  from house where active = 1";
        ResultSet rs =stmt.executeQuery(sql);
        
        while(rs.next()){
                
            House house = new House();
            ArrayList<Comment> comments = new ArrayList<Comment>();
            ArrayList<Image> images = new ArrayList<Image>();
            int houseID = rs.getInt("houseID");
            house.setAdName(rs.getString("adName"));
            house.setDescription(rs.getString("description"));
            house.setAdType(rs.getString("adtype"));
            house.setSize(rs.getInt("size"));
            house.setActive(rs.getInt("active"));
            house.setFloor(rs.getInt("floor"));
            house.setStatus(rs.getString("status"));
            house.setType(rs.getString("type"));
            house.setLocation(rs.getString("location"));
            house.setRate(rs.getDouble("rate"));
            house.setCountRate(rs.getInt("countRate"));
            house.setTotalRates(rs.getInt("totalRates"));
            house.setPrice(rs.getDouble("price"));
            comments = commentIO.selectAllComments(houseID);
            images = imageIO.selectImages(houseID);
            house.setComments(comments);
            house.setImages(images);
            house.setHouseID(houseID);
            houses.add(house);

        }
        stmt.close();
        conn.close();
        
        return houses;
    }
    
    
    
    public House selectHouses (int houseID) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, sqluser, password);

        CommentIO commentIO = new CommentIO();
        ImageIO imageIO = new ImageIO();

        if (conn == null) System.out.println("conn is not working");

        
        String sql = "select adName, description, adtype, size, active, floor, status, type,"
                + " location, rate, countRate, totalRates, price  from house where houseID = ?;";

        PreparedStatement prst = conn.prepareStatement(sql);
        prst.setInt(1, houseID);
        ResultSet rs = prst.executeQuery();
        
                
        House house = new House();
        ArrayList<Comment> comments = new ArrayList<Comment>();
        ArrayList<Image> images = new ArrayList<Image>();
        
        while (rs.next()){
            house.setAdName(rs.getString("adName"));
            house.setDescription(rs.getString("description"));

            house.setAdType(rs.getString("adtype"));
            house.setSize(rs.getInt("size"));
            house.setActive(rs.getInt("active"));
            house.setFloor(rs.getInt("floor"));
            house.setStatus(rs.getString("status"));
            house.setType(rs.getString("type"));
            house.setLocation(rs.getString("location"));
            house.setRate(rs.getDouble("rate"));
            house.setCountRate(rs.getInt("countRate"));
            house.setTotalRates(rs.getInt("totalRates"));
            house.setPrice(rs.getDouble("price"));
            comments = commentIO.selectAllComments(houseID);
            images = imageIO.selectImages(houseID);
            house.setHouseID(houseID);
            house.setComments(comments);
            house.setImages(images);

        }
            
        prst.close();
        conn.close();
        
        return house;
    }
    
}
