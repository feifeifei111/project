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
</head>
<body>
<c:forEach items="${sessionScope.depts}" var="dept">
    <div>
        <p>部门名称：${dept.name}</p>
        <p>创建时间：${dept.createTime}</p>
        <a>修改部门</a>&nbsp;
        <a>删除部门</a>&nbsp;
        <a href="postMessage?deptId=${dept.id}">查看部门内职位</a>&nbsp;
    </div>
</c:forEach>
</table>
</body>
</html>
