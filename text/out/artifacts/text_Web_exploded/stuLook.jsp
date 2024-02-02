<%--
  Created by IntelliJ IDEA.
  User: lyh
  Date: 2023/7/7
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <li><a href="<%=request.getContextPath()%>/stuproject?method=showstulist">管理学生信息</a></li>
                <li><a href="<%=request.getContextPath()%>/teaproject?method=showtealist">管理教师信息</a></li>
                <li><a href="<%=request.getContextPath()%>/project?method=showhowklist" class="active">查看</a></li>
            </ul>
        </div>
    </nav>

    <%--    获得学号--%>
    <form action="<%=request.getContextPath()%>/project" method="get">
        <input type="hidden" value="lookstu" name="method">
        <p>查看学生提交作业情况：</p>
        请输入学号<input type="text" name="sno" value="${howk.sno}">
        <input type="hidden" value=sno name="sno">
        <div class="submit_div"><input type="submit" value="确认"></div>
    </form>

<%--    <form action="<%=request.getContextPath()%>/project" method="get">--%>
<%--        <input type="hidden" value="looktea" name="method">--%>
<%--        <p>查看教师批改作业情况：</p>--%>
<%--        请输入教师编号<input type="text" name="tno" value="${howk.tno}">--%>
<%--        <input type="hidden" value=tno name="tno">--%>
<%--        <div class="submit_div"><input type="submit" value="确认"></div>--%>
<%--    </form>--%>
</div>
</body>
</html>
