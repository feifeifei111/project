<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/2/3
  Time: 22:04
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
<a href="employeeBack">返回</a>
<table border="1" cellspacing="0">
    <caption>${sessionScope.year}年${sessionScope.month}月奖惩表</caption>
    <tr>
        <th>奖惩金额</th>
        <th>时间</th>
        <th>原因</th>
    </tr>
    <c:forEach items="${sessionScope.rewAndPuns}" var="rewAndPun">
        <tr>
            <td>${rewAndPun.money}</td>
            <td>${rewAndPun.time}</td>
            <td>${rewAndPun.cause}</td>
        </tr>
    </c:forEach>
</table>
<a href="beforeRP">上个月</a>&nbsp;&nbsp;
<c:forEach begin="1" end="${sessionScope.totalPages}" var="i">
    <a href="showRewAndPun?currentPage=${i}">${i}</a>
</c:forEach>&nbsp;&nbsp;
<a href="afterRP">下个月</a>
</body>
</html>
