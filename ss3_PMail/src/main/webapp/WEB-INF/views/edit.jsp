<%--
  Created by IntelliJ IDEA.
  User: Thong
  Date: 06/01/2024
  Time: 12:51 PM
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
<form:form modelAttribute="findMail" action="/email/postcreate" method="post">
    Languages: <form:select path="langueges" multiple="${false}">
    <form:options items="${listLanguage}"/>
</form:select>

    Size: <form:select path="size" multiple="${false}">
    <form:options items="${listSize}"/>
</form:select>


    Spam <form:input path="spam" type="number"/>
    Signature : <form:input path="signature" type="text"/>

    <input type="submit" value="Submit">Edit
</form:form>
</body>
</html>
