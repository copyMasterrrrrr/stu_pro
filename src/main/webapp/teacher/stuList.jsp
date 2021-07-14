<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2021/6/20
  Time: 12:38:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />

    <style type="text/css">
        body {
            padding-bottom: 40px;
            background: white;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }
        .label{
            display: inline-block;
            margin-top: 30px;
            margin-left: 30px;
            height: 30px;
            padding-top: 8px;
        }
    </style>
</head>
<body>

<form class="form-inline definewidth m20" action="${pageContext.request.contextPath}/findByStuName.action" method="post">
    学生名称：
    <input type="text" name="name" id="username" class="abc input-default" >&nbsp;&nbsp;
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp;
</form>
<br>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>序号</th>
        <th>学生账号</th>
        <th>学生密码</th>
        <th>学生性别</th>
        <th>学生电话</th>
        <th>学生姓名</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${stuList}" var="s" varStatus="c">
        <tr >
            <td>${c.count}</td>
            <td>${s.username}</td>
            <td>${s.password}</td>
            <td>${s.sex}</td>
            <td>${s.phone}</td>
            <td>${s.nickname}</td>
            <td>
                <a href="${pageContext.request.contextPath}/findById.action?uid=${s.id}">修改</a>
                <a href="${pageContext.request.contextPath}/delete.action?uid=${s.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script>
</script>
