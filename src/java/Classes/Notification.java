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
public class Notification {
    // read 0 or 1
    private int read;
    private String content;
    private String link;

    public Notification(int read, String content, String link) {
        this.read = read;
        this.content = content;
        this.link = link;
    }

    public void setRead(int read) {
        this.read = read;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getRead() {
        return read;
    }

    public String getContent() {
        return content;
    }

    public String getLink() {
        return link;
    }

    
}
