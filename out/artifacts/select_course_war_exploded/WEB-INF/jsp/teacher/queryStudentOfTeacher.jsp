<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10254
  Date: 2021/4/15
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选课情况</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
</head>
<body>
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
                <button type="button" value="删除" onclick="remove(${c_id},${student.s_studentid})">删除
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
总计人数：${number}
<script>
    function remove(c_id, s_studentid) {

        $.ajax({
            url: "${pageContext.request.contextPath}/teacher/deleteStudentByTeacher",
            type: "post",
            data: {
                "c_id": c_id,
                "s_studentid": s_studentid
            },
            success: function (data) {
                if (data === "success") {
                    alert("删除成功");
                    window.location.href = "";
                }

            }
        })


    }
</script>
</body>
</html>
