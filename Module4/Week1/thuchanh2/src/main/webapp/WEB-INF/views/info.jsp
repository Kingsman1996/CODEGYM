<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Info</title>
</head>
<body>
<h1>Customer Info</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Sửa tên mới</th>
    </tr>
    <tr>
        <td>${customer.id}</td>
        <td>${customer.name}</td>
        <td>
            <form action="/customer/${customer.id}" method="post">
                <input type="text" name="name">
                <button type="submit">Chốt</button>
            </form>
        </td>
    </tr>
</table>
</body>
</html>
