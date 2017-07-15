<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Abraham
  Date: 15/07/2017
  Time: 02:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>formIncome</title>
</head>
<body>
    <s:form action="addIncome">
        <s:textfield name="amount" label="Monto"/>
        <s:textarea name="description" label="Descripcion"/>
        <s:radio list="#{'1':'Soles','2':'Dolares','3':'Euros'}" label="Tipo" name="currency"/>
        <s:submit value="Save"/>
    </s:form>
<a href="viewIncome.jsp">Ver Ingresos</a>
</body>
</html>
