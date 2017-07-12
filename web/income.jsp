<%--
  Created by IntelliJ IDEA.
  User: usuario
  Date: 05/07/2017
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="b" uri="http://bootstrapjsp.org/" %>
<jsp:include page="bootstrap.jsp"/>
<jsp:include page="navbar.jsp"/>

<html>
<head title="Incomes">
</head>
<body>

<b:container>
    <b:jumbotron title="Sample">
        <h1>Income</h1>
        <p>This example is a quick exercise to illustrate how the default, static and fixed to top navbar work. It includes the responsive CSS and HTML, so it also adapts to your viewport and device.</p>
    </b:jumbotron>
</b:container>

<b:container>
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-8 col-md-offset-2 col-lg-8 col-lg-offset-2">
            <table class="table table-bordered table-inverse">
                <thead>
                <tr class="bg-primary">
                    <th>#</th>
                    <th>Monto</th>
                    <th>Fecha</th>
                    <th>Descripción</th>
                    <th>Acción</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>s/. 4500. 00</td>
                    <td>20/04</td>
                    <td>Sueldo</td>
                    <td>
                        <p>
                            <button type="button" class="btn btn-sm btn-info">Editar</button>
                            <button type="button" class="btn btn-sm btn-danger">Eliminar</button>
                        </p>
                    </td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>$ 100. 00</td>
                    <td>21/04</td>
                    <td>Bono</td>
                    <td>
                        <p>
                            <button type="button" class="btn btn-sm btn-info">Editar</button>
                            <button type="button" class="btn btn-sm btn-danger">Eliminar</button>
                        </p>
                    </td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>s/. 750. 00</td>
                    <td>10/04</td>
                    <td>Regalías</td>
                    <td>
                        <p>
                            <button type="button" class="btn btn-sm btn-info">Editar</button>
                            <button type="button" class="btn btn-sm btn-danger">Eliminar</button>
                        </p>
                    </td>
                </tr>
                </tbody>
            </table>
            <div class="pull-right">
                <button type="submit" class="btn btn-primary">Registrar nuevo ingreso</button>
            </div>
        </div>
    </div>
<jsp:include page="footer.jsp"/>
</b:container>
</body>
</html>
