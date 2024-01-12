<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Thong
  Date: 01/01/2024
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>sehun</h1>
inbox: <c:out value="${entedmassenger}"/>

<form action="/dictionary/post" method="post">
    <table>
        <tr>
            <td><input type="radio" name="e" value="vie">vn-english</td>

            <td><input type="radio" name="e" value="english">english-vn</td>
        </tr>

        <tr>
            <td><input type="text" name="result"></td>
             <td><button>Trans</button></td>
        </tr>
      </table>
</form>
<p><span>result: <c:out value="${kq}" /></span></p>
<p> <span>result: <c:out value="${kq2}" /></span></p>
</body>
</html>
