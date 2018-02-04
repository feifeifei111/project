<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <c:if test="${sessionScope.attend==null}">
        <a href="signIn">签到</a>
    </c:if>
    <c:if test="${sessionScope.attend.beginState==1&&sessionScope.attend.endState==0}">
        <a href="signOut?attendId=${sessionScope.attend.id}">签退</a>
    </c:if>
    <a href="selectAttendance">查看打卡记录</a>
    <a href="selectRewAndPun">查看奖惩记录</a>
</body>
</html>
