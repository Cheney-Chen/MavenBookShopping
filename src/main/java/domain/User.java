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
public class User implements Serializable{
    
    private String user_ID;
    private String user_Password;
    private Date user_Date;

    public User(String user_ID, String user_Password, Date user_Date) {
        this.user_ID = user_ID;
        this.user_Password = user_Password;
        this.user_Date = user_Date;
    }

    public User(String user_ID, String user_Password) {
        this.user_ID = user_ID;
        this.user_Password = user_Password;
    }

    /**
     * Get the value of user_Date
     *
     * @return the value of user_Date
     */
    public Date getUser_Date() {
        return user_Date;
    }

    /**
     * Set the value of user_Date
     *
     * @param user_Date new value of user_Date
     */
    public void setUser_Date(Date user_Date) {
        this.user_Date = user_Date;
    }

    /**
     * Get the value of user_Password
     *
     * @return the value of user_Password
     */
    public String getUser_Password() {
        return user_Password;
    }

    /**
     * Set the value of user_Password
     *
     * @param user_Password new value of user_Password
     */
    public void setUser_Password(String user_Password) {
        this.user_Password = user_Password;
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

}
