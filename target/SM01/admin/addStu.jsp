<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2021/6/20
  Time: 13:05:52
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


    </style>
</head>
<script>
    function goBack(){
        location.href='${pageContext.request.contextPath}/findAllStu.action'
    }
</script>
<body>
<font color="red">${addMsg}</font>
<form action="${pageContext.request.contextPath}/add.action" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <input type="hidden" name="type" value="0">
        <tr>
            <td width="10%" class="tableleft">学生账号</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">学生密码</td>
            <td><input type="text"   name="password"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">学生性别</td>
            <td>
                <input type="radio" name="sex" value="男" checked> 男
                <input type="radio" name="sex" value="女" > 女
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">学生电话</td>
            <td><input type="text"   name="phone"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">真实姓名</td>
            <td><input type="text"   name="nickname"/></td>
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
