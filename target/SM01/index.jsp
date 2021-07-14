<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2021/6/23
  Time: 22:07:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://ajax.aspnetcdn.com/ajax/bootstrap/4.2.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.default.css" id="theme-stylesheet">
</head>
<body>
<div class="page login-page">
    <div class="container d-flex align-items-center">
        <div class="form-holder has-shadow">
            <div class="row">
                <!-- Logo & Information Panel-->
                <div class="col-lg-6">
                    <div class="info d-flex align-items-center">
                        <div class="content">
                            <div class="logo">
                                <h1>欢迎登录</h1>
                            </div>
                            <p>学生导师管理系统</p>
                        </div>
                    </div>
                </div>
                <!-- Form Panel    -->
                <div class="col-lg-6 bg-white">
                    <div class="form d-flex align-items-center">
                        <div class="content">
                            <font color="red">${loginMsg}</font>
                            <form action="${pageContext.request.contextPath }/login.action" method="post" id="loginFrom"  class="form-validate">
                                <div class="form-group">
                                    <input id="login-username" type="text" name="username" required data-msg="请输入用户名" placeholder="用户名" value="t0012" class="input-material">
                                </div>
                                <div class="form-group">
                                    <input id="login-password" type="password" name="password" required data-msg="请输入密码" placeholder="密码" value="1232" class="input-material">
                                </div>
                                <button id="login"  type="submit" class="btn btn-primary">登录</button>
                            </form>
                            <br />
                            <small>没有账号?</small><a href="register.jsp" class="signup">&nbsp;注册</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
