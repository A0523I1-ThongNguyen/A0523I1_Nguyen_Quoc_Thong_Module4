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
<a href="/service/createView?id=${mail.getId()}">ADD</a>
<table>
    <tr>
        <td>Id</td>
        <td>Languages</td>
        <td>Size</td>
        <td>Spams_Fillter</td>
        <td>signature</td>
        <td style="color: rebeccapurple">UPDATE</td>
        <td style="color: red">DELETE</td>
    </tr>
    <c:forEach items="${mailList}" var="mail" varStatus="loop">
        <tr>
            <td>${mail.id}</td>
            <td>
                <c:forEach items="${mail.getLanguages()}" var="lan">
                <span><c:out value="${lan}"/></span>
                </c:forEach>
            <td>
                <c:forEach items="${mail.getSize()}" var="sizeOf">
                    <span><c:out value="${sizeOf}"/></span>
                </c:forEach>
            </td>
            <td>${mail.spams_Fillter}</td>
            <td>
                <c:forEach items="${mail.getSignature()}" var="signa">
                    <span><c:out value="${signa}"/></span>

                </c:forEach>
            </td>
            <td><a href="/service/updateView?id=${mail.getId()}">EDIT</a></td>
            <td><a href="/service/delete?id=${mail.getId()}">DELETE</a></td>
<%--            <td><a href="/service/updateName?name=${mail.getSpams_Fillter()}">DELETE</a></td>--%>

        </tr>
    </c:forEach>
</table>
</body>
</html>
