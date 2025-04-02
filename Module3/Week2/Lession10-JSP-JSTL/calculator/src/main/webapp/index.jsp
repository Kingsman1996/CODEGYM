<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang nhập phép tính</title>
</head>
<body>
<h2>Nhập phép tính</h2>
<form action="calculate" method="POST">
    <label for="operand1">Toán tử trước:</label>
    <input type="number" id="operand1" name="operand1" required>
    <br><br>

    <label for="operator">Phép tính:</label>
    <select id="operator" name="operator" required>
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select>
    <br><br>
    <label for="operand2">Toán tử sau:</label>
    <input type="number" id="operand2" name="operand2" required>
    <br><br>
    <input type="submit" value="Tính toán">
</form>
</body>
</html>
