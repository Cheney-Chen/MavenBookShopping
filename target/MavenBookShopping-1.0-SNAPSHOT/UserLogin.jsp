<%-- 
    Document   : AdminLogin
    Created on : 2013/10/21, 下午 02:19:18
    Author     : base
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ${error}
          <form action="UserLogin.do" method="post">
            <ul>
                <li>ID :<input name="id" value=""/></li>
                <li>Password :<input name="password" type="password" value=""/></li>
                <li><input type="submit" value="Login"/>
                    <input type="reset" value="Abort"/></li>
            </ul>
        </form>
    </body>
</html>
