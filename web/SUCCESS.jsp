<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Abraham
  Date: 16/07/2017
  Time: 02:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SUCCESS</title>
</head>
<body>
    <h1>SUCCESS</h1>
    <jsp:useBean id="service" class="pe.edu.utp.planandsave.services.PSService"/>
    <%/*<c:forEach var="income" items="${service.incomes}">
        <table border="1">
            <th>Monto<th>Descripcion<th>Fecha<th>Moneda
            <tr>
                <td><c:out value="${income.amount}"/>
                <td><c:out value="${income.description}"/>
                <td><c:out value="${income.registrationDate}"/>
                <td><c:out value="${income.currency.id}"/>
        </table>
    </c:forEach>*/%>
</body>
</html>
