/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import domain.Book;
import java.io.IOException;
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
 * @author Amy
 */
public class ShowBookList extends HttpServlet {

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
     
        BookService bookService = (BookService) getServletContext().getAttribute("bookService");//呼叫service
        
        int booksCount = bookService.getBooksCount();//取得book總數
        int size = (request.getParameter("size") != null) ? Integer.parseInt(request.getParameter("size")) : 10;//檢查目前page,size
        int page = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1;//此變數名稱固定在getBooksPages()方法裡

        List<StringBuilder> pageList = getBooksPages("ShowBookList.view", booksCount, size);//計算需要頁面且回傳超連結
        Set<Book> bookSet = bookService.getAllBook(Math.min(page, pageList.size()), size);//根據page與size查找資料庫book,page不超過size

        request.setAttribute("page", page);//給頁面目前page
        request.setAttribute("size", size);//給頁面目前size
        request.setAttribute("booksPage", bookSet);//給搜尋結果
        request.setAttribute("pageList", pageList);//給超連結
        request.getRequestDispatcher("BookList.jsp").forward(request, response);
//         BookService bookService=(BookService) getServletContext().getAttribute("bookService");
//       
//         
//
//        request.setAttribute("bookSet", bookService.getAllBook());//List給頁面
//        request.getRequestDispatcher("BookList.jsp").forward(request, response);
//         String Result = gson.toJson(bookList); 
//       String Result = gson.toJson(booksPrint);            

//		       try {  
//		    	  	   PrintWriter out = response.getWriter();  
//		    	  	   out.print(Result);
//		    	   	   out.close();  
//		    	   	  } catch (IOException e) {  
//		    	   		System.out.println(e);   
//		    	   	  }  



//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ShowBookList</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ShowBookList at " +bookSet+ "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        } finally {            
//            out.close();
//        }
       
        
    }
     public List<StringBuilder> getBooksPages(String url, Integer count, Integer size) {//以全部筆數與每頁size計算需要頁數與組出超連結

        List<StringBuilder> pageList = new ArrayList<>();
        for (int i = 1; i <= Math.ceil(count / (double) size); i++) {
            pageList.add(new StringBuilder("<a href='").append(url).append("?page=").append(i).append("&size=").append(size).append("'>").append(i).append("</a>"));
        }
        return pageList;
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
