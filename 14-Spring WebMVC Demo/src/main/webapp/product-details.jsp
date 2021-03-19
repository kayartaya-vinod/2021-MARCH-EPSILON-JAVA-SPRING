<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product list</title>
<link
	href="https://bootswatch.com/4/united/bootstrap.min.css"
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
		<a href="./">Home</a> &middot;
		<a href="./product-list">All products</a> &middot;
		<a href="./products-by-brand?brand=Malnad">Malnad</a> &middot;
		<a href="./products-by-brand?brand=Fresho">Fresho</a> &middot;
		<a href="./products-by-brand?brand=Zespri">Zespri</a> 
		</p>

		<div class="row">
		
			<div class="col">
				<img src="${p.picture}" class="img img-thumbnail" alt="${p.description}">
			</div>
			
			<div class="col">
				<h3>${p.name}</h3>
				<p>${p.description}</p>
				<p>${p.quantityPerUnit}</p>
				<p>By <a href="./products-by-brand?brand=${p.brand}">${p.brand}</a></p>
				<p>Category: <a href="./products-by-category?category=${p.category}">${p.category}</a></p>
				<p>₹ ${p.unitPrice}/-</p>
				<p>Discount: ${p.discount}%</p>
				
				<a href="./edit-product?id=${p.id}" class="btn btn-primary">Edit</a>
				<a href="./delete-product?id=${p.id}" class="btn btn-link">Delete</a>
				
			</div>
		</div>

	</div>
</body>
</html>






