<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thong
  Date: 29/12/2023
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Conver Money</title>
</head>
<body>
<form action="/convert/money" method="post">
    <tr>
        <td>Choose</td>
        <td><input type="radio" name="e" value="usd">VND > USD</td>
        <td><input type="radio" name="e" value="vnd"> USD > VND</td>
    </tr>

    <tr>

    </tr>

    <tr>
        <td>Convert</td>
        <input type="number" id="money" name="money">
        <td><button type="submit">Chuyen doi</button></td>
    </tr>
</form>
<p>Result: <c:out value="${cd}"/></p>
</body>
</html>
