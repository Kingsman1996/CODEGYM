<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.product.model.Product" %>
<html>
<head>
    <title>Chi tiết sản phẩm</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<%
    Product product = (Product) request.getAttribute("product");
%>

<div class="container">
    <h2 class="mt-4">Chi tiết sản phẩm</h2>

    <table class="table table-bordered">
        <tr>
            <th>Tên sản phẩm</th>
            <td><%= product.getName() %></td>
        </tr>
        <tr>
            <th>Giá sản phẩm</th>
            <td><%= product.getPrice() %> $</td>
        </tr>
        <tr>
            <th>Mô tả</th>
            <td><%= product.getDescription() %></td>
        </tr>
        <tr>
            <th>Nhà sản xuất</th>
            <td><%= product.getManufacturer() %></td>
        </tr>
    </table>

    <a href="/products" class="btn btn-secondary">Quay lại danh sách</a>
</div>

</body>
</html>
