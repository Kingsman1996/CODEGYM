<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sản phẩm</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2 class="mt-4">Thêm sản phẩm mới</h2>

    <form action="/products?action=create" method="post">
        <div class="mb-3">
            <label for="id" class="form-label">ID:</label>
            <input type="number" class="form-control" id="id" name="id" required>
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Tên sản phẩm:</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Giá sản phẩm:</label>
            <input type="number" step="0.01" class="form-control" id="price" name="price" required>
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Mô tả:</label>
            <textarea class="form-control" id="description" name="description" required></textarea>
        </div>
        <div class="mb-3">
            <label for="manufacturer" class="form-label">Nhà sản xuất:</label>
            <input type="text" class="form-control" id="manufacturer" name="manufacturer" required>
        </div>
        <button type="submit" class="btn btn-success">Thêm sản phẩm</button>
        <a href="/products" class="btn btn-secondary">Quay lại</a>
    </form>
</div>
</body>
</html>
