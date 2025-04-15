<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Mượn sách</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 40px;
        }

        h1 {
            text-align: center;
            color: #007BFF;
            font-size: 24px;
        }

        form {
            max-width: 500px;
            margin: auto;
            background: white;
            padding: 20px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
            border-radius: 10px;
        }

        p {
            font-size: 16px;
            margin-bottom: 12px;
        }

        input, select {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        button {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: 0.3s;
            font-size: 16px;
        }

        button:hover {
            opacity: 0.8;
        }

        button[type="submit"] {
            background-color: #28a745;
            color: white;
        }

        button[type="button"] {
            background-color: #dc3545;
            color: white;
        }

        .alert-message {
            color: red;
            font-weight: bold;
        }

    </style>
</head>
<body>
<h1>Mượn sách</h1>
<form method="post">
    <p>Mã sách: <input type="text" name="bookCode" value="${book.code}" readonly></p>
    <p>Tên sách: <input type="text" name="bookTitle" value="${book.title}" readonly></p>

    <p>Tên học sinh:
        <select name="studentId">
            <c:forEach var="student" items="${studentList}">
                <option value="${student.id}">${student.name}</option>
            </c:forEach>
        </select>
    </p>

    <p>Ngày mượn: <input type="text" id="borrowDate" name="borrowDate" value="${today}" readonly></p>
    <p>Ngày trả: <input type="text" id="returnDate" name="returnDate" onchange="validateReturn()"></p>

    <button type="submit">Mượn</button>
    <button type="button" onclick="cancel()">Hủy</button>
</form>

<script>
    function validateReturn() {
        let borrowDate = document.getElementById("borrowDate").value;
        let returnDate = document.getElementById("returnDate").value;
        if (parseInt(returnDate) <= parseInt(borrowDate)) {
            alert("Ngày trả phải sau ngày mượn!");
            document.getElementById("returnDate").value = "";
        }
    }

    function cancel(event) {
        let confirmation = confirm("Quay về trang danh sách?");
        if (confirmation) {
            window.location.href = "book?action="
        } else {
            event.preventDefault()
        }
    }
</script>
</body>

</html>
