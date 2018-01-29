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
</head>
<body>
<a href="userSuccess.jsp">返回</a>
<form action="updateResume" method="post" >
    <table>
        <tr>
            <th colspan="7">个人简历</th>
        </tr>
        <tr>
            <td>姓名</td>
            <td>
                <input type="text" name="name" value="${sessionScope.resume.name}">
            </td>
            <td>性别</td>
            <td>
                <input type="text" name="sex" value="${sessionScope.resume.sex}">
            </td>
            <td>出生年月</td>
            <td>
                <input type="text" name="birthday" value="${sessionScope.resume.birthday}">
            </td>
            <td rowspan="5"></td>
        </tr>
        <tr>
            <td>籍贯</td>
            <td>
                <input type="text" name="birthPlace" value="${sessionScope.resume.birthPlace}">
            </td>
            <td>名族</td>
            <td>
                <input type="text" name="nation" value="${sessionScope.resume.nation}">
            </td>
            <td>政治面貌</td>
            <td>
                <input type="text" name="politicalStatus" value="${sessionScope.resume.politicalStatus}">
            </td>
        </tr>
        <tr>
            <td>身体状况</td>
            <td>
                <input type="text" name="healthy" value="${sessionScope.resume.healthy}">
            </td>
            <td>婚姻状况</td>
            <td>
                <input type="text" name="marriage" value="${sessionScope.resume.marriage}">
            </td>
            <td>学历</td>
            <td>
                <input type="text" name="education" value="${sessionScope.resume.education}">
            </td>
        </tr>
        <tr>
            <td>联系方式</td>
            <td colspan="2">
                <input type="text" name="phone" value="${sessionScope.resume.phone}">
            </td>
            <td>邮箱</td>
            <td colspan="2">
                <input type="text" name="email" value="${sessionScope.resume.email}">
            </td>
        </tr>
        <tr>
            <td>所学专业</td>
            <td colspan="2">
                <input type="text" name="major" value="${sessionScope.resume.major}">
            </td>
            <td>毕业学校</td>
            <td colspan="2">
                <input type="text" name="school" value="${sessionScope.resume.school}">
            </td>
        </tr>
        <tr>
            <td>专业能力</td>
            <td colspan="6">
                <input type="text" name="competence" value="${sessionScope.resume.competence}">
            </td>
        </tr>
        <tr>
            <td>求职意向</td>
            <td colspan="6">
                <input type="text" name="post" value="${sessionScope.resume.post}">
            </td>
        </tr>
        <tr>
            <td rowspan="3">实践经历</td>
            <td rowspan="3" colspan="6">
                <input type="text" name="experience" value="${sessionScope.resume.experience}">
            </td>
        </tr>
        <tr>
            <td rowspan="2">获奖情况</td>
            <td rowspan="2" colspan="6">
                <input type="text" name="award" value="${sessionScope.resume.award}">
            </td>
        </tr>
        <tr>
            <td>爱好或特长</td>
            <td colspan="6">
                <input type="text" name="hobbyOrSpeciality" value="${sessionScope.resume.hobbyOrSpeciality}">
            </td>
        </tr>
        <tr>
            <td rowspan="2">自我评价</td>
            <td rowspan="2" colspan="6">
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
