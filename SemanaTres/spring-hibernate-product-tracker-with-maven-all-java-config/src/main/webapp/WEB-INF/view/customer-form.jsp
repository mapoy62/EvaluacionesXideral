<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Customer</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>RPT - Relación de Productos Tienda</h2>
		</div>
	</div>

	<div id="container">
		<h3>Guardar Producto</h3>
	
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Nombre del Producto:</label></td>
						<td><form:input path="nomProd" /></td>
					</tr>
				
					<tr>
						<td><label>Categoría:</label></td>
						<td><form:input path="categoria" /></td>
					</tr>

					<tr>
						<td><label>Cantidad:</label></td>
						<td><form:input path="cant" /></td>
					</tr>
					
					<tr>
						<td><label>Costo:</label></td>
						<td><form:input path="cant" /></td>
					</tr>
					
					

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/product/list">Regresar a lista de Productos</a>
		</p>
	
	</div>

</body>

</html>










