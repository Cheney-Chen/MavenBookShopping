/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Admin;

/**
 *
 * @author base
 */
public interface IAdminDAO {
    public Admin getAdminByID(String id);
}
