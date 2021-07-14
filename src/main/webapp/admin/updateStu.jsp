<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2021/6/20
  Time: 13:05:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


    </style>
</head>
<script>
    function goBack(){
        location.href='${pageContext.request.contextPath}/findAllStu.action'
    }
</script>
<body>
<font color="red">${updateMsg}</font>
<form action="${pageContext.request.contextPath}/update.action" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <input type="hidden" name="type" value="0">
        <input type="hidden" name="id" value="${stu.id}">
        <tr>
            <td width="10%" class="tableleft">学生账号</td>
            <td><input type="text" value="${stu.username}" name="username"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">学生密码</td>
            <td><input type="text" value="${stu.password}"  name="password"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">学生性别</td>
            <td>
                <input type="radio" name="sex" value="男" <c:if test="${stu.sex=='男'}"> checked='checked'  </c:if> > 男
                <input type="radio" name="sex" value="女" <c:if test="${stu.sex=='女'}"> checked='checked'  </c:if>> 女
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">学生电话</td>
            <td><input type="text" value="${stu.phone}"  name="phone"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">真实姓名</td>
            <td><input type="text" value="${stu.nickname}"  name="nickname"/></td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button  type="submit" class="btn btn-primary">保存</button> &nbsp;
                &nbsp;<button onclick="goBack()" type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
