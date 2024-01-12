<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<table border="2px soild">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>singer</th>
        <th>category</th>
        <th>path</th>
    </tr>
    <c:forEach items="${music}" var="music" varStatus="loop">
        <tr>
            <td>${music.getId()}</td>
            <td>${music.getName()}</td>
            <td>${music.getSinger()}</td>
            <td>${music.getCategory()}</td>
            <td>${music.getPath()}</td>
        </tr>
    </c:forEach>
    <a href="/music/create">UpLoad</a>
</table>
</body>
</html>
