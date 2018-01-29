<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/1/27
  Time: 21:59
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
        table input{
            border: none;
        }
    </style>
</head>
<body>
<form action="addResume" method="post" >
    <table border="1" cellspacing="0" >
        <tr>
            <th colspan="7">个人简历</th>
        </tr>
        <tr>
            <td align="center">姓名</td>
            <td>
                <input type="text" name="name" required>
            </td>
            <td align="center">性别</td>
            <td>
                <input type="text" name="sex" required>
            </td>
            <td align="center">出生年月</td>
            <td>
                <input type="text" name="birthday" required>
            </td>
            <td rowspan="5" width="100"></td>
        </tr>
        <tr>
            <td align="center">籍贯</td>
            <td>
                <input type="text" name="birthPlace" required>
            </td>
            <td align="center">名族</td>
            <td>
                <input type="text" name="nation" required>
            </td>
            <td align="center">政治面貌</td>
            <td>
                <input type="text" name="politicalStatus" required>
            </td>
        </tr>
        <tr>
            <td align="center">身体状况</td>
            <td>
                <input type="text" name="healthy" required>
            </td>
            <td align="center">婚姻状况</td>
            <td>
                <input type="text" name="marriage" required>
            </td>
            <td align="center">学历</td>
            <td>
                <input type="text" name="education" required>
            </td>
        </tr>
        <tr>
            <td align="center">联系方式</td>
            <td colspan="2">
                <input type="text" name="phone" required>
            </td>
            <td align="center">邮箱</td>
            <td colspan="2">
                <input type="text" name="email" required>
            </td>
        </tr>
        <tr>
            <td align="center">所学专业</td>
            <td colspan="2">
                <input type="text" name="major" required>
            </td>
            <td align="center">毕业学校</td>
            <td colspan="2">
                <input type="text" name="school" required>
            </td>
        </tr>

        <tr>
            <td align="center">专业能力</td>
            <td colspan="6">
                <input type="text" name="competence" required>
            </td>
        </tr>
        <tr>
            <td align="center">求职意向</td>
            <td colspan="6">
                <input type="text" name="post" required>
            </td>
        </tr>
        <tr height="100">
            <td align="center" >实践经历</td>
            <td colspan="6">
                <input type="text" name="experience" required>
            </td>
        </tr>
        <tr height="50">
            <td align="center">获奖情况</td>
            <td colspan="6">
                <input type="text" name="award" required>
            </td>
        </tr>
        <tr height="50">
            <td align="center">爱好或特长</td>
            <td colspan="6">
                <input type="text" name="hobbyOrSpeciality" required>
            </td>
        </tr>
        <tr height="50">
            <td align="center">自我评价</td>
            <td colspan="6">
                <input type="text" name="selfComment" required>
            </td>
        </tr>
        <tr></tr>
        <tr>
            <th colspan="7">
                <input type="submit" value="提交">
            </th>
        </tr>
    </table>
</form>
</body>
</html>
