<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/1/29
  Time: 10:12
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
<a href="listResume">查看游客简历</a>
<a href="addRecruitMiddle">添加招聘信息</a>
<c:forEach items="${sessionScope.recruits}" var="recruit">
    <c:forEach items="${sessionScope.depts}" var="dept">
        <c:forEach items="${sessionScope.posts}" var="post">
            <c:if test="${recruit.postId==post.id&&post.deptId==dept.id}">
                <div class="d1">
                    <p>部门：${dept.name}</p>
                    <p>职位：${post.name}</p>
                    <p>职位需求：${recruit.requirement}</p>
                    <p>工资待遇：${recruit.salaryRange}</p>
                    <p>公司简介：${recruit.introduction}</p>
                    <p>公司地址：${recruit.address}</p>
                    <a href="updateRecruitMiddle?recruitId=${recruit.id}">修改招聘信息</a>&nbsp;
                    <a href="delete?recruitId=${recruit.id}">撤销发布</a>
                </div>
            </c:if>
        </c:forEach>
    </c:forEach>
</c:forEach>
<c:forEach begin="1" end="${sessionScope.totalPages}" var="i">
    <a href="showRecruit?currentPage=${i}">${i}</a>
</c:forEach>
</body>
</html>
