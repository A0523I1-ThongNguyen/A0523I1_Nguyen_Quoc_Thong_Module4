<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thong
  Date: 03/01/2024
  Time: 8:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/car/showViewCreate">Show View Create</a>
<h1>List Car</h1>
<table border="2px soild ">

    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Brand</th>
        <th>Price</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${listCar}" var="e">
        <tr>
            <td>${e.getId()}</td>
            <td>${e.name}</td>

            <td>
                <c:forEach items="${e.brand}" var="object">
                    <span>${object}</span>
                </c:forEach>
            </td>
            <td>${e.price}</td>

            <td>
<%--                <a href="/service/edit?id=${mail.getId()}">EDIT</a>--%>
<%--                <a href="/car/showViewCreate?id=${e.getId()}">Delete</a>--%>
                <form action="/car/delete?id=${e.getId()}" method="post">
                    <button>Xoa</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<p>${flash}</p>
</body>
</html>
