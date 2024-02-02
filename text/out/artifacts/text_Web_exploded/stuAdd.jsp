<%--
  Created by IntelliJ IDEA.
  User: lyh
  Date: 2023/7/7
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加学生</title>
</head>
<body>
    <div align="center" class="stuAdd">
        <form action="<%=request.getContextPath()%>/project" method="post">
            学号：<div><input type="text" name="sno" ><br></div>
            姓名：<div><input type="text" name="sname" ><br></div>
            邮箱：<div><input type="text" name="email" ></div>
            <input type="hidden" name="method" value="addstu" >
<%--            type="hidden" 表示此部分代码不显示，但会随着表单一同提交给服务器--%>
            <p>ps:密码默认000000</p>
            <br>
            <div class="submit_div"><input type="submit" value="确认添加"></div>
        </form>
    </div>
</body>
</html>
