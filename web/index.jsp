<%--
  Created by IntelliJ IDEA.
  User: Administrador
  Date: 30/06/2017
  Time: 08:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="b" uri="http://bootstrapjsp.org/" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="bootstrap.jsp"/>

<html>
<head title="Plan&Save">
</head>
<body id="index">
<!---->
<jsp:include page="navbar.jsp"/>
<!-- Carousel
================================================== -->
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
</div><!-- /.carousel -->
<b:container>

<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing" style="padding-bottom: 100px">

  <!-- Three columns of text below the carousel -->
  <div class="row">
    <div class="col-lg-4">
      <img class="img-circle" src="img/monitorea.jpg" alt="Generic placeholder image" width="140" height="140">
      <h2>Monitorea</h2>
      <p>¡Al registrar tus gastos o deudas podrás darles seguimiento e identificar cual de ellas no te permite alcanzar tus metas financieras!</p>
      <p><a class="btn btn-default" href="#" role="button">Ver detalles &raquo;</a></p>
    </div><!-- /.col-lg-4 -->
    <div class="col-lg-4">
      <img class="img-circle" src="img/reducirgastos.jpg" alt="Generic placeholder image" width="140" height="140">
      <h2>Reduce tus gastos</h2>
      <p>Elimine gastos innecesarios y libere a la familia algo más de dinero, llegando al final del mes con un mayor desahogo y con más dinero disponibe</p>
      <p><a class="btn btn-default" href="#" role="button">Ver detalles &raquo;</a></p>
    </div><!-- /.col-lg-4 -->
    <div class="col-lg-4">
      <img class="img-circle" src="img/metas.jpg" alt="Generic placeholder image" width="140" height="140">
      <h2>Alcanza tus metas</h2>
      <p>Puedes tener lo que quieras, pero no puedes tenerlo todo. Corta tus gastos en las cosas innecesarias e invierte en aquellas que te hagan sentir mejor</p>
      <p><a class="btn btn-default" href="#" role="button">Ver detalles &raquo;</a></p>
    </div><!-- /.col-lg-4 -->
  </div><!-- /.row -->

  <!-- START THE FEATURETTES -->

  <hr class="featurette-divider">

    <div class="row featurette">
      <div class="col-md-7">
        <h2 class="featurette-heading">Responsablilidad Financiera<span class="text-muted"></span></h2>
        <p class="lead">Aprenda a realizar mejores decisiones consumiendo de forma inteligente desde ahora, gastando y pagando sus deudas de forma más efectiva</p>
      </div>
      <div class="col-md-5">
        <img class="featurette-image img-responsive center-block" src="img/responsabilidadf.jpg">
      </div>
    </div>


  <hr class="featurette-divider">

  <div class="row featurette">
    <div class="col-md-7 col-md-push-5">
      <h2 class="featurette-heading">Gestión del dinero<span class="text-muted"></span></h2>
      <p class="lead">Administre inteligentemente su dinero gastantdo menos de lo que gana, invirtiendo temprano y ahorrando</p>
    </div>
    <div class="col-md-5 col-md-pull-7">
      <img class="featurette-image img-responsive center-block" src="img/getiondinero.jpg">
    </div>
  </div>

  <hr class="featurette-divider">

  <div class="row featurette">
    <div class="col-md-7">
      <h2 class="featurette-heading">Reducción de gastos y deudas<span class="text-muted"></span></h2>
      <p class="lead">Con el monitoreo podrá eliminar de manera más efectiva sus gastos y deudas más importantes hasta que estas disminuyan</p>
    </div>
    <div class="col-md-5">
      <img class="featurette-image img-responsive center-block" src="img/reducciongastosdeudas.png">
    </div>
  </div>
</div>
</b:container>
<jsp:include page="footer.jsp"/>
</body>
</html>
