<%--
  Created by IntelliJ IDEA.
  User: 10254
  Date: 2021/4/22
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 管理系统大布局 - Layui</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/layui.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
    <link rel="stylesheet" href="/static/css/bootstrap.css">
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">欢迎您</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">nav 1</a></li>
            <li class="layui-nav-item"><a href="">nav 2</a></li>
            <li class="layui-nav-item"><a href="">nav 3</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">nav groups</a>
                <dl class="layui-nav-child">
                    <dd><a href="">menu 11</a></dd>
                    <dd><a href="">menu 22</a></dd>
                    <dd><a href="">menu 33</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"
                         class="layui-nav-img">
                    tester
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">set 1</a></dd>
                    <dd><a href="">set 2</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">Sign out</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">管理员管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/admin/queryAdmin">管理员列表</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/admin/queryAdmin">添加管理员</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item ">
                    <a href="javascript:;">教师管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/admin/queryTeacher">教师列表</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/admin/ToaddTeacher">添加教师</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item ">
                    <a href="javascript:;">课程管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="">教师开课</a></dd>
                        <dd><a href="">学生选课</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item ">
                    <a href="javascript:;">学生管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/admin/queryStudent">学生列表</a></dd>
                        <dd><a href="">添加学生</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item">
                    <a class="" href="javascript:;">个人信息管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">个人信息</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="javascript:;">常见问题</a></li>
                <li class="layui-nav-item"><a href="">关于我们</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">内容主体区域</div>


        <div class="layui-carousel" id="test1">
            <div carousel-item>
                <div><img src="/static/images/1.jpg"></div>
                <div><img src="/static/images/2.jpg"></div>
                <div><img src="/static/images/3.jpg"></div>
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

</body>
</html>