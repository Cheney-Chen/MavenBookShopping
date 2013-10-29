/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author base
 */
public class OrderDetail implements Serializable{
 
    private Integer order_ID;
    private Integer book_ID;
        private Integer orderDetail_Amount;

    public OrderDetail(Integer ID, Integer bookID, Integer amount) {
        this.order_ID = ID;
        this.book_ID = bookID;
        this.orderDetail_Amount = amount;
    }

    public OrderDetail(Integer book_ID, Integer orderDetail_Amount) {
        this.book_ID = book_ID;
        this.orderDetail_Amount = orderDetail_Amount;
    }

    public OrderDetail() {
    }

    /**
     * Get the value of amount
     *
     * @return the value of amount
     */
    public Integer getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(Integer order_ID) {
        this.order_ID = order_ID;
    }

    public Integer getBook_ID() {
        return book_ID;
    }

    public void setBook_ID(Integer book_ID) {
        this.book_ID = book_ID;
    }

    public Integer getOrderDetail_Amount() {
        return orderDetail_Amount;
    }

    public void setOrderDetail_Amount(Integer orderDetail_amount) {
        this.orderDetail_Amount = orderDetail_amount;
    }

   
   
}
