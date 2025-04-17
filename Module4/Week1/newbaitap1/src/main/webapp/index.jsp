<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Chuyển đổi USD → VNĐ</title>
</head>
<body>
<h2>Chuyển đổi USD sang VNĐ</h2>
<form action="convert" method="post">
    Tỉ giá (VND/USD): <input type="number" step="0.01" name="rate" required><br><br>
    Số tiền (USD): <input type="number" step="0.01" name="usd" required><br><br>
    <input type="submit" value="Chuyển đổi">
</form>

<br>
<c:if test="${not empty vnd}">
    <h3>Kết quả:</h3>
    <p><strong>${vnd}</strong></p>
</c:if>
</body>
</html>
