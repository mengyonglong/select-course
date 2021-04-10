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
</head>
<body>
<h3>教师管理</h3>
<table>
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
    <c:forEach items="${teacherList}" var="teacher" varStatus="0">
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


</body>
</html>
