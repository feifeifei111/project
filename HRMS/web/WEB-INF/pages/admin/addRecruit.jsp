<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/1/29
  Time: 10:58
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
    <form action="addRecruit" method="post">
        职位名称：<select name="postId">
            <c:forEach items="${sessionScope.posts}" var="post">
                <option value="${post.id}">${post.name}</option>
            </c:forEach>
        </select><br>
        职位要求：<input type="text" name="requirement"><br>
        薪资：<input type="text" name="salaryRange"><br>
        公司简介：<input type="text" name="introduction"><br>
        公司地址：<input type="text" name="address"><br>
        <input type="submit" value="发布">
    </form>
</body>
</html>
