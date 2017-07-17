<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Abraham
  Date: 15/07/2017
  Time: 05:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>formExpense</title>
</head>
<body>
    <s:form action="addExpense">
        <s:textfield name="amount" label="Monto"/>
        <s:textarea name="description" label="Descripcion"/>
        <s:radio list="#{'1':'Soles','2':'Dolares','3':'Euros'}" label="Tipo" name="currency"/>
        <s:select list="#{'1':'Alimento','2':'Comida'}" label="Categoria" name="expenseCategory" headerKey="0" headerValue="---Seleccionar---"/>
        <s:submit value="Save"/>
    </s:form>

    <a href="viewExpense.jsp">Ver Gastos</a>

</body>
</html>
