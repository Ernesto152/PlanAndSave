<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="bootstrap.jsp"/>
<jsp:include page="navbar.jsp"/>
<html>
<head title="Debt"></head>
<body>
<b:container>
<div>
  <br>
    <form action="" class="form-horizontal">
    <div class="form-group">
      <h2><label class="col-md-10 col-md-offset-2">REGISTRO DE GASTOS</label></h2>
    </div>
    <br>
    <div class="form-group">
      <label for="monto" class="control-label col-md-2">Monto: </label>
        <div class="col-md-4"> <%--5 columnas de tamaño mediano--%>
          <input class="form-control" type="text" id="monto" placeholder="Ingrese aquí la cantidad de su gasto...." required/></td>
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
      <label for="FechLim" class="control-label col-md-2">Fecha Límite:</label>
      <div class="col-md-2">
        <input class="form-control" type="date" id="FechLim">
      </div>
    </div>
    <div class="form-group">
      <div class="dropdown col-md-2 col-md-offset-2 col-lg-offset-2">
        <button class="btn btn-default dropdown-toggle" type="button" id="dropdownmenu1" data-toggle="dropdown" aria-extended="true">
        Categoria
        <span class="caret"></span>
        </button>
        <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownmenu1">
          <li role="presentation"><a role="item" href="#">Alimentos</a> </li>
          <li role="presentation"><a role="item" href="#">Ropa</a> </li>
          <li role="presentation"><a role="item" href="#">Servicios Básicos</a> </li>
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
