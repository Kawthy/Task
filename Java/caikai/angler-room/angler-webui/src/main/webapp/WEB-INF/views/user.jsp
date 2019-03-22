<%--
  Created by IntelliJ IDEA.
  User: Kawthy
  Date: 2019/3/17
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<json:object>
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message" value="${message}"></json:property>
<json:object name="data">
    <json:property name="id" value="${user.id}"></json:property>
    <json:property name="name" value="${user.name}"></json:property>
    <json:property name="character" value="${character}"></json:property>
    <json:property name="create_at" value="${user.createAt}"></json:property>
    <json:property name="create_byname" value="${create_byname}"></json:property>
    </json:object>
</json:object>
</body>
</html>
