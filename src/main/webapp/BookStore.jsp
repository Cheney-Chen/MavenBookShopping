<%-- 
    Document   : BookListjsp
    Created on : 2013/9/30, 下午 03:05:37
    Author     : Amy
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
        <title>JSP Page</title>
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
        <c:import url="BookStoreHyperLink.jsp"></c:import>
         <c:if test="${CarSize>'0'}">
            <a href="<c:url value="ShoppingCarShow.do"/>">購物車</a>${CarSize}
        </c:if>
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
                <th>數量</th> 
            </tr>
        <tr>
         <c:forEach var="book" items="${booksPage}">
        <tr>
        <th>${book.book_ID}</th>
         <th>${book.book_Name}</th>
          <th>${book.book_Author}</th>
           <th>${book.book_Publisher}</th>
            <th>${book.book_Price}</th>
        <form action="ShoppingCarBuy.do" method="post">
             <th><input type="text" name="quantity" value="1"></th>
             <input type="hidden" name="id" value="${book.book_ID}">
            <th><input type="submit" name="Submmit" value="加入購物車"/></th>
        </form>
        </tr>
        </c:forEach>
        </table>
       
    </body>
</html>
