/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IOrderDAO;
import dao.IOrderDetailDAO;
import domain.Order;
import domain.OrderDetail;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author base
 */
public class OrderService {
    private IOrderDAO orderDAO;
      private IOrderDetailDAO orderDetailDAO;

    public OrderService(IOrderDAO orderDAO, IOrderDetailDAO orderDetailDAO) {
        this.orderDAO = orderDAO;
        this.orderDetailDAO = orderDetailDAO;
    }

   
    
    public void addOrder(Order order){
    orderDAO.addOrder(order);
    }
     public void addOrderDetail(List<OrderDetail> orderDetail){
         for(OrderDetail detail:orderDetail){
    orderDetailDAO.addOrderDetail(detail);
     }
    }
     public Map<Order,List<OrderDetail>> getOrderByID(Integer id){
         Map<Order,List<OrderDetail> >OrderMap =new HashMap<>();
         OrderMap.put(orderDAO.getOrderByID(id), orderDetailDAO.getOrderDetailByID(id));
        return OrderMap;
         
     }
    public int getOrder_IDByUser_IDandMaxDate(String userID){
    return orderDAO.getOrder_IDByUser_IDandMaxDate(userID);
    }
    
}
