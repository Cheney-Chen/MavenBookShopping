/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.imp;

/**
 *
 * @author base
 */
import dao.IUserDAO;
import domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class UserDAO implements IUserDAO {

    final private DataSource dataSource;

    public UserDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public User getUserByID(String id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        User user = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement("SELECT USER_ID,USER_PASSWORD,USER_DATE FROM \"USER\" WHERE USER_ID=?");
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {//必須要有游標next才取的到值
                user = new User(rs.getString("USER_ID"), rs.getString("USER_PASSWORD"), rs.getTimestamp("USER_DATE"));
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
        return user;
    }

    @Override
    public void addUser(String id, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement("INSERT INTO \"USER\" (USER_ID,USER_PASSWORD,USER_DATE) VALUES(?,?,?)");
            stmt.setString(1, id);
            stmt.setString(2, password);
            stmt.setTimestamp(3,new Timestamp(new Date().getTime()));
            stmt.executeUpdate();
        } catch (SQLException ex1) {
            throw new RuntimeException(ex1);
        } finally {
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
    }
}
