/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;

/**
 *
 * @author lenovo
 */
public class Comment {
    private String comment;
    private User user;
    private Date date;
    public Comment(String comm, User u, Date dt)
    {
        comment = comm;
        user = u;
        date = dt;
    }
    
    public void setcomment(String comm)
    {
        comment = comm;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public String getcomment()
    {
        return comment;
    }

    public User getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }
    
}
