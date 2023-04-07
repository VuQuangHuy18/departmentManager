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
		<h2>Cat Manage</h2>
	</div>





	<div id="content">


		<select name="loai">
			<option></option>
			<option>Anh lông ngắn</option>
			<option>Anh lông dài</option>
			<option>Anh lông đen</option>

		</select> <input type="button" value="Search"> <br> <br>


		<!-- put new button: Add Student -->

		<input type="button" value="Add a department"
			onclick="window.location.href='\add-New-Department.jsp'; return false;"
			class="add-student-button" />


		<table style="width: 60%; border: solid 1px;">

			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Employee Quatity</th>

				<th>Action</th>
			</tr>

			<c:forEach var="tempCat" items="${DEPARTMENTS}">

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
					<c:param name="command" value="DELETE" />
					<c:param name="catId" value="${tempCat.id}" />
				</c:url>
				<tr>
					<td>${tempCat.id}</td>
					<td>${tempCat.name}</td>
					<td>${tempCat.employees.size()}</td>

					<td><a href="${tempLink}">Update</a> | <a href="${deleteLink}"
						onclick="if (!(confirm('delete ?'))) return false"> Delete</a> | <a
						href="${sonLink}">View Detail</a></td>
				</tr>

			</c:forEach>

		</table>

	</div>


</body>
</html>