<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/2/26
  Time: 11:09
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
<div style="background: lightgray;padding: 20px;width:500px">
    <c:forEach items="${sessionScope.depts}" var="dept">
        <c:forEach items="${sessionScope.posts}" var="post">
            <c:if test="${sessionScope.employee.postId==post.id&&post.deptId==dept.id}">
                <p><b style="color: cornflowerblue">部门：</b>${dept.name}</p>
                <p><b style="color: cornflowerblue">职位：</b>${post.name}</p>
            </c:if>
        </c:forEach>
    </c:forEach>
    <c:forEach items="${sessionScope.trains}" var="train">
        <c:if test="${sessionScope.employee.trainId==train.id&&train.state==1}">
            <p><b style="color: cornflowerblue">培训名称：</b>${train.name}</p>
            <p><b style="color: cornflowerblue">培训内容：</b>${train.content}</p>
            <p><b style="color: cornflowerblue">开始时间：</b>${train.beginTime}</p>
            <p><b style="color: cornflowerblue">结束时间：</b>${train.endTime}</p>
        </c:if>
    </c:forEach>
</div>
</body>
</html>
