/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Book;
import java.util.Map;

/**
 *
 * @author base
 */
public class ShoppingCarService {
    public Integer getTotalPay(Map<Book,Integer> shoppingCar){
         int total=0;
        for(Book element:shoppingCar.keySet()){
         total+= element.getBook_Price()*shoppingCar.get(element);
          }
        return total;
    }
    
    public Integer CountTotal(Map<?,Integer> shoppingCar){
         int num = 0;
        for(int element:shoppingCar.values()){//所有書數量總和
        num+=element;
        }
        return num;
    }
    
    public void addToShoppingCar(Book book,Integer quantity,Map<Book,Integer>shoppingCar){
      if (shoppingCar.containsKey(book)) {//若session裡有同book
            shoppingCar.put(book, shoppingCar.get(book) + quantity);//session裡的數量加上quantity
        } else {
            shoppingCar.put(book, quantity);//無同book加入session
        }
    }
    public void clearShoppingCar(Map<?,?>shoppingCar){
    shoppingCar.clear();;
    }
    
    
}
