<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: usuario
  Date: 18/07/2017
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="b" uri="http://bootstrapjsp.org/" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="bootstrap.jsp"/>
<jsp:include page="navbarPrueba.jsp"/>
<html>
<head>

</head>
<body>
<div class="row">
    <div class="col-md-8 col-lg-8">
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img class="first-slide" src="img/ingresa.jpg" alt="First slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1><strong>Ingresa</strong></h1>
                            <p>Tendrás la oportunidad de ingresar todo tipo de gastos y deudas que hayas o vayas a realizar</p>
                            <p><a class="btn btn-lg btn-primary" href="signup.jsp" role="button">Registrate Ahora</a></p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="second-slide" src="img/idenetifica.jpg" alt="Second slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1><strong>Identifica</strong></h1>
                            <p class="color-bar">Con Plan&Save podrás visualizarás con mayor facilidad las deudas o gastos que quieres eliminar</p>
                            <p><a class="btn btn-lg btn-primary" href="signup.jsp" role="button">Quiero registrarme</a></p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="third-slide" src="img/elimina.png" alt="Third slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1><strong>Elimina</strong></h1>
                            <p>Con nuestra ayuda, podrás eliminar las deudas o gastos que deberás cancelar primero antes que se acumulen</p>
                            <p><a class="btn btn-lg btn-primary" href="signup.jsp" role="button">Deseo unirme</a></p>
                        </div>
                    </div>
                </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
    <div class="col-md-4 col-lg-4">
        <div class="container" id="container">
            <s:form action="login" id="contact">
                <h3>Inicia sesión</h3>
                Ingresar con
                <div class="social-buttons">
                    <a href="#" class="btn btn-fb"><i class="fa fa-facebook"></i> Facebook</a>
                    <a href="#" class="btn btn-tw"><i class="fa fa-twitter"></i> Twitter</a>
                </div>
                </hr>
                <s:textfield name="email" placeholder="Email"/>
                <s:password name="password" placeholder="Password"/>
                <s:submit cssClass="btn btn-primary" value="Iniciar sesión"/>
            </s:form>
        </div>
    </div>
</div>
    <jsp:include page="footer.jsp"/>
</body>
</html>
