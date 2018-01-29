<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<c:forEach items="${sessionScope.posts}" var="post">
    <div>
        <p>职位名称：${post.name}</p>
        <p>职位描述：${post.createTime}</p>
        <p>创建时间：${post.createTime}</p>
        <a>修改职位</a>&nbsp;
        <a>删除职位</a>&nbsp;
        <a href="employeeMessage?postId=${post.id}">查看职位所有员工</a>&nbsp;
    </div>
</c:forEach>

</body>
</html>
