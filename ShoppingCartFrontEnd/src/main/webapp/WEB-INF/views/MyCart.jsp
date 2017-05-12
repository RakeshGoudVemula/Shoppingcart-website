<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
 
 
</head>
<body>
<body>
	<div class="container">
		<div id="cart">
			<table class="table bordered">
				<thead>
					<tr>
						<td>Product</td>
						<td>Quantity</td>
						<td>Price</td>
						<td>Action</td>
					</tr>
				</thead>
				<c:forEach var="cart" items="${cartList}">
					<tr>
						<td>${cart.product_name}</td>
						<td>${cart.quantity}</td>
						<td>${cart.price}</td>
						<td><a href="myCart/delete/${cart.id}" class="glyphicon glyphicon-trash"></a>
					</tr>
				</c:forEach>
				<tr>
					<td>Total Rs.${totalAmount}</td>
			</table>
		</div>
	</div>
</html>