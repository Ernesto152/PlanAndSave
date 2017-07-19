<%--
  Created by IntelliJ IDEA.
  User: Abraham
  Date: 15/07/2017
  Time: 05:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="b" uri="http://bootstrapjsp.org/" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="bootstrap.jsp"/>
<jsp:include page="navbar.jsp"/>
<html>
<head>
    <title>formExpense</title>
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
            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                <img class="featurette-image img-responsive center-block" src="img/ahorro.jpg" style="padding-top: 35px">
            </div>
            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
                <div class="container" id="container">
                    <s:form action="addExpense" id="contact">
                        <h3>Registra</h3>
                        <h4>Llena este formulario con un nuevo gasto</h4>
                        <s:textfield name="amount" placeholder="Monto"/>
                        <s:textarea name="description" placeholder="Descripcion"/>
                        <s:radio list="#{'1':'Soles','2':'Dolares','3':'Euros'}" label="Tipo" name="currency"/>
                        <s:select list="#{'1':'Alimento','2':'Comida'}" label="Categoria" name="expenseCategory" headerKey="0" headerValue="---Seleccionar---"/>
                        <s:submit cssClass="btn btn-primary" value="Registrar"/>
                    </s:form>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </b:container>
</body>
</html>
