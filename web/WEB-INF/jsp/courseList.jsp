<%--
  Created by IntelliJ IDEA.
  User: 10254
  Date: 2021/4/8
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>课程列表</title>
</head>
<body>
<h3>课程管理</h3>
<table>
    <thead>
    <tr>
        <th>课程号</th>
        <th>课程名</th>
        <th>属性</th>
        <th>学分</th>
        <th>教师</th>
        <th>地点</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>

        <c:forEach items="${courseList}" var="course" varStatus="0">

            <tr>
                <td>${course.c_id}</td>
                <td>${course.c_name}</td>
                <td>${course.c_properties}</td>
                <td>${course.c_credit}</td>
                <td>${course.t_name}</td>
                <td>${course.c_place}</td>
                <td>
                    <a href="/scourse/selectCourse/${course.c_id}/${course.t_teacherid}">选课</a>
                </td>
            </tr>

        </c:forEach>



    </tbody>


</table>


</body>
</html>
