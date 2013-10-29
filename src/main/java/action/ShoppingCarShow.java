/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import domain.ShoppingCar;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.ShoppingCarService;

/**
 *
 * @author Amy
 */
public class ShoppingCarShow extends HttpServlet {

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
//        BookService bookService=(BookService) getServletContext().getAttribute("bookService");//實作service
//      Book book=new Book();//Book物件
//      int total=0;//總金額
      HttpSession session=request.getSession();
//      List<Book> shoppingCarList =(List<Book>) session.getAttribute("shoppingCar");//取session
//       for(Book element:shoppingCarList){
//      total+=element.getPrice();
//      }
     
//      Map<Book,Integer> shoppingCarMap=(Map<Book,Integer>) session.getAttribute("shoppingCar");//呼叫shoppingCar
//      for(Book element:shoppingCarMap.keySet()){
//      total+=element.getPrice()*shoppingCarMap.get(element);
//      }
//      
//      Set<Map.Entry<Book,Integer>> allSet=shoppingCarMap.entrySet();//Set化Map
//   Iterator<Map.Entry<Book,Integer>> iterator=allSet.iterator();//迭代化Set
//      while(iterator.hasNext()){
//          Map.Entry<Book,Integer> temp=iterator.next();//一定要有參考位置才能遍歷
//          total+=temp.getKey().getPrice()*temp.getValue();//book的price相乘session的數量加總
//      }//累加總金額

//      request.setAttribute("total", total);//總金額給頁面
     
       ShoppingCar shoppingcar=(ShoppingCar) session.getAttribute("shoppingCar");//呼叫購物車物件
            ShoppingCarService shoppingCarService=(ShoppingCarService) getServletContext().getAttribute("shoppingCarService");//呼叫service
       request.setAttribute("total", shoppingCarService.getTotalPay(shoppingcar.getShoppingCarMap()));//總金額給頁面
      
      request.getRequestDispatcher("ShoppingCar.jsp").forward(request, response);
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
