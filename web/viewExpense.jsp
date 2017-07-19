<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="b" uri="http://bootstrapjsp.org/" %>
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
    <title>Title</title>
</head>
<body>
    <b:container>
        <b:jumbotron title="Sample">
            <h1>Gastos</h1>
            <p>Lleva un control de tus gastos</p>
        </b:jumbotron>
    </b:container>
    <b:container>
        <jsp:useBean id="service" class="pe.edu.utp.planandsave.services.PSService"/>
        <div class="row">
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
                        <c:forEach var="expense" items="${service.expenses}" varStatus="loop">
                            <tr>
                                <td><c:out value="${loop.count}"/></td>
                                <td><c:out value="${expense.amount}"/>
                                <td><c:out value="${expense.registrationDate}"/>
                                <td><c:out value="${expense.description}"/>
                                <td><c:out value="${expense.expensesCategory.name}"/>
                                <td><c:out value="${expense.currency.name}"/>
                                <td>
                                    <p>
                                        <button type="button" class="btn btn-sm btn-info">Editar</button>
                                        <button type="button" class="btn btn-sm btn-danger">Eliminar</button>
                                    </p>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="pull-right">
                    <a href="formExpense.jsp" type="button" class="btn btn-primary">Registrar nuevo gasto</a>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </b:container>
</body>
</html>
