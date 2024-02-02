<%--
  Created by IntelliJ IDEA.
  User: lyh
  Date: 2023/7/11
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改教师信息</title>
</head>
<body>
<div align="center" class="teaupdate">
  <form action="<%=request.getContextPath()%>/teaproject" method="get">
    <input type="hidden" value="updtea" name="method">
    <p>待修改信息的教师：</p>
    请输入教师编号<input type="text" name="tno" value="${teas.tno}">
    <input type="hidden" value=tno name="tno">
    <div class="submit_div"><input type="submit" value="确认"></div>
  </form>

  <form action="<%=request.getContextPath()%>/teaproject" method="post">
    <input type="hidden" name="tno" value="${teas.tno}"><br>
    <p>需要将该教师信息修改为：</p>
    姓名：<input type="text" name="tname" value="${teas.tname}"><br>
    密码：<input type="text" name="tpassword" value="${teas.tpassword}"><br>
    <input type="text" hidden value="updatetea" name="method">
    <div class="submit_div"><input type="submit" value="确认更改"></div>
  </form>
</div>
</body>
</html>
