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
</head>
<body>
<form action="addResume" method="post" >
    <table>
        <tr>
            <th colspan="7">个人简历</th>
        </tr>
        <tr>
            <td>姓名</td>
            <td>
                <input type="text" name="name">
            </td>
            <td>性别</td>
            <td>
                <input type="text" name="sex">
            </td>
            <td>出生年月</td>
            <td>
                <input type="text" name="birthday">
            </td>
            <td rowspan="5"></td>
        </tr>
        <tr>
            <td>籍贯</td>
            <td>
                <input type="text" name="birthPlace">
            </td>
            <td>名族</td>
            <td>
                <input type="text" name="nation">
            </td>
            <td>政治面貌</td>
            <td>
                <input type="text" name="politicalStatus">
            </td>
        </tr>
        <tr>
            <td>身体状况</td>
            <td>
                <input type="text" name="healthy">
            </td>
            <td>婚姻状况</td>
            <td>
                <input type="text" name="marriage">
            </td>
            <td>学历</td>
            <td>
                <input type="text" name="education">
            </td>
        </tr>
        <tr>
            <td>联系方式</td>
            <td colspan="2">
                <input type="text" name="phone">
            </td>
            <td>邮箱</td>
            <td colspan="2">
                <input type="text" name="email">
            </td>
        </tr>
        <tr>
            <td>所学专业</td>
            <td colspan="2">
                <input type="text" name="major">
            </td>
            <td>毕业学校</td>
            <td colspan="2">
                <input type="text" name="school">
            </td>
        </tr>
        <tr>
            <td>专业能力</td>
            <td colspan="6">
                <input type="text" name="competence">
            </td>
        </tr>
        <tr>
            <td>求职意向</td>
            <td colspan="6">
                <input type="text" name="post">
            </td>
        </tr>
        <tr>
            <td rowspan="3">实践经历</td>
            <td rowspan="3" colspan="6">
                <input type="text" name="experience">
            </td>
        </tr>
        <tr>
            <td rowspan="2">获奖情况</td>
            <td rowspan="2" colspan="6">
                <input type="text" name="award">
            </td>
        </tr>
        <tr>
            <td>爱好或特长</td>
            <td colspan="6">
                <input type="text" name="hobbyOrSpeciality">
            </td>
        </tr>
        <tr>
            <td rowspan="2">自我评价</td>
            <td rowspan="2" colspan="6">
                <input type="text" name="selfComment">
            </td>
        </tr>
        <tr>
            <th>
                <input type="submit" value="提交">
            </th>
        </tr>
    </table>
</form>
</body>
</html>
