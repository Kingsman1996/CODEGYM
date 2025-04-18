<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Kết quả chọn gia vị</title>
</head>
<body>
<h2>Danh sách gia vị bạn đã chọn:</h2>
<ul>
  <c:forEach var="condiment" items="${condimentList}">
    <li>${condiment}</li>
  </c:forEach>
</ul>

<a href="/">Chọn lại</a>
</body>
</html>
