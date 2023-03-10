<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Lista Productos</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>RPT - Relación de Productos Tienda</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Agregar producto"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre Producto</th>
					<th>Categoría</th>
					<th>Cantidad</th>
					<th>Costo</th>
					<th>Precio</th>
					<th>Acciones</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempProduct" items="${products}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/product/showFormForUpdate">
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/product/delete">
						<c:param name="productId" value="${tempProduct.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempProduct.nomProd} </td>
						<td> ${tempProduct.categoria} </td>
						<td> ${tempProduct.cant} </td>
						<td>$ ${tempProduct.costo} </td>
						<td>$ ${tempProduct.precio} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('¿Estas seguro de eliminar este producto?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









