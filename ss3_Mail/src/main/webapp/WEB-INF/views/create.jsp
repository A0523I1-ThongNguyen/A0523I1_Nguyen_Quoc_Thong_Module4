<%--
  Created by IntelliJ IDEA.
  User: thanhngan
  Date: 10/4/2023
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="mailList" method="post" action="/service/edit">
    Languages : <form:checkboxes path="languages" items="${lan}"/> <br>
    <span>Page Size:Show </span> <form:checkboxes path="size" items="${page}"/> <span>emails per pages</span> <br>

    Signatire: <form:input path="signature"/> <br>
    <button>EDIT</button>
</form:form>
</body>
</html>
