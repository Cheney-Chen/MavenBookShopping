/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import domain.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.BookService;

/**
 *
 * @author base
 */
public class BookGetPages extends HttpServlet {

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
        String url = (String) request.getSession().getAttribute("bookListUrl");
        BookService bookService = (BookService) getServletContext().getAttribute("bookService");//呼叫service

        int booksCount = bookService.getBooksCount();//取得book總數
        int size = 10;
        int page = 1;//此變數名稱固定在getBooksPages()方法裡

        if (request.getParameter("size") != null && request.getParameter("page") != null) {//檢查目前page,size
            page = Integer.parseInt(request.getParameter("page"));
            size = Integer.parseInt(request.getParameter("size"));
        } else if (request.getSession().getAttribute("page") != null && request.getSession().getAttribute("size") != null) {
            page = (int) request.getSession().getAttribute("page");//從session找page,size
            size = (int) request.getSession().getAttribute("size");
        }
         request.getSession().setAttribute("page", page);
        request.getSession().setAttribute("size", size);

        List<StringBuilder> pagesList = new ArrayList<>();

        for (int i = 1; i <= Math.ceil(booksCount / (double) size); i++) {
            pagesList.add(new StringBuilder("<a href='").append(url).append("?page=").append(i).append("&size=").append(size).append("'>").append(i).append("</a>"));
        }
        request.setAttribute("pagesList", pagesList);
        
         Set<Book> bookSet = bookService.getAllBook(Math.min(page, pagesList.size()), size);//根據page與size查找資料庫book,page不超過size
//               request.getSession().setAttribute("page", page);
//          request.getSession().setAttribute("size", size);
        request.getSession().setAttribute("bookSet", bookSet);//反正每次都要查新的,不用活太久
        
        request.getRequestDispatcher("BookGetPages.jsp").forward(request, response);
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
