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
    <c:forEach items="${studentList}" var="student" varStatus="0">
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


</body>
</html>
