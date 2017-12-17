package Logical_layer;

import Classes.House;
import Classes.User;
import Model.HouseIO;
import Model.UserIO;
import java.sql.SQLException;

import java.util.ArrayList;

/**
 * Created by maryam on 12/10/17.
 */
public class AdminLogic {
    
    
    private ArrayList<House> suspendedHouses;


    public void removeHouse(ArrayList<House> houses, House house) throws ClassNotFoundException, SQLException{

        houses.remove(house);
        HouseIO houseIO = new HouseIO();
        houseIO.deleteHouse(house.getAdName());
        
    }
    
    public void suspendHouse(String adName) throws ClassNotFoundException, SQLException{
        HouseIO houseIO = new HouseIO();
        houseIO.suspendHouse(adName);
    }
    
    public ArrayList <House> selectSuspendedHouses() throws ClassNotFoundException, SQLException{
        
        HouseIO houseIO = new HouseIO();
        ArrayList<House> houses= houseIO.selectSuspendedHouses();
        suspendedHouses = houses;
        return houses;
    }
    
    public ArrayList<User> viewusers() throws ClassNotFoundException, SQLException{
        UserIO userio=new UserIO();
        ArrayList<User> users=new ArrayList<User>();
        users=userio.viewAllusers();
        System.out.println("adminlogic");
        return users;
    }

}
