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
                    <img src="/static/images/1.jpg"
                         class="layui-nav-img">
                    ${sessionScope.admin.a_name}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">set 1</a></dd>
                    <dd><a href="">set 2</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="/logOut">注销</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item ">
                    <a class="" href="javascript:;">管理员管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/admin/queryAdmin">管理员列表</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/admin/ToAddAdmin">添加管理员</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item  ">
                    <a class="" href="javascript:;">教师管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/admin/queryTeacher">教师列表</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/admin/ToaddTeacher">添加教师</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item ">
                    <a href="javascript:;">课程管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/admin/queryCourse">教师开课</a></dd>
                        <dd><a href="/admin/queryStudentCourse">学生选课</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item ">
                    <a href="javascript:;">学生管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/admin/queryStudent">学生列表</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/admin/ToAddStudent">添加学生</a></dd>

                    </dl>
                </li>

                <li class="layui-nav-item">
                    <a class="" href="javascript:;">个人信息管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/admin/ToUpdateAdmin">个人信息</a></dd>
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
                <div class="col-md-4 column" style="font-weight: lighter">管理员列表</div>
                <div class="col-md-4 column"></div>
                <div class="col-md-4 column">
                    <%--搜索图书--%>
                    <form class="form-inline" action="/books/searchBookByName" method="post"
                          style="float: right;padding-bottom: 20px;">
                        <input type="text" class="form-control" name="bookName" placeholder="请输入您所要查询管理员的姓名"
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
                            <th>教师</th>
                            <th>地点</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${courseList.list}" var="course" varStatus="0">
                            <tr>
                                <td>${course.c_id}</td>
                                <td>${course.c_name}</td>
                                <td>${course.c_properties}</td>
                                <td>${course.c_credit}</td>
                                <td>${course.t_name}</td>
                                <td>${course.c_place}</td>
                                <td>
                                    <button type="button" class="btn btn-success"
                                            onclick="window.location.href='/admin/updateTeacher/${teacher}'">修改
                                    </button>
                                    <button type="button" class="btn btn-danger"
                                            onclick="deltea(${teacher.t_teacherid})">删除
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <div style="padding: 15px;">
            当前第${courseList.pageNum}页，共${courseList.pages}页，共${courseList.total}条记录
            <br>
            <br>
            <div class="row" style="float: right">
                <div class="form-inline">
                    <button type="button" class="btn btn-dark" onclick="window.location.href='/admin/queryCourse?start=0'">
                        首页
                    </button>
                    <button type="button" class="btn btn-dark"
                            onclick="window.location.href='/admin/queryCourse?start=${courseList.prePage}'">上一页
                    </button>
                    <c:forEach items="${courseList.navigatepageNums}" var="pageNum">
                        <button type="button" class="btn btn-dark"
                                onclick="window.location.href='/admin/queryCourse?start=${pageNum*2-2}'">${pageNum}</button>
                    </c:forEach>
                    <input type="text"class="form-control" type="text" style="width: auto" id="searchtea" placeholder="请输入您想要查询的页码">
                    <button name="bts" type="button" class="btn btn-info" onclick="searchTea()">查询</button>
                    <button type="button" class="btn btn-dark"
                            onclick="window.location.href='/admin/queryCourse?start=${courseList.nextPage}'">下一页
                    </button>
                    <button type="button" class="btn btn-dark"
                            onclick="window.location.href='/admin/queryCourse?start=${courseList.navigateLastPage}'">尾页
                    </button>
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

</body>
</html>

