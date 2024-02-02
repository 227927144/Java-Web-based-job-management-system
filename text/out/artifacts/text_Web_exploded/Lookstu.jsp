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
  <title>查看学生完成作业情况</title>
</head>
<body>
<div align="center" class="stulook">
  <form action="<%=request.getContextPath()%>/lookproject" method="get">
    <input type="hidden" name="method" value="lookstu1">
    <input type="hidden" name="sno" value="${howksno}">
    <br><p>该学生学号为："${howksno}"<input type="submit" value="查看该生作业提交情况">
      <hr>
      已完成作业如下：<br>
<%--    获取已完成作业的信息，绘制成表单--%>
    <table class="look1">
      <c:forEach items="${hlistNotnull}" var="h1">
        <tr>
          <td>———————————</td>
          <td>———————————</td>
        </tr>
        <tr>
          <th>作业编号:</th>
          <td>${h1.hno}</td>
        </tr>
        <tr>
          <th>截止时间:</th>
          <td>${h1.deadlineTime}</td>
        </tr>
        <tr>
          <th>提交内容:</th>
          <td>${h1.content}</td>
        </tr>
        <tr>
          <th>作业得分:</th>
          <td>${h1.score}</td>
        </tr>
      </c:forEach>
    </table></p>

    <%--    获取未完成作业的信息，绘制成表单--%>
    <p><hr>未完成作业如下：<br>
    <table class="look2">
      <c:forEach items="${hlistNull}" var="h2">
        <tr>
          <td>———————————</td>
          <td>———————————</td>
        </tr>
        <tr>
          <th>作业编号:</th>
          <td>${h2.hno}</td>
        </tr>
        <tr>
          <th>截止时间:</th>
          <td>${h2.deadlineTime}</td>
        </tr>
      </c:forEach>
    </table></p>

<%--    从后端获取后端统计计算得出的作业完成率perchentecl和平均分pjf--%>
    <p><hr>作业完成率为："${percentwcl}"</p>
    <p>作业平均分为：（仅统计获得评分的作业）:"${pjf}"分</p>
    <a href="<%=request.getContextPath()%>/project?method=showstulist">返回</a></li>
  </form>

</div>
</body>
</html>
