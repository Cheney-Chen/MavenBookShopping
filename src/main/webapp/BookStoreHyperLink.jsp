<%-- 
    Document   : HyperLink
    Created on : 2013/10/2, 下午 05:12:56
    Author     : Amy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       ${userLogin} <a href="<c:url value="ShowBookStore.view"/>">Store</a>|<a href="index.jsp">index</a>
    </body>
</html>
