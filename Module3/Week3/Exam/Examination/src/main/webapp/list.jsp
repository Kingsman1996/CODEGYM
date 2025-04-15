<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Danh sách sách đang được mượn</title>
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

        .return-btn {
            background-color: #ff4d4d;
            color: white;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
        }
        table {
            border-collapse: collapse;
            width: 100%;
            border: 2px solid black;
            box-shadow: 2px 2px 8px rgba(0, 0, 0, 0.2);
        }

        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: left;
            border-radius: 5px;
        }

        th {
            background-color: #f2f2f2;
            font-family: "Roboto", sans-serif;
        }

        tr:hover {
            background-color: #f8f8f8;
            cursor: pointer;
        }

        .return-btn {
            background-color: #ff4d4d;
            color: white;
            border: none;
            padding: 8px 12px;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .return-btn:hover {
            background-color: #cc0000;
        }

    </style>
</head>
<body>
<h1>Danh sách sách đang được mượn</h1>

<table>
    <tr>
        <th>Mã mượn sách</th>
        <th>Tên sách</th>
        <th>Tác giả</th>
        <th>Tên học sinh</th>
        <th>Lớp</th>
        <th>Ngày mượn</th>
        <th>Ngày trả</th>
        <th>Hành động</th>
    </tr>

    <c:forEach var="borrowCard" items="${borrowCardList}">
        <tr>
            <td>MS-${String.format("%04d", borrowCard.id)}</td>
            <td>${borrowCard.book.title}</td>
            <td>${borrowCard.book.author}</td>
            <td>${borrowCard.student.name}</td>
            <td>${borrowCard.student.className}</td>
            <td>${borrowCard.borrowDate}</td>
            <td>${borrowCard.returnDate}</td>
            <td>
                <a href="?action=return&borrowCardId=${borrowCard.id}">
                    <button type="button" class="return-btn" onclick="returnBook()">Trả sách</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
<script>
    function returnBook(event) {
        let confirmation = confirm("Chắc muốn trả sách?");
        if (!confirmation) {
            event.preventDefault();
        }
    }
</script>


</body>
</html>
