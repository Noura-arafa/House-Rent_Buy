/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author lenovo
 */
public class Interest {
    private String type;
    private int size;
    private String status;

    public Interest(String type, int size, String status) {
        this.type = type;
        this.size = size;
        this.status = status;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public String getStatus() {
        return status;
    }
    
}
