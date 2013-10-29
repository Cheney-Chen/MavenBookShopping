/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Book;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Amy
 */
public interface IBookDAO {
public String runBookID() throws IOException;
    public void addBook(Book book);
    public Set<Book> getAllBooks() ;
    public Book getBookByID(Integer id)throws IOException ;
    public boolean isBookExisted(Book book);
      public Set<Book> getAllBooks(Integer page,Integer size) ;
      public Integer getBooksCount();
      public List<Book> searchBook(Book bookCondition);
}