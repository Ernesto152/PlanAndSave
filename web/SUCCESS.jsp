<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
    <p>Welcome</p>
    <s:property value="email"/>
    <s:property value="user.id"/>
    
  <%/*  <jsp:useBean id="service" class="pe.edu.utp.planandsave.services.PSService"/>
    <c:forEach var="user" items="${service.getUsersByEmail({<s:property value="email">},)}">
        <p><c:out value="${user.id}"/> <c:out value="${user.firstName}"/><c:out value="${user.lastName}"/><c:out value="${user.email}"/></p>
    </c:forEach>*/%>



</body>
</html>
