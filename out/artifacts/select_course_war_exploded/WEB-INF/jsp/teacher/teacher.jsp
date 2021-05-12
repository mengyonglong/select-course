<%--
  Created by IntelliJ IDEA.
  User: 10254
  Date: 2021/4/22
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>教师管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/layui.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
    <link rel="stylesheet" href="/static/css/bootstrap.css">
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">
            欢迎您 ${sessionScope.teacher.t_name}
        </div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">

                <img src="/static/images/1.jpg"
                     class="layui-nav-img">
                ${sessionScope.admin.a_name}

            </li>
            <li class="layui-nav-item"><a href="/logOut">注销</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item ">
                    <a class="" href="javascript:;">教师操作</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/teacher/queryCourseByTeacher">查看课程信息</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/teacher/addCourse">添加课程信息</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/teacher/ToUpdateMe">个人信息修改</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item"><a href="javascript:;">常见问题</a></li>
                <li class="layui-nav-item"><a href="">关于我们</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">在线选课系统</div>

        <div class="container">
            <h1>欢迎进入本系统</h1>

        </div>
    </div>

</div>
    <script src="${pageContext.request.contextPath}/static/js/layui.js"></script>
    <script>
        //JavaScript代码区域
        layui.use('element', function () {
            var element = layui.element;

        });


        layui.use('carousel', function () {
            var carousel = layui.carousel;
            //建造实例
            carousel.render({
                elem: '#test1'
                , width: '100%' //设置容器宽度
                , arrow: 'always' //始终显示箭头
                , autoplay: 'true'
                , interval: '3000'
            });
        });
    </script>

    <script>
        function deladm(a_id) {
            $.ajax({
                url: "${pageContext.request.contextPath}/admin/deleteAdminById/" + a_id,
                type: "post",
                data: {
                    "a_id": a_id
                },
                success: function (data) {
                    if (data == "success") {
                        alert("删除成功");
                        window.location.href = "${pageContext.request.contextPath}/admin/queryAdmin";
                    }
                }
            })
        }
    </script>

</body>
</html>
