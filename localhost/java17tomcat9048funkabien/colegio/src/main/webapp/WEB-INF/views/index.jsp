<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <!--libreria font awesome-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
           
        <title>Pagina Indice</title>       
            
    </head>
    <body style="background: #f1f1f1;margin: 15px 30px;">
    <!-- header -->  
    <%@include file="/WEB-INF/views/shared/header.jsp" %>
    <!-- barnav -->
    <%@include file="/WEB-INF/views/shared/navbar.jsp" %>
    
    <!-- main -->
    <div class="container">
    <div class="row" style="padding: 20px;">
      <div class="col-md-2" style="padding-right:20px;">
        <!--list group-->
        <div class="list-group">  
                          
          <a href="<c:url value='/usuario_listar'/>" class="list-group-item list-group-item-action">Usuarios</a>
          <a href="<c:url value='/alumno_listar'/>" class="list-group-item list-group-item-action">Alumnos</a>
          <a href="<c:url value='/apoderado_listar'/>" class="list-group-item list-group-item-action">Apoderados</a>   
          <a href="<c:url value='/calendario_listar'/>" class="list-group-item list-group-item-action">Calendarios</a> 
          <a href="<c:url value='/ano_escolar_listar'/>" class="list-group-item list-group-item-action">Años Escolares</a>   
          <a href="<c:url value='/grado_listar'/>" class="list-group-item list-group-item-action">Grados</a>   
          <a href="<c:url value='/seccion_listar'/>" class="list-group-item list-group-item-action">Secciones</a> 
          <a href="<c:url value='/matricula_listar'/>" class="list-group-item list-group-item-action" id="mati">Matriculas</a> 
          <a href="<c:url value='/pago_listar'/>" class="list-group-item list-group-item-action">Pagos</a>              
        </div>
      </div>
      <div class="col-md-10" style="background: #fff;padding: 20px; min-height: calc(100vh-15px);">
        <h4>Sistema de Gestión de Pagos!</h4>
        <div style="text-align: justify;padding-bottom: 8px;">
          Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quidem culpa eligendi aperiam est commodi doloribus consequuntur placeat maxime dolorem similique adipisci necessitatibus tenetur inventore, rem neque non, ratione dicta labore.
        </div><button type="button" class="btn btn-primary btn-sm">Más informacion</button>
        <hr>
        <div class="row">
          <div class="col-md-3">
            <figure class="figure">
              <img src="<c:url value='/images/autos.jpg' />" class="figure-img img-fluid rounded">
              <div style="padding-bottom: 5px;">
                <figcaption class="figure-caption" style="text-align: justify;">
                  Lorem ipsum dolor sit, amet consectetur adipisicing elit. Ipsam voluptatibus atque veniam sapiente provident. Quasi nisi a, recusandae totam, minima mquam quos aspernatur et asperiores ducimus omnis est.
                </figcaption>
              </div>
              <button type="button" class="btn btn-success btn-sm">Ver más</button>
              <button type="button" class="btn btn-danger btn-sm">Descargar</button>
            </figure>
          </div>
          <div class="col-md-3">
            <figure class="figure">
              <img src="<c:url value='/images/marcas.jpg' />"  class="figure-img img-fluid rounded">
              <div style="padding-bottom: 5px;">
                <figcaption class="figure-caption" style="text-align: justify;">
                  Lorem ipsum dolor sit, amet consectetur adipisicing elit. Ipsam voluptatibus atque veniam sapiente provident. Quasi nisi a, recusandae totam, minima mquam quos aspernatur et asperiores ducimus omnis est.
                </figcaption>
              </div>
              <button type="button" class="btn btn-success btn-sm">Ver más</button>
              <button type="button" class="btn btn-danger btn-sm">Descargar</button>
            </figure>
          </div>
          <div class="col-md-3">
            <figure class="figure">
              <img src="<c:url value='/images/carreras.jpg' />"  class="figure-img img-fluid rounded">
              <div style="padding-bottom: 5px;">
                <figcaption class="figure-caption" style="text-align: justify;">
                  Lorem ipsum dolor sit, amet consectetur adipisicing elit. Ipsam voluptatibus atque veniam sapiente provident. Quasi nisi a, recusandae totam, minima mquam quos aspernatur et asperiores ducimus omnis est.
                </figcaption>
              </div>
              <button type="button" class="btn btn-success btn-sm">Ver más</button>
              <button type="button" class="btn btn-danger btn-sm">Descargar</button>
            </figure>
          </div>
          <div class="col-md-3">
            <figure class="figure">
              <img src="<c:url value='/images/subastas.jpg' />" class="figure-img img-fluid rounded">
              <div style="padding-bottom: 5px;">
                <figcaption class="figure-caption" style="text-align: justify;">
                  Lorem ipsum dolor sit, amet consectetur adipisicing elit. Ipsam voluptatibus atque veniam sapiente provident. Quasi nisi a, recusandae totam, minima mquam quos aspernatur et asperiores ducimus omnis est.
                </figcaption>
              </div>
              <button type="button" class="btn btn-success btn-sm">Ver más</button>
              <button type="button" class="btn btn-danger btn-sm">Descargar</button>
            </figure>
          </div>
        </div>
      </div>
    </div>
  </div>    
                 
        
   <!-- footer -->
  <%@include file="/WEB-INF/views/shared/footer.jsp" %>  
    
    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
    </body>
</html>

  