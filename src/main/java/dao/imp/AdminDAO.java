/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.imp;

import dao.IAdminDAO;
import domain.Admin;
import domain.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author base
 */
public class AdminDAO implements IAdminDAO{
 final private DataSource dataSource;

    public AdminDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
 
 
    @Override
    public Admin getAdminByID(String id) {
         Connection conn = null;
        PreparedStatement stmt = null;
        Admin admin = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement("SELECT ADMIN_ID,ADMIN_PASSWORD,ADMIN_DATE FROM ADMIN WHERE ADMIN_ID=?");
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {//必須要有游標next才取的到值
                admin = new Admin(rs.getString("ADMIN_ID"), rs.getString("ADMIN_PASSWORD"),rs.getTimestamp("ADMIN_DATE"));
            }
        } catch (SQLException ex1) {
            throw new RuntimeException(ex1);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex1) {
                    Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }

        }
        return admin;
    }
    
}
