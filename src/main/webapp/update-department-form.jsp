<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<div id="container">
		<h3>Update Department</h3>

		<form action="Controller" method="GET">

			<input type="hidden" name="command" value="UPDATE" /> <input
				type="hidden" name="catId" value="${THE_DEPARTMENT.id}" />

			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><input type="text" name="name"
							value="${THE_DEPARTMENT.name}" /></td>
					</tr>


					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				</tbody>
			</table>
		</form>

		<div style="clear: both;"></div>

		<p>
			<a href="Controller">Back to list</a>
		</p>
	</div>
</body>
</html>