/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author base
 */
public class BookStore {
    private Set<Book> bookStore=new TreeSet<>();

    public BookStore() {
    }

    public BookStore(Set<Book> bookStore) {
        this.bookStore = bookStore;
    }

    public Set<Book> getBookStore() {
        return bookStore;
    }

    public void setBookStore(Set<Book> bookStore) {
        this.bookStore = bookStore;
    }
    
}
