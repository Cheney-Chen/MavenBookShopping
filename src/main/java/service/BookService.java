
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Book;

import dao.IBookDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Amy
 */
public class BookService {

    private IBookDAO bookDAO;

    public BookService(IBookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public BookService() {
    }

    public String runBookID() throws IOException {

        return bookDAO.runBookID();
    }

    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    public Set<Book> getAllBook() throws IOException {

        return bookDAO.getAllBooks();
    }

    public Book getBookByID(Integer id) throws IOException {

        return bookDAO.getBookByID(id);
    }

    public Set<Book> getAllBook(Integer page, Integer size) {

        return bookDAO.getAllBooks(page, size);
    }

    public Integer getBooksCount() {
        return bookDAO.getBooksCount();
    }
 public List<Book> searchBook(Book bookCondition){
    return bookDAO.searchBook(bookCondition);
    }
}
