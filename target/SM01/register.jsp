<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://ajax.aspnetcdn.com/ajax/bootstrap/4.2.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
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
                                <h1>欢迎注册</h1>
                            </div>
                            <p>注册登录界面模板</p>
                        </div>
                    </div>
                </div>
                <!-- Form Panel    -->
                    <div class="col-lg-6 bg-white">
                        <div class="form d-flex align-items-center">
                            <div class="content">
                                <font color="red">${registerMsg}</font>
                                <form id="registerForm" action="${pageContext.request.contextPath }/register.action" method="post">
                                <div class="form-group">
                                    <input id="register-username" class="input-material" type="text" name="username" placeholder="请输入用户名" >
                                </div>
                                <div class="form-group">
                                    <input id="register-password" class="input-material" type="password" name="password" placeholder="请输入密码"   >
                                </div>
                                <div class="form-group">
                                    <input id="register-passwords" class="input-material" type="text" name="nickname" placeholder="真实姓名"   >
                                </div>
                                <div class="form-group">
                                    <input  class="input-material" type="text" name="phone" placeholder="联系方式"   >
                                </div>
                                <div >
                                    <input   type="radio" name="type" value="0" > 学生
                                    <input   type="radio" name="type" value="1" > 导师
                                </div>
                                    <br>
                                <div >
                                    <input   type="radio" name="sex" value="男" > 男
                                    <input   type="radio" name="sex" value="女" > 女
                                </div>
                                    <br>

                                <div class="form-group">
                                    <button id="regbtn" type="submit"  name="registerSubmit" class="btn btn-primary">注册</button>
                                </div>
                                </form>
                                <small>已有账号?</small><a href="login.jsp" class="signup">&nbsp;登录</a>
                            </div>
                        </div>
                    </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="js/jquery-1.11.3.min.js"></script>
<script>
</script>
</html>
