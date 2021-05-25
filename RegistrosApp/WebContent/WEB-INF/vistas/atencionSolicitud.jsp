<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../templates/header.jsp"></jsp:include>
<main class="continer mt-6">
	<div class="columns is-centered">
		<div class="column is-8">
			<table class="table is-hovered is-bordered is-fullwidth">
				<thead class="has-background-primary">
					<tr>
						<th>Nro Atencion</th>
						<th>Nombre del cliente</th>
						<th>Tipo de solicitud</th>
						<th>Decision</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="solicitud" items="${solicitudes}">
						<tr>
							<td></td>
							<td>${solicitud.nombre}</td>
							<td>${solicitud.tipo}</td>
							<td><a
								href="AtenderSolicitudController.do?atenderCliente=${solicitud.nombre}"
								class="has-text-primary">Atender</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</main>
</body>
</html>