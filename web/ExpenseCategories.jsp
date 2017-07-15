<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Abraham
  Date: 13/07/2017
  Time: 11:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Expense Category Add</title>
</head>
<body>
<s:form action="addExpenseCategory">
    <s:textfield name="id" label="ID"/>
    <s:textfield name="name" label="Name"/>
    <s:submit value="Save"/>
</s:form>
</body>
</html>
