<%--
  Created by IntelliJ IDEA.
  User: 10254
  Date: 2021/4/8
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生列表</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
</head>
<body>
<h3>学生管理</h3>
<table border="1px solid #ccc" cellspacing="0" cellpadding="0">
    <thead>
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>学院</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${studentList.list}" var="student" varStatus="0">
        <tr>
            <td>${student.s_studentid}</td>
            <td>${student.s_name}</td>
            <td>${student.s_sex}</td>
            <td>${student.s_age}</td>
            <td>${student.s_department}</td>
            <td>
                <a href="/books/toUpdatePage/${book.bookID}">修改</a>
                &nbsp; | &nbsp;
                <a href="/books/deleteBook/${book.bookID}">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
当前第${studentList.pageNum}页，共${studentList.pages}页，共${studentList.total}条记录
<br>


<a href="/admin/queryStudent?start=0">首页</a>
<a href="/admin/queryStudent?start=${studentList.prePage}">上一页</a>
<c:forEach items="${studentList.navigatepageNums}" var="pageNum">
    <a href="/admin/queryStudent?start=${pageNum*2-2}">${pageNum}</a>
</c:forEach>
<input type="text" id="searchstu" placeholder="请输入您想要查询的页码">
<button name="bts" onclick="searchStu()">查询</button>
<a href="/admin/queryStudent?start=${studentList.nextPage}">下一页</a>
<a href="/admin/queryStudent?start=${studentList.navigateLastPage}">尾页</a>

</body>

<script>
    function searchStu() {
        var numstu=$('#searchstu').val()*2-2;
        window.location.href = '${pageContext.request.contextPath}/admin/queryStudent?start='+numstu

    }
</script>
</html>
