<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- lo cambia a formulario spring:permite que "producto" llegue al form desde el controlador -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <!--libreria font awesome-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
           
<title>Borrar Año Escolar</title>

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
          <h4>Bootstrap CRUD</h4>        
          <a href="/mil" class="list-group-item list-group-item-action">Ir al Indice</a>
          <a href="/mil/ano_escolar_listar" class="list-group-item list-group-item-action">Listar Años Escolares</a>        
        </div>
      </div>
      <div class="col-md-10" style="background: #fff;padding: 20px;min-height: calc(100vh);">
        <h6>Borrar Año Escolar</h6>
        <div style="padding-top: 10px;">
           <div class="container text-white bg-dark" style="padding:20px 100px ">
           
            
            <form:form name="" method="POST" modelAttribute="ano_escolar">
              <div class="mb-3">
                <label for="exampleFormControlInputID" class="form-label">Año Escolar ID</label>
                <form:input type="text" path="id" class="form-control" id="exampleFormControlInputID" readonly="true" />
              </div>
              <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">Nombre</label>
                <form:input type="text" path="nombre" class="form-control" id="exampleFormControlInput1" readonly="true" />
              </div>
              <p>¿Seguro que quiere borrar?</p>
              <p>No podrás borrar Años Escolares cuyos ID existen en la tabla Grado o Matricula</p><br>

              <div style="text-align: right;">
                <button type="submit" class="btn btn-primary btn-sm"> Borrar</button>
                <button type="button" onclick="location.href='/mil/ano_escolar_listar'" class="btn btn-danger btn-sm">Cancelar</button>
              </div>
            </form:form> 
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