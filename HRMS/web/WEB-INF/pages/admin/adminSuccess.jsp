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
</head>
<body>
<form>
    <input type="submit" value="部门">
</form>
<form>
    <input type="submit" value="职位">
</form>
<form>
    <input type="submit" value="员工">
</form>
<form>
    <input type="submit" value="薪资">
</form>
<form>
    <input type="submit" value="考勤">
</form>
<form>
    <input type="submit" value="培训">
</form>
<form>
    <input type="submit" value="奖惩">
</form>
<form action="listResume" method="post">
    <input type="submit" value="招聘">
</form>
</body>
</html>
