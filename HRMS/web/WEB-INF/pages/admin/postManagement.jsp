<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/1/29
  Time: 16:26
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
<a href="deptManagement">返回</a>
<div>
    <form action="addPost" method="post">
        <input type="text" name="name" value="职位名称" required><br>
        <input type="text" name="description" value="职位描述" required><br>
        <input type="hidden" name="deptId" value="${sessionScope.deptId}">
        <input style="text-align: center" type="submit" value="添加">
    </form>
</div>

<c:forEach items="${sessionScope.posts}" var="post">
    <div style="background: lightgray;margin: 10px;float: left">
        <p>职位名称：${post.name}</p>
        <p>职位描述：${post.description}</p>
        <p>创建时间：<fmt:formatDate value="${post.createTime}" type="date"/></p>
        <a href="deletePost?postId=${post.id}">删除职位</a>&nbsp;
        <a href="employeeMessage?postId=${post.id}">查看职位所有员工</a>
    </div>
</c:forEach>

</body>
</html>
