<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10254
  Date: 2021/4/10
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生选课</title>
</head>
<body>
<h1>已选课程</h1>


<table>
    <thead>
    <tr>
        <th>课程号</th>
        <th>课程名</th>
        <th>属性</th>
        <th>学分</th>
        <th>地点</th>
        <th>教师名</th>
        <th>学院</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${student}" var="sCourse" varStatus="0">

        <tr>
            <td>${sCourse.c_id}</td>
            <td>${sCourse.}</td>
            <td>${}</td>
            <td>${studentCourse.course.c_credit}</td>
            <td>${studentCourse.course.c_place}</td>
            <td>${studentCourse.t_name}</td>
            <td>${studentCourse.t_department}</td>

            <td>
                <button type="button" id="selects${course.c_id}" value="退选"
                        onclick="select(${course.c_id},${course.t_teacherid})">退选
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
