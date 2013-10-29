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
public class ShowBookDetail extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("bookID"));//取id
//        String name = request.getParameter("name");//取name
//        String author = request.getParameter("author");//取author
//        String publisher = request.getParameter("publisher");//取publisher
//        int price = Integer.parseInt(request.getParameter("price"));//取price
//        Book book = new Book(id, name, author, publisher, price);//設定book參數
         BookService bookService=(BookService) getServletContext().getAttribute("bookService");
//       Set<Book> bookStore=(Set<Book>) getServletContext().getAttribute("bookStore");
//      for(Book element:bookStore){
//      if(id==element.getID()){
//          book=element;
//              }
//      }
//         Book book = bookService.getBookByID(id);//bookService取得book
//         Gson gson  = new Gson();
//         String Result = gson.toJson(book); 
//         booksPrint="<th>"+book.getID()+"</th>"
//                 +"<th>"+book.getName()+"</th>"
//                 +"<th>"+book.getAuthor()+"</th>"
//                 +"<th>"+book.getPublisher()+"</th>"
//                 +"<th>"+book.getPrice()+"</th>";
//       String Result = gson.toJson(booksPrint);            

//		       try {  
//		    	  	   PrintWriter out = response.getWriter();  
//		    	  	   out.print(Result);
//		    	   	   out.close();  
//                                   
//		    	   	  } catch (IOException e) {  
//		    	   		System.out.println( e);   
//		    	   	  }  
        request.setAttribute("Book", bookService.getBookByID(id));//book給頁面
        request.getRequestDispatcher("BookDetail.jsp").forward(request, response);
//                     response.sendRedirect("BookDetail.jsp");

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
