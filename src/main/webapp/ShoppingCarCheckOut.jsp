<%-- 
    Document   : ShoppingCar
    Created on : 2013/10/1, 下午 04:42:44
    Author     : Amy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <c:import url="BookStoreHyperLink.jsp"></c:import>
         <table border="1">
              <tr>
                <th>ID</th>
              <th>書名</th>
                <th>作者</th>
                <th>出版社</th>
                <th>價格</th> 
                <th>數量</th> 
                <th>金額</th>
            </tr>
         <c:forEach var="order" items="${orderMap}">
        <tr>
        <th>${order.key.book_ID}</th>
          <th>${order.key.book_Name}</th>
          <th>${order.key.book_Author}</th>
         <th>${order.key.book_Publisher}</th>
         <th>${order.key.book_Price}</th>
         <th>${order.value}</th>
         <th>${order.key.book_Price*order.value}</th>
         </tr>
         </c:forEach>
         <tr>
             <th>總金</th>
             <th colspan="6">${total}</th>
         </tr>
    </table>
    </body>
</html>
