/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ami.web.core.models;

/**
 *
 * @author Jonathan Perry
 */
public class Temperature {

    private int value;
    private String date;
    private String time;
    
    public Temperature() {
        
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public String getDate() {
        return date;
    }
    
    public void setTime(String time) {
        this.time = time;
    }
    
    public String getTime() {
        return time;
    }
    
    
}
