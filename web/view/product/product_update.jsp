<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FuTao
  Date: 2022/10/26
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>商品详情</title>
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
        <li><a href="#">商品中心</a></li>
        <li>商品管理</li>
        <li>商品详情</li>
    </ul>
</div>
<form action="${pageContext.request.contextPath}/product/update" class="form-horizontal" method="post">
    <input name="id" type="hidden" value="${requestScope.product.id}">
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">商品条码</label>
                <div class="col-sm-9">
                    <input type="text" name="barCode" class="form-control input-sm" value="${requestScope.product.barCode}" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">商品名称</label>
                <div class="col-sm-9">
                    <input type="text" name="productName" class="form-control input-sm" value="${requestScope.product.productName}" />
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">销售单价</label>
                <div class="col-sm-9">
                    <input type="text" name="salePrice" class="form-control input-sm" value="${requestScope.product.price}" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">供应商</label>
                <div class="col-sm-6">
                    <select name="supplierId" class="form-control input-sm">
                        <c:forEach items="${requestScope.supplierlist}" var="supplier">
                            <option value="${supplier.id}"<c:if test="${requestScope.product.supplierId == supplier.id}">selected="selected"</c:if>>${supplier.supplierName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">品类</label>
                <div class="col-sm-6">
                    <select name="categoryId" class="form-control input-sm">
                        <c:forEach items="${requestScope.categorylist}" var="category">
                            <option value="${category.id}"<c:if test="${requestScope.product.categoryId == category.id}">selected="selected"</c:if>>${category.category_name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            </div>
        </div>
    </div>
    <!--结束 -->
    <div class="row">
        <div class="col-sm-3 col-sm-offset-4">
            <input  type="submit" class="btn btn-success" value="提交"/>
            <a class="btn btn-warning" href="${pageContext.request.contextPath}/product/getAll">返回上一级</a>
        </div>
    </div>
</form>
</body>
</html>
