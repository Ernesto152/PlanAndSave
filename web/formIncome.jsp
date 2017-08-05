<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: Abraham
  Date: 15/07/2017
  Time: 02:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="b" uri="http://bootstrapjsp.org/" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="bootstrap.jsp"/>
<jsp:include page="navbar.jsp"/>
<html>
<head>
    <title>Registra tus ingresos</title>
</head>
<body id="income">

<s:if test="%{#session.user_id==null || #session.user_id==0}">
    <jsp:include page="errorLogin.jsp"/>
</s:if>

<s:if test="%{#session.user_id>0}">

<b:container>
    <s:div cssClass="container">
        <s:div cssClass="row">
            <br>
            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                <img class="featurette-image img-responsive center-block" src="img/ahorro.jpg" style="padding-top: 35px; padding-bottom: 35px">
            </div>
            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                <s:div cssClass="container col-md-8">
                    <s:form action="addIncome">

                        <s:div cssClass="form-group">
                            <h2><s:label >REGISTRO DE INGRESOS</s:label></h2>
                        </s:div>

                        <s:hidden name="user" value="%{#session.user_id}"/>

                        <s:div cssClass="form-group">
                            <s:label cssClass="control-label" for="amount">Monto: </s:label>
                            <s:textfield name="amount" maxLength="10" cssClass="form-control" placeholder="Ingrese el monto..." required="true" />
                        </s:div>

                        <s:div cssClass="form-group">
                            <s:textarea name="description" label="Desripcion" maxLength="100" cssClass="form-control"
                                        placeholder="Escriba la descripcion del ingreso" required="true"/>
                        </s:div>

                        <s:div cssClass="form-group">
                            <s:label cssClass="control-label" for="currency">Moneda: </s:label>
                            <s:radio name="currency" list="#{'1':'Soles','2':'Dolares','3':'Euros'}" required="true" />

                        </s:div>

                        <s:submit value="Ingresar" cssClass="btn btn-block btn-primary "/>

                    </s:form>
                </s:div>
            </div>
        </s:div>
    </s:div>
</b:container>
<jsp:include page="footer.jsp"/>
</s:if>
</body>
</html>
