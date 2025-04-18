<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Máy tính đơn giản</title>
</head>
<body>
<h2>Máy tính JSP</h2>
<form method="post" action="/calculate">
    Số thứ nhất: <input type="text" name="num1" required><br><br>
    Số thứ hai: <input type="text" name="num2" required><br><br>
    Phép toán:
    <select name="operator">
        <option value="+">Cộng (+)</option>
        <option value="-">Trừ (-)</option>
        <option value="*">Nhân (*)</option>
        <option value="/">Chia (/)</option>
    </select><br><br>
    <input type="submit" value="Tính">
</form>
<c:if test="${not empty result}">
    <h1>Kết quả</h1>
    <p>${result}</p>
</c:if>

</body>
</html>
