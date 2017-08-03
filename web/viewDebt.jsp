<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="b" uri="http://bootstrapjsp.org/" %>
<jsp:include page="bootstrap.jsp"/>
<%--
  Created by IntelliJ IDEA.
  User: Abraham
  Date: 18/07/2017
  Time: 05:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="navbar.jsp"/>
<html>
<head>
</head>
<body>
<b:container>
    <b:jumbotron title="Sample">
        <h1>Deudas</h1>
        <p>Lleva un control de tus </p>
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
                    <c:forEach var="debt" items="${service.debts}" varStatus="loop">
                        <c:if test="${debt.user.id}">
                            <tr>
                                <td><c:out value="${loop.count}"/></td>
                                <td><c:out value="${debt.freeAmount}"/>
                                <td><c:out value="${debt.periodAmount}"/>
                                <td><c:out value="${debt.currency.name}"/>
                                <td><c:out value="${debt.quota}"/>
                                <td><c:out value="${debt.period.name}"/>
                                <td><c:out value="${debt.startDate}"/>
                                <td><c:out value="${debt.expensesCategory.name}"/>
                                <td><c:out value="${debt.description}"/>
                                <td>
                                    <p>
                                        <button type="button" class="btn btn-sm btn-info">Editar</button>
                                        <button type="button" class="btn btn-sm btn-danger">Eliminar</button>
                                    </p>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="pull-right">
                <a href="debt.jsp" type="button" class="btn btn-primary">Registrar nuevo gasto</a>
            </div>
        </div>
    </div>
</b:container>
<jsp:include page="footer.jsp"/>
</body>
</html>
