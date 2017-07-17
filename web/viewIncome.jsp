<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="b" uri="http://bootstrapjsp.org/" %>
<jsp:include page="bootstrap.jsp"/>

<%--
  Created by IntelliJ IDEA.
  User: Abraham
  Date: 15/07/2017
  Time: 04:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="navbar.jsp"/>
<html>
<head>
    <title>View Incomes</title>
    <script>
        function tablas(){
            var yea=document.getElementById("tabla1").rows.length;
            alert(yea);
        }
    </script>
</head>
<body>
<b:container>
    <b:jumbotron title="Sample">
        <h1>Ingresos</h1>
        <p>Lleva un control de tus ingresos</p>
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
                            <th>Descripción</th>
                            <th>Fecha</th>
                            <th>Moneda</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="income" items="${service.incomes}" varStatus="loop">
                            <tr>
                                <td><c:out value="${loop.count}"/></td>
                                <td><c:out value="${income.amount}"/></td>
                                <td><c:out value="${income.description}"/></td>
                                <td><c:out value="${income.registrationDate}"/></td>
                                <td><c:out value="${income.currency.name}"/></td>
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
                    <a href="formIncome.jsp" type="button" class="btn btn-primary">Registrar nuevo ingreso</a>
                </div>
            </div>
        </div>
    <jsp:include page="footer.jsp"/>
</b:container>

</body>
</html>
