<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/1/31
  Time: 16:02
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
            $("#dept").change(function () {
                var d=$(this).val()
                // alert(d)
                $.ajax({
                    url:"getPostByDept",
                    data:{"d":d},
                    javaType:"json",
                    success:function (positions) {
                        $("#position").empty()
                        var p=eval(positions)
                        // alert(JSON.stringify(p))
                        var str="";
                        $.each(positions,function (index,value) {
                            str+="<option value="+value.id

                                +">"+value.name

                                +"</option>"
                        })
                        $("#position").append(str)
                    }
                })
            })
        })
    </script>
</head>
<body>
<form action="addRecruit" method="post">
    部门：<select id="dept">
    <option value="0">请选择</option>
    <c:forEach items="${sessionScope.depts}" var="dp">
        <option value="${dp.id}">${dp.name}</option>
    </c:forEach>
</select>&nbsp;&nbsp;&nbsp;&nbsp;
    职位：<select id="position" name="postId">
    <option value="0">请选择</option>
</select><br>
    职位要求：<input type="text" name="requirement"><br>
    薪资待遇：<input type="text" name="salary"><br>
    公司简介：<input type="text" name="introduction"><br>
    公司地址：<input type="text" name="address"><br>
    <input type="submit" value="发布">
</form>
</body>
</html>
