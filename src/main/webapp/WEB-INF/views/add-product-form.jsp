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
	<div class="container mt-5">
			<div class="row">
				<div class="col-md-6 offset-md-3">
					<h2 class = "text-center">Add Product</h2>
					<form action = "handleProduct" method="post">
						<div class = "form-group">
							<label>Product Name</label>
							<input type = "text" class = "form-control" name = "name" required>
						</div>
						<div class = "form-group">
							<label>Product Description</label>
							<textarea class = "form-control" rows = "5" name = "description" required></textarea>
						</div>
						<div class = "form-group">
							<label>Product Price</label>
							<input type = "text" class = "form-control" rows = "5" name = "price" required>
						</div>
						<div class = "text-center">
							<a href = '${pageContext.request.contextPath }/' class = "btn btn-outline-warning">Back</a>
							<button class = "btn btn-outline-success">Submit</button>
							<button type = "reset" class = "btn btn-outline-primary">Reset</button>
						</div>
					</form>
				</div>
			</div>
	</div>
</body>
</html>