<%--
  Created by IntelliJ IDEA.
  User: lyh
  Date: 2023/7/7
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>删除学生</title>
</head>
<body>
<div align="center" class="studelete">
    <form action="<%=request.getContextPath()%>/project" method="get">
        <table border="0.5" class="studelete">
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
<%--            显示所有学生的学号，姓名，邮箱，以及在该生信息右侧提供删除的操作--%>
            <c:forEach items="${slist}" var="stuDao">
                <tr>
                    <td>${stuDao.sno}</td>
                    <td>${stuDao.sname}</td>
                    <td>${stuDao.email}</td>
                    <td>
                        <a href="<%=request.getContextPath()%>/project?method=delstu&sno=${stuDao.sno}">删除</a>
<%--                        将待删除学生的学号传递给servlet层，以便后续执行删除操作--%>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
