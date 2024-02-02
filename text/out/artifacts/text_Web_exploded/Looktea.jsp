<%--
  Created by IntelliJ IDEA.
  User: lyh
  Date: 2023/7/12
  Time: 1:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查看教师批改作业情况</title>
</head>
<body>
<div align="center" class="tealook">
  <form action="<%=request.getContextPath()%>/lookproject" method="get">
    <input type="hidden" name="method" value="looktea1">
    <input type="hidden" name="tno" value="${thowktno}">
<%--    将教师的编号传给后端，据此调取该教师发布的作业的数据--%>
    <br><p>该教师的教师编号为："${thowktno}"<input type="submit" value="查看该教师批改作业情况">
    <hr>
    已批改作业如下：<br>
<%--    获取该教师已批改的作业的信息--%>
    <table class="tlook1">
      <c:forEach items="${scoreNotnull}" var="th1">
        <tr>
          <td>———————————</td>
          <td>———————————</td>
        </tr>
        <tr>
          <th>作业编号:</th>
          <td>${th1.hno}</td>
        </tr>
        <tr>
          <th>截止时间:</th>
          <td>${th1.deadlineTime}</td>
        </tr>
        <tr>
          <th>提交内容:</th>
          <td>${th1.content}</td>
        </tr>
        <tr>
          <th>作业提交人:</th>
          <td>${th1.sno}</td>
        </tr>
        <tr>
          <th>批改分数:</th>
          <td>${th1.score}</td>
        </tr>
      </c:forEach>
    </table></p>

<%--    获取该教师未批改的作业的信息--%>
    <p><hr>未批改作业如下：<br>
    <table class="tlook2">
      <c:forEach items="${scoreNull}" var="th2">
        <tr>
          <td>———————————</td>
          <td>———————————</td>
        </tr>
        <tr>
          <th>作业编号:</th>
          <td>${th2.hno}</td>
        </tr>
        <tr>
          <th>截止时间:</th>
          <td>${th2.deadlineTime}</td>
        </tr>
        <tr>
          <th>收到作业的学生:</th>
          <td>${th2.sno}</td>
        </tr>
      </c:forEach>
    </table></p>

<%--    获取后端计算并传来的教师批改作业的比率--%>
    <p><hr>作业批改率为："${tpercentwcl}"</p>
    <a href="<%=request.getContextPath()%>/project?method=showstulist">返回</a></li>
  </form>

</div>
</body>
</html>
