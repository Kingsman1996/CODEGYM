<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Danh sách sách</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
            border: 2px solid black;
        }

        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 20px;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            background-color: #ffffff;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
            border-radius: 8px;
            overflow: hidden;
        }

        th {
            background-color: #007BFF;
            color: white;
            padding: 12px;
            text-align: center;
        }

        td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
            text-align: center;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        button {
            padding: 8px 12px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: 0.3s;
        }

        button:hover {
            opacity: 0.8;
        }

        .borrow-btn {
            background-color: #28a745;
            color: white;
        }

        .disabled-text {
            color: red;
            font-weight: bold;
        }

        .view-borrowed-btn {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            border: none;
            cursor: pointer;
            display: block;
            margin: 20px auto;
            text-align: center;
            width: 200px;
        }

    </style>
</head>
<body>
<h1>Danh sách sách</h1>

<a href="book?action=list">
    <button class="view-borrowed-btn">Xem sách đã mượn</button>
</a>

<table>
    <tr>
        <th>Mã sách</th>
        <th>Tên sách</th>
        <th>Tác giả</th>
        <th>Số lượng</th>
        <th>Mô tả</th>
        <th></th>
    </tr>
    <c:forEach var="book" items="${bookList}">
        <tr>
            <td>${book.code}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.amount}</td>
            <td>${book.description}</td>
            <td>
                <c:choose>
                    <c:when test="${book.amount > 0}">
                        <a href="?action=borrow&bookId=${book.id}">
                            <button class="borrow-btn">Mượn</button>
                        </a>
                    </c:when>
                    <c:otherwise>
                        <span class="disabled-text">Tạm thời không thể mượn sách này</span>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>
</body>

</html>
