<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/1/27
  Time: 16:14
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
    <script src="js/jquery-3.1.0.js"></script>
    <style>
        form{
            float: left;
        }
    </style>
</head>
<body>
<form action="deptManagement" method="post">
    <input type="submit" value="部门管理">
</form>
<form action="calculateSalary" method="post">
    <input type="submit" id="in1" value="结算上月薪资">
</form>
<form>
    <input type="submit" value="考勤管理">
</form>
<form action="trainManagementMiddle" method="post">
    <input type="submit" value="培训管理">
</form>
<form>
    <input type="submit" value="奖惩管理">
</form>
<form action="recruitPage" method="post">
    <input type="submit" value="招聘管理">
</form>
</body>
</html>
