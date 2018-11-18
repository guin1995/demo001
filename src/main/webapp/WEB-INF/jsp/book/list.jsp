<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>列表</title>
    <script src="/static/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">

        //删除
        function deleteBook() {
            var checkList = $("input:checkbox[name='id']:checked");
            if(checkList.length<=0){
                alert("请先选中一项");
                return;
            }
            var ids = "";
            checkList.each(function() { // 遍历name=test的多选框
                ids += $(this).val()+",";  // 每一个被选中项的值
            });
            $("#ids").val(ids);
            $("#deleteFrom").submit();
        }
    </script>
</head>
<body>
    <div>
        <a href="/book/toAdd"><button>新建</button></a>
        <button type="button" onclick="deleteBook()">删除</button>
    </div>
    <form id="deleteFrom" action="/book/delete" method="post">
        <input type="hidden" name="_method" value="delete" />
        <input type="hidden" name="ids" id="ids" value="">
    </form>
    <div>
        <table border="1px" cellspacing="0">
                <tr>
                    <td style="width: 30px"></td>
                    <td style="width: 100px">名称</td>
                    <td style="width: 100px">价格</td>
                    <td style="width: 30px"></td>
                </tr>
            <c:forEach items="${bookList}" var="book">
                <tr>
                    <td><input type="checkbox" name="id" id="id" value="${book.id}"/></td>
                    <td>${book.name}</td>
                    <td>${book.price}</td>
                    <td><a href="/book/toUpdate/${book.id}">修改</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
