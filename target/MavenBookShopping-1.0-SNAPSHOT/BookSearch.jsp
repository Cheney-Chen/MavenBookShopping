<%-- 
    Document   : BookSearch
    Created on : 2013/10/24, 下午 05:26:44
    Author     : base
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Page</title>
        <script>
             function checkNaN(obj){
                if(isNaN(obj.value)||obj.value===""){
                    obj.value="請輸入數字";
                    obj.select();
                    return false;
                }
                return true;
            }
            
        </script>
    </head>
    <body>
        <h1>Search Book</h1>
        <c:import url="AdminHyperRef.jsp"></c:import>
        <form action="BookSearchShow.view" method="post" >
            <ul>
                 <li>ID :<input name="id" value=""/></li>
                 <li>Name :<input name="name" value=""/></li>
                <li>Author :<input name="author" value=""/></li>
                <li>Publisher :<input name="publisher" value=""/></li>
                <li>Price :<input name="price" value=""/></li>
                <li><input type="submit" value="search"/><input type="reset" value="Abort"/></li>
            </ul>
        </form>
         <br/>第<c:forEach var="page" items="${pageList}">
             ${page}
                     </c:forEach>頁
        <form action="ShowBookStore.view" method="post" onsubmit="return checkNaN(this.size);">
                <input type="hidden" name="page" value="${page}">
                <input type="text" size="5" name="size" value="${size}">
                <input type="submit" name="pageSubmmit" value="每頁顯示"/>
            </form>
        <table border="1">
              <tr>
                <th>ID</th>
              <th>書名</th>
                <th>作者</th>
                <th>出版社</th>
                <th>價格</th> 
            </tr>
         <c:forEach var="book" items="${bookList}">
        <tr>
        <th>${book.book_ID}</th>
         <th>${book.book_Name}</th>
          <th>${book.book_Author}</th>
           <th>${book.book_Publisher}</th>
            <th>${book.book_Price}</th>
            <th><input type="button" name="button" value="ShowDetail" onclick="window.location.href='ShowBookDetail.view?bookID=${book.book_ID}'"/></th>
        </tr>
        </c:forEach>
        </table>
    </body>
</html>