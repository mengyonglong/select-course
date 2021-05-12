<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/static/css/bootstrap.css">

    <!-- Custom Styles -->
    <link rel="stylesheet" type="text/css" href="/static/css/styles.css">

    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>

    <title>登录</title>
</head>
<body>

<!-- Backgrounds -->

<div id="login-bg" class="container-fluid">

    <div class="bg-img"></div>
    <div class="bg-color"></div>
</div>

<!-- End Backgrounds -->

<div class="container" id="login">
    <div class="row justify-content-center">
        <div class="col-lg-8">
            <div class="login">

                <h1>Login</h1>

                <!-- Loging form -->
                <form>
                    <div class="form-group">
                        <input type="text" class="form-control" id="id" placeholder="输入学号或教师号">
                    </div>

                    <div class="form-group">
                        <input type="password" class="form-control" id="password" placeholder="输入密码">
                    </div>

                    <div class="form-group">
                        <div class="form-check form-check-inline" id="radio" aria-required="true">
                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1"
                                   value="学生">
                            <label class="form-check-label" for="inlineRadio1">学生</label>

                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2"
                                   value="教师">
                            <label class="form-check-label" for="inlineRadio2">教师</label>

                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3"
                                   value="管理员">
                            <label class="form-check-label" for="inlineRadio3">管理员</label>
                        </div>
                    </div>

                    <br>
                    <input type="button" class="btn btn-lg btn-block btn-success" value="登录" onclick="a()">
                </form>
                <!-- End Loging form -->

            </div>
            Copyright &copy; 2021.Company name All rights reserved.<a target="_blank"
                                                                      href="http://sc.chinaz.com/moban/">孟哈哈</a>
        </div>
    </div>
</div>

<script type="text/javascript">
    function a() {

        $.ajax({
            url: "${pageContext.request.contextPath}/logins",
            type: "post",
            data: {
                "id": $("#id").val(),
                "password": $("#password").val(),
                "radio": $("#radio input:radio:checked").val()
            },
            success: function (data) {
                if (data == "null") {
                    alert("登录失败，查无此人")
                } else if (data == "admin") {
                    window.location.href = "${pageContext.request.contextPath}/admin/queryAdmin";
                } else if (data == "teacher") {
                    window.location.href = "${pageContext.request.contextPath}/teacher/teacher";
                } else {
                    window.location.href = "${pageContext.request.contextPath}/student/student";
                }
            }
        })
    }


</script>

</body>
</html>