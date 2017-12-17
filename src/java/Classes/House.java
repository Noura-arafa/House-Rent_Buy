/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class House {
    private String description;
    private String adType;
    private int size;
    int houseID;

    
    
    //gededa
    int countRate=0;
    //
    
    // active 0 ot 1 
    private int active;
    private int floor;
    private String status;
    private String type;
    private String location;
    private Double rate;
    private int totalRates;
    private String adName;
    private ArrayList<Comment> comments;
    private ArrayList<Image> images;
    private Double price;

    public House(String description, String adType, int size, int active, int floor, String status, String type, String location, Double rate, String adName, Double price) {
        this.description = description;
        this.adType = adType;
        this.size = size;
        this.active = active;
        this.floor = floor;
        this.status = status;
        this.type = type;
        this.location = location;
        this.rate = rate;
        this.adName = adName;
        this.price = price;
    }

    public House() {
    }

    public void setCountRate(int countRate) {
        this.countRate = countRate;
    }
    
    public void setTotalRates(int totalRates){
        this.totalRates = totalRates;
    }
    
    public void setPrice (Double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAdType(String adType) {
        this.adType = adType;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }
    

    public void setComment(Comment comment) {
        this.comments.add(comment);
    }

    public void setImage(Image image) {
        this.images.add(image);
    }
      
    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }
    
    public void setComments(ArrayList<Comment> comments){
        this.comments = comments;
    }
    
    public String getDescription() {
        return description;
    }

    public String getAdType() {
        return adType;
    }

    public int getSize() {
        return size;
    }

    public int getActive() {
        return active;
    }

    public int getFloor() {
        return floor;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public Double getRate() {
        return rate;
    }

    public String getAdName() {
        return adName;
    }
    

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public int getCountRate() {
        return countRate;
    }
    
    public int getTotalRates(){
        return totalRates;
    }
    public Double getPrice(){
        return price;
    }
    
    public Double addRate(Double newRate){
        totalRates+=newRate;
        ++countRate;
        this.rate = totalRates/(countRate*1.0);
        return rate;
    }
    
    public int getHouseID() {
        return houseID;
    }

    public void setHouseID(int houseID) {
        this.houseID = houseID;
    }
    
    
    
    
}
