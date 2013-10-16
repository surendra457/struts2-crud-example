<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="employee==null || employee.employeeId == null">
	<s:set name="title" value="%{'Add new employee'}"/>
</s:if>
<s:else>
	<s:set name="title" value="%{'Update employee'}"/>
</s:else>

<html>
<head>
    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
    <style>td { white-space:nowrap; }</style>
    <title><s:property value="#title"/></title>
</head>
<body>
<div class="titleDiv"><s:text name="application.title"/></div>
<h1><s:property value="#title"/></h1>
<s:actionerror />
<s:actionmessage />
<s:form action="saveEmployee" method="post">
    <s:textfield name="employee.firstName" value="%{employee.firstName}" label="%{getText('label.firstName')}" size="40"/>
    <s:textfield name="employee.lastName" value="%{employee.lastName}" label="%{getText('label.lastName')}" size="40"/>
    <s:textfield name="employee.age" value="%{employee.age}" label="%{getText('label.age')}" size="20"/>
    <s:select name="employee.department.departmentId" value="%{employee.department.departmentId}" list="departments" listKey="departmentId" listValue="name"/>
    <s:hidden name="employee.employeeId" value="%{employee.employeeId}"/>
    <s:submit value="%{getText('button.label.submit')}"/>
    <s:submit value="%{getText('button.label.cancel')}" action="index"/>
</s:form>
</body>
</html>