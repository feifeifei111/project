<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/2/4
  Time: 15:36
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
        .black_overlay{
            display: none;
            position: absolute;
            top: 0%;
            left: 0%;
            width: 100%;
            height: 100%;
            background-color: black;
            z-index:1001;
            -moz-opacity: 0.8;
            opacity:.80;
            filter: alpha(opacity=88);
        }
        .white_content {
            display: none;
            position: absolute;
            top: 25%;
            left: 25%;
            width: 55%;
            height: 55%;
            padding: 20px;
            border: 10px solid orange;
            background-color: white;
            z-index:1002;
            overflow: auto;
        }
    </style>

</head>
<body>
<a href="employeeBack">返回</a>
<table border="1" cellspacing="0">
    <caption>我的工资表</caption>
    <tr>
        <th>基本工资</th>
        <th>项目奖金</th>
        <th>奖惩金额</th>
        <th>社会保险</th>
        <th>总计</th>
        <th>日期</th>
        <th></th>
    </tr>
    <c:forEach items="${sessionScope.salaries}" var="salary">
        <tr>
            <td>${salary.basic}</td>
            <td>${salary.bonus}</td>
            <td>${salary.rewAndPun}</td>
            <td>${salary.social}</td>
            <td><fmt:formatNumber type="number" value="${salary.basic+salary.bonus+salary.rewAndPun+salary.social}" maxFractionDigits="2"/> </td>
            <td>${salary.year}年${salary.month}月</td>
            <td>
                <form action="dissentMiddle" method="post">
                    <input type="hidden" name="year" value="${salary.year}">
                    <input type="hidden" name="month" value="${salary.month}">
                    <input type="hidden" name="salaryId" value="${salary.id}">
                    <input type="submit" value="申请复议">
                </form>
                <%--<a href="javascript:void (0)" onclick="document.getElementById('light').style.display='block';
                 document.getElementById('fade').style.display='block'">申请复议</a>
                <div id="light" class="white_content">
                    <a href="javascript:void(0)" onclick="document.getElementById('light').style.display='none';
                 document.getElementById('fade').style.display='none'">取消申请复议</a>
                    <form action="dissent" method="post">
                        <input type="hidden" name="year" value="${salary.year}">
                        <input type="hidden" name="month" value="${salary.month}">
                        <input type="hidden" name="salaryId" value="${salary.id}">
                        复议理由：<input type="text" name="reason" required><br>
                        少算(多算)的金额：<input type="number" name="money" value="0"><br>
                        <input type="submit" value="申请复议">
                    </form>
                </div>
                <div id="fade" class="black_overlay"></div>--%>
            </td>
        </tr>
    </c:forEach>
</table>
<c:forEach begin="1" end="${sessionScope.totalPages}" var="i">
    <a href="showSalary?currentPage=${i}">${i}</a>
</c:forEach>
</body>
</html>
