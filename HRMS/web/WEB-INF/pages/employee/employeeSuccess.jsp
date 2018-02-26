<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/1/27
  Time: 16:14
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
            $("#in2").click(function () {
                $.ajax({
                    async: false,/*默认为true异步,false为同步*/
                    url:"signOutAJAX",
                    type:"post",
                    success:function (data) {
                        var x=confirm(data)
                        if (x==true){
                            $("#in2").attr("type","submit")
                        }else {
                            $("#in2").attr("type","button")
                        }
                    }
                })
            })
        })
    </script>
    <style>
        form{
            float: left;
        }
    </style>
</head>
<body>
    <c:if test="${sessionScope.attend==null}">
        <form action="signIn" method="post">
            <input type="submit" id="in1" value="签到">&nbsp;&nbsp;
        </form>
        <%--<a href="signIn" id="a1">签到</a>--%>
    </c:if>
    <c:if test="${sessionScope.attend.endState==0}">
        <form action="signOut" method="post">
            <input type="hidden" name="attendId" value="${sessionScope.attend.id}">
            <input type="button" id="in2" value="签退">&nbsp;&nbsp;
        </form>
        <%--<a href="signOut?attendId=${sessionScope.attend.id}" id="a2">签退</a>--%>
    </c:if>
    <form action="selfMessage" method="post">
        <input type="submit" value="查看基本信息">&nbsp;&nbsp;
    </form>
    <form action="selectAttendance" method="post">
        <input type="submit" value="查看打卡记录">&nbsp;&nbsp;
    </form>
    <form action="selectRewAndPun" method="post">
        <input type="submit" value="查看奖惩记录">&nbsp;&nbsp;
    </form>
    <form action="selectSalary" method="post">
        <input type="submit" value="查看工资表">
    </form>
    <%--<a href="selfMessage">查看基本信息</a>
    <a href="selectAttendance">查看打卡记录</a>
    <a href="selectRewAndPun">查看奖惩记录</a>
    <a href="selectSalary">查看工资表</a>--%>
</body>
</html>
