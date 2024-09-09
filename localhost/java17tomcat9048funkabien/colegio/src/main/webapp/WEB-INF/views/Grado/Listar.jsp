<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
           
<title>Pagina Grado Listar</title>

</head>
<body style="background: #f1f1f1;margin: 15px 30px;">
 
    <%@include file="/WEB-INF/views/shared/header.jsp" %>    

    <%@include file="/WEB-INF/views/shared/navbar.jsp" %>

<div class="container">
    <div class="row" style="padding: 15px;">
      <div class="col-md-2" style="padding-right:10px;">
        <div class="list-group">  
          <h5>Lista de Grados</h5>        
          <a href="/mil" class="list-group-item list-group-item-action">Ir al Indice</a>
          <a href="/mil/grado_registrar" class="list-group-item list-group-item-action">Registrar Nuevo Grado</a>                  
        </div>     
        
      </div>
      <div class="col-md-10" style="background: #fff;padding: 10px; min-height: calc(100vh);">
        <div style="padding-top: 10px;">
       
          <table class="table table-striped table-hover">
            <thead>
              <tr>
                <th scope="col" style="padding-left: 10px;">ID</th>
                <th scope="col">Nombre</th>
                <th scope="col">Estado</th>
                <th scope="col">Año Escolar Id</th>                                      
                <th scope="col" style="text-align:center">Acciones</th>
              </tr>
            </thead>
            <tbody>
               <c:forEach var="gra" items="${bGrado}">
                   <tr>
		                <th scope="row" style="padding-left: 10px;">${gra.id}</th>
		                <td>${gra.nombre}</td>
		                <td>${gra.estado}</td>
		                <td>${gra.ano_escolar.id}</td>		                	                	                
		                <td>
		                  <a href="/mil/grado_editar/${gra.id}" role="button" class="btn btn-success btn-sm">Editar</a>
			              <a href="/mil/grado_borrar/${gra.id}" role="button" class="btn btn-danger btn-sm">Borrar</a>			              			               		                
		                </td>		                
		           </tr>              
               </c:forEach>      
                           
            </tbody>
          </table>
        </div>               
        
      </div>
    </div>
  </div>

  <%@include file="/WEB-INF/views/shared/footer.jsp" %>  
    
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>