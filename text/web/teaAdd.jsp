<%--
  Created by IntelliJ IDEA.
  User: lyh
  Date: 2023/7/11
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加老师</title>
</head>
<body>
<div align="center" class="teaAdd">
    <form action="<%=request.getContextPath()%>/teaproject" method="post">
        编号：<div><input type="text" name="tno" ><br></div>
        姓名：<div><input type="text" name="tname" ><br></div>
        <input type="hidden" name="method" value="addtea" >
        <p>ps:密码默认000000</p>
        <br>
        <div class="submit_div"><input type="submit" value="确认添加"></div>
    </form>
</div>
</body>
</html>
