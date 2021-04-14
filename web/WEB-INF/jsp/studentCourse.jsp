<%--
  Created by IntelliJ IDEA.
  User: 10254
  Date: 2021/4/10
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生选课</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
</head>
<body>
<h1>已选课程</h1>


<table border="1px solid #ccc" cellspacing="0" cellpadding="0">
    <thead>
    <tr>
        <th>课程号</th>
        <th>课程名</th>
        <th>属性</th>
        <th>学分</th>
        <th>地点</th>
        <th>教师名</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${courseList}" var="course">

        <tr>
            <td>${course.c_id}</td>
            <td>${course.c_name}</td>
            <td>${course.c_properties}</td>
            <td>${course.c_credit}</td>
            <td>${course.c_place}</td>
            <td>${course.t_name}</td>
            <td>
                <button type="button" id="selects${course.c_id}" value="退选"
                        onclick="remove(${course.c_id},${sessionScope.student.s_studentid})">退选
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script>
    function remove(c_id, s_studentid) {

        $.ajax({
            url: "${pageContext.request.contextPath}/scourse/deleteCourseByStudent",
            type: "post",
            data: {
                "c_id": c_id,
                "s_studentid": s_studentid
            },
            success: function (data) {
                if (data === "success") {
                    alert("退选成功");
                    window.location.href = "";
                }

            }
        })


    }
</script>
</body>
</html>
