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
                    <a class="" href="javascript:;">管理员</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/admin/queryAdmin">管理员列表</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/admin/queryStudent">学生管理</a></dd>
                        <dd><a href="">课程管理</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item ">
                    <a href="javascript:;">教师管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/admin/queryTeacher">教师列表</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/admin/ToaddTeacher">添加教师</a></dd>
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
        <div style="padding: 15px;"></div>
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-4 column" style="font-weight: lighter">学生列表</div>
                <div class="col-md-4 column"></div>
                <div class="col-md-4 column">
                    <%--搜索图书--%>
                    <form class="form-inline" action="/books/searchBookByName" method="post"
                          style="float: right;padding-bottom: 20px;">
                        <span style="color: red">${error}</span>
                        <input type="text" class="form-control" name="bookName" placeholder="请输入您所要查询图书的名称"
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
                            <th>学号</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>年龄</th>
                            <th>学院</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${studentList.list}" var="student" varStatus="0">
                            <tr>
                                <td>${student.s_studentid}</td>
                                <td>${student.s_name}</td>
                                <td>${student.s_sex}</td>
                                <td>${student.s_age}</td>
                                <td>${student.s_department}</td>
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
        当前第${studentList.pageNum}页，共${studentList.pages}页，共${studentList.total}条记录
        <br>
        <a href="/admin/queryStudent?start=0">首页</a>
        <a href="/admin/queryStudent?start=${studentList.prePage}">上一页</a>
        <c:forEach items="${studentList.navigatepageNums}" var="pageNum">
            <a href="/admin/queryStudent?start=${pageNum*2-2}">${pageNum}</a>
        </c:forEach>
        <input type="text" id="searchstu" placeholder="请输入您想要查询的页码">
        <button type="button" class="btn btn-info" name="bts" onclick="searchStu()">查询</button>
        <a href="/admin/queryStudent?start=${studentList.nextPage}">下一页</a>
        <a href="/admin/queryStudent?start=${studentList.navigateLastPage}">尾页</a>

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
    function searchStu() {
        var numstu = $('#searchstu').val() * 2 - 2;
        window.location.href = '${pageContext.request.contextPath}/admin/queryStudent?start=' + numstu

    }
</script>

</body>
</html>