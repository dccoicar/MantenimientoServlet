<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>title Applying</title>
</head>
<body>
	
	<h2>Aqui se construira una aplicación de JSP con SERVLET</h2>

	<!-- "?parametro=sesion" -->
	<form id="someForm" action="servlet2D?action=register" method="post">


		<table>

			<tr>
				<td>Id:</td>
				<td><input type="text" name="id" placeholder=" Digite id" readonly/></td>
			</tr>

			<tr>
				<td>Nombres:</td>
				<td><input type="text" name="nombres" placeholder="Digite nombres" /></td>
			</tr>

			<tr>
				<td>Apellidos:</td>
				<td><input type="text" name="apellidos"	placeholder="Digite apellidos" /></td>
			</tr>

			<tr>
				<td>Dirección:</td>
				<td><input type="text" name="direccion"	placeholder="Digite dirección" /></td>
			</tr>

			<tr>
				<td>Paises:</td>
				<td><select name="paises">
						<option value="Mexico">México</option>
						<option value="Argentina">Argentina</option>
						<option value="Brazil">Brazil</option>
						<option value="Peru">Perú</option>
						<option value="Colombia">Colombia</option>
				</select></td>
			</tr>

			<tr>
				<td colspan="2" style="float: right;"><input type="submit"value="enviar" /></td>
			</tr>

		</table>

	</form>
	<!-- End Form -->




</body>
</html>