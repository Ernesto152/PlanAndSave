<%@ taglib prefix="b" uri="http://bootstrapjsp.org/" %>
<%--
  Created by IntelliJ IDEA.
  User: usuario
  Date: 14/07/2017
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="bootstrap.jsp"/>
<jsp:include page="navbar.jsp"/>
<html>
<head title="Expense"></head>
<body>
<b:container>
<div>
<br>
    <form action="" class="form-horizontal"> <%-- Nos permite trabajar con columnas 1 a 1--%>
        <div class="form-group">
            <h2><label class="col-md-10 col-md-offset-2">REGISTRO DE DEUDAS </label></h2>
        </div>
        <br>
        <div class="form-group">
          <label for="monto" class="control-label col-md-2">Monto: </label>
            <div class="col-md-4"> <%--5 columnas de tamaño mediano--%>
                <input class="form-control" type="text"  id="monto" placeholder="Ingrese aquí su sueldo...." required/></td>
            </div>
        </div>
        <div class="form-group">
          <label class="control-label col-md-2">Moneda:</label>
                <label for="Soles" class="radio-inline">
                    <input type="radio" name="rMoneda" id="Soles">Soles
                </label>
                <label for="Dolares" class="radio-inline">
                    <input type="radio" name="rMoneda" id="Dolares">Dolares
                </label>
        </div>
        <div class="form-group">
            <label for="cuotas" class="control-label col-md-2">Cuotas:</label>
            <div class="col-md-1">
                <input class="form-control" type="number" min="1" id="cuotas">
            </div>
        </div>
        <div class="form-group">
        <label class="control-label col-md-2">Intervalo:</label>
                <label for="interMen" class="radio-inline">
                   <input type="radio" name="rIntervalo" id="interMen">Mensual
                </label>
                <label for="interAnual" class="radio-inline">
                    <input type="radio" name="rIntervalo" id="interAnual">Anual
                </label>
        </div>
        <div class="form-group">
            <label for="FechLim" class="control-label col-md-2">Fecha Límite:</label>
            <div class="col-md-2">
                <input class="form-control" type="date" id="FechLim">
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-2 col-md-offset-2">
                <input class="btn btn-sm btn-default" type="button" value="Nueva Categoria">
            </div>
            <div class="dropdown col-md-2">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownmenu1" data-toggle="dropdown" aria-extended="true">
                    Categoria
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownmenu1">
                    <li role="presentation"><a role="item" href="#">Ropa</a> </li>
                    <li role="presentation"><a role="item" href="#">Servicios</a> </li>
                    <li role="presentation"><a role="item" href="#">Equipos</a> </li>
                </ul>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-4 col-md-offset-2">
                <textarea class="form-control" placeholder="Escriba aqui su descripción...."></textarea>
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-3 col-md-offset-2">
                <input class="btn btn-lg btn-block btn-primary" type="submit" value="Ingresar">
            </div>
        </div>
    </form>
</div>
</b:container>
</body>
</html>
