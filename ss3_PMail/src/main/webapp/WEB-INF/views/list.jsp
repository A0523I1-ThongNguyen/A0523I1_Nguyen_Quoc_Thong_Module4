<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thong
  Date: 06/01/2024
  Time: 12:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/email/viewcreate">Create</a>
<table border="2px soild">
    <tr>
        <td>ID</td>
        <td>Language</td>
        <td>Size</td>
        <td>Spam</td>
        <td>signature</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>

    <c:forEach items="${listEmail}" var="e" varStatus="loop">
        <tr>
            <td>${e.id}</td>
            <td>
                <c:forEach items="${e.langueges}" var="lang">
                    <span><c:out value="${lang}"/>  </span>
                </c:forEach>
            </td>
            <td>
                <c:forEach items="${e.size}" var="size">
                    <span><c:out value="size"/> </span>
                </c:forEach>
            </td>

            <td>${e.spam}</td>

            <td>${e.signature}</td>

            <td>
                <a href="/email/getedit?id=${e.getId()}">EDIT</a>
            </td>
            <td>
                <form action="/email/delete?id=${e.getId()}" method="post">
                    <button>Xoa</button>
                </form>
            </td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
