<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/1/29
  Time: 17:02
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
<c:forEach items="${sessionScope.employeeList}" var="employee">
    <c:forEach items="${sessionScope.depts}" var="dept">
        <c:forEach items="${sessionScope.posts}" var="post">
            <c:if test="${employee.postId==post.id&&post.deptId==dept.id}">
                <div style="float: left">
                    <p>员工姓名：${employee.name}</p>
                    <p>员工性别：${employee.sex}</p>
                    <p>出生日期：${employee.birthday}</p>
                    <p>员工部门：${dept.name}</p>
                    <p>员工职位：${post.name}</p>
                    <c:if test="${employee.state==1}">
                        <p>员工状态：在职</p>
                        <form action="dismiss" method="post">
                            <input type="hidden" name="employeeId" value="${employee.id}">
                            <input type="submit" value="解聘">
                        </form>
                    </c:if>
                    <c:if test="${employee.state==0}">
                        <p>员工状态：离职</p>
                    </c:if>
                    <c:if test="${sessionScope.trainId==0}">
                        <p>非培训状态</p>
                        <form action="arrangeTrain" method="post">
                            <input type="hidden" name="employeeId" value="${employee.id}">
                            <input type="submit" value="安排培训">
                        </form>
                    </c:if>
                    <c:if test="${employee.trainId!=0}">
                        <p>培训中</p>
                    </c:if>
                </div>
            </c:if>
        </c:forEach>
    </c:forEach>
</c:forEach>
<c:forEach begin="1" end="${sessionScope.totalPages}" var="i">
    <form style="float: left" action="showEmployee" method="post">
        <input type="hidden" name="currentPage" value="${i}">
        <input type="hidden" name="postId" value="${sessionScope.postId}">
        <input type="submit" value="${i}">
    </form>
</c:forEach>
</body>
</html>
