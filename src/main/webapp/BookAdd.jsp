<%-- 
    Document   : index
    Created on : 2013/9/29, 下午 10:43:38
    Author     : Amy
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
        <h1>Add Book</h1>
        <c:import url="AdminHyperRef.jsp"></c:import>
        <form action="addBook.do" method="post" onsubmit="return checkNaN(this.price)">
            <ul>
                <li>Name :<input name="name" value=""/></li>
                <li>Author :<input name="author" value=""/></li>
                <li>Publisher :<input name="publisher" value=""/></li>
                <li>Price :<input name="price" value=""/></li>
                <li><input type="submit" value="Add"/><input type="reset" value="Abort"/></li>
            </ul>
        </form>
    </body>
</html>