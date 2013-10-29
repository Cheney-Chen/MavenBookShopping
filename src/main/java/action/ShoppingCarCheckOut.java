/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import domain.Book;
import domain.Order;
import domain.OrderDetail;
import domain.ShoppingCar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.BookService;
import service.OrderService;

/**
 *
 * @author base
 */
public class ShoppingCarCheckOut extends HttpServlet {

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
        OrderService orderService = (OrderService) getServletContext().getAttribute("orderService");//呼叫service
        BookService bookService = (BookService) getServletContext().getAttribute("bookService");//呼叫service

        
        HttpSession session = request.getSession();
        ShoppingCar shoppingcar = (ShoppingCar) session.getAttribute("shoppingCar");//取session的shoppingcar物件
        Map<Book, Integer> shoppingCarMap = shoppingcar.getShoppingCarMap();//shoppingcar拿屬性
        
        
       String userID=(String) session.getAttribute("userLogin");
        Order order = new Order();//用sessionId作為orderID
        order.setUser_ID((String) session.getAttribute("userLogin"));
        orderService.addOrder(order);
        List<OrderDetail> detailList=new ArrayList<>();
       
        for (Book book : shoppingCarMap.keySet()) {
            detailList.add(new OrderDetail(orderService.getOrder_IDByUser_IDandMaxDate(userID),book.getBook_ID(), shoppingCarMap.get(book)));//sessionid作為detailID放入購物車bookId與數量
        }
          orderService.addOrderDetail(detailList);//order加入後端
        session.invalidate();//清空購物車

        Map<Order, List<OrderDetail>> orderMap = orderService.getOrderByID(orderService.getOrder_IDByUser_IDandMaxDate(userID));//用sessionid從後端拿order
        Map<Book, Integer> finalOrderMap = new HashMap<>();
        int total = 0;
        for (OrderDetail detail : detailList) {//遍歷該訂單的OrderDetail
                finalOrderMap.put(bookService.getBookByID(detail.getBook_ID()), detail.getOrderDetail_Amount());//用bookservice拿到book
                total += bookService.getBookByID(detail.getBook_ID()).getBook_Price() * detail.getOrderDetail_Amount();
        }

        request.setAttribute("orderMap", finalOrderMap); //從後端取得方才購物車資訊傳給頁面
        request.setAttribute("total", total);//總金額給頁面
        request.getRequestDispatcher("ShoppingCarCheckOut.jsp").forward(request, response);
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
//            for (Book element : shoppingCarMap.keySet()) {
//                orderDetail = new OrderDetail(session.getId(), element.getID(), shoppingCarMap.get(element));
//
//                out.println("<h1>Servlet ShowBookList at " + orderDetail.getID() +","+ orderDetail.getBookID()+","+ orderDetail.getAmount()+ "</h1>");
//            }
//            out.println("</body>");
//            out.println("</html>");
//        } finally {
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
