<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Thong
  Date: 03/01/2024
  Time: 8:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="car" action="/car/create" method="post">
    ID: <form:input type="number" path="id"/>
    Name: <form:input path="name" type="text"/>
    Brand:
    <form:select path="brand" multiple="${false}">
        <form:options items="${brandList}"/>
    </form:select>
    Price: <form:input path="price" type="number"/>
    <input type="submit" value="Submit">
</form:form>


</body>
</html>
