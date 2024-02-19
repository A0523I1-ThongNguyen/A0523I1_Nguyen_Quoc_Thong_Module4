<%--
  Created by IntelliJ IDEA.
  User: Thong
  Date: 27/01/2024
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="mail" action="/service/updatePost" method="post">
    ID: <form:input path="id" type="number"/>
<%--    <input type="number" name="newId"  value="${mail.id}" />--%>
    Languages:
    <form:select path="languages" multiple="${false}">
        <form:options items="${listLanguage}"/>
    </form:select>

    size:
    <form:select path="size" multiple="${false}">
        <form:options items="${listSize}"/>
    </form:select>
    Spams_Fillter:
    <form:input path="spams_Fillter"  type="text"/>
    signature:
    <form:input path="signature" type="text"/>

    <button>Update</button>
</form:form>
</body>
</html>
