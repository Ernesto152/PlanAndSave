<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="b" uri="http://bootstrapjsp.org/" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="bootstrap.jsp"/>
<%--
  Created by IntelliJ IDEA.
  User: Abraham
  Date: 18/07/2017
  Time: 05:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tus Deudas</title>
</head>
<body id="view">
<jsp:include page="navbar.jsp"/>
<b:container>
    <b:jumbotron title="Sample">
        <h1>Deudas</h1>
        <p>Lleva un control de tus Deudas </p>
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
                        <th>Amortización</th>
                        <th>Moneda</th>
                        <th>Cuotas</th>
                        <th>Periodo</th>
                        <th>Fecha</th>
                        <th>Categoria</th>
                        <th>Descripcion</th>
                        <th>Acción</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:set var="count" value="0" scope="page"/>
                    <c:forEach var="debt" items="${service.debts}">
                        <c:if test="${debt.user.id eq user_id}">
                            <c:set var="count" value="${count+1}" scope="page"/>
                            <tr>
                                <td><c:out value="${count}"/></td>
                                <td><c:out value="${debt.freeAmount}"/></td>
                                <td><c:out value="${debt.periodAmount}"/></td>
                                <td><c:out value="${debt.currency.name}"/></td>
                                <td><c:out value="${debt.quota}"/></td>
                                <td><c:out value="${debt.period.name}"/></td>
                                <td><c:out value="${debt.startDate}"/></td>
                                <td><c:out value="${debt.expensesCategory.name}"/></td>
                                <td><c:out value="${debt.description}"/></td>
                                <td>
                                    <p>
                                        <a href="#" class="btn btn-sm btn-info">Editar</a>
                                        <a href="<s:url action="deleteDebts">
                                        <s:param name="debt_id"><c:out value="${debt.id}"/></s:param></s:url>"
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
                <a href="debt.jsp" type="button" class="btn btn-primary">Registrar nueva deuda</a>
            </div>
        </div>
    </div>
</b:container>
<jsp:include page="footer.jsp"/>
</body>
</html>
