/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author base
 */
public class Order implements Serializable{
    
    private Integer order_ID;
    private Date order_Date;
    private String user_ID;

    public Order(Integer order_ID, Date order_Date, String user_ID) {
        this.order_ID = order_ID;
        this.order_Date = order_Date;
        this.user_ID = user_ID;
    }

    /**
     * Get the value of user_ID
     *
     * @return the value of user_ID
     */
    public String getUser_ID() {
        return user_ID;
    }

    /**
     * Set the value of user_ID
     *
     * @param user_ID new value of user_ID
     */
    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }

    public Order(Integer ID) {
        this.order_ID = ID;
    }

    public Order() {
       
    }

    /**
     * Get the value of time
     *
     * @return the value of time
     */
    public Integer getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(Integer order_ID) {
        this.order_ID = order_ID;
    }

    public Date getOrder_Date() {
        return order_Date;
    }

    public void setOrder_Date(Date order_Date) {
        this.order_Date = order_Date;
    }

  
}
