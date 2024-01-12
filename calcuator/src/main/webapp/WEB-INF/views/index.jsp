<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/search/calp" method="post">
    <table>
        <tr>
            <td><input type="text" name="num1"></td>
            <td><input type=text" name="num2"></td>
        </tr>
        <tr>
            <td>
                <button type="submit" name="e" value="plus">plus</button>
                <button type="submit" name="e" value="subtraction">subtraction</button>
            </td>
            <td>
                <button type="submit" name="e" value="multiplication">multiplication</button>
                <button type="submit" name="e" value="division">division</button>
            </td>
        </tr>
    </table>
</form>
<p>Kết quả: <c:out value="${result}"/></p>
</body>
</html>
