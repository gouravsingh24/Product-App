<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="./common.jsp"%>

</head>
<body>
	<div class="container-fluid mt-3">
		<div class="row">
			<div class="col-md-12">
				<h2 class="text-center">Welcome to Product App</h2>

				<table class="table mt-3">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Product</th>
							<th scope="col">Description</th>
							<th scope="col">Price</th>
							<th scope="col">Date</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products }" var="x">
							<tr>
								<th scope="row">${x.id }</th>
								<td>${x.name }</td>
								<td>${x.description }</td>
								<td class = "font-weight-bold">&#x20B9; ${x.price }</td>
								<td>${x.date }</td>
								<td>
									<a href = "deleteProduct/${x.id }"><i class="fa-solid fa-trash-can text-danger" style = "font-size : 25px;"></i></a>
									<a href = "updateProduct/${x.id }"><i class="fa-solid fa-pen-to-square text-primary" style = "font-size : 25px;"></i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class = "container text-center mt-4">
					<a href = "addProduct" class = "btn btn-outline-primary">Add Product</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>