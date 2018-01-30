<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/1/29
  Time: 10:58
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
        $(
//            加载部门列表
            $.ajax({
                type:"post",
                url:"listDepts",
                success:function (data) {
                    data=JSON.parse(data);
                    var dept=$("#dept").html();
                    for (var i = 0; i < data.length; i++) {
                        var obj = data[i];
                        dept=dept+"<option value="+obj.id+">"+obj.name+"</option>"
                    }
                    $("#dept").html(dept);

//                    二级联动 加载部门对应岗位
                    $("#dept").change(function () {
//                        alert("ok");
                        $.ajax({
                            type:"post",
                            url:"listPostByDeptId",
                            data:"deptId="+$("#dept").val(),
                            success:function (data1) {
                                data1=JSON.parse(data1);
                                var job="<option value='-1'>--请选择--</option>";
                                for (var i = 0; i < data1.length; i++) {
                                    var obj = data1[i];
                                    job=job+"<option value="+obj.pid+">"+obj.pname+"</option>"
                                }
                                $("#job").html(job);
                            }
                        });
                    })
                }
            })
        )
    </script>
</head>
<body>
    <form action="addRecruit" method="post">
        <%--职位名称：<select name="postId">
            <c:forEach items="${sessionScope.posts}" var="post">
                <option value="${post.id}">${post.name}</option>
            </c:forEach>
        </select><br>--%>

        选择部门：
        <select name="dept" id="dept">
            <option value="-1">--请选择--</option>
        </select>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        选择岗位：
        <select name="pid" id="job">
            <option value="-1">--请选择--</option>
        </select><br>
        <%--<script>
            var dept = document.getElementById("dept");
            var post = document.getElementById("post");
            var depts = [ '部门1', '部门2' ];// 后台请求
            <c:forEach items="${sessionScope.depts}" var="d">

            dept.innerHTML += '<option value="'+depts[i]+'">' + depts[i]
                + '</option>';

            </c:forEach>
            for (var i = 0; i < depts.length; i++) {//初始化部门
                dept.innerHTML += '<option value="'+depts[i]+'">' + depts[i]
                    + '</option>';
            }
            //选择员工
            function choose() {
                // 根据dept.value后台请求
                post.innerHTML = '<option>--请选择--</option>';
                for (var i = 1; i <= 5; i++) {
                    post.innerHTML += '<option value="'+i+'">' + dept.value
                        + '里的员工' + i + '</option>';
                }
            }
        </script>--%>

        职位要求：<input type="text" name="requirement"><br>
        薪资待遇：<input type="text" name="salaryRange"><br>
        公司简介：<input type="text" name="introduction"><br>
        公司地址：<input type="text" name="address"><br>
        <input type="submit" value="发布">
    </form>
</body>
</html>
