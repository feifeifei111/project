<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/2/3
  Time: 9:56
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
    <caption>${sessionScope.year}年${sessionScope.month}月考勤表</caption>
    <tr>
        <th>签到时间</th>
        <th>签到状态</th>
        <th>签退时间</th>
        <th>签退状态</th>
    </tr>
    <c:forEach items="${sessionScope.attendances}" var="attendance">
        <tr>
            <td>${attendance.begintime}</td>
            <c:if test="${attendance.beginState==1}">
                <td>正常</td>
            </c:if>
            <c:if test="${attendance.beginState==2}">
                <td>迟到</td>
            </c:if>
            <c:if test="${attendance.beginState==3}">
                <td>旷工</td>
            </c:if>
            <td>${attendance.endTime}</td>
            <c:if test="${attendance.endState==1}">
                <td>正常</td>
            </c:if>
            <c:if test="${attendance.endState==2}">
                <td>早退</td>
            </c:if>
            <c:if test="${attendance.endState==3}">
                <td>旷工</td>
            </c:if>
        </tr>
    </c:forEach>
</table>
<a href="before">上个月</a>&nbsp;&nbsp;
<c:forEach begin="1" end="${sessionScope.totalPages}" var="i">
    <a href="showAttendance?currentPage=${i}">${i}</a>
</c:forEach>&nbsp;&nbsp;
<a href="after">下个月</a>
</body>
</html>
