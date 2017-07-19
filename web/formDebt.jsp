<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Abraham
  Date: 18/07/2017
  Time: 05:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>formDebt</title>
</head>
<body>

<s:form action="addDebt">
    <s:textarea name="debt_description" label="Descripcion"/>
    <s:select list="#{'1':'Alimento','2':'Comida'}" label="Categoria" name="expenseCategory" headerKey="0" headerValue="---Seleccionar---"/>
    <s:textfield name="debt_quota" label="Numero de Cuotas"/>
    <s:radio list="#{'1':'Semanal','2':'Mensual','3':'Anual'}" label="Periodo" name="period"/>
    <s:textfield name="debt_freeAmount" label="Monto Original"/>
    <s:textfield name="debt_periodAmount" label="Monto por Periodo"/>
    <s:radio list="#{'1':'Soles','2':'Dolares','3':'Euros'}" label="Tipo" name="currency"/>

    <s:submit value="Save"/>
</s:form>

<%/*<s:form action="addExpense">
    <s:textfield name="amount" label="Monto"/>
    <s:textarea name="description" label="Descripcion"/>
    <s:radio list="#{'1':'Soles','2':'Dolares','3':'Euros'}" label="Tipo" name="currency"/>
    <s:select list="#{'1':'Alimento','2':'Comida'}" label="Categoria" name="expenseCategory" headerKey="0" headerValue="---Seleccionar---"/>
    <s:submit value="Save"/>
</s:form>*/%>

<a href="viewExpense.jsp">Ver Deudas</a>

</body>
</html>
