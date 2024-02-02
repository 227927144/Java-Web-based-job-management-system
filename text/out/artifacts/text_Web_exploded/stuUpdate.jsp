<%--
  Created by IntelliJ IDEA.
  User: lyh
  Date: 2023/7/7
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改学生信息</title>
</head>
<body>
<div align="center" class="stuupdate">
<%--    获得学号--%>
    <form action="<%=request.getContextPath()%>/project" method="get">
        <input type="hidden" value="updstu" name="method">
        <p>待修改信息的学生：</p>
        请输入学号<input type="text" name="sno" value="${stus.sno}">
        <div class="submit_div"><input type="submit" value="确认"></div>
    </form>

    <form action="<%=request.getContextPath()%>/project" method="post">
        <input type="hidden" name="sno" value="${stus.sno}"><br>
        <p>需要将该生信息修改为：</p>
        姓名：<input type="text" name="sname" value="${stus.sname}"><br>
        密码：<input type="text" name="spassword" value="${stus.spassword}"><br>
        邮箱：<input type="text" name="email" value="${stus.email}"><br>
        <input type="text" hidden value="updatestu" name="method">
        <div class="submit_div"><input type="submit" value="确认更改"></div>
    </form>
</div>
</body>
</html>
