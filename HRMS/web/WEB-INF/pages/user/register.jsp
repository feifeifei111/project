<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/1/26
  Time: 13:42
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
    <link rel="stylesheet" href="../../../css/style.css">
    <script>
        $(function () {
            $("#f_tags").blur(function () {
                $.ajax({
                    url:"nameAJAX",
                    type:"post",
                    data:"name="+$("#name").val(),
                    success:function (data) {
                        $("#p").html(data)
                        $("#p").css("color","blue")
                        if (data=="账户名已存在"){
                            $("#sub").attr("type","button")
                        }else {
                            $("#sub").attr("type","submit")
                        }
                    }
                })
            })
        })
        $(document).ready(function () {
            $("#pass1").keydown(function () {
                var len = $("#pass1").val().length;
                if (len<5){
                    $("#w").css("backgroundColor","red");
                    $("#m").css("backgroundColor","white");
                    $("#s").css("backgroundColor","white");
//                    $("#error2").html("密码不得少于4位");
                }else if (len>=5&&len<=8){
//                    $("#error2").html("");
                    $("#w").css("backgroundColor","red");
                    $("#m").css("backgroundColor","yellow");
                    $("#s").css("backgroundColor","white");
                }else{
//                    $("#error2").html("");
                    $("#w").css("backgroundColor","red");
                    $("#m").css("backgroundColor","yellow");
                    $("#s").css("backgroundColor","green");
                }
            })
        });
        $(function () {
            var x=false;
            var y=false;
            var z=false;
            var w=false;
            $("#name").blur(function () {
                var reg=/^[a-zA-Z][a-zA-Z0-9_]{1,15}$/;
                var value=$("#name").val();
                if(reg.test(value)&&value!=""&&value!=null){
                    $("#p1").html("√");
                    $("#p1").css("color","green");
                    x=true;
                }else {
                    $("#p1").html("字母开头，1-16字符，允许字母数字下划线");
                    $("#p1").css("color","red");
                    x=false;
                }
            });
            $("#pass1").blur(function () {
                var reg=/^[a-zA-Z]\w{3,15}$/;
                var value=$("#pass1").val();
                if(reg.test(value)&&value!=""&&value!=null){
                    $("#p2").html("√");
                    $("#p2").css("color","green");
                    y=true;
                }else{
                    $("#p2").html("以字母开头，长度在4~16之间，只能包含字母、数字和下划线");
                    $("#p2").css("color","red");
                    y=false;
                }
            });
            $("#pass2").blur(function () {
                var oldPass=$("#pass1").val();
                var newPass=$("#pass2").val();
                if(newPass!=""&&newPass!=null&&oldPass==newPass){
                    $("#p3").html("√");
                    $("#p3").css("color","green");
                    z=true;
                }else {
                    $("#p3").html("密码不一致");
                    $("#p3").css("color","red");
                    z=false;
                }
            })
            $("#phone").blur(function () {
                var phone=$("#phone").val();
                var reg=/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
                if(reg.test(phone)){
                    $("#p4").html("√");
                    $("#p4").css("color","green");
                    w=true;
                }else {
                    $("#p4").html("手机号码不正确");
                    $("#p4").css("color","red");
                    w=false;
                }
            })
            $("#f").submit(function () {
                if (x&&y&&z&&w){
                    return true;
                }
                alert("输入不合法");
                return false;
            })
        })
    </script>
</head>
<body>
<h1>人力资源管理系统</h1>
<div class="container w3">
    <h2>现在注册</h2>
    <form action="register" method="post" id="f">
        <div class="username">
            <span class="username" style="height:19px">账号:</span>
            <input type="text" name="name" id="name" class="name" placeholder="" required="">
            <div class="clear"></div>
            <p id="p1" class="p1"></p><p id="p" class="p1"></p>
        </div>

        <div class="password-agileits">
            <span class="username"style="height:19px">密码:</span>
            <input type="password" name="pass1" id="pass1" class="password" placeholder="" required="">
            <p id="w" class="p1">&nbsp;</p>
            <p id="m" class="p1">&nbsp;</p>
            <p id="s" class="p1">&nbsp;</p><br>
            <div class="clear"></div>
            <p id="p2"></p>
        </div>



        <div class="password-agileits">
            <span class="username"style="height:19px">确认密码:</span>
            <input type="password" name="pass2" id="pass2" class="password" placeholder="" required="">
            <div class="clear"></div>
            <p id="p3"></p>
        </div>

        <div class="username">
            <span class="username"style="height:19px">性别:</span>
            <input type="radio" name="sex" value="男" checked>男
            <input type="radio" name="sex" value="女">女
            <div class="clear"></div>
        </div>
        <p></p>
        <div class="username" style="margin-top: 40px">
            <span class="username" style="height:19px">年龄:</span>
            <input type="number" name="age" class="name" min="1" value="18" placeholder="" required="">
            <div class="clear"></div>
        </div>

        <div class="username">
            <span class="username" style="height:19px">联系方式:</span>
            <input type="text" name="phone" id="phone" class="name" placeholder="" required="">
            <div class="clear"></div>
            <p id="p4"></p>
        </div>

        <div class="username">
            <span class="username" style="height:19px">邮箱:</span>
            <input type="email" name="email" class="name" placeholder="" required="">
            <div class="clear"></div>
        </div>

       <%-- <div class="rem-for-agile">
            <input type="checkbox" name="remember" class="remember">记得我
            　　
            <br>
            <a href="#">忘记了密码</a><br>
        </div>--%>
        <div class="login-w3">
            <input type="submit" class="login" value="注册">
        </div>
        <div class="clear"></div>
    </form>
</div>
</body>
</html>
