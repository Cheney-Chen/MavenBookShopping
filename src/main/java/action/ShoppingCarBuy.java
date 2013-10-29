/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import domain.Book;
import domain.ShoppingCar;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.BookService;
import service.ShoppingCarService;

/**
 *
 * @author Amy
 */
public class ShoppingCarBuy extends HttpServlet {

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

        int id = Integer.parseInt(request.getParameter("id"));//取id
        int quantity = Integer.parseInt(request.getParameter("quantity"));//取quantity


        BookService bookService = (BookService) getServletContext().getAttribute("bookService");
        HttpSession session = request.getSession();
//        List<Book> shoppingCarList =(List<Book>) session.getAttribute("shoppingCar");//取session
//        for(int i=0;i<quantity;i++){
//        shoppingCarList.add(new Book(id,name,author,publisher,Integer.parseInt(price)));
//        }          
        ShoppingCar shoppingcar = (ShoppingCar) session.getAttribute("shoppingCar");//呼叫購物車
        ShoppingCarService shoppingCarService = (ShoppingCarService) getServletContext().getAttribute("shoppingCarService");//呼叫service
        shoppingCarService.addToShoppingCar(bookService.getBookByID(id), quantity, shoppingcar.getShoppingCarMap());//加入購物車
//        Map<Book, Integer> shoppingCarMap = (Map<Book, Integer>) session.getAttribute("shoppingCar");//取session
//        if (shoppingCarMap.containsKey(book)) {//若session裡有同book
//            int num = shoppingCarMap.get(book) + quantity;//session裡的數量加上quantity
//            shoppingCarMap.put(book, num);
//        } else {
//            shoppingCarMap.put(book, quantity);//無同book加入session
//        }

        request.getRequestDispatcher(response.encodeURL("ShowBookStore.view")).forward(request, response);//回列表
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
