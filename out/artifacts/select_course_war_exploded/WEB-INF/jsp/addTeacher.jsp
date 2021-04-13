<%--
  Created by IntelliJ IDEA.
  User: 10254
  Date: 2021/4/13
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加教师</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
</head>
<body>
<h1>添加教师信息</h1>
<form id="addForm">
    教师号：<input type="text" name="t_teacherid" required>
    姓名：<input type="text" name="t_name" required>
    性别：<input type="text" name="t_sex" required>
    学院：<input type="text" name="t_department" required>
    <input type="button" value="添加" onclick="addTeacher()">
</form>


<script type="text/javascript">
    function addTeacher() {
        $.ajax({
            url: "${pageContext.request.contextPath}/teacher/addTeacher",
            type: 'post',
            dataType:"json",

            data: $('#addForm').serialize(),
            success: function (data) {
                alert(data);
                if (data!=="null") {
                    alert("添加成功");
                } else {
                    alert("添加失败");
                }
            }
        })

    }
</script>
</body>
</html>
