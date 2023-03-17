<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Shopping Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Agregar Usuario"
				   onclick="window.location.href='showFormForAddUser'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Correo</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our users -->
				<c:forEach var="tempUsuario" items="${usuarios}">
				
					<!-- construct a "compras" link with user id -->
					<c:url var="compraLink" value="/compras/list-compras">
						<c:param name="usuarioId" value="${tempUsuario.id}" />
					</c:url>

					<!-- construct an "update" link with user id -->
					<c:url var="updateLink" value="/usuario/showFormForUpdateUser">
						<c:param name="usuarioId" value="${tempUsuario.id}" />
					</c:url>					

					<!-- construct an "delete" link with user id -->
					<c:url var="deleteLink" value="/usuario/deleteUser">
						<c:param name="usuarioId" value="${tempUsuario.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempUsuario.nombre} </td>
						<td> ${tempUsuario.apellido} </td>
						<td> ${tempUsuario.correo} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${compraLink}">Compras</a>
							|
							<a href="${updateLink}">Actualizar</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this user?'))) return false">Eliminar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









