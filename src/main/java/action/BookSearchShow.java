/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import domain.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.BookService;

/**
 *
 * @author base
 */
public class BookSearchShow extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id = (request.getParameter("id") != "") ? Integer.parseInt(request.getParameter("id")) : 0;
        String name = "%".concat(request.getParameter("name")).concat("%");
        String author = "%".concat(request.getParameter("author")).concat("%");//取author
        String publisher = "%".concat(request.getParameter("publisher")).concat("%");//取publisher
        int price = (request.getParameter("price") != "") ? Integer.parseInt(request.getParameter("price")) : 0;//取price

        BookService bookService = (BookService) getServletContext().getAttribute("bookService");
        List<Book> bookList = bookService.searchBook(new Book(id, name, author, publisher, price));
        request.setAttribute("bookList", bookList);
        request.getRequestDispatcher("BookSearch.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
