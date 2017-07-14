<%--
  Created by IntelliJ IDEA.
  User: Abraham
  Date: 12/07/2017
  Time: 04:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="b" uri="http://bootstrapjsp.org/" %>

<jsp:include page="bootstrap.jsp"/>
<jsp:include page="navbar.jsp"/>


<html>
<head title="Plan&Save">
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript" src="js/overviewChart.js"></script>
</head>
<body>

<b:container>
    <b:jumbotron title="Sample">
        <h1>Overview</h1>
        <p>This example is a quick exercise to illustrate how the default, static and fixed to top navbar work. It includes the responsive CSS and HTML, so it also adapts to your viewport and device.</p>
    </b:jumbotron>
</b:container>

<b:container>
    <b:row>
        <div class="col-xs-10 col-xs-offset-2 col-sm-10 col-sm-offset-2 col-md-10 col-md-offset-2 col-lg-10 col-lg-offset-2">
            <div class="chart">
                <div id="chart_div1"/>
            </div>
        </div>
    </b:row>

    <b:row>
        <div class="col-xs-12 col-sm-12 col-md-8 col-md-offset-2 col-lg-8 col-lg-offset-2">
            <table class="table table-bordered table-inverse table-striped">
                <thead>
                <tr class="bg-primary">
                    <th>Año</th>
                    <th>Mes</th>
                    <th>Ingreso</th>
                    <th>Gasto</th>
                    <th>Deuda</th>
                    <th>Saldo</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>2017</td>
                    <td>Abril</td>
                    <td>s/. 4500. 00</td>
                    <td>s/. 1000. 00</td>
                    <td>s/. 1500. 00</td>
                    <td>s/. 2000. 00</td>
                </tr>
                <tr>
                    <td>2017</td>
                    <td>Mayo</td>
                    <td>s/. 5000. 00</td>
                    <td>s/. 800. 00</td>
                    <td>s/. 1500. 00</td>
                    <td>s/. 2700. 00</td>
                </tr>
                <tr class="info">
                    <td colspan="2">Total</td>
                    <td>s/. 9500. 00</td>
                    <td>s/. 1800. 00</td>
                    <td>s/. 3000. 00</td>
                    <td>s/. 4700. 00</td>
                </tr>
                </tbody>
            </table>
        </div>
    </b:row>
    <jsp:include page="footer.jsp"/>
</b:container>

</body>
</html>
