<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/1/28
  Time: 20:25
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
    <c:forEach items="resumes" var="resume">
        <div>
            <table>
                <tr>
                    <th colspan="7">个人简历</th>
                </tr>
                <tr>
                    <td>姓名</td>
                    <td>${resume.name}</td>
                    <td>性别</td>
                    <td>${resume.sex}</td>
                    <td>出生年月</td>
                    <td>${resume.birthday}</td>
                    <td rowspan="5"></td>
                </tr>
                <tr>
                    <td>籍贯</td>
                    <td>${resume.birthPlace}</td>
                    <td>名族</td>
                    <td>${resume.nation}</td>
                    <td>政治面貌</td>
                    <td>${resume.politicalStatus}</td>
                </tr>
                <tr>
                    <td>身体状况</td>
                    <td>${resume.healthy}</td>
                    <td>婚姻状况</td>
                    <td>${resume.marriage}</td>
                    <td>学历</td>
                    <td>${resume.education}</td>
                </tr>
                <tr>
                    <td>联系方式</td>
                    <td colspan="2">${resume.phone}</td>
                    <td>邮箱</td>
                    <td colspan="2">${resume.email}</td>
                </tr>
                <tr>
                    <td>所学专业</td>
                    <td colspan="2">${resume.major}</td>
                    <td>毕业学校</td>
                    <td colspan="2">${resume.school}</td>
                </tr>
                <tr>
                    <td>专业能力</td>
                    <td colspan="6">${resume.competence}</td>
                </tr>
                <tr>
                    <td>求职意向</td>
                    <td colspan="6">${resume.post}</td>
                </tr>
                <tr>
                    <td rowspan="3">实践经历</td>
                    <td rowspan="3" colspan="6">${resume.experience}</td>
                </tr>
                <tr>
                    <td rowspan="2">获奖情况</td>
                    <td rowspan="2" colspan="6">${resume.award}</td>
                </tr>
                <tr>
                    <td>爱好或特长</td>
                    <td colspan="6">${resume.hobbyOrSpeciality}</td>
                </tr>
                <tr>
                    <td rowspan="2">自我评价</td>
                    <td rowspan="2" colspan="6">${resume.selfComment}</td>
                </tr>
                <tr>
                    <c:if test="${resume.state==1}">
                        <form action="inform" method="post">
                            <input type="hidden" name="resumeId" value="${resume.id}">
                            <input type="submit" value="通知面试">
                        </form>
                    </c:if>
                    <c:if test="${resume.state==3}">
                        <form action="hire" method="post">
                            <input type="hidden" name="resumeId" value="${resume.id}">
                            <input type="submit" value="通过面试并录用">
                        </form>
                    </c:if>
                </tr>
            </table>
        </div>
    </c:forEach>
    <c:forEach begin="1" end="${sessionScope.totalPages}" var="i">
        <a href="showResume?currentPage=${i}">${i}</a>
    </c:forEach>
</body>
</html>