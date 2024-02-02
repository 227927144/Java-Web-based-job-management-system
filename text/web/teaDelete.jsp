<%--
  Created by IntelliJ IDEA.
  User: lyh
  Date: 2023/7/11
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>删除老师</title>
</head>
<body>
<div align="center" class="teadelete">
  <form action="<%=request.getContextPath()%>/teaproject" method="get">
    <table border="0.5" class="teadelete">
      <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${tlist}" var="teaDao">
        <tr>
          <td>${teaDao.tno}</td>
          <td>${teaDao.tname}</td>
          <td>
            <a href="<%=request.getContextPath()%>/teaproject?method=deltea&tno=${teaDao.tno}">删除</a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </form>
</div>
</body>
</html>
