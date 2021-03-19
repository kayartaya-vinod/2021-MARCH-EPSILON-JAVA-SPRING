<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product list</title>
<link href="https://bootswatch.com/4/united/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="alert alert-primary">

		<div class="container">
			<h1>Spring MVC Demo</h1>
		</div>
	</div>
	<div class="container">
		<p>Product list</p>

		<p>
			<a href="./">Home</a> &middot; <a href="./product-list">All
				products</a> &middot; <a href="./products-by-brand?brand=Malnad">Malnad</a>
			&middot; <a href="./products-by-brand?brand=Fresho">Fresho</a>
			&middot; <a href="./products-by-brand?brand=Zespri">Zespri</a>
		</p>

		<table class="table table-hover">
			<thead>
				<tr>
					<th></th>
					<th>Name</th>
					<th>Quantity per unit</th>
					<th>Brand</th>
					<th>Category</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="p">
					<tr>
						<td><a href="./product-details?id=${p.id}"> <img
								src="${p.picture}" height="60">
						</a> <a class="float-right" href="./delete-product?id=${p.id}">&times;</a>
						</td>
						<td><a href="./product-details?id=${p.id}"> ${p.name} </a></td>
						<td>${p.quantityPerUnit}</td>
						<td><a href="./products-by-brand?brand=${p.brand}">
								${p.brand} </a></td>
						<td><a href="./products-by-category?category=${p.category}">
								${p.category} </a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>