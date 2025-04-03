<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Chỉnh sửa sản phẩm</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <h2 class="mt-4">Chỉnh sửa sản phẩm</h2>

    <div class="card p-3 mb-4">
        <h5><strong>Tên:</strong> ${product.name}</h5>
        <h5><strong>Giá:</strong> ${product.price} VNĐ</h5>
        <h5><strong>Mô tả:</strong> ${product.description}</h5>
        <h5><strong>Nhà sản xuất:</strong> ${product.manufacturer}</h5>
    </div>

    <form method="post">
        <div class="mb-3">
            <input type="hidden" id="id" name="id" value="${product.id}">
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Tên sản phẩm:</label>
            <input type="text" class="form-control" id="name" name="name" value="${product.name}" required>
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Giá sản phẩm:</label>
            <input type="number" step="0.01" class="form-control" id="price" name="price" value="${product.price}"
                   required>
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Mô tả:</label>
            <textarea class="form-control" id="description" name="description"
                      required>${product.description}</textarea>
        </div>
        <div class="mb-3">
            <label for="manufacturer" class="form-label">Nhà sản xuất:</label>
            <input type="text" class="form-control" id="manufacturer" name="manufacturer"
                   value="${product.manufacturer}" required>
        </div>
        <button type="submit" class="btn btn-warning">Cập nhật</button>
        <a href="/products" class="btn btn-secondary">Quay lại</a>
    </form>
</div>

</body>
</html>
