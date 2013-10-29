/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.OrderDetail;
import java.util.List;

/**
 *
 * @author base
 */
public interface IOrderDetailDAO {
    public void addOrderDetail(OrderDetail orderDetail);
    public List<OrderDetail> getOrderDetailByID(Integer id);
}
