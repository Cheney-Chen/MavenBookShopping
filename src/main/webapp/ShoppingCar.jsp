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
         <a href="ShoppingCarClear.do">clear</a>
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
         <c:forEach var="book" items="${shoppingCar.shoppingCarMap}">
        <tr>
        <th>${book.key.book_ID}</th>
         <th>${book.key.book_Name}</th>
          <th>${book.key.book_Author}</th>
           <th>${book.key.book_Publisher}</th>
            <th>${book.key.book_Price}</th>
         <th>${book.value}</th>
          <th>${book.key.book_Price*book.value}</th>
        
            <th><input type="button" name="button" value="移除" onclick="window.location.href='ShoppingCarDelete.do?bookID=${book.key.book_ID}'"/></th>
       
         </tr>
         </c:forEach>
         <tr>
         <th>總金</th>
         <th colspan="7"> ${total}</th>
         </tr>
    </table>
        <input type="button" name="button" value="結帳" onclick="window.location.href='ShoppingCarCheckOut.do'"/>
    </body>
</html>
