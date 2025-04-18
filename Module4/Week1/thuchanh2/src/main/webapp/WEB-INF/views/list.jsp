<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customer List</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Thao tác</th>
    </tr>
    <c:forEach var="customer" items="${customerList}">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>
                <a href="/customer/${customer.id}">Xem thông tin</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
