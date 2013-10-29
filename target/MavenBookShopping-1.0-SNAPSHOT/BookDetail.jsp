<%-- 
    Document   : BookDetail
    Created on : 2013/9/30, 下午 06:13:09
    Author     : Amy
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="AdminHyperRef.jsp"></c:import>
        <table border="1">
            <tr>
                <th>ID</th>
              <th>書名</th>
                <th>作者</th>
                <th>出版社</th>
                <th>價格</th> 
            </tr>
            <tr>
        <th>${Book.book_ID}</th><!--EL中變數兩字都大寫-->
        <th>${Book.book_Name}</th>
        <th>${Book.book_Author}</th>
        <th>${Book.book_Publisher}</th>
        <th>${Book.book_Price}</th>
            </tr>
        </table>
    </body>
</html>
