<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>

<%--
  Created by IntelliJ IDEA.
  User: usuario
  Date: 14/07/2017
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="bootstrap.jsp"/>
<jsp:include page="navbar.jsp"/>

<html>
<head title="debt">
</head>

<body>
<s:div cssClass="container">
<s:div cssClass="row">
    <br>
    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
        <img class="featurette-image img-responsive center-block" src="img/debts_imagen.jpg" style="padding-top: 35px">
    </div>
    <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
    <s:div cssClass="container col-md-8">
    <s:form action="addDebt">

        <s:div cssClass="form-group">
            <h2><s:label >REGISTRO DE DEUDAS</s:label></h2>
        </s:div>

        <s:hidden name="user" value="%{#session.user_id}"/>

        <s:div cssClass="form-group">
            <s:label cssClass="control-label" for="debt_freeAmount">Monto: </s:label>
                <s:textfield name="debt_freeAmount" maxLength="7" cssClass="form-control" placeholder="Ingrese su deuda..." required="true" />
        </s:div>

        <s:div cssClass="form-group">
            <s:label cssClass="control-label" for="debt_periodAmount">Amortización: </s:label>
            <s:textfield name="debt_periodAmount" maxLength="7" cssClass="form-control" placeholder="Ingrese su amortización..." required="true"/>
        </s:div>

        <s:div cssClass="form-group">
            <s:label cssClass="control-label" for="currency">Moneda: </s:label>
            <s:radio name="currency" list="#{'1':'Soles','2':'Dolares','3':'Euros'}" required="true" />

        </s:div>

        <s:div cssClass="form-group">
            <s:label cssClass="control-label" for="debt_quota">Cuotas: </s:label>
            <s:textfield name="debt_quota" type="number" cssClass="form-control" min="1" max="50" required="true"/>
        </s:div>

        <s:div cssClass="form-group">
            <s:label cssClass="control-label" for="period">Intervalo: </s:label>
            <s:radio name="period" list="#{'1':'Semanal','2':'Mensual','3':'Anual'}" required="true" />

        </s:div>



        <s:div cssClass="form-group">
            <s:select name="expenseCategory" list="#{'1':'Alimento','2':'Comida'}" cssClass="form-control"
                      headerKey="0" headerValue="--Seleccionar--" required="true"/>

        </s:div>

        <s:div cssClass="form-group">
                <s:textarea name="debt_description" label="Desripcion" maxLength="100" cssClass="form-control"
                            placeholder="Escriba la descripcion de la deuda" required="true"/>
        </s:div>

        <s:submit value="Ingresar" cssClass="btn btn-block btn-primary "/>

    </s:form>
    </s:div>
    </div>
</s:div>
</s:div>
</body>
</html>
