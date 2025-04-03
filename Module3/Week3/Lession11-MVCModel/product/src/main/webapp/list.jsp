<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container mt-4">
    <h2>Danh sách sản phẩm</h2>

    <form action="/products?action=search" method="get" class="d-flex mb-3">
        <input type="text" name="keyword" class="form-control" placeholder="Tìm sản phẩm..." required>
        <button type="submit" class="btn btn-primary ms-2">Tìm kiếm</button>
    </form>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên sản phẩm</th>
            <th>Giá sản phẩm</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price} $</td>
                <td>
                    <a href="/products?action=view&id=${product.id}" class="btn btn-info btn-sm">Chi tiết</a>
                    <a href="/products?action=edit&id=${product.id}" class="btn btn-warning btn-sm">Sửa</a>
                    <a href="/products?action=delete&id=${product.id}" class="btn btn-danger btn-sm"
                       onclick="return confirm('Bạn có chắc muốn xóa sản phẩm này?');">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
