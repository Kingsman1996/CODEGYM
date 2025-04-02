<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.HashMap" %>
<html>
<head>
</head>
<body>
<%
    HashMap<String, String> dic = new HashMap<>();
    dic.put("hello", "Xin chào");
    dic.put("how", "Thế nào");
    dic.put("book", "Quyển vở");
    dic.put("computer", "Máy tính");
    String searchWord = request.getParameter("search");
    String output = "Không tìm thấy";
    if (dic.containsKey(searchWord)) {
        output = dic.get(searchWord);
    }
%>
<h3>Kết quả:</h3>
<p>
    <%= output %>
</p>
</body>
</html>
