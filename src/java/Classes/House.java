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
    // active 0 ot 1 
    private int active;
    private int floor;
    private String status;
    private String type;
    private String location;
    private int rate;
    private ArrayList<Comment> comments;
    private ArrayList<Image> images;

    public House(String description, String adType, int size, int active, int floor, String status, String type, String location, int rate) {
        this.description = description;
        this.adType = adType;
        this.size = size;
        this.active = active;
        this.floor = floor;
        this.status = status;
        this.type = type;
        this.location = location;
        this.rate = rate;
        
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

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setComment(Comment comment) {
        this.comments.add(comment);
    }

    public void setImages(Image image) {
        this.images.add(image);
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

    public int getRate() {
        return rate;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public ArrayList<Image> getImages() {
        return images;
    }
    
    
    
}
