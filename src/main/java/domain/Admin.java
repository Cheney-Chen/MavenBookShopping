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
public class Admin implements Serializable{
    
    private String admin_ID;
    private String admin_Password;
    private Date admin_Date;

    /**
     * Get the value of admin_Date
     *
     * @return the value of admin_Date
     */
    public Admin(String admin_ID, String admin_Password) {
        this.admin_ID = admin_ID;
        this.admin_Password = admin_Password;
    }

    public Admin(String admin_ID, String admin_Password, Date admin_Date) {
        this.admin_ID = admin_ID;
        this.admin_Password = admin_Password;
        this.admin_Date = admin_Date;
    }

    
    
    public Date getAdmin_Date() {
        return admin_Date;
    }

    /**
     * Set the value of admin_Date
     *
     * @param admin_Date new value of admin_Date
     */
    public void setAdmin_Date(Date admin_Date) {
        this.admin_Date = admin_Date;
    }

    /**
     * Get the value of admin_Password
     *
     * @return the value of admin_Password
     */
    public String getAdmin_Password() {
        return admin_Password;
    }

    /**
     * Set the value of admin_Password
     *
     * @param admin_Password new value of admin_Password
     */
    public void setAdmin_Password(String admin_Password) {
        this.admin_Password = admin_Password;
    }

    /**
     * Get the value of admin_ID
     *
     * @return the value of admin_ID
     */
    public String getAdmin_ID() {
        return admin_ID;
    }

    /**
     * Set the value of admin_ID
     *
     * @param admin_ID new value of admin_ID
     */
    public void setAdmin_ID(String admin_ID) {
        this.admin_ID = admin_ID;
    }

}
