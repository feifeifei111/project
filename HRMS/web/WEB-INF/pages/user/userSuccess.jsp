<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/1/26
  Time: 17:06
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
<c:if test="${sessionScope.resume!=null}">
    <form action="updateRusumeMiddle" method="post">
        <input type="submit" value="修改简历">
    </form>
</c:if>
<form action="process" method="post">
    <input type="submit" value="查看面试通知">
</form>
<c:forEach items="${sessionScope.recruitMessages}" var="recruit">
    <c:forEach items="${sessionScope.depts}" var="dept">
        <c:forEach items="${sessionScope.posts}" var="post">
            <c:if test="${recruit.postId==post.id&&post.deptId}">
                <div class="d1">
                    <p>部门：${dept.name}</p>
                    <p>职位：${post.name}</p>
                    <p>职位需求：${recruit.requirement}</p>
                    <p>工资范围：${recruit.salaryRange}</p>
                    <p>公司地址：${recruit.address}</p>
                    <form action="apply" method="post">
                        <input type="hidden" name="recruitId" value="${recruit.id}">
                        <input type="submit" value="申请职位">
                    </form>
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
