<%--
  Created by IntelliJ IDEA.
  User: 10254
  Date: 2021/4/8
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>教师列表</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
</head>
<body>
<h3>教师管理</h3>
<a href="/admin/ToaddTeacher">添加教师</a>
<table border="1px solid #ccc" cellspacing="0" cellpadding="0">
    <thead>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>学院</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${teacherList.list}" var="teacher" varStatus="0">
        <tr>
            <td>${teacher.t_teacherid}</td>
            <td>${teacher.t_name}</td>
            <td>${teacher.t_sex}</td>
            <td>${teacher.t_department}</td>
            <td>
                <a href="/books/toUpdatePage/${book.bookID}">修改</a>
                &nbsp; | &nbsp;
                <a href="/books/deleteBook/${book.bookID}">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
当前第${teacherList.pageNum}页，共${teacherList.pages}页，共${teacherList.total}条记录
<br>


<a href="/admin/queryTeacher?start=0">首页</a>
<a href="/admin/queryTeacher?start=${teacherList.prePage}">上一页</a>
<c:forEach items="${teacherList.navigatepageNums}" var="pageNum">
    <a href="/admin/queryTeacher?start=${pageNum*2-2}">${pageNum}</a>
</c:forEach>
<input type="text" id="searchtea" placeholder="请输入您想要查询的页码">
<button name="bts" onclick="searchTea()">查询</button>
<a href="/admin/queryTeacher?start=${teacherList.nextPage}">下一页</a>
<a href="/admin/queryTeacher?start=${teacherList.navigateLastPage}">尾页</a>

</body>

<script>
    function searchTea() {
        var numtea=$('#searchtea').val()*2-2;
        window.location.href = '${pageContext.request.contextPath}/admin/queryTeacher?start='+numtea

    }
</script>

</body>
</html>
