<%-- 
    Document   : UserRegister
    Created on : 2013/10/24, 上午 08:53:51
    Author     : base
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <h1>Register</h1>
        <c:import url="BookStoreHyperLink.jsp"></c:import>
        <form action="UserRegister.do" method="post" >
            <ul>
                <li>ID :<input name="id" value=""/></li>
                <li>password :<input name="password" value=""/></li>
                <li><input type="submit" value="register"/><input type="reset" value="Abort"/></li>
            </ul>
        </form>
    </body>
</html>
