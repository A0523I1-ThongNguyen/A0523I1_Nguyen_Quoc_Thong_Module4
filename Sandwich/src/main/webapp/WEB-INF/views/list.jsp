<%--
  Created by IntelliJ IDEA.
  User: Thong
  Date: 02/01/2024
  Time: 9:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Sandwich</title>
</head>
<hr>
<form action="/sandwich/post" method="post">
<h1>Sandwich Condiments</h1>
<tr>
  <td>lettuce<input type="checkbox" name="e" value="lettuce"></td>
  <td>tomato<input type="checkbox" name="e" value="tomato"></td>
  <td>mustard<input type="checkbox" name="e" value="mustard"></td>
  <td>sprouts<input type="checkbox" name="e" value="sprouts"></td>
</tr>
  <td>GD<input type="checkbox" name="z" value="GD"></td>
  <td>Sehun<input type="checkbox" name="z" value="Sehun"></td>
  <td>Eunji<input type="checkbox" name="z" value="Eunji"></td>
  <td>Irene<input type="checkbox" name="z" value="Irene"></td>
</hr>
<tr>
  <button type="submit">Save</button>
</tr>
</form>
<c:forEach items="${listSand}" var="item">
  <p><c:out value="${item}"/></p>
</c:forEach>
<c:forEach items="${listIdol}" var="item">
  <p><c:out value="${item}"/></p>
</c:forEach>
</body>
</html>
