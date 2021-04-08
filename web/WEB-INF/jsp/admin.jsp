<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10254
  Date: 2021/4/7
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员</title>
</head>
<body>
<h3>管理员管理</h3>
<table>
    <thead>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>权限</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${adminList}" var="admin" varStatus="0">
        <tr>
            <td>${admin.a_id}</td>
            <td>${admin.a_name}</td>
            <td>${admin.a_sex}</td>
            <td>${admin.a_power}</td>
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
