<%--
  Created by IntelliJ IDEA.
  User: 李德天
  Date: 2018/8/7
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String addUrl = request.getContextPath() + "/user/add" ;
%>
<form action="<%= addUrl%>" method = "post" enctype="multipart/form-data">
    雇员姓名：<input name="ename" type = "text" id = "ename"><br>
    雇员照片：<input name="photo" type="file" id = "photo"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
