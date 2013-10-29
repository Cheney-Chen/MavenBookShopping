/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Order;

/**
 *
 * @author base
 */
public interface IOrderDAO {
    public void addOrder(Order order);
    public Order getOrderByID(Integer id);
    public int getOrder_IDByUser_IDandMaxDate(String userID);
    
}
