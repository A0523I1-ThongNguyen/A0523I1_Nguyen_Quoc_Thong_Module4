<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: thanhngan
  Date: 9/26/2023
  Time: 6:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        table,tr,td{
            border: 1px solid;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <td>Id</td>
        <td>Languages</td>
        <td>Size</td>
        <td>Spams_Fillter</td>
        <td>signature</td>
        <td>edit</td>
    </tr>
    <c:forEach items="${mailList}" var="mail" varStatus="loop">
        <tr>
            <td>${mail.getId()}</td>
            <td>
                <c:forEach items="${mail.getLanguages()}" var="lan">
                <span><c:out value="${lan}"/></span>
                </c:forEach>
            <td>
                <c:forEach items="${mail.getSize()}" var="sizeOf">
                    <span><c:out value="${sizeOf}"/></span>
                </c:forEach>
            </td>
            <td>${mail.getSpams_Fillter()}</td>
            <td>

                <c:forEach items="${mail.getSignature()}" var="signa">
                    <span><c:out value="${signa}"/></span>

                </c:forEach>
            </td>
            <td><a href="/service/edit?id=${mail.getId()}">EDIT</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
