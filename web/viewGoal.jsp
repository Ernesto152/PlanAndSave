<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="b" uri="http://bootstrapjsp.org/" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="bootstrap.jsp"/>
<%--
  Created by IntelliJ IDEA.
  User: Abraham
  Date: 05/08/2017
  Time: 01:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="navbar.jsp"/>
<html>
<head>
    <title>Title</title>
</head>
<body>

<s:if test="%{#session.user_id==null || #session.user_id==0}">
    <jsp:include page="errorLogin.jsp"/>
</s:if>

<s:if test="%{#session.user_id>0}">

    <jsp:useBean id="service" class="pe.edu.utp.planandsave.services.PSService"/>
    <c:forEach var="income" items="${service.incomes}">
        <c:if test="${income.user.id eq user_id}">
            <c:set var="sumIncome" value="${sumIncome+(income.amount*income.currency.exchangeRate)}"/>
        </c:if>
    </c:forEach>

    <c:forEach var="expense" items="${service.expenses}">
        <c:if test="${expense.user.id eq user_id}">
            <c:set var="sumExpense" value="${sumExpense+(expense.amount*expense.currency.exchangeRate)}"/>
        </c:if>
    </c:forEach>

    <c:forEach var="debt" items="${service.debts}">
        <c:if test="${debt.user.id eq user_id}">
            <c:set var="sumDebt" value="${sumDebt+(debt.quota*debt.periodAmount*debt.currency.exchangeRate)}"/>
        </c:if>
    </c:forEach>

    <c:set var="saves" value="${sumIncome-sumExpense-sumDebt}"/>

    <b:container>
        <b:jumbotron title="Sample">
            <h1>Mis Metas</h1>
            <p>Alcanza tus Metas </p>
            <fmt:setLocale value = "es_PE"/>
            <p>Mi saldo : <fmt:formatNumber value = "${saves}" type = "currency"/></p>
        </b:jumbotron>
    </b:container>
    <b:container>
        <div class="row" style="padding-bottom: 50px">
            <div class="col-xs-12 col-sm-12 col-md10 col-md-offset-1 col-lg-10 col-lg-offset-1">
                <div class="table-responsive">
                    <table class="table table-bordered table-inverse table-striped table-responsive">
                        <thead>
                        <tr class="bg-primary">
                            <th>#</th>
                            <th>Monto</th>
                            <th>Imagen</th>
                            <th>Moneda</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:set var="count" value="0" scope="page"/>
                        <c:forEach var="goal" items="${service.goals}">
                            <c:if test="${goal.user.id eq user_id}">
                                <c:if test="${goal.currency.id eq 1}">
                                    <fmt:setLocale value = "es_PE"/>
                                </c:if>
                                <c:if test="${goal.currency.id eq 2}">
                                    <fmt:setLocale value = "en_US"/>
                                </c:if>
                                <c:if test="${goal.currency.id eq 3}">
                                    <fmt:setLocale value = "es_ES"/>
                                </c:if>
                                <c:set var="count" value="${count+1}" scope="page"/>
                                <tr>
                                    <td><c:out value="${count}"/></td>
                                    <td align="right"><fmt:formatNumber value = "${goal.amount}" type = "currency"/></td>
                                    <td><c:out value="${goal.status}"/></td>
                                    <td align="center"><img src="<c:out value="${goal.image.url}"/>" style="width: 400px; height: 250px"></td>
                                    <td><c:out value="${goal.currency.name}"/></td>
                                    <td>
                                        <p>
                                            <a href="<s:url action="completeGoal">
                                        <s:param name="id"><c:out value="${goal.id}"/></s:param>
                                        <s:param name="saves"><c:out value="${saves}"/></s:param></s:url>"
                                               class="btn btn-sm btn-info">Completar</a>

                                            <a href="<s:url action="deleteGoal">
                                        <s:param name="id"><c:out value="${goal.id}"/></s:param></s:url>"
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
                    <a href="formGoal.jsp" type="button" class="btn btn-primary">Registrar nueva meta</a>
                </div>
            </div>
        </div>
    </b:container>


</s:if>

<jsp:include page="footer.jsp"/>
</body>
</html>
