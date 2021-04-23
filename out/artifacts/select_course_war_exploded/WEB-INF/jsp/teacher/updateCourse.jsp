<%--
  Created by IntelliJ IDEA.
  User: 10254
  Date: 2021/4/15
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改课程信息</title>
</head>
<body>
<form action="/teacher/updateCourse" method="post">
    <input type="hidden" name="c_id" value="${course.c_id}">
    课程名称：<input type="text" name="c_name" value="${course.c_name}">
    属性：<input type="text" name="c_properties" value="${course.c_properties}">
    学分：<input type="text" name="c_credit" value="${course.c_credit}">
    地点：<input type="text" name="c_place" value="${course.c_place}">
    <input type="submit" value="更新">
</form>
</body>
</html>
