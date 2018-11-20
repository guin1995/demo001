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

        function goPage(page){
            location.href="/book/list?currentPage="+page;
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
            <c:forEach items="${page.dataList}" var="book">
                <tr>
                    <td><input type="checkbox" name="id" id="id" value="${book.id}"/></td>
                    <td>${book.name}</td>
                    <td>${book.price}</td>
                    <td><a href="/book/toUpdate/${book.id}">修改</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div style="width: 14%">
        <div style="text-align:center; margin-top:40px" id="venderfen">
            当前第${page.currentPage }页/共${page.totalPage }页
            <c:choose>
                <c:when test="${page.currentPage==1&&page.totalPage==0}">

                </c:when>
                <c:when test="${page.currentPage==1&&page.totalPage==1}">

                </c:when>
                <c:when test="${page.currentPage==2&&page.totalPage==2}">
                    <input type="button" value="首页" onclick="goPage(1)" />
                    <input type="button" value="上一页"
                           onclick="goPage(${page.currentPage-1})" />
                </c:when>
                <c:when test="${page.currentPage==1 }">
                    <input type="button" value="上一页" >
                    <input type="button" value="下一页"
                           onclick="goPage(${page.currentPage+1})" />
                    <input type="button" value="末页"
                           onclick="goPage(${page.totalPage})" />
                </c:when>
                <c:when test="${page.currentPage==page.totalPage }">
                    <input type="button" value="首页" onclick="goPage(1)" />
                    <input type="button" value="上一页"
                           onclick="goPage(${page.currentPage-1})" />
                </c:when>
                <c:otherwise>
                    <input type="button" value="首页" onclick="goPage(1)" />
                    <input type="button" value="上一页"
                           onclick="goPage(${page.currentPage-1})" />
                    <input type="button" value="下一页"
                           onclick="goPage(${page.currentPage+1})" />
                    <input type="button" value="末页"
                           onclick="goPage(${page.totalPage})" />
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</body>
</html>