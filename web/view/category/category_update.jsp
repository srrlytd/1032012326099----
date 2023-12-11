<%--
  Created by IntelliJ IDEA.
  User: FuTao
  Date: 2022/10/24
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>品类详情</title>
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
        <li>商品中心</li>
        <li>品类管理</li>
        <li>品类详情</li>
    </ul>
</div>
<form action="${pageContext.request.contextPath}/category/update" class="form-horizontal">
    <input type="hidden" value="modify" name="action" >
    <input type="hidden" name="strid" value="${requestScope.category.id}">
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">品类编号</label>
                <div class="col-sm-9">
                    <input type="text" name="" disabled="disabled" class="form-control input-sm" value="${requestScope.category.id}" />

                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">品类名称</label>
                <div class="col-sm-9">
                    <input type="text" name="categoryName" class="form-control input-sm" value="${requestScope.category.category_name}"/>
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    <div class="row">
        <div class="col-sm-3 col-sm-offset-4">
            <input  type="submit" class="btn btn-success" value="提交"/>
            <a class="btn btn-warning" href="${pageContext.request.contextPath}/category/getAll">返回上一级</a>
        </div>
    </div>
</form>
</body>
</html>
