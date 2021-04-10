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
    <meta charset="UTF-8">
    <title>课程列表</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
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
                <button type="button" id="selects${course.c_id}" value="选课"
                        onclick="select(${course.c_id},${course.t_teacherid})">选课
                </button>
            </td>
        </tr>

    </c:forEach>


    </tbody>


</table>

<script>
    function select(c_id, t_teacherid) {

        $.ajax({
            url: "${pageContext.request.contextPath}/scourse/selectCourse",
            type: "post",
            data: {
                "c_id": c_id,
                "t_teacherid": t_teacherid
            },
            success: function (data) {
                if (data === "success") {
                    $("#selects" + c_id).text("已选");
                    document.getElementById('selects' + c_id).disabled = true;
                    alert("选课成功");
                }

            }
        })


    }
</script>
</body>
</html>
