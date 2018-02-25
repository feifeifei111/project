<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/1/29
  Time: 15:57
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
    <style>
        .d{
            float: left;
        }
    </style>
</head>
<body>
<div style="margin: auto;width: 500px">
    <a href="adminBack">返回</a><br>
    <form action="addDept" method="post" style="float: left">
        <input type="text" name="name" value="部门名称" required>
        <input type="submit" value="添加部门">&nbsp;&nbsp;
    </form>
    <form action="searchEmployee" method="post">
        <input type="text" name="name">
        <input type="submit" value="搜索员工">
    </form>
    <c:forEach items="${sessionScope.depts}" var="dept">
        <div class="d" style="background:lightgray;margin: 10px">
            <p>部门名称：${dept.name}</p>
            <p>创建时间：<fmt:formatDate value="${dept.createTime}" type="date"/></p>
            <a href="deleteDept?deptId=${dept.id}">删除部门</a>&nbsp;
            <a href="postManagement?deptId=${dept.id}">查看部门内职位</a>&nbsp;
            <a href="arrangeDeptTrain?deptId=${dept.id}">安排部门员工培训</a>
        </div>
    </c:forEach>
</div>


</body>
</html>
