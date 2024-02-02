<%--
  Created by IntelliJ IDEA.
  User: lyh
  Date: 2023/7/7
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生信息管理页面</title>
    <link rel="stylesheet" type="text/css" href="mainmemu.css">
</head>
<body>
<div align="center">
    <nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <ul class="mainmenu">
            <li><a href="<%=request.getContextPath()%>/project?method=showstulist" class="active">管理学生信息</a></li>
            <li><a href="<%=request.getContextPath()%>/teaproject?method=showtealist">管理教师信息</a></li>
            <li><a href="<%=request.getContextPath()%>/lookproject?method=showhowklist">查看</a></li>
        </ul>
    </div>
</nav>
    <p>学生信息列表如下</p>
    <table border="1" cellspacing="0" class="studentList">
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>密码</th>
            <th>邮箱</th>
        </tr>
        <c:forEach items="${slist}" var="stuDao">
            <tr>
                <td>${stuDao.sno}</td>
                <td>${stuDao.sname}</td>
                <td>${stuDao.spassword}</td>
                <td>${stuDao.email}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <table>
        <tr>
            <td>可选择操作：</td>
            <td>
                <a href="stuAdd.jsp">增加学生</a>
            </td>
            <td>
                <a href="<%=request.getContextPath()%>/project?method=delstulist">删除学生</a>
            </td>
            <td>
                <a href="stuUpdate.jsp">修改学生信息</a>
            </td>
        </tr>
    </table>

</div>
</body>
</html>