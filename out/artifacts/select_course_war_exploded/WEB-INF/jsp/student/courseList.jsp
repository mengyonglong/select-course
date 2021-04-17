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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
</head>
<body>
<h3>课程管理</h3>
<form class="form-inline" action="/student/searchCourse" method="post" >
    <input  style="width: 326px;" type="text" class="form-control" name="c_name" value="${c_name}" placeholder="请输入您想要查询课程的名称或课程属性">
    <input type="submit" value="查询" class="btn btn-success">
</form>


<table border="1px solid #ccc" cellspacing="0" cellpadding="0">
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
            url: "${pageContext.request.contextPath}/student/selectCourse",
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
                if(data==="fail"){
                    alert("课程已选，请勿重复选择！");
                }

            }
        })


    }
</script>
</body>
</html>
