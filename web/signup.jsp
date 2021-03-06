<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: usuario
  Date: 05/07/2017
  Time: 1:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="b" uri="http://bootstrapjsp.org/" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="bootstrap.jsp"/>
<jsp:include page="navbar.jsp"/>

<html>
<head title="Sign Up">
</head>
<body>
<b:container>
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
            <img class="featurette-image img-responsive center-block" src="img/ahorro.jpg" style="padding-top: 35px">
        </div>
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
            <div class="container" id="container">
                <s:form action="addUser" id="contact">
                    <h3>Regístrate</h3>
                    <h4>Únete a nosotros y experimenta</h4>
                    <s:textfield placeholder="Nombre" name="firstName"/>
                    <s:textfield placeholder="Apellidos" name="lastName"/>
                    <s:textfield placeholder="Correo electrónico" name="email" type="email"/>
                    <s:password placeholder="Contraseña" name="password" type="password"/>
                    <s:submit cssClass="btn btn-primary" value="Registrarme"/>
                </s:form>
            </div>
        </div>
    </div>
</b:container>
<jsp:include page="footer.jsp"/>
</body>
</html>

