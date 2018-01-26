<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/1/25
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
    <link rel="stylesheet" href="../../css/style.css">
</head>
<body>
<h1>人力资源管理系统</h1>
<div class="container w3">
    <h2>现在登录</h2>
    <form action="login" method="post">
        <div class="username">
            <span class="username" style="height:19px">账号:</span>
            <input type="text" name="name" class="name" placeholder="" required="">
            <div class="clear"></div>
        </div>
        <div class="password-agileits">
            <span class="username"style="height:19px">密码:</span>
            <input type="password" name="pass" class="password" placeholder="" required="">
            <div class="clear"></div>
        </div>
        <div class="rem-for-agile1">
            <input type="radio" name="identify" value="0" checked>游客登录&nbsp;&nbsp;&nbsp;
            <input type="radio" name="identify" value="1">员工登录&nbsp;&nbsp;&nbsp;
            <input type="radio" name="identify" value="2">管理员登录
        </div>
        <div class="rem-for-agile">
            <input type="checkbox" name="remember" class="remember">记得我
            　　
            <br>
            <a href="#">忘记了密码</a>&nbsp;&nbsp;
            <a href="registerMiddle" class="login">注册</a>
        </div>
        <div class="login-w3">
            <input type="submit" class="login" value="登录">
        </div>

    </form>
    <form>

    </form>
</div>
<%--div class="footer-w3l">
    <p> 人力资源后台登录系统</p>
</div>--%>
</body>
</html>
