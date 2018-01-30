<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/1/29
  Time: 19:19
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
<a href="addRecruitMiddle">添加招聘信息</a>
    <c:forEach items="${sessionScope.depts}" var="dept">
        <c:forEach items="${sessionScope.posts}" var="post">
            <c:if test="${sessionScope.recruit.postId==post.id&&post.deptId==dept.id}">
                <div class="d1">
                    <form action="updateRecruit" method="post">
                        <span>部门：${dept.name}</span><p>
                        <span>职位：${post.name}</span><p>
                        职位需求：<input type="text" name="requirement" value="${sessionScope.recruit.requirement}"></p>
                        薪资待遇：<input type="text" name="salaryRange" value="${sessionScope.recruit.salaryRange}"></p>
                        公司简介：<input type="text" name="introduction" value="${sessionScope.recruit.introduction}"></p>
                        公司地址：<input type="text" name="address" value="${sessionScope.recruit.address}"></p>
                        <input type="hidden" name="recruitId" value="${sessionScope.recruit.id}">
                        <input type="submit" value="确认修改">
                    </form>

                </div>
            </c:if>
        </c:forEach>
    </c:forEach>

</body>
</html>
