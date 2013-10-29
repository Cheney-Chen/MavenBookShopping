package dao.imp;

import java.io.Serializable;import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;

public class DatabaseBean implements Serializable {
    private String jdbcUrl;
    private String user;
    private String password;
    

//    public DatabaseBean() {
//        try {
//            Context initContext = new InitialContext();
//            Context envContext = (Context)
//                           initContext.lookup("java:/comp/env");
//            dataSource = (DataSource) envContext.lookup("jdbc/demo");
//        } catch (NamingException ex) {
//            throw new RuntimeException(ex);
//        }
//
//    }
public Connection dataSource(){
 
        try {
            return DriverManager.getConnection(jdbcUrl,user,password);
                
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
}
    
    
    public boolean isConnectedOK() {
        boolean ok = false;
        Connection conn = null;
        SQLException ex = null;
        try {
            conn = DriverManager.getConnection(jdbcUrl,user,password);
            if (!conn.isClosed()) {
                ok = true;
            }
        } catch (SQLException e) {
            ex = e;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    if(ex == null) {
                        ex = e;
                    }
                }
            }
            if(ex != null) {
                throw new RuntimeException(ex);
            }
        }
        return ok;
    }
}
