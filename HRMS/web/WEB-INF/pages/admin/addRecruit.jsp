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
                                    job=job+"<option value="+obj.postId+">"+obj.name+"</option>"
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

        选择部门：
        <select name="dept" id="dept">
            <option value="0">--请选择--</option>
        </select>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        选择岗位：
        <select name="pid" id="job">
            <option value="0">--请选择--</option>
        </select><br>


        职位要求：<input type="text" name="requirement"><br>
        薪资待遇：<input type="text" name="salaryRange"><br>
        公司简介：<input type="text" name="introduction"><br>
        公司地址：<input type="text" name="address"><br>
        <input type="submit" value="发布">
    </form>
</body>
</html>
