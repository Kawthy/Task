<%--
  Created by IntelliJ IDEA.
  User: Kawthy
  Date: 2019/3/17
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<json:object>
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message" value="${message}"></json:property>
    <%--<json:object name="data">--%>

    <json:array name="users">
        <c:forEach items="${users}" var="user">
            <json:object>
                <json:property name="id" value="${user.id}"></json:property>
                <json:property name="name" value="${user.name}"></json:property>
                <json:property name="character" value="${user.character}"></json:property>
                <json:property name="create_at" value="${user.createAt}"></json:property>
                <json:property name="create_byname" value="${user.createBy}"></json:property>
                <json:property name="characterName" value="${characterList.get(pm.index).name}"></json:property>
            </json:object>
        </c:forEach>
    </json:array>
    <%--</json:object>--%>
</json:object>
</body>
</html>
