<%--
  Created by IntelliJ IDEA.
  User: usuario
  Date: 03/08/2017
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="b" uri="http://bootstrapjsp.org/" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="bootstrap.jsp"/>
<jsp:include page="navbar.jsp"/>
<html>
<head>
    <title>Editar</title>
</head>
<body>
    <s:form>
        <p>Descripcion :<s:property value="description"/></p>
        <p><s:textarea name="description" placeholder="Nueva descripcion" size="100%"/></p>
        <p>Monto: <s:property value="amount"/></p>
        <p><s:textfield name="amount" placeholder="Nuevo monto" size="100%"/></p>
        <s:submit cssClass="btn btn-primary" value="Registrar"/>
    </s:form>

</body>
</html>
