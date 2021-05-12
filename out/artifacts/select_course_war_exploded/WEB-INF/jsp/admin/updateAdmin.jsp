<%--
  Created by IntelliJ IDEA.
  User: 10254
  Date: 2021/4/24
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改信息</title>
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
        <div class="layui-logo">
            欢迎您 在线选课系统
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
        <div style="padding: 15px;">修改信息</div>

        <c:choose>
            <c:when test="${admin!=null}">
                <form class="layui-form" id="updateForm">
                    <div class="layui-form-item">
                        <label class="layui-form-label">账号</label>
                        <div class="layui-input-block">
                            <input type="text" name="a_username" value="${admin.a_username}" required
                                   lay-verify="required" placeholder="请输入管理员账号"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <input type="hidden" name="a_id" value="${admin.a_id}">

                    <div class="layui-form-item">
                        <label class="layui-form-label">密码</label>
                        <div class="layui-input-block">
                            <input type="password" name="a_password" value="${admin.a_password}" required
                                   lay-verify="required" placeholder="请输入密码"
                                   autocomplete="off" class="layui-input">
                            <i class="fa fa-eye-slash"></i>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">姓名</label>
                        <div class="layui-input-block">
                            <input type="text" name="a_name" value="${admin.a_name}" required lay-verify="required"
                                   placeholder="请输入姓名"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">性别</label>
                        <div class="layui-input-block">
                            <c:if test="${admin.a_sex=='男'}">
                                <input type="radio" name="a_sex" value="男" title="男" checked>
                                <input type="radio" name="a_sex" value="女" title="女">
                            </c:if>
                            <c:if test="${admin.a_sex=='女'}">
                                <input type="radio" name="a_sex" value="男" title="男">
                                <input type="radio" name="a_sex" value="女" title="女" checked>
                            </c:if>

                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">权限</label>
                        <div class="layui-input-block">

                            <c:choose>
                                <c:when test="${admin.a_power==1&&sessionScope.admin.a_id==admin.a_id}">
                                    <input type="radio" name="a_power" value="1" title="1" checked >
                                    <input type="radio" name="a_power" value="0" title="0" >
                                </c:when>
                                <c:otherwise>
                                    <c:if test="${admin.a_power==1}">
                                        <input type="radio" name="a_power" value="1" title="1" checked disabled>
                                        <input type="radio" name="a_power" value="0" title="0" disabled>
                                    </c:if>
                                    <c:if test="${admin.a_power==0}">
                                        <input type="radio" name="a_power" value="1" title="1">
                                        <input type="radio" name="a_power" value="0" title="0" checked>
                                    </c:if>

                                </c:otherwise>

                            </c:choose>

                        </div>
                    </div>

                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit lay-filter="formDemo" onclick="updateAdmin()">立即提交
                            </button>
                        </div>
                    </div>
                </form>
            </c:when>

            <c:otherwise>
                <form class="layui-form" id="updateForm">
                    <div class="layui-form-item">
                        <label class="layui-form-label">账号</label>
                        <div class="layui-input-block">
                            <input type="text" name="a_username" value="${sessionScope.admin.a_username}" required
                                   lay-verify="required" placeholder="请输入管理员账号"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">密码</label>
                        <div class="layui-input-block">
                            <input type="password" name="a_password" value="${sessionScope.admin.a_password}" required
                                   lay-verify="required" placeholder="请输入密码"
                                   autocomplete="off" class="layui-input">
                            <i class="fa fa-eye-slash"></i>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">姓名</label>
                        <div class="layui-input-block">
                            <input type="text" name="a_name" value="${sessionScope.admin.a_name}" required
                                   lay-verify="required"
                                   placeholder="请输入姓名"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">性别</label>
                        <div class="layui-input-block">
                            <c:if test="${sessionScope.admin.a_sex=='男'}">
                                <input type="radio" name="a_sex" value="男" title="男" checked>
                                <input type="radio" name="a_sex" value="女" title="女">
                            </c:if>
                            <c:if test="${sessionScope.admin.a_sex=='女'}">
                                <input type="radio" name="a_sex" value="男" title="男">
                                <input type="radio" name="a_sex" value="女" title="女" checked>
                            </c:if>

                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">权限</label>
                        <div class="layui-input-block">
                            <c:if test="${sessionScope.admin.a_power==1}">
                                <input type="radio" name="a_power" value="1" title="1" checked>
                                <input type="radio" name="a_power" value="0" title="0">
                            </c:if>

                            <c:if test="${sessionScope.admin.a_power==0}">
                                <input type="radio" name="a_power" value="1" title="1">
                                <input type="radio" name="a_power" value="0" title="0" checked>
                            </c:if>

                        </div>
                    </div>

                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit lay-filter="formDemo" onclick="updateAdmin()">立即提交
                            </button>

                        </div>
                    </div>
                </form>

            </c:otherwise>
        </c:choose>

    </div>

</div>

<div class="layui-footer">
    <!-- 底部固定区域 -->
    底部固定区域
</div>


<script src="${pageContext.request.contextPath}/static/js/jquery-3.6.0.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/static/js/layui.js"></script>
<script type="text/javascript">
    function updateAdmin() {
        $.ajax({
            url: "${pageContext.request.contextPath}/admin/updateAdmin",
            type: 'post',
            dataType: "json",
            //  在这里进行form表单的序列化提交时，需要设置dataType为 "json",否则即使报200但是进error
            data: $('#updateForm').serialize(),
            success: function (data) {
                if (data !== "null") {
                    alert("修改成功");
                    window.location.href = "${pageContext.request.contextPath}/admin/queryAdmin";
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
