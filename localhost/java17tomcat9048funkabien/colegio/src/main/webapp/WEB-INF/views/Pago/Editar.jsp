<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <!--libreria font awesome-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
           
<title>Pagina Editar</title>

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
          <a href="/mil/index" class="list-group-item list-group-item-action">Ir al Indice</a>
          <a href="/mil/pago_listar" class="list-group-item list-group-item-action">Listar Pagos</a>                   
        </div>
      </div>
      <div class="col-md-10" style="background: #fff;padding: 20px;min-height: calc(100vh);">
        <h5>Editar un Nuevo Pago!</h5>
        <div style="padding-top: 10px;">
           <div class="container text-white bg-dark" style="padding:20px 100px ">
            <!--formulario:-->
            <form:form name="" method="POST" modelAttribute="pago">
              <div class="mb-3">
                <label for="exampleFormControlInput0" class="form-label">ID</label>
                <form:input path="id" type="text" class="form-control" readOnly="true" id="exampleFormControlInput0" />
              </div>
              <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">Fecha de Pago</label>
                <form:input path="fecha" type="date" class="form-control" id="exampleFormControlInput1" />
              </div>
              <div class="mb-3">
                <label for="exampleFormControlInput2" class="form-label">Monto a Pagar</label>
                <form:input path="monto" step="any" type="number" class="form-control" id="exampleFormControlInput2" />
              </div>
              <div class="mb-3">
                <label for="exampleFormControlInput3" class="form-label">Estado del Pago</label>
                <form:input path="estado" type="text" class="form-control" id="exampleFormControlInput3" />
              </div>          
              
              <div class="mb-3">
                <label for="exampleFormControlInput4" class="form-label">Calendario ID</label>
                <form:select path="calendario.id" class="form-select" aria-label="Default select example">
				    <form:options items="${bCalenda}" itemValue="id" itemLabel="id" />
				</form:select>                
              </div>
              <div class="mb-3">
                <label for="exampleFormControlInput5" class="form-label">Usuario User</label>
                <form:select path="usuari.id" class="form-select" aria-label="Default select example">
				    <form:options items="${bUsuario}" itemValue="id" itemLabel="user" />
				</form:select>                
              </div>              
              <div class="mb-3">
                <label for="exampleFormControlInput6" class="form-label">Matrícula ID</label>
                <form:select path="matricula.id" class="form-select" aria-label="Default select example">
				    <form:options items="${bMatricula}" itemValue="id" itemLabel="id" />
				</form:select>                
              </div>               
              
              <div style="text-align: right;">
                <button type="submit" class="btn btn-primary btn-sm"> Guardar</button>
                <button type="button" onclick="location.href='<c:url value="/pago_listar"/>'" class="btn btn-danger btn-sm">Cancelar</button>
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

      
   