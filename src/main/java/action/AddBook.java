/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import domain.Book;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.BookService;

/**
 *
 * @author Amy
 */
public class AddBook extends HttpServlet {

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


        request.setCharacterEncoding("UTF-8");//設定請求為UTF8編碼
//          Set<Book> bookStore=(Set<Book>) getServletContext().getAttribute("bookStore");
//         id=bookService.runBookID();//Service產生ID
        String name = request.getParameter("name");//取name
        String author = request.getParameter("author");//取author
        String publisher = request.getParameter("publisher");//取publisher
        String price = request.getParameter("price");//取price

        Book book = new Book(name, author, publisher, Integer.parseInt(price));//設定book參數
        BookService bookService = (BookService) getServletContext().getAttribute("bookService");//呼叫service
        bookService.addBook(book);//Service加入book到後端

//        BookStore bookStore = (BookStore) getServletContext().getAttribute("bookStore");//呼叫store
//        BookStoreService bookStoreService = (BookStoreService) getServletContext().getAttribute("bookStoreService"); //呼叫service
        
//        if(bookStoreService.isBookExisted(book)){//驗證是否有加入至db
//        bookStoreService.addToBookStore(book, bookStore.getBookStore());//加入application
//       }
       
        response.sendRedirect("ShowBookList.view");//轉發到列表頁面

//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet AddBook</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet AddBook at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        } finally {    
//            out.println(id);
//            out.close();
//        }
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
