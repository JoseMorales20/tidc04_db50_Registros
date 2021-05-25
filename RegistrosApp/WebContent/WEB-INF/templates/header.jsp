<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<link href="vendor/bulma/css/bulma.min.css" rel="stylesheet">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<header>
		<nav class="navbar has-background-primary" role="navigation"
			aria-label="main navigation">
			<div class="navbar-brand">
				<a class="navbar-item" href="infex.jsp"> <img src="img/logo.jpg"></a>
				<a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample"> 
				<span aria-hidden="true"></span> 
				<span aria-hidden="true"></span> 
				<span aria-hidden="true"></span>
				</a>
			</div>
			<div id="navbarBasicExample" class="navbar-menu">
				<div class="navbar-start">
					<a class="navbar-item"> Home </a>

					<div class="navbar-item has-dropdown is-hoverable">
						<a class="navbar-link" href=""> Solicitud </a>

						<div class="navbar-dropdown">
							<a class="navbar-item" href="IngresarSolicitudController.do">ingresar </a> 
								

						</div>
					</div>
					<div class="navbar-item has-dropdown is-hoverable">
						<a class="navbar-link" href="">atenciones</a>
						<div class="navbar-dropdown">
							<a class="navbar-item" href="AtenderSolicitudController.do">atender</a>
						</div>
					</div>
				</div>
			</div>
		</nav>
	</header>