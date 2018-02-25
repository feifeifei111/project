<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/2/25
  Time: 21:41
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
<form action="dissent" method="post">
    复议原因：<input type="text" name="reason">
    少算(多算)金额：<input type="number" name="money" value="0">
    <input type="submit" value="确定">
</form>
</body>
</html>
