<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        div{
            float: left;
        }
    </style>
</head>
<body>
<a href="adminBack">返回</a>
<form action="addDept" method="post">
    <input type="text" name="name" value="部门名称" required>添加部门
</form>
<c:forEach items="${sessionScope.depts}" var="dept">
    <div>
        <p>部门名称：${dept.name}</p>
        <p>创建时间：${dept.createTime}</p>
        <%--<a>修改部门</a>&nbsp;--%>
        <a href="deleteDept?deptId=${dept.id}">删除部门</a>&nbsp;
        <a href="postManagement?deptId=${dept.id}">查看部门内职位</a>&nbsp;
        <a href="arrangeDeptTrain?deptId=${dept.id}">安排此部门员工参加培训</a>
    </div>
</c:forEach>
<form action="searchEmployee" method="post">
    <input type="text" name="name">
    <input type="submit" value="搜索员工">
</form>
</body>
</html>
