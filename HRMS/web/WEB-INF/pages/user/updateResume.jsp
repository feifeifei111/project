<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/1/28
  Time: 22:19
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
<a href="back">返回</a>
<form action="updateResume" method="post" >
    <table border="1" cellspacing="0">
        <tr>
            <th colspan="7">个人简历</th>
        </tr>
        <tr>
            <td align="center">姓名</td>
            <td>
                <input type="text" name="name" value="${sessionScope.resume.name}">
            </td>
            <td align="center">性别</td>
            <td>
                <input type="text" name="sex" value="${sessionScope.resume.sex}">
            </td>
            <td align="center">出生年月</td>
            <td>
                <input type="text" name="birthday" value="${sessionScope.resume.birthday}">
            </td>
            <td rowspan="5" width="100"></td>
        </tr>
        <tr>
            <td align="center">籍贯</td>
            <td>
                <input type="text" name="birthPlace" value="${sessionScope.resume.birthPlace}">
            </td>
            <td align="center">名族</td>
            <td>
                <input type="text" name="nation" value="${sessionScope.resume.nation}">
            </td>
            <td align="center">政治面貌</td>
            <td>
                <input type="text" name="politicalStatus" value="${sessionScope.resume.politicalStatus}">
            </td>
        </tr>
        <tr>
            <td align="center">身体状况</td>
            <td>
                <input type="text" name="healthy" value="${sessionScope.resume.healthy}">
            </td>
            <td align="center">婚姻状况</td>
            <td>
                <input type="text" name="marriage" value="${sessionScope.resume.marriage}">
            </td>
            <td align="center">学历</td>
            <td>
                <input type="text" name="education" value="${sessionScope.resume.education}">
            </td>
        </tr>
        <tr>
            <td align="center">联系方式</td>
            <td colspan="2">
                <input type="text" name="phone" value="${sessionScope.resume.phone}">
            </td>
            <td align="center">邮箱</td>
            <td colspan="2">
                <input type="text" name="email" value="${sessionScope.resume.email}">
            </td>
        </tr>
        <tr>
            <td align="center">所学专业</td>
            <td colspan="2">
                <input type="text" name="major" value="${sessionScope.resume.major}">
            </td>
            <td align="center">毕业学校</td>
            <td colspan="2">
                <input type="text" name="school" value="${sessionScope.resume.school}">
            </td>
        </tr>
        <tr>
            <td align="center">专业能力</td>
            <td colspan="6">
                <input type="text" name="competence" value="${sessionScope.resume.competence}">
            </td>
        </tr>
        <tr>
            <td align="center">求职意向</td>
            <td colspan="6">
                <input type="text" name="post" value="${sessionScope.resume.post}">
            </td>
        </tr>
        <tr height="100">
            <td align="center">实践经历</td>
            <td colspan="6">
                <input type="text" name="experience" value="${sessionScope.resume.experience}">
            </td>
        </tr>
        <tr height="50">
            <td align="center">获奖情况</td>
            <td colspan="6">
                <input type="text" name="award" value="${sessionScope.resume.award}">
            </td>
        </tr>
        <tr>
            <td height="50" align="center">爱好或特长</td>
            <td colspan="6">
                <input type="text" name="hobbyOrSpeciality" value="${sessionScope.resume.hobbyOrSpeciality}">
            </td>
        </tr>
        <tr height="50">
            <td align="center">自我评价</td>
            <td colspan="6">
                <input type="text" name="selfComment" value="${sessionScope.resume.selfComment}">
            </td>
        </tr>
        <tr>
            <th>
                <input type="submit" value="确认修改">
            </th>
        </tr>
    </table>
</form>
</body>
</html>
