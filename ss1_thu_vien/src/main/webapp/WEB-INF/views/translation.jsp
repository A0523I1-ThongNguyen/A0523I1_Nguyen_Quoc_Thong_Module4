<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thong
  Date: 29/12/2023
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lib</title>
</head>
<style>
    span{
        color: red;
    }
</style>
<body>
<form action="/lib/tran" method="post">
    <table>
        <tr>
            <td>Choose Language</td>
            <td><input type="radio" name="e" value="english">Viet-Anh</td>
            <td><input type="radio" name="e" value="vn">Anh-Viet</td>
        </tr>
        <tr>
            <td>Enter word to tran</td>
            <td><input type="text" name="word"></td>
            <td><button type="submit">Dich</button></td>
        </tr>
    </table>
</form>

<p>  <span>Result :<c:out value="${result}"/></span>  </p>
<p>  <span>Find :<c:out value="${find}"/></span> </p>

<%--<input type="text" name="result" value="${result}"  />--%>
</body>
</html>
