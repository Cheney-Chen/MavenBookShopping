/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IAdminDAO;
import dao.IUserDAO;
import domain.Admin;
import domain.User;

/**
 *
 * @author base
 */
public class UserService {
    private IUserDAO userDAO;

    public UserService(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

  

    public User getUserByID(String id) {
        return userDAO.getUserByID(id);
    }

    public boolean validateUser(String id, String password) {
        if (userDAO.getUserByID(id) != null) {
             return userDAO.getUserByID(id).getUser_Password().equals(password);
        }
       return false;
    }
    
    public void addUser(String id,String password){
    userDAO.addUser(id, password);
    }
    
    public boolean IsUserExist(String id){
    return userDAO.getUserByID(id)!=null;
    }
}
