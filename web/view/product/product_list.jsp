<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FuTao
  Date: 2022/10/25
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>商品列表</title>
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
        <li>商品管理</li>
        <li>商品列表</li>
    </ul>
</div>
<div class="row alert alert-info" style="margin:0px; padding:3px;">
    <form class="form-inline" action="${pageContext.request.contextPath}/product/getAll">
        <div class="form-group">
            <label class="" for="activename">商品名称：</label>
            <input type="text" name="key" class="form-control" id="activename" placeholder="请输入商品名称">
        </div>
        <input type="submit" class="btn btn-danger" value="查询"/>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
    <table class="table  table-condensed table-striped">
        <tr>
            <th>商品条码</th>
            <th>品类</th>
            <th>商品名称</th>
            <th>销售单价(元)</th>
            <th>供应商</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${requestScope.productlist}" var="product" varStatus="i">
            <tr>
                <td>${product.barCode}</td>
                <td>${product.categoryName}</td>
                <td>${product.productName}</td>
                <td>${product.price}</td>
                <td>${product.supplierName}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/product/getProductById?id=${product.id}">修改</a>
                    <a href="${pageContext.request.contextPath}/product/delete?id=${product.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
<%--        <tr>--%>
<%--            <td>7293884239</td>--%>
<%--            <td>饮料</td>--%>
<%--            <td>农夫山泉500ml</td>--%>
<%--            <td>2.00</td>--%>
<%--            <td>济南九州通商贸有限公司</td>--%>
<%--            <td>--%>
<%--                <a href="product_modify.html">修改</a>--%>
<%--                <a href="#">删除</a>--%>
<%--            </td>--%>
<%--        </tr>--%>
    </table>
</div>
</body>
</html>
