<%--
  Created by IntelliJ IDEA.
  User: Kawthy
  Date: 2019/3/20
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<json:object>
<json:property name="code" value="${code}"></json:property>
<json:property name="message" value="${message}"></json:property>
    <json:property name="data" value="${data}"></json:property>
</json:object>
</body>
</html>
