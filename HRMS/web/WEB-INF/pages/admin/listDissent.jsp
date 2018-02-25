<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/2/25
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
</head>
<body>
<a href="employeeMessage?postId=${sessionScope.postId}">返回</a><br>
<table border="1" cellspacing="0">
    <caption>复议表</caption>
    <tr>
        <th>复议原因</th>
        <th>金额</th>
        <th>日期</th>
        <th></th>
    </tr>
    <c:forEach items="${sessionScope.dissents}" var="dissent">
        <tr>
            <td>${dissent.reason}</td>
            <td>${dissent.money}</td>
            <td>${dissent.year}年${dissent.month}月</td>
            <td>
                <a href="accept?dissentId=${dissent.id}">同意复议</a>&nbsp;
                <a href="refuse?dissentId=${dissent.id}">拒绝复议</a>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
