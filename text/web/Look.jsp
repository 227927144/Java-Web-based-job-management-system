<%--
  Created by IntelliJ IDEA.
  User: lyh
  Date: 2023/7/7
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查看</title>
    <link rel="stylesheet" type="text/css" href="mainmemu.css">
</head>
<body>
<div align="center" class="stulook">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <ul class="mainmenu">
                <li><a href="<%=request.getContextPath()%>/project?method=showstulist">管理学生信息</a></li>
                <li><a href="<%=request.getContextPath()%>/teaproject?method=showtealist">管理教师信息</a></li>
                <li><a href="<%=request.getContextPath()%>/lookproject?method=showhowklist" class="active">查看</a></li>
            </ul>
        </div>
    </nav>

    <%--    获得学号--%>
    <form action="<%=request.getContextPath()%>/lookproject" method="get">
        <input type="hidden" name="method" value="lookstu">
        <p>查看学生提交作业情况：<br>
        请输入学号<input type="text" name="sno" value="${howksno}">
<%--            获得后端传来的学生学号数据--%>
        <input type="submit" value="确认"></p>
    </form>

    <%--    获得教师编号--%>
    <form action="<%=request.getContextPath()%>/lookproject" method="get">
        <input type="hidden" name="method" value="looktea">
        <p>查看教师批改作业情况：<br>
            请输入教师编号：<input type="text" name="tno" value="${thowktno}">
            <input type="submit" value="确认"></p>
    </form>
</div>
</body>
</html>
