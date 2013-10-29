/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dao.IBookDAO;
import dao.imp.BookDAO;
import domain.Book;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import service.BookService;

/**
 *
 * @author Amy
 */
public class NewClass {
   private static final String driver = "org.apache.derby.jdbc.ClientDriver";
    
    private static final String url="jdbc:derby://localhost:1527/BookShopping";
    
    private static final String user="app";
    
    private static final String password="app";
     private static final  Date time=new Date();;
    public static void main(String[] args) throws IOException, SQLException {
            Connection conn=DriverManager.getConnection(url,user,password);
    
       PreparedStatement stmt = null;
         Set<Book> bookSet = new TreeSet<>();
        String booksCount="";
         ResultSet rs=null;
         float aa=10.0f;
         int bb=10;
        try {
            stmt = conn.prepareStatement("SELECT COUNT(*) FROM BOOK");
            rs = stmt.executeQuery();

            if (rs.next()) {
                   System.out.print(rs.getInt(1)/(double)aa);
            }
        } catch (SQLException ex1) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex1);
        } finally {
            if (conn != null) {
                try {
                  
                    conn.close();
                } catch (SQLException ex1) {
                    Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
        System.out.println(new Timestamp(new Date().getTime()));
}
}