<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/1/30
  Time: 13:56
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
<c:forEach items="${sessionScope.employees}" var="employee">
    <c:forEach items="${sessionScope.depts}" var="dept">
        <c:forEach items="${sessionScope.posts}" var="post">
            <c:if test="${employee.postId==post.id&&post.deptId==dept.id}">
                <div>
                    <p>姓名：${employee.name}</p>
                    <p>性别：${employee.sex}</p>
                    <p>生日：${employee.birthday}</p>
                    <p>部门：${dept.name}</p>
                    <p>职位：${post.name}</p>
                    <c:if test="${employee.state==1}">
                        <p>状态：在职</p>
                        <form action="dismiss" method="post">
                            <input type="hidden" name="employeeId" value="${employee.id}">
                            <input type="submit" value="解聘">
                        </form>
                    </c:if>
                    <c:if test="${employee.state==0}">
                        <p>状态：离职</p>
                    </c:if>
                </div>
            </c:if>
        </c:forEach>
    </c:forEach>
</c:forEach>
</body>
</html>
