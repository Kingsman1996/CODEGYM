<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Checkbox</title>
</head>
<body>
<h2>Chọn gia vị:</h2>
<form action="order" method="post">
    <input type="checkbox" name="condiment" value="Xà lách"/> Xà lách <br>
    <input type="checkbox" name="condiment" value="Cà chua"/> Cà chua <br>
    <input type="checkbox" name="condiment" value="Mù tạt"/> Mù tạt <br>
    <input type="checkbox" name="condiment" value="Dưa chuột"/> Dưa chuột <br><br>
    <input type="submit" value="Chốt"/>
</form>
</body>
</html>
