<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10254
  Date: 2021/4/10
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师课程</title>
</head>
<body>
<h1>教师课程列表</h1>

<table>
    <thead>
    <tr>
        <th>课程号</th>
        <th>课程名</th>
        <th>属性</th>
        <th>学分</th>
        <th>地点</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${teacher.courses}" var="course" varStatus="0">

        <tr>
            <td>${course.c_id}</td>
            <td>${course.c_name}</td>
            <td>${course.c_properties}</td>
            <td>${course.c_credit}</td>
            <td>${course.c_place}</td>
            <td>
                <button type="button" id="selects${course.c_id}" value="退课"
                        onclick="select(${course.c_id},${course.t_teacherid})">退课
                </button>
            </td>
        </tr>

    </c:forEach>


    </tbody>


</table>


</body>
</html>
