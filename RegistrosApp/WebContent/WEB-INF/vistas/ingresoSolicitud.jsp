<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../templates/header.jsp"></jsp:include>
<main class="container mt-6">
	<c:if test="${mensaje != null}">
		<div class="columns is-centered mb-6">
			<div class="column is-6">
				<div class="notification is-info">
					<p>${mensaje}</p>
				</div>
			</div>
		</div>
	</c:if>

	<c:if test="${errores != null }">
		<div class="columns is-centered mb-6">
			<div class="column is-6">
				<div class="notification is-warning">
					<h6>complete los campos del formulario</h6>
					<div class="content">
						<ul>
							<c:forEach var="error" items="${errores}">
								<li>${error}</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<div class="columns is-centered">
		<div class="column is-6">
			<form method="POST" action="IngresarSolicitudController.do">
				<div class="card">
					<div class="card-header has-background-primary">
						<span class="card-header-title">Ingrese Datos</span>
					</div>
					<div class="card-content">
						<div class="field">
							<label class="label" for="rut-txt">RUT Cliente</label>
							<div class="control">
								<input type="text" class="input" is="rut-txt" name="rut-txt"
									placeholder="xxxxxxxx-x" />
							</div>
						</div>
						<div class="field">
							<label class="label" for="nombre-txt">Nombre</label>
							<div class="control">
								<input type="text" class="input" is="nombre-txt"
									name="nombre-txt" placeholder="Nombre y Apellido" />
							</div>
						</div>
						<div class="field">
							<label class="label" for="tipo-select">Tipo de solicitud</label>
							<div class="control">
								<div class="select">
									<select name="tipo-select" id="tipo-select">
										<option>Solicitud de Cédula de Identidad</option>
										<option>Retiro de Cédula de Identidad</option>
										<option>Solicitud de Certificado de Nacimiento</option>
										<option>Solicitud de Certificado de Defunción</option>
									</select>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
			<div class="card">
				<form method="GET" action="Redirecionamiento.do">
					<div class="card-content has-text-centered">
						<div class="card-footer-item">
							<button type="submit" name="ingresar" class="button has-background-primary">Ingresar</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</main>
</body>
</html>