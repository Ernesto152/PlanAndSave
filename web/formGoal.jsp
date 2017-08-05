<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://bootstrapjsp.org/" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="bootstrap.jsp"/>
<jsp:include page="navbar.jsp"/>

<html>
<head title="goal">
</head>

<body>

<s:if test="%{#session.user_id==null || #session.user_id==0}">
    <jsp:include page="errorLogin.jsp"/>
</s:if>

<s:if test="%{#session.user_id>0}">
    <c:container>
        <div style="padding-bottom: 100px">
            <s:div cssClass="row">
                <br>
                <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                    <img class="featurette-image img-responsive center-block" src="img/goal.jpg" style="padding-top: 35px; padding-bottom: 35px">
                </div>
                <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                    <s:div cssClass="container col-md-8">
                        <s:form action="addGoal">

                            <s:div cssClass="form-group">
                                <h2><s:label >Nueva Meta</s:label></h2>
                            </s:div>

                            <s:hidden name="user" value="%{#session.user_id}"/>

                            <s:div cssClass="form-group">
                                <s:select name="image" list="#{'1':'Carro','2':'Moto','3':'Cocina','4':'Lavadora'}" cssClass="form-control"
                                          headerKey="0" headerValue="--Seleccionar--"/>
                            </s:div>

                            <s:div cssClass="form-group">
                                <s:label cssClass="control-label" for="name">Nombre: </s:label>
                                <s:textfield name="name" maxLength="7" cssClass="form-control" placeholder="Ingrese su meta ..." />
                            </s:div>

                            <s:div cssClass="form-group">
                                <s:label cssClass="control-label" for="amount">Monto: </s:label>
                                <s:textfield name="amount" maxLength="7" cssClass="form-control" placeholder="Ingrese su monto..." required="true" />
                            </s:div>

                            <s:div cssClass="form-group">
                                <s:label cssClass="control-label" for="currency">Moneda: </s:label>
                                <s:radio name="currency" list="#{'1':'Soles','2':'Dolares','3':'Euros'}" required="true" />
                            </s:div>

                            <s:submit value="Aceptar" cssClass="btn btn-primary "/>

                        </s:form>
                    </s:div>
                </div>
            </s:div>
        </div>

    </c:container>
</s:if>
</body>
</html>
