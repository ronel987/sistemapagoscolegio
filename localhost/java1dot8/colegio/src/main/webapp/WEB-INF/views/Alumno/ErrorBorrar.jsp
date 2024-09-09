<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error </title>
<style type="text/css">
body {
margin:120px;
padding:110px 70px;
} 
div {
margin:35px;
border:2px solid red;
padding:25px;
}
 h2 {
 margin:30px;
 text-align:center; 
 }
 button {
 text-align:center;
 width:260px;
 height:35px;
 background-color:orange;
 }
 </style>
</head>
<body>
<div>
<h2>PAGINA DE ERROR: DUPLICASTE ALGUN DATO</h2>
<h3>¡¡¡NO PUEDE DUPLICAR CELULAR NI DNI DE ALUMNO!!!</h3>

<br><br>
<button type="button" onclick="location.href='/mil/alumno_listar'">Regresar a Listar Alumnos</button>
</div>

</body>
</html>