<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10254
  Date: 2021/4/22
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加课程</title>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <title>layout 管理系统大布局 - Layui</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/layui.css">
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
        <div style="padding: 15px;">添加课程</div>

        <form class="layui-form" id="addForm">
            <div class="layui-form-item">
                <label class="layui-form-label">课程名</label>
                <div class="layui-input-block">
                    <input type="text" name="c_name" required lay-verify="required" placeholder="请输入课程名"
                           autocomplete="off" class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">属性</label>
                <div class="layui-input-block">
                    <select name="c_properties" lay-verify="required">
                        <c:forEach items="${stringList}" var="c_properties">
                            <option value="${c_properties}">${c_properties}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">学分</label>
                <div class="layui-input-block">
                    <input type="text" name="c_credit" required lay-verify="required" placeholder="请输入学分"
                           autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">地点</label>
                <div class="layui-input-block">
                    <input type="text" name="c_place" required lay-verify="required" placeholder="请输入上课地点"
                           autocomplete="off" class="layui-input">
                </div>
            </div>



            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo" onclick="addCourse()">添加</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>
</div>


<script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/static/js/layui.js"></script>
<script type="text/javascript">
    function addCourse() {
        $.ajax({
            url: "${pageContext.request.contextPath}/teacher/addCourseByTeacher",
            type: 'post',
            dataType: "json",
            //  在这里进行form表单的序列化提交时，需要设置dataType为 "json",否则即使报200但是进error
            data: $('#addForm').serialize(),
            success: function (data) {
                if (data !== "null") {
                    alert("添加成功");
                    window.location.href = "${pageContext.request.contextPath}/teacher/queryCourseByTeacher";
                }
            }
        })

    }
</script>

<script>
    //Demo
    layui.use('form', function () {
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function (data) {
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>

</body>
</html>
