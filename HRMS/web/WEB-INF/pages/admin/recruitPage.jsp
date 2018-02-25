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
    <style>
        .d{
            float: left;
            margin: 10px;
            background: lightgray;
        }
    </style>
</head>
<body>
<a href="adminBack">返回</a>&nbsp;&nbsp;
<a href="listResume">查看游客简历</a>&nbsp;&nbsp;
<a href="addRecruitMiddle">添加招聘信息</a><br>
<c:forEach items="${sessionScope.recruits}" var="recruit">
    <c:forEach items="${sessionScope.depts}" var="dept">
        <c:forEach items="${sessionScope.posts}" var="post">
            <c:if test="${recruit.postId==post.id&&post.deptId==dept.id}">
                <div class="d">
                    <p><b style="color: cornflowerblue">部门：</b>${dept.name}</p>
                    <p><b style="color: cornflowerblue">职位：</b>${post.name}</p>
                    <p><b style="color: cornflowerblue">职位需求：</b>${recruit.requirement}</p>
                    <p><b style="color: cornflowerblue">工资待遇：</b>${recruit.salary}</p>
                    <p><b style="color: cornflowerblue">公司简介：</b>${recruit.introduction}</p>
                    <p><b style="color: cornflowerblue">公司地址：</b>${recruit.address}</p>
                    <a href="updateRecruitMiddle?recruitId=${recruit.id}">修改招聘信息</a>&nbsp;
                    <a href="delete?recruitId=${recruit.id}">撤销发布</a>
                </div>
            </c:if>
        </c:forEach>
    </c:forEach>
</c:forEach>
<div style="clear: both">
    <c:forEach begin="1" end="${sessionScope.totalPages}" var="i">
        <a href="showAdminRecruit?currentPage=${i}">${i}</a>
    </c:forEach>
</div>
</body>
</html>
