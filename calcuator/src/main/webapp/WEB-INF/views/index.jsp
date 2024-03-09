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
        <%-- Lưu ý rằng name của một phần tử HTML (như input, button,...) là tên của tham số được gửi đi khi form được gửi đi.
        Giá trị của phần tử HTML sẽ được gửi đi kèm theo tên này để server có thể biết được giá trị của phần tử HTML đó.--%>
        <tr>
            <td>
                <button type="submit" name="e" value="plus">plus</button>
                <button type="submit" name="e" value="subtraction">subtraction</button>
            </td>
            <td>
                <input type="submit" name="e" value="multiplication"></input>
                <input type="submit" name="e" value="division"></input>
            </td>
        </tr>
    </table>
</form>
<p>Kết quả: <c:out value="${result}"/></p>
</body>
</html>
