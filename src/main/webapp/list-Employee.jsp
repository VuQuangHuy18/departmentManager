<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cat MEO MEO WEB</title>
</head>
<body>
	<div class="">
		<img
			src="https://khoinguonsangtao.vn/wp-content/uploads/2022/08/ve-mong-vuot-va-duoi.png"
			width="150" height="100">
		<h2>Employee Of Department with ID ${idDepartment}</h2>

	</div>





	<div id="content">





		<!-- put new button: Add Student -->

		<input type="button" value="Add a Employee "
			onclick="window.location.href='\add-New-Employee.jsp'; return false;"
			class="add-student-button" />


		<table style="width: 60%; border: solid 1px;">

			<tr>
				<th>ID</th>
				<th>Name</th>


				<th>Action</th>
			</tr>

			<c:forEach var="tempCat" items="${EMPLOYEES}">

				<!-- set up a link for each student -->
				<c:url var="tempLink" value="Controller">
					<c:param name="command" value="LOAD" />
					<c:param name="catId" value="${tempCat.id}" />
					
				</c:url>


				<c:url var="sonLink" value="Controller">
					<c:param name="command" value="SON" />
					<c:param name="catId" value="${tempCat.id}" />
				</c:url>

				<!--  set up a link to delete a student -->
				<c:url var="deleteLink" value="Controller">
					<c:param name="command" value="DELETESON" />
					<c:param name="catId" value="${tempCat.id}" />
				</c:url>
				<tr>
					<td>${tempCat.id}</td>
					<td>${tempCat.name}</td>


					<td><a href="${tempLink}">Update</a> | <a href="${deleteLink}"
						onclick="if (!(confirm('delete ?'))) return false"> Delete</a></td>
				</tr>

			</c:forEach>

		</table>

	</div>


</body>
</html>