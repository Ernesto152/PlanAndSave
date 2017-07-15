<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Abraham
  Date: 15/07/2017
  Time: 05:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="navbar.jsp"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:useBean id="service" class="pe.edu.utp.planandsave.services.PSService"/>
    <c:forEach var="expense" items="${service.expenses}">
        <table border="1">
            <th>Monto<th>Fecha<th>Descripcion<th>Categoria<th>Moneda</th>
            <tr>
                <td><c:out value="${expense.amount}"/>
                <td><c:out value="${expense.registrationDate}"/>
                <td><c:out value="${expense.description}"/>
                <td><c:out value="${expense.expensesCategory.name}"/>
                <td><c:out value="${expense.currency.name}"/>
        </table>
    </c:forEach>

    <p><a href="formIncome.jsp">Volver a Ingresar</a></p>


</body>
</html>
