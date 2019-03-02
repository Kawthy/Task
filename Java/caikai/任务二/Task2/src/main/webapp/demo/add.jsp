<%--
  Created by IntelliJ IDEA.
  User: Kawthy
  Date: 2019/3/1
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=UTF-8"  %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<json:array name="students" var="student" items="${students}"/>
</body>
</html>
