/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.imp.AdminDAO;
import dao.imp.BookDAO;
import dao.imp.OrderDAO;
import dao.imp.OrderDetailDAO;
import dao.imp.UserDAO;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import service.AdminService;
import service.BookService;
import service.OrderService;
import service.ShoppingCarService;
import service.UserService;

/**
 *
 * @author base
 */
@WebListener//必要
public class BookShoppingListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent contextEvent) {
        try {
            //環境命名environment naming context（ENC）
            DataSource dataSource = InitialContext.doLookup("java:comp/env/jdbc/bookShopping");//database在webxml的url,建立datasource
            contextEvent.getServletContext().setAttribute("bookService", new BookService(new BookDAO(dataSource)));//appliction放入service裡interface要實作的類別與datasource（透過建構子）
//           contextEvent.getServletContext().setAttribute("bookStore",new BookStore(new BookService(new BookDAO(dataSource)).getAllBook()));//放入bookStore
//           contextEvent.getServletContext().setAttribute("bookStoreService",new BookStoreService(new BookDAO(dataSource)));
            contextEvent.getServletContext().setAttribute("shoppingCarService", new ShoppingCarService());
            contextEvent.getServletContext().setAttribute("orderService", new OrderService(new OrderDAO(dataSource), new OrderDetailDAO(dataSource)));
            contextEvent.getServletContext().setAttribute("adminService", new AdminService(new AdminDAO(dataSource)));
            contextEvent.getServletContext().setAttribute("userService", new UserService(new UserDAO(dataSource)));
        } catch (NamingException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
}
