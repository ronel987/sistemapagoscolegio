<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <!--libreria font awesome-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
           
<title>Pagina Pagos Listar</title>

</head>
<body style="background: #f1f1f1;margin: 15px 30px;">
<!-- header -->  
    <%@include file="/WEB-INF/views/shared/header.jsp" %>    
<!-- barnav -->
    <%@include file="/WEB-INF/views/shared/navbar.jsp" %>
<!-- main -->
<div class="container">
    <div class="row" style="padding: 15px;">
      <div class="col-md-2" style="padding-right:10px;">
        <div class="list-group">  
          <h5>Lista de Pagos</h5>        
          <a href="/mil" class="list-group-item list-group-item-action">Ir al Indice</a>
          <a href="/mil/pago_registrar" class="list-group-item list-group-item-action">Registrar Nuevo Pago</a>                  
        </div>     
        
      </div>
      <div class="col-md-10" style="background: #fff;padding: 10px; min-height: calc(100vh);">
        <div style="padding-top: 10px;">
        <!--tabla listar-->
          <table class="table table-striped table-hover">
            <thead>
              <tr>
                <th scope="col" style="padding-left: 10px;">ID</th>
                <th scope="col">Fecha</th>
                <th scope="col">Monto</th>
                <th scope="col">Estado</th>
                <th scope="col">Calendario Id</th>
                <th scope="col">Usuario Id</th>
                <th scope="col">Matricula Id</th>                
                <th scope="col" style="text-align:center">Acciones</th>
              </tr>
            </thead>
            <tbody>
               <c:forEach var="pago" items="${baraja}">
                   <tr>
		                <th scope="row" style="padding-left: 10px;">${pago.id}</th>
		                <td>${pago.fecha}</td>
		                <td>${pago.monto}</td>
		                <td>${pago.estado}</td>
		                <td>${pago.calendario.id}</td>
		                <td>${pago.usuari.id} </td>
		                <td>${pago.matricula.id}</td>		                
		                <td>
		                  <a href="/mil/pago_editar/${pago.id}" role="button" class="btn btn-success btn-sm">Editar</a>
			              <a href="/mil/pago_borrar/${pago.id}" role="button" class="btn btn-danger btn-sm">Borrar</a>
			              <a href="/mil/pago_cp/${pago.id}" role="button" class="btn btn-info btn-sm">Ver C/P</a>     			               		                
		                </td>		                
		           </tr>              
               </c:forEach>      
                           
            </tbody>
          </table>
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