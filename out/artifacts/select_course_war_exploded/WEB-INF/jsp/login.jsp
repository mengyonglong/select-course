<%--
  Created by IntelliJ IDEA.
  User: 10254
  Date: 2021/4/8
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
</head>
<body>
<form >
    账号<input type="text" id="id" placeholder="请输入学号或教师号">
    密码<input type="password" id="password">
    <div class="form-check form-check-inline" id="radio" aria-required="true">
        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="学生">
        <label class="form-check-label" for="inlineRadio1">学生</label>

        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="教师">
        <label class="form-check-label" for="inlineRadio2">教师</label>

        <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="管理员">
        <label class="form-check-label" for="inlineRadio3">管理员</label>
    </div>
    <input type="button" value="登录" onclick="a()">
</form>


<script type="text/javascript">
    function a() {
        $.ajax({
            url: "${pageContext.request.contextPath}/logins",
            type:"post",
            data: {
                "id":$("#id").val(),
                "password":$("#password").val(),
                "radio":$("#radio input:radio:checked").val()
            },
            success: function (data) {
                if(data=="null"){
                    alert("登录失败，查无此人")
                }else if(data=="admin"){
                    window.location.href="${pageContext.request.contextPath}/admin/queryAdmin";
                }else if(data=="teacher"){
                    window.location.href="${pageContext.request.contextPath}/teacher/teacher";
                }else{
                    window.location.href="${pageContext.request.contextPath}/student/student";
                }
            }
        })
    }
</script>
</body>
</html>
