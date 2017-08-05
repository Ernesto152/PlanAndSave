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
  Time: 05:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="navbar.jsp"/>
<html>
<head>
    <title>Tus gastos</title>
</head>
<body>

<s:if test="%{#session.user_id==null || #session.user_id==0}">
    <jsp:include page="errorLogin.jsp"/>
</s:if>

<s:if test="%{#session.user_id>0}">
    <b:container>
        <b:jumbotron title="Sample">
            <h1>Gastos</h1>
            <p>Lleva un control de tus gastos</p>
        </b:jumbotron>
    </b:container>
    <b:container>
        <jsp:useBean id="service" class="pe.edu.utp.planandsave.services.PSService"/>
        <div class="row" style="padding-bottom: 50px">
            <div class="col-xs-12 col-sm-12 col-md-8 col-md-offset-2 col-lg-8 col-lg-offset-2">
                <div class="table-responsive">
                    <table class="table table-bordered table-inverse table-striped table-responsive" id="tabla1">
                        <thead>
                        <tr class="bg-primary">
                            <th>#</th>
                            <th>Monto</th>
                            <th>Fecha</th>
                            <th>Descripcion</th>
                            <th>Categoria</th>
                            <th>Moneda</th>
                            <th>Acción</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:set var="count" value="0" scope="page"/>
                        <c:forEach var="expense" items="${service.expenses}">
                            <c:if test="${expense.user.id eq user_id}">
                                <c:if test="${expense.currency.id eq 1}">
                                    <fmt:setLocale value = "es_PE"/>
                                </c:if>
                                <c:if test="${expense.currency.id eq 2}">
                                    <fmt:setLocale value = "en_US"/>
                                </c:if>
                                <c:if test="${expense.currency.id eq 3}">
                                    <fmt:setLocale value = "es_ES"/>
                                </c:if>
                                <c:set var="count" value="${count+1}" scope="page"/>
                                <tr>
                                    <td><c:out value="${count}"/></td>
                                    <td align="right"><fmt:formatNumber value = "${expense.amount}" type = "currency"/>
                                    <td><c:out value="${expense.registrationDate}"/>
                                    <td><c:out value="${expense.description}"/>
                                    <td><c:out value="${expense.expensesCategory.name}"/>
                                    <td><c:out value="${expense.currency.name}"/>
                                    <td>
                                        <p>
                                            <button type="button" class="btn btn-sm btn-info">Editar</button>
                                            <a href="<s:url action="deleteExpense">
                                            <s:param name="id"><c:out value="${expense.id}"/></s:param></s:url>"
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
                    <a href="formExpense.jsp" type="button" class="btn btn-primary">Registrar nuevo gasto</a>
                </div>
            </div>
        </div>
    </b:container>
</s:if>
    <jsp:include page="footer.jsp"/>
</body>
</html>
