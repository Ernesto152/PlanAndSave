<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: usuario
  Date: 27/06/2017
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currencies</title>
</head>
<body>
<jsp:useBean id="service" class="pe.edu.utp.planandsave.services.PSService"/>
<c:forEach var="currency" items="${service.currencies}">
    <p><c:out value="${currency.name}"/></p>
</c:forEach>
</body>
</html>
