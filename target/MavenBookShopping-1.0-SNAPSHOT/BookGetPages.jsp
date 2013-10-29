<%-- 
    Document   : BookGetPages
    Created on : 2013/10/25, 下午 04:16:15
    Author     : base
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        第<c:forEach var="page" items="${pagesList}">
             ${page}
                     </c:forEach>頁
                     <form action="BookGetPages.view" method="post">
              <input type="hidden" name="page" value="${page}">
                <input type="text" size="5" name="size" value="${size}">
                <input type="submit" name="pageSubmmit" value="每頁顯示"/>
            </form>
              
    </body>
</html>
