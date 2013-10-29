/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.imp;

import dao.IOrderDetailDAO;
import domain.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author base
 */
public class OrderDetailDAO implements IOrderDetailDAO{
final private DataSource dataSource;

    public OrderDetailDAO(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    
    @Override
  synchronized  public void addOrderDetail(final OrderDetail orderDetail) {
                 Connection conn = null;
        PreparedStatement stmt = null;
       
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement("INSERT INTO ORDERDETAIL(ORDER_ID,BOOK_ID,ORDERDETAIL_AMOUNT) VALUES(?,?,?)");
            stmt.setInt(1, orderDetail.getOrder_ID());
            stmt.setInt(2, orderDetail.getBook_ID());
            stmt.setInt(3, orderDetail.getOrderDetail_Amount());
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
    public List<OrderDetail> getOrderDetailByID(final Integer id) {
          Connection conn = null;
        PreparedStatement stmt=null;
        List<OrderDetail> OrderDetailList=new ArrayList<>();
        ResultSet rs =null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement("SELECT ORDER_ID,BOOK_ID,ORDERDETAIL_AMOUNT FROM ORDERDETAIL WHERE ORDER_ID=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
while(rs.next()){//必須要有游標next才取的到值
             OrderDetailList.add( new OrderDetail(rs.getInt("ORDER_ID"),rs.getInt("BOOK_ID"),rs.getInt("ORDERDETAIL_AMOUNT")));
             
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
        return OrderDetailList;
    }
    }
    
