package web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(
        urlPatterns = {"/ShowBookList.view", "/BookAdd.jsp"}, //"/user_pratice.jsp",
        initParams = {
    @WebInitParam(name = "Admin", value = "AdminLogin.jsp")
 
})
public class AdminLoginFilter implements Filter {

    private String AdminLogin_View;
 
    @Override
    public void init(FilterConfig config) throws ServletException {
        this.AdminLogin_View = config.getInitParameter("Admin");
       
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
      
         if (req.getSession().getAttribute("adminLogin") != null) {
            chain.doFilter(request, response);
        } else {
           resp.sendRedirect(AdminLogin_View);
        }
    }

    @Override
    public void destroy() {
    }
}
