<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>列表</title>
</head>
<body>
<table style="background: 1px">
    <tr>
        <td>名称</td>
        <td>价格</td>
        <td>日期</td>
    </tr>
    <c:forEach items="${bookList}" var="book">
        <tr>
            <td>${book.name}</td>
            <td>${book.price}</td>
            <td>${book.date}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>