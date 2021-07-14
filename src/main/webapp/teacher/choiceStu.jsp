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
<body>
<font color="red">${choice}</font>
<form action="${pageContext.request.contextPath}/choiceStu.action" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <input type="hidden" name="tid" value="${user.id}">
        <tr>
            <td width="10%" class="tableleft">选择学生</td>
            <td>
                    <c:forEach items="${stuList}" var="t" >
                        <input type="checkbox" name="sids" value="${t.id}"> ${t.nickname}
                    </c:forEach>
            </td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button  type="submit" class="btn btn-primary">保存</button> &nbsp;
            </td>
        </tr>
    </table>
</form>
</body>
</html>
