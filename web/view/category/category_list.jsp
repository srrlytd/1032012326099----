<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FuTao
  Date: 2022/10/24
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>品类列表</title>
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
        <li>商品中心</li>
        <li>品类管理</li>
        <li>品类列表</li>
    </ul>
</div>
<div class="row alert alert-info" style="margin:0px; padding:3px;">
    <form class="form-inline" method="get" action="getAll" >
        <div class="form-group">
            <label class="" for="activename">品类名称：</label>
            <input type="text" name="key" class="form-control" id="activename" placeholder="请输入品类名称">
        </div>
        <input type="submit" class="btn btn-danger" value="查询"/>
        &nbsp;&nbsp;
        <a class="btn btn-success" href="${pageContext.request.contextPath}/view/category/category_add.jsp">添加品类</a>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
    <table class="table  table-condensed table-striped">
        <tr>
            <th>品类编号</th>
            <th>品类名称</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${requestScope.categorylist}" var="category" varStatus="i">
            <tr>
                <td>${i.index+1}</td>
                <td>${category.category_name}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/category/getCategoryById?id=${category.id}">修改</a>
                    <a href="${pageContext.request.contextPath}/category/delete?id=${category.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div style="margin: auto;color: red">${requestScope.msg}</div>
</div>
</body>
</html>
