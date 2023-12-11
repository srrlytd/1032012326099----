<%--
  Created by IntelliJ IDEA.
  User: FuTao
  Date: 2022/10/24
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>添加供应商</title>
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
        <li>供应商</li>
        <li>添加供应商</li>
    </ul>
</div>
<form action="${pageContext.request.contextPath}/supplier/add" class="form-horizontal" method="post">
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">供应商名称</label>
                <div class="col-sm-9">
                    <input type="text" name="supplierName" class="form-control input-sm"/>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">地址</label>
                <div class="col-sm-9">
                    <input type="text" name="address" class="form-control input-sm" />
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">联系人</label>
                <div class="col-sm-9">
                    <input type="text" name="contactsName" class="form-control input-sm" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">联系电话</label>
                <div class="col-sm-9">
                    <input type="text" name="tel" class="form-control input-sm" />
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    <div class="row">
        <div class="col-sm-3 col-sm-offset-4">
            <input  type="submit" class="btn btn-success" value="提交"/>
            <a class="btn btn-warning" href="${pageContext.request.contextPath}/supplier/getAll">返回上一级</a>
        </div>
    </div>
</form>
</body>
</html>
