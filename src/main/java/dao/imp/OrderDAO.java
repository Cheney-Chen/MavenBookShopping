/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.imp;

import dao.IOrderDAO;
import domain.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author base
 */
public class OrderDAO implements IOrderDAO{
final private DataSource dataSource;


    public OrderDAO(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
   synchronized public void addOrder(final Order order) {
         Connection conn = null;
        PreparedStatement stmt = null;
       
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement("INSERT INTO \"ORDER\" (ORDER_DATE,USER_ID) VALUES(?,?)");
            stmt.setTimestamp(1,new Timestamp(new Date().getTime()));
            stmt.setString(2, order.getUser_ID());
            stmt.executeUpdate();
        } catch (SQLException ex1) {
            throw new RuntimeException(ex1);
        } finally {
              if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex1) {
                    Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex1);
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

    @Override
    public Order getOrderByID(final Integer id) {
         Connection conn = null;
        PreparedStatement stmt=null;
         Order order=null;
         ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement("SELECT ORDER_ID, ORDER_DATE, USER_ID FROM  \"ORDER\" WHERE ORDER_ID=?");
            stmt.setInt(1, id);
           rs = stmt.executeQuery();
while(rs.next()){//必須要有游標next才取的到值
             order = new Order(rs.getInt("ORDER_ID"),rs.getTimestamp("ORDER_DATE"),rs.getString("USER_ID"));
}
        } catch (SQLException ex1) {
            throw new RuntimeException(ex1);
        } finally {
              if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex1) {
                    Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
               if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex1) {
                    Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex1);
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
        return order;
    }

    @Override
    public int getOrder_IDByUser_IDandMaxDate(String userID) {
        Connection conn = null;
        PreparedStatement stmt=null;
         int order_ID=0;
         ResultSet rs = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement("SELECT ORDER_ID FROM  \"ORDER\" WHERE USER_ID=? AND ORDER_DATE=(select max(ORDER_DATE) from \"ORDER\")");
         stmt.setString(1, userID);
           rs = stmt.executeQuery();
while(rs.next()){//必須要有游標next才取的到值
           order_ID=rs.getInt("ORDER_ID");
}
        } catch (SQLException ex1) {
            throw new RuntimeException(ex1);
        } finally {
              if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex1) {
                    Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
               if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex1) {
                    Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex1);
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
        return order_ID;
    }

   
    
    
    
    
    
}
