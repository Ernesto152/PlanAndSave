<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="b" uri="http://bootstrapjsp.org/" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="bootstrap.jsp"/>


<%--
  Created by IntelliJ IDEA.
  User: Abraham
  Date: 15/07/2017
  Time: 04:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tus ingresos</title>
</head>
<body id="view">
<jsp:include page="navbar.jsp"/>

<s:if test="%{#session.user_id==null || #session.user_id==0}">
    <jsp:include page="errorLogin.jsp"/>
</s:if>

<s:if test="%{#session.user_id>0}">
<b:container>
    <b:jumbotron title="Sample">
        <h1>Ingresos</h1>
        <p>Lleva un control de tus ingresos</p>
    </b:jumbotron>
</b:container>
<b:container>
    <jsp:useBean id="service" class="pe.edu.utp.planandsave.services.PSService"/>
        <div class="row" style="padding-bottom: 50px">
            <div class="col-xs-12 col-sm-12 col-md-8 col-md-offset-2 col-lg-8 col-lg-offset-2">
                <div class="table-responsive">
                    <table class="table table-bordered table-inverse table-striped table-responsive">
                        <thead>
                        <tr class="bg-primary">
                            <th>#</th>
                            <th>Monto</th>
                            <th>Descripción</th>
                            <th>Fecha</th>
                            <th>Moneda</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:set var="count" value="0" scope="page"/>
                        <c:forEach var="income" items="${service.incomes}">
                            <c:if test="${income.user.id eq user_id}">
                                <c:if test="${income.currency.id eq 1}">
                                    <fmt:setLocale value = "es_PE"/>
                                </c:if>
                                <c:if test="${income.currency.id eq 2}">
                                    <fmt:setLocale value = "en_US"/>
                                </c:if>
                                <c:if test="${income.currency.id eq 3}">
                                    <fmt:setLocale value = "es_ES"/>
                                </c:if>
                                <c:set var="count" value="${count+1}" scope="page"/>
                            <tr>
                                <td><c:out value="${count}"/></td>
                                <td align="right"><fmt:formatNumber value = "${income.amount}" type = "currency"/></td>
                                <td><c:out value="${income.description}"/></td>
                                <td><c:out value="${income.registrationDate}"/></td>
                                <td><c:out value="${income.currency.name}"/></td>
                                <td>
                                    <p>
                                        <a href="<s:url action="edit"><s:param name="id"><c:out value="${income.id}"/></s:param></s:url>" class="btn btn-sm btn-info">Editar</a>
                                        <a href="<s:url action="deleteIncome">
                                        <s:param name="id"><c:out value="${income.id}"/></s:param></s:url>"
                                           class="btn btn-sm btn-danger">Eliminar</a>
                                    </p>
                                </td>
                            </tr>
                            </c:if>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="pull-right">
                    <a href="formIncome.jsp" type="button" class="btn btn-primary">Registrar nuevo ingreso</a>
                </div>
            </div>
        </div>
</b:container>
</s:if>
<jsp:include page="footer.jsp"/>
</body>
</html>
