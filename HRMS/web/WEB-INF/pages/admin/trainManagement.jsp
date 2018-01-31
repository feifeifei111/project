<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/1/30
  Time: 19:30
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
    <script src="js/jquery-3.1.0.js"></script>
    <script>
        $(function () {
            $("#in1").click(function () {
                $("#d1").css("display","block")
            });
            $("#a1").click(function () {
                $("#d2").css("display","block")
            })
        })

    </script>
</head>
<body>
<a href="adminBack">返回</a>
<div id="d1" style="display: none">
    <form>
        培训名称：<input  type="text" name="name">
        培训内容：<input type="text" name="content">
        起始时间：<input type="text" name="beginTime">
        结束时间：<input type="text" name="endTime">
        <input type="submit" value="添加">
    </form>
</div>
<input type="submit" value="新增培训内容" id="in1">
    <c:forEach items="${sessionScope.trains}" var="train">
        <div style="float: left">
            <p>培训名称：${train.name}</p>
            <p>培训内容：${train.content}</p>
            <p>起始时间：${train.beginTime}</p>
            <p>结束时间：${train.endTime}</p>
            <a href="deleteTrain?id=${train.id}">删除</a>&nbsp;&nbsp;
            <a href="#" id="a1">修改</a>
            <div id="d2" style="display: none">
                <form action="updateTrain" method="post">
                    <input type="hidden" name="id" value="${train.id}">
                    <input type="hidden" name="state" value="${train.state}">
                    培训名称：<input type="text" name="name" value="${train.name}">
                    培训内容：<input type="text" name="content" value="${train.content}">
                    起始时间：<input type="text" name="beginTime" value="${train.beginTime}">
                    结束时间：<input type="text" name="endTime" value="${train.endTime}">
                    <input type="submit" value="确认修改">
                </form>
            </div>
        </div>
    </c:forEach>
</body>
</html>
