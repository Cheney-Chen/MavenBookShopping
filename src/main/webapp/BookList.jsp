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
        <c:import url="AdminHyperRef.jsp"></c:import>
       <br/>第<c:forEach var="page" items="${pageList}">
             ${page}
                     </c:forEach>頁
        <form action="ShowBookList.view" method="post" onsubmit="return checkNaN(this.size);">
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
         <c:forEach var="book" items="${bookSet}">
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
