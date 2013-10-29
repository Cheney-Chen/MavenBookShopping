/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IAdminDAO;
import domain.Admin;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author base
 */
public class AdminService {

    private IAdminDAO adminDAO;

    public AdminService(IAdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    public Admin getAdminByID(String id) {
        return adminDAO.getAdminByID(id);
    }

    public boolean validateAdmin(String id, String password) {
        if (adminDAO.getAdminByID(id) != null) {
             return adminDAO.getAdminByID(id).getAdmin_Password().equals(password);
        }
       return false;
    }
}
