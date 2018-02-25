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
<a href="deptManagement">返回</a><br>
<c:forEach items="${sessionScope.employees}" var="employee">
    <c:forEach items="${sessionScope.depts}" var="dept">
        <c:forEach items="${sessionScope.posts}" var="post">
            <c:if test="${employee.postId==post.id&&post.deptId==dept.id}">
                <div style="margin: 10px;background: lightgray;float: left;padding-left: 10px">
                    <p>员工姓名：${employee.name}</p>
                    <p>员工性别：${employee.sex}</p>
                    <p>出生日期：${employee.birthday}</p>
                    <p>员工部门：${dept.name}</p>
                    <p>员工职位：${post.name}</p>
                    <c:if test="${employee.state==1}">
                        <p>员工状态：在职</p>

                        <c:if test="${employee.trainId!=0}">
                            <p>培训中</p>
                        </c:if>
                        <%--<form action="changePost" method="post" style="padding-left: auto;text-align: center">
                            部门：<select id="dept">
                            <option value="0">请选择</option>
                            <c:forEach items="${sessionScope.depts}" var="dp">
                                <option value="${dp.id}">${dp.name}</option>
                            </c:forEach>
                        </select>&nbsp;&nbsp;
                            职位：<select id="position" name="postId">
                            <option value="0">请选择</option>
                        </select>
                            <input type="hidden" name="employeeId" value="${employee.id}">
                            <input type="submit" value="换岗">&nbsp;&nbsp;
                        </form>
                        <form action="selectSingleAttend" method="post" style="float: left">
                            <input type="hidden" name="employeeId" value="${employee.id}">
                            <input type="submit" value="查看考勤">&nbsp;
                        </form>
                        &lt;%&ndash;<form action="selectEmployeeRAP" method="post" style="float: left">
                            <input type="hidden" name="employeeId" value="${employee.id}">
                            <input type="submit" value="查看奖惩">&nbsp;
                        </form>&ndash;%&gt;
                        <c:if test="${employee.trainId==0}">
                            <form action="arrangeSingleTrain" method="post" style="float: left">
                                <input type="hidden" name="employeeId" value="${employee.id}">
                                <input type="submit" value="安排培训">&nbsp;&nbsp;
                            </form>
                        </c:if>
                        <form action="dismiss" method="post" style="text-align: center">
                            <input type="hidden" name="employeeId" value="${employee.id}">
                            <input type="submit" value="解聘">
                        </form>--%>
                    </c:if>
                    <c:if test="${employee.state==0}">
                        <p>员工状态：离职</p>
                    </c:if>
                </div>
            </c:if>
        </c:forEach>
    </c:forEach>
</c:forEach>
</body>
</html>
