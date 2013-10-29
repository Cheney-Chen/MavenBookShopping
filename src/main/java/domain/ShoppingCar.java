/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author base
 */
public class ShoppingCar {

    private Map<Book, Integer> shoppingCarMap = new TreeMap<>();
    private Integer total;

    /**
     * Get the value of total
     *
     * @return the value of total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * Set the value of total
     *
     * @param total new value of total
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    public ShoppingCar(Map<Book, Integer> shoppingCarMap) {
        this.shoppingCarMap = shoppingCarMap;
    }

    public ShoppingCar() {
    }

    public Map<Book, Integer> getShoppingCarMap() {
        return shoppingCarMap;
    }

    public void setShoppingCarMap(Map<Book, Integer> shoppingCarMap) {
        this.shoppingCarMap = shoppingCarMap;
    }
}
