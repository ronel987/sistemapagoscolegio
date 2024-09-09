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
           
<title>Pagina Comprobante de Pago</title>

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
          <h5>Detalle de Pago</h5>        
          <a href="/mil" class="list-group-item list-group-item-action">Ir al Indice</a>   
          <a href="/mil/pago_listar" class="list-group-item list-group-item-action">Listar Pagos</a>                        
        </div>     
        
      </div>
      <div class="col-md-10" style="background: #fff;padding: 10px; min-height: calc(100vh);">
        <div style="padding-top: 10px;">
           <h4 style="text-align:center;font:bold;font-size:18;color:blue;">Comprobante de Pago</h4>
           <div style="text-align: right;">                
                <button type="button" target="_blank" onclick="location.href='<c:url value="/pago_cp/${aidi}/?format=pdf/"/>'" class="btn btn-success btn-sm">Imprimir</button>
           </div>
           
        <!--tabla datos del Comprobante de Pago-->
          <table class="table table-striped table-hover">
          <caption>Colegio Mil Maravillas</caption>
            <thead>
              <tr>
                <th scope="col" style="padding-left: 10px;">Código de Pago</th>
                <th scope="col">Fecha de Pago</th>
                <th scope="col">Monto Pagado</th>
                <th scope="col">Estado</th>               
              </tr>
            </thead>
            <tbody>               
                   <tr class="table-info">
		                <th scope="row" style="padding-left: 10px;">${pago.id}</th>
		                <td>${pago.fecha}</td>
		                <td>${pago.monto}</td>
		                <td>${pago.estado}</td>		                	                
		           </tr>              
                   <tr>
		                <th>Concepto</th>
		                <td>Mes</td>
		                <td>Fecha Límite</td>
		                <td>Programado</td>		                	                
		           </tr>        
		           <tr>
		                <th scope="row" style="padding-left: 10px;">${pago.calendario.concepto}</th>
		                <td>${pago.calendario.mes}</td>
		                <td>${pago.calendario.flimite}</td>
		                <td>${pago.calendario.monto}</td>		                	                
		           </tr>     
		           <tr>
		                <th scope="row" style="font:bold;">Alumno</th>
		                <td>Apellidos</td>
		                <td colspan="2">Dni</td>		                		                	                
		           </tr>        
		           <tr>
		                <th style="font:normal;">${pago.matricula.alumno.nombres}</th>
		                <td>${pago.matricula.alumno.apellidos}</td>
		                <td colspan="2">${pago.matricula.alumno.dni}</td>		                		                	               
		           </tr>     
		           <tr>
		                <th scope="row" >Apoderado</th>
		                <td>Apellidos</td>
		                <td colspan="2">Dni</td>
		                		                	                
		           </tr>        
		           <tr>
		                <th style="font:normal;">${pago.matricula.alumno.apoderado.nombres}</th>
		                <td>${pago.matricula.alumno.apoderado.apellidos}</td>
		                <td colspan="2">${pago.matricula.alumno.apoderado.dni}</td>
		                		                	               
		           </tr>  
		           <tr>
		                <th scope="row">Cajero</th>
		                <td>Apellidos</td>
		                <td colspan="2">Usuario</td>
		                		                	                
		           </tr>        
		           <tr>
		                <th style="font:normal;">${pago.usuari.nombre}</th>
		                <td>${pago.usuari.apellidos}</td>
		                <td colspan="2">${pago.usuari.user}</td>
		                	                	               
		           </tr>                                        
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