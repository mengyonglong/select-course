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
        <title>课程列表</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/layui.css">
        <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
        <link rel="stylesheet" href="/static/css/bootstrap.css">
    </head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">
            欢迎您 ${sessionScope.student.s_name}
        </div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">

                <img src="/static/images/1.jpg"
                     class="layui-nav-img">
                ${sessionScope.student.s_name}

            </li>
            <li class="layui-nav-item"><a href="/logOut">注销</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item ">
                    <a class="" href="javascript:;">学生操作</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/course/queryCourse">查看全部课程</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/student/queryMyCourse">查看已选课程</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/student/ToQueryMe">个人信息查看</a></dd>
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
                <div class="col-md-4 column" style="font-weight: lighter">教师开课</div>
                <div class="col-md-4 column"></div>
                <div class="col-md-4 column">
                    <%--搜索图书--%>
                    <form class="form-inline" action="/student/searchCourse" method="post"
                          style="float: right;padding-bottom: 20px;">
                        <input type="text" class="form-control" name="c_name" placeholder="请输入您所要查询课程的名称"
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
                            <th>选课人数</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:if test="${courseLists!=null}">

                        <c:forEach items="${courseLists.list}" var="course" varStatus="0">

                            <tr>
                                <td>${course.c_id}</td>
                                <td>${course.c_name}</td>
                                <td>${course.c_properties}</td>
                                <td>${course.c_credit}</td>
                                <td>${course.t_name}</td>
                                <td>${course.c_place}</td>
                                <td>${course.c_number}</td>
                                <td>
                                    <button type="button" class="btn btn-success" id="selects${course.c_id}" value="选课"
                                            onclick="select(${course.c_id},${course.t_teacherid})">选课
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
            当前第${courseLists.pageNum}页，共${courseLists.pages}页，共${courseLists.total}条记录
            <br>
            <br>
            <div class="row" style="float: right">
                <div class="form-inline">
                    <button type="button" class="btn btn-dark"
                            onclick="window.location.href='/course/queryCourse?start=0'">
                        首页
                    </button>
                    <button type="button" class="btn btn-dark"
                            onclick="window.location.href='/course/queryCourse?start=${courseLists.prePage}'">上一页
                    </button>
                    <c:forEach items="${courseLists.navigatepageNums}" var="pageNum">
                        <button type="button" class="btn btn-dark"
                                onclick="window.location.href='/course/queryCourse?start=${pageNum*2-2}'">${pageNum}</button>
                    </c:forEach>
                    <input type="text" class="form-control" type="text" style="width: auto" id="num"
                           placeholder="请输入您想要查询的页码">
                    <button name="bt" type="button" class="btn btn-info" onclick="search()">查询</button>
                    <button type="button" class="btn btn-dark"
                            onclick="window.location.href='/course/queryCourse?start=${courseLists.nextPage}'">下一页
                    </button>
                    <button type="button" class="btn btn-dark"
                            onclick="window.location.href='/course/queryCourse?start=${courseLists.navigateLastPage}'">尾页
                    </button>
                </div>
            </div>
        </div>
        </c:if>

        <c:if test="${courseList!=null}">
        <c:forEach items="${courseList.list}" var="course" varStatus="0">
            <tr>
                <td>${course.c_id}</td>
                <td>${course.c_name}</td>
                <td>${course.c_properties}</td>
                <td>${course.c_credit}</td>
                <td>${course.t_name}</td>
                <td>${course.c_place}</td>
                <td>${course.c_number}</td>
                <td>
                    <button type="button" class="btn btn-success" id="selects${course.c_id}" value="选课"
                            onclick="select(${course.c_id},${course.t_teacherid})">选课
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
            <button type="button" class="btn btn-dark"
                    onclick="window.location.href='/student/searchCourse?start=0&c_name=${c_name}'">
                首页
            </button>
            <button type="button" class="btn btn-dark"
                    onclick="window.location.href='/student/searchCourse?start=${courseList.prePage}&c_name=${c_name}'">
                上一页
            </button>
            <c:forEach items="${courseList.navigatepageNums}" var="pageNum">
                <button type="button" class="btn btn-dark"
                        onclick="window.location.href='/student/searchCourse?start=${pageNum*2-2}&c_name=${c_name}'">${pageNum}</button>
            </c:forEach>
            <input type="text" class="form-control" type="text" style="width: auto" id="numByName"
                   placeholder="请输入您想要查询的页码">
            <button name="bts" type="button" class="btn btn-info" onclick="searches('${c_name}')">查询</button>
            <button type="button" class="btn btn-dark"
                    onclick="window.location.href='/student/searchCourse?start=${courseList.nextPage}&c_name=${c_name}'">
                下一页
            </button>
            <button type="button" class="btn btn-dark"
                    onclick="window.location.href='/student/searchCourse?start=${courseList.navigateLastPage}&c_name=${c_name}'">
                尾页
            </button>
        </div>
    </div>
</div>
</c:if>


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
    function select(c_id, t_teacherid) {

        $.ajax({
            url: "${pageContext.request.contextPath}/student/selectCourse",
            type: "post",
            data: {
                "c_id": c_id,
                "t_teacherid": t_teacherid
            },
            success: function (data) {
                if (data === "success") {
                    $("#selects" + c_id).text("已选");
                    document.getElementById('selects' + c_id).disabled = true;
                    alert("选课成功");
                }
                if (data === "fail") {
                    alert("课程已选，请勿重复选择！");
                }

            }
        })


    }

    function search() {
        var num = $('#num').val() * 2 - 2;
        window.location.href = '${pageContext.request.contextPath}/course/queryCourse?start=' + num
    }

    function searches(c_name) {
        var numByNames = $('#numByName').val() * 2 - 2;
        window.location.href = '${pageContext.request.contextPath}/student/searchCourse?start=' + numByNames + '&c_name=' + c_name
    }
</script>

</body>
</html>

