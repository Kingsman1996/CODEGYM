<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Từ điển Anh – Việt</title>
</head>
<body>
<h2>Từ điển Anh – Việt</h2>
<form action="search" method="post">
    Nhập từ tiếng Anh: <input type="text" name="word" required>
    <input type="submit" value="Tra cứu">
</form>

<br>
<c:if test="${not empty meaning}">

    <p><strong>${word}</strong> : <span style="color: red;">${meaning}</span></p>
</c:if>

<c:if test="${not empty notFound}">
    <p style="color: red;">${notFound}</p>
</c:if>
</body>
</html>
