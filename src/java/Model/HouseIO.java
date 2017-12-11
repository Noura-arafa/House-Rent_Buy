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
        static String password = "";
    

    
    public int getUser(int houseID) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/house_buy_rent";
        String username = "root";
        String password = "12345678a";
        ResultSet RS = null;
        int userID=-1;
        Connection Con =  DriverManager.getConnection(url, username, password);
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
        System.out.println("blabla");
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, sqluser, password);
        UserIO uio = new UserIO();
        int userid = uio.getUserID(user.getuserName()) ;
        int testid = getHouseID(house);
        if (testid != 0)
        {
            System.out.println("exist");
            return ;
        }
        
        String insertQuery = "Insert INTO house "
                + "(description, adtype, size, active, floor, status, type, location, rate, hUserID, adName)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement prst = conn.prepareStatement(insertQuery);
        prst.setString(1, house.getDescription());
        prst.setString(2, house.getAdType());
        prst.setInt(3, house.getSize());
        prst.setInt(4, house.getActive());
        prst.setInt(5, house.getFloor());
        prst.setString(6, house.getStatus());
        prst.setString(7, house.getType());
        prst.setString(8, house.getLocation());
        prst.setDouble(9, house.getRate());

        prst.setInt(10, userid);
        prst.setString(11, house.getAdName());

        prst.executeUpdate();
        
       
       prst.close();
       conn.close();
    }
    public void edit(ArrayList<String> newprop, ArrayList<String> propName, int houseId) throws ClassNotFoundException, SQLException
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
    
    public ResultSet search(boolean rent,String typesearch,String input) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
            Connection Con =DriverManager.getConnection(url, sqluser, password);
            Statement Stmt = Con.createStatement();
             ResultSet RS = null;
        if(rent==true){
            
            if(typesearch=="Area"){
               PreparedStatement statement = Con.prepareStatement("select * FROM house WHERE  size = ? AND adtype = ?");
               int modinput = Integer.parseInt(input);
               statement.setInt(1, modinput);
               statement.setString(2, "rent"); 
               RS = statement.executeQuery();
               
            }
            else if(typesearch=="Floor"){
                PreparedStatement statement = Con.prepareStatement("select * from house where floor = ? AND adtype=?");
                int modinput = Integer.parseInt(input);
                statement.setInt(1, modinput);    
                statement.setString(2, "rent"); 
                RS = statement.executeQuery();
            }
            else if(typesearch=="Status"){
                PreparedStatement statement = Con.prepareStatement("select * from house where status = ? AND adtype=?");
                statement.setString(1, input); 
                statement.setString(2, "rent"); 
                RS = statement.executeQuery();
                }
            else if(typesearch=="Type"){
                PreparedStatement statement = Con.prepareStatement("select * from house where type = ? AND adtype=?");
                statement.setString(1, input);  
                statement.setString(2, "rent"); 
                RS = statement.executeQuery();
            } 
        }
        else{
            if(typesearch=="Area"){
               PreparedStatement statement = Con.prepareStatement("select * from house where size = ? AND adtype=?");
               int modinput = Integer.parseInt(input);
               statement.setInt(1, modinput);  
               statement.setString(2, "sale"); 
               RS = statement.executeQuery();
            }
            else if(typesearch=="Floor"){
                PreparedStatement statement = Con.prepareStatement("select * from house where floor = ? AND adtype=?");
                int modinput = Integer.parseInt(input);
                statement.setInt(1, modinput);  
                statement.setString(2, "sale"); 

                RS = statement.executeQuery();
            }
            else if(typesearch=="Status"){
                PreparedStatement statement = Con.prepareStatement("select * from house where status = ? AND adtype=?");
                statement.setString(1, input);
                               statement.setString(2, "sale"); 

                RS = statement.executeQuery();
            }
            else if(typesearch=="Type"){
                PreparedStatement statement = Con.prepareStatement("select * from house where type = ? AND adtype=?");
                statement.setString(1, input);
                statement.setString(2, "sale"); 

                RS = statement.executeQuery();
            }
        }
        return RS;
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
    
    public void deleteHouse(House house) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, sqluser, password);
        String query = "delete from house where "
                + "(description, adtype, size, active, floor, status, type, location, rate)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
        prst.executeUpdate();

        prst.close();
        conn.close();

    }

    public void updateHouse (House house) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, sqluser, password);
        String query = "update house set "
                + "(description, adtype, size, active, floor, status, type, location, rate)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)"
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

    public ArrayList<House> selectAllHouses () throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, sqluser, password);

        ArrayList<House> houses = new ArrayList<>();
        CommentIO commentIO = new CommentIO();
        ImageIO imageIO = new ImageIO();

        if (conn == null) System.out.println("conn is not working");

        Statement stmt = conn.createStatement();
        String sql = "select houseID, adname, description, adtype, size, active, floor, status, type,"
                + " location, rate, countRate, totalRates, price  from house;";
        ResultSet rs =stmt.executeQuery(sql);
        
        while(rs.next()){
                
            House house = new House();
            ArrayList<Comment> comments = new ArrayList<Comment>();
            ArrayList<Image> images = new ArrayList<Image>();
            int houseID = rs.getInt("houseID");
            house.setAdName(rs.getString("adname"));
            house.setDescription(rs.getString("description"));
            house.setAdType(rs.getString("adtype"));
            house.setSize(rs.getInt("size"));
            house.setActive(rs.getInt("type"));
            house.setFloor(rs.getInt("floor"));
            house.setStatus(rs.getString("status"));
            house.setType(rs.getString("type"));
            house.setLocation(rs.getString("location"));
            house.setRate(rs.getDouble("rate"));
            house.setCountRate(rs.getInt("countRate"));
            house.setTotalRates(rs.getInt("toatRates"));
            house.setPrice(rs.getDouble("price"));
            comments = commentIO.selectAllComments(houseID);
            images = imageIO.selectImages(houseID);
            
            house.setComments(comments);
            house.setImages(images);
            
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

        
        String sql = "select houseID, adname, description, adtype, size, active, floor, status, type,"
                + " location, rate, countRate, totalRates, price  from house where houseId = ?;";

        PreparedStatement prst = conn.prepareStatement(sql);
        prst.setInt(1, houseID);
        ResultSet rs = prst.executeQuery();
        
                
        House house = new House();
        ArrayList<Comment> comments = new ArrayList<Comment>();
        ArrayList<Image> images = new ArrayList<Image>();
        house.setAdName(rs.getString("adname"));
        house.setDescription(rs.getString("description"));
        house.setAdType(rs.getString("adtype"));
        house.setSize(rs.getInt("size"));
        house.setActive(rs.getInt("type"));
        house.setFloor(rs.getInt("floor"));
        house.setStatus(rs.getString("status"));
        house.setType(rs.getString("type"));
        house.setLocation(rs.getString("location"));
        house.setRate(rs.getDouble("rate"));
        house.setCountRate(rs.getInt("countRate"));
        house.setTotalRates(rs.getInt("toatRates"));
        house.setPrice(rs.getDouble("price"));
        comments = commentIO.selectAllComments(houseID);
        images = imageIO.selectImages(houseID);

        house.setComments(comments);
        house.setImages(images);
            
            
            
        prst.close();
        conn.close();
        
        return house;
    }
    
    
    

}
