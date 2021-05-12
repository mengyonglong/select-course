<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10254
  Date: 2021/4/23
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有课程</title>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <title>管理员列表</title>
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
                ${sessionScope.teacher.t_name}

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
        <div style="padding: 15px;"></div>

        <div class="container">
            <div class="row clearfix">
                <div class="col-md-4 column" style="font-weight: lighter">课程信息</div>
                <div class="col-md-4 column"></div>
                <div class="col-md-4 column">
                    <%--搜索图书--%>
                    <form class="form-inline" action="/admin/searchCourseOfStudent" method="get"
                          style="float: right;padding-bottom: 20px;">
                        <input type="text" class="form-control" name="t_name" placeholder="请输入您所要查询课程的名称"
                               style="margin-left: 280px;">
                        <input type="submit" value="查询" class="btn btn-success"
                               style=" margin-right: 10px;margin-left: 500px;margin-top: -40px;border-right-width: 20px;padding-left: 20px;">
                    </form>
                </div>
            </div>


            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-hover table-striped">
                        <thead>
                        <tr>
                            <th>课程号</th>
                            <th>课程名</th>
                            <th>属性</th>
                            <th>学分</th>
                            <th>地点</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>


                        <c:forEach items="${teacher.courses}" var="course" varStatus="0">

                            <tr>
                                <td>${course.c_id}</td>
                                <td>${course.c_name}</td>
                                <td>${course.c_properties}</td>
                                <td>${course.c_credit}</td>
                                <td>${course.c_place}</td>

                                <td>
                                    <button type="button" class="btn btn-success"
                                            onclick="window.location.href='/teacher/queryCourseTeacher/${course.c_id}'">
                                        编辑
                                    </button>
                                    <button type="button" class="btn btn-primary"
                                            onclick="window.location.href='/teacher/queryOfTeacher?c_id=${course.c_id}'">
                                        详情
                                    </button>
                                    <button type="button" class="btn btn-danger" value="退课"
                                            onclick="remove(${course.c_id})">退课
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="layui-footer">
    <!-- 底部固定区域 -->
    底部固定区域
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
    function searchCou() {
        var numtea = $('#searchcou').val() * 2 - 2;
        window.location.href = '${pageContext.request.contextPath}/admin/queryTeacher?start=' + numtea

    }

    function remove(c_id) {
        $.ajax({
            url: "${pageContext.request.contextPath}/teacher/deleteCourseTranser",
            type: "post",
            data: {
                "c_id": c_id
            },
            success: function (data) {
                if (data === "success") {
                    alert("退选成功");
                    window.location.href = "";
                } else {
                    alert("推选失败");
                }

            }
        })
    }
</script>

</body>
</html>

