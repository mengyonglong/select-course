<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10254
  Date: 2021/4/15
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选课情况</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
</head>
<body>
<table border="1px solid #ccc" cellspacing="0" cellpadding="0">
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
                <button type="button" value="删除" onclick="remove(${c_id},${student.s_studentid})">删除
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

当前第${studentList.pageNum}页，共${studentList.pages}页，共${studentList.total}人
<br>


<a href="/scourse/queryStudentOfTeacher?start=0&c_id=${c_id}">首页</a>
<a href="/scourse/queryStudentOfTeacher?start=${studentList.prePage}&c_id=${c_id}">上一页</a>
<c:forEach items="${studentList.navigatepageNums}" var="pageNum">
    <a href="/scourse/queryStudentOfTeacher?start=${pageNum*2-2}&c_id=${c_id}">${pageNum}</a>
</c:forEach>
<input type="text" id="searchstuoftea" placeholder="请输入您想要查询的页码">
<button name="bts" onclick="searchStuOftea(${c_id})">查询</button>
<a href="/scourse/queryStudentOfTeacher?start=${studentList.nextPage}&c_id=${c_id}">下一页</a>
<a href="/scourse/queryStudentOfTeacher?start=${studentList.navigateLastPage}&c_id=${c_id}">尾页</a>



<script>
    function remove(c_id, s_studentid) {

        $.ajax({
            url: "${pageContext.request.contextPath}/teacher/deleteStudentByTeacher",
            type: "post",
            data: {
                "c_id": c_id,
                "s_studentid": s_studentid
            },
            success: function (data) {
                if (data === "success") {
                    alert("删除成功");
                    window.location.href = "";
                }

            }
        })


    }
</script>
<script>
    function searchStuOftea(c_id) {
        var numstutea=$('#searchstuoftea').val()*2-2;
        window.location.href = '${pageContext.request.contextPath}/scourse/queryStudentOfTeacher?start='+numstutea+'&c_id='+c_id

    }
</script>
</body>
</html>
