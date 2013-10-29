/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IBookDAO;
import domain.Book;
import java.util.Set;

/**
 *
 * @author base
 */
public class BookStoreService {
     private IBookDAO bookDAO;

    public BookStoreService() {
    }

    public BookStoreService(IBookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
     
    public boolean isBookExisted(Book book){
         return bookDAO.isBookExisted(book);
    }
     public void readyBookStore(){

     }
             
             
    public void addToBookStore(Book book,Set<Book> bookStore){
      book.setBook_ID(bookStore.size()+1);
        bookStore.add(book);
    }
    
}
