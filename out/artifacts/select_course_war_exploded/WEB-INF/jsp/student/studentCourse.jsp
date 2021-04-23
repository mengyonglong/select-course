<%--
  Created by IntelliJ IDEA.
  User: 10254
  Date: 2021/4/10
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生选课</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
    <link rel="stylesheet" href="/static/css/bootstrap.css">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>课程查看</small>
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                </h1>
            </div>
        </div>

        <div class="row clearfix">
            <div class="col-md-4 column"></div>
            <div class="col-md-4 column"></div>
            <div class="col-md-4 column">
                <%--搜索图书--%>
                <form class="form-inline" action="/student/searchCourse" method="post">
                    <input style="width: 326px;" type="text" class="form-control" name="c_name" value="${c_name}"
                           placeholder="请输入您想要查询课程的名称或课程属性">
                    <input type="submit" value="查询" class="btn btn-success">
                </form>
            </div>
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
                    <th>教师名</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${courseList.list}" var="course">

                    <tr>
                        <td>${course.c_id}</td>
                        <td>${course.c_name}</td>
                        <td>${course.c_properties}</td>
                        <td>${course.c_credit}</td>
                        <td>${course.c_place}</td>
                        <td>${course.t_name}</td>
                        <td>
                            <button type="button" id="selects${course.c_id}" value="退选"
                                    onclick="remove(${course.c_id},${sessionScope.student.s_studentid})">退选
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    当前第${courseList.pageNum}页，共${courseList.pages}页，共${courseList.total}条记录
    <br>


    <a href="/student/queryMyCourse?start=0">首页</a>
    <a href="/student/queryMyCourse?start=${courseList.prePage}">上一页</a>
    <c:forEach items="${courseList.navigatepageNums}" var="pageNum">
        <a href="/student/queryMyCourse?start=${pageNum*2-2}">${pageNum}</a>
    </c:forEach>
    <input type="text" id="numPage" placeholder="请输入您想要查询的页码">
    <button name="bt" onclick="searchPage()">查询</button>
    <a href="/student/queryMyCourse?start=${courseList.nextPage}">下一页</a>
    <a href="/student/queryMyCourse?start=${courseList.navigateLastPage}">尾页</a>

</div>


<script>
    function remove(c_id, s_studentid) {

        $.ajax({
            url: "${pageContext.request.contextPath}/student/deleteCourseByStudent",
            type: "post",
            data: {
                "c_id": c_id,
                "s_studentid": s_studentid
            },
            success: function (data) {
                if (data === "success") {
                    alert("退选成功");
                    window.location.href = "";
                }

            }
        })
    }

    function searchPage() {
        var numPage = $('#numPage').val();
        window.location.href = '${pageContext.request.contextPath}/student/queryMyCourse?start=' + numPage

    }
</script>
</body>
</html>
