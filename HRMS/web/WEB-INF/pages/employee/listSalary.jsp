<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/2/4
  Time: 15:36
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
<table>
    <caption>我的工资表</caption>
    <tr>
        <th>基本工资</th>
        <th>项目奖金</th>
        <th>奖惩金额</th>
        <th>社会保险</th>
        <th>总计</th>
        <th>日期</th>
    </tr>
    <c:forEach items="${sessionScope.salaries}" var="salary">
        <tr>
            <td>${salary.basic}</td>
            <td>${salary.bonus}</td>
            <td>${salary.rewAndPun}</td>
            <td>${salary.social}</td>
            <td>${salary.basic+salary.bonus+salary.rewAndPun+salary.social}</td>
            <td>${salary.year}年${salary.month}月</td>
        </tr>
    </c:forEach>
</table>
<c:forEach begin="1" end="${sessionScope.totalPages}" var="i">
    <a href="showSalary?currentPage=${i}">${i}</a>
</c:forEach>
</body>
</html>
