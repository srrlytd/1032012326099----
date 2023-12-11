<%--
  Created by IntelliJ IDEA.
  User: FuTao
  Date: 2022/10/27
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>进货录入</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; " >
        <li>进货管理</li>
        <li>进货录入</li>
        <li>录入结果</li>
    </ul>
</div>
<div class="row">
    <div class="col-sm-3 col-sm-offset-4">
        点击菜单"销售报表"，查看录入结果；若要继续录入，请点击
        <a class="btn btn-warning" href="${pageContext.request.contextPath}/view/sale/do_sale.jsp">继续销售</a>
    </div>
</div>
</body>
</html>
