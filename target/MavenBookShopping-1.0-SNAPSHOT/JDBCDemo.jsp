<%-- 
    Document   : JDBCDemo
    Created on : 2013/10/7, 上午 11:52:41
    Author     : base
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="db" class="dao.imp.DatabaseBean"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
 
    </head>
    
   <body>
        <c:choose>
            <c:when test="${db.connectedOK}">連線成功！</c:when>
            <c:otherwise>連線失敗！</c:otherwise>
        </c:choose>
    </body>
</html>
