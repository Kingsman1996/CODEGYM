<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Discount Calculator</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        label, input {
            display: block;
            margin: 10px 0;
        }

        button {
            margin-top: 10px;
        }
    </style>
</head>
<body>
<h2>Discount Calculator</h2>
<form action="/calculate" method="post">
    <label for="price">Giá sản phẩm:</label>
    <input type="number" id="price" name="price" step="0.01" required>

    <label for="discount">Phần trăm giảm giá (%):</label>
    <input type="number" id="discount" name="discount" step="0.01" required>

    <button type="submit">Submit</button>
</form>
</body>
</html>
