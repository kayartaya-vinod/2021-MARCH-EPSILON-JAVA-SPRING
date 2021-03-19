<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
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
				<sf:form modelAttribute="p" action="./update-product">
					<sf:hidden path="id"/>
					<sf:hidden path="picture"/>
					
					<div class="form-group">
						<label>Name: 
						<sf:input path="name" cssClass="form-control"/>
						</label>
					</div>
					<div class="form-group">
						<label>Description: 
						<sf:input path="description" cssClass="form-control"/>
						</label>
					</div>
					<div class="form-group">
						<label>Quantity per unit: 
						<sf:input path="quantityPerUnit" cssClass="form-control"/>
						</label>
					</div>
					<div class="form-group">
						<label>Brand: 
						<sf:input path="brand" cssClass="form-control"/>
						</label>
					</div>
					<div class="form-group">
						<label>Category: 
						<sf:input path="category" cssClass="form-control"/>
						</label>
					</div>
					<div class="form-group">
						<label>Unit price: 
						<sf:input path="unitPrice" cssClass="form-control"/>
						</label>
					</div>
					<div class="form-group">
						<label>Discount: 
						<sf:input path="discount" cssClass="form-control"/>
						</label>
					</div>
					
					<button class="btn btn-primary">Submit</button>
					<a class="btn btn-link" href="./product-details?id=${p.id}">Cancel</a>
					
				</sf:form>
				
			</div>
		</div>

	</div>
</body>
</html>