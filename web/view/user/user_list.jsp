<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FuTao
  Date: 2022/10/26
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>用户列表</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; ">
        <li>系统管理</li>
        <li>用户管理</li>
        <li>用户列表</li>
    </ul>
</div>
<div class="row alert alert-info" style="margin:0px; padding:3px;">
    <form class="form-inline" action="${pageContext.request.contextPath}/user/getAll">
        <div class="form-group">
            <label class="" for="activename">用户姓名：</label>
            <input type="text" name="key" class="form-control" id="activename" placeholder="请输入用户姓名">
        </div>
        <input type="submit"  class="btn btn-danger" value="查询"/>
        &nbsp;&nbsp;
        <a class="btn btn-success" href="${pageContext.request.contextPath}/role/getAll">添加用户</a>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
    <table class="table  table-condensed table-striped">
        <tr>
            <th>用户编号</th>
            <th>用户姓名</th>
            <th>登陆账号</th>
            <th>电话</th>
            <th>微信号</th>
            <th>身份证号</th>
            <th>地址</th>
            <th>角色</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${requestScope.userlist}" var="user" varStatus="i">
            <tr>
                <td>${i.index+1}</td>
                <td>${user.username}</td>
                <td>${user.loginname}</td>
                <td>${user.phone}</td>
                <td>${user.wx}</td>
                <td>${user.id_no}</td>
                <td>${user.address}</td>
                <td>${user.role_name}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/user/getUserById?id=${user.id}">修改</a>
                    <a href="${pageContext.request.contextPath}/user/deleted?id=${user.id}">删除</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
