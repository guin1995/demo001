<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <title>新建修改</title>
</head>
<body>
<form action="/book/save" method="post">
    <input type="hidden" name="id" id="id" value="${book.id }"/>
    <c:if test="${id!=null }">
        <input type="hidden" name="_method" value="put" />
    </c:if>
    名称：<input type="text" name="name" value="${book.name }" id="name"/>
    <br/>
    价格：<input type="text" name="price" value="${book.price }" id="price"/>
    <br/>
    <button type="submit">提交</button>
</form>
</body>
</html>
