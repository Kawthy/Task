<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--<jsp:forward page="/students/list"></jsp:forward>--%>
<json:object>
    <p>起始页:</p><json:property name="pageNo" value="${pageNO}"/>
    <p>每页条数:</p><json:property name="size" value="${size}"/>
    <p>学生总数:</p><json:property name="count" value="${count}"/>
    <json:property name="code">
        <spring:message code ="${code}"/>
    </json:property>
<json:array name="students" var="student" items="${students}">
    <json:property name="id" value="${student.id}"/>
    <json:property name="name" value="${student.name}"/>
    <json:property name="qq" value="${student.qq}"/>
</json:array>
</json:object>


