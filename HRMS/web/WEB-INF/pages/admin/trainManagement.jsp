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
<a href="adminBack">返回</a>&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" value="新增培训内容" id="in1"><br>
<div id="d1" style="display: none">
    <form action="addTrain" method="post">
        培训名称：<input  type="text" name="name" required><br>
        培训内容：<input type="text" name="content" required><br>
        起始时间：<input type="text" name="beginTime" value="年-月-日 时:分"><br>
        结束时间：<input type="text" name="endTime" value="年-月-日 时:分"><br>
        <input type="submit" value="添加">
    </form>
</div>
    <c:forEach items="${sessionScope.trains}" var="train">
        <div style="float: left;width: 200px;background: lightgray;margin: 10px">
            <p><b style="color: cornflowerblue">培训名称</b>：${train.name}</p>
            <p><b style="color: cornflowerblue">培训内容：</b>${train.content}</p>
            <p><b style="color: cornflowerblue">起始时间：</b>${train.beginTime}</p>
            <p><b style="color: cornflowerblue">结束时间：</b>${train.endTime}</p>

            <form action="deleteTrain" method="post" style="float: left">
                <input type="hidden" name="id" value="${train.id}">
                &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="删除">
            </form>&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="submit" value="修改" id="a1">
            <div id="d2" style="display: none">
                <form action="updateTrain" method="post">
                    <input type="hidden" name="id" value="${train.id}">
                    <input type="hidden" name="state" value="${train.state}">
                    培训名称：<input type="text" name="name" value="${train.name}"><br>
                    培训内容：<input type="text" name="content" value="${train.content}"><br>
                    起始时间：<input type="text" name="beginTime" value="${train.beginTime}"><br>
                    结束时间：<input type="text" name="endTime" value="${train.endTime}"><br>
                    <input type="submit" value="确认修改">
                </form>
            </div>
        </div>
    </c:forEach>
</body>
</html>
