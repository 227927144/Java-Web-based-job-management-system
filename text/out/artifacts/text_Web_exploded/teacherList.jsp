<%--
  Created by IntelliJ IDEA.
  User: lyh
  Date: 2023/7/9
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>教师信息管理页面</title>
    <link rel="stylesheet" type="text/css" href="mainmemu.css">
</head>
<body>
<div align="center">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <ul class="mainmenu">
                <li><a href="<%=request.getContextPath()%>/project?method=showstulist">管理学生信息</a></li>
                <li><a href="<%=request.getContextPath()%>/teaproject?method=showtealist" class="active">管理教师信息</a></li>
                <li><a href="<%=request.getContextPath()%>/lookproject?method=showhowklist">查看</a></li>
            </ul>
        </div>
    </nav>
    <p>教师信息列表如下</p>
    <table border="1" cellspacing="0" class="teacherList">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>密码</th>
        </tr>
        <c:forEach items="${tlist}" var="teaDao">
            <tr>
                <td>${teaDao.tno}</td>
                <td>${teaDao.tname}</td>
                <td>${teaDao.tpassword}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <table>
        <tr>
            <td>可选择操作：</td>
            <td>
                <a href="teaAdd.jsp">增加老师</a>
            </td>
            <td>
                <a href="<%=request.getContextPath()%>/teaproject?method=deltealist">删除老师</a>
            </td>
            <td>
                <a href="teaUpdate.jsp">修改老师信息</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>