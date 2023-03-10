<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Product</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/add-product-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>RPT - Relación de Productos Tienda</h2>
		</div>
	</div>

	<div id="container">
		<h3>Guardar Producto</h3>
	
		<form:form action="saveProduct" modelAttribute="product" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Nombre del Producto:</label></td>
						<td><form:input path="nomProd" /></td>
					</tr>
				
					<tr>
						<td><label for="categoria">Categoría:</label></td>
						<td>
							<form:select path="categoria">  
						        <form:option value="1" label="Lácteos"/>  
						        <form:option value="2" label="Botanas"/>  
						        <form:option value="3" label="Dulcería"/>  
						        <form:option value="4" label="Bebidas"/>  
						     </form:select>  
						</td>
					</tr>

					<tr>
						<td><label>Cantidad:</label></td>
						<td><form:input path="cant" /></td>
					</tr>
					
					<tr>
						<td><label>Costo:</label></td>
						<td><form:input path="costo" /></td>
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










