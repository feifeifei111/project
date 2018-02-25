<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/1/31
  Time: 13:43
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
<a href="employeeMessage?postId=${sessionScope.postId}">返回</a>
<table border="1" cellspacing="0">
    <tr>
        <th>培训名称</th>
        <th>培训内容</th>
        <th>起始时间</th>
        <th>结束时间</th>
        <th></th>
    </tr>
    <c:forEach items="${sessionScope.trains}" var="train">
        <tr>
            <td>${train.name}</td>
            <td>${train.content}</td>
            <td>${train.beginTime}</td>
            <td>${train.endTime}</td>
            <td>
                <form action="addEmployeeTrain" method="post">
                    <input type="hidden" name="trainId" value="${train.id}">
                    <input type="hidden" name="employeeId" value="${sessionScope.employeeId}">
                    <input type="submit" value="选择">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
