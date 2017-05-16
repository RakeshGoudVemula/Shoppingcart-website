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
<style type="text/css">
.table {
 color: black;
}

</style>
</head>
<body>
<body>
	<div class="container">
		<div id="cart">
			<table class="table bordered">
				<thead>
					<tr>
						<td>Product</td>
						<td>Price</td>
						<td>Action</td>
					</tr>
				</thead>
				<c:forEach var="cart" items="${cartList}">
					<tr>
						<td>${cart.product_name}</td>
						<td>${cart.price}</td>
						<td><a href="myCart/delete/${cart.id}">
								<button type="button" class="btn btn-danger">
									<span class="glyphicon glyphicon-trash"></span> Delete
								</button>
							</a>
					</tr>
				</c:forEach>
				<tr>
					<td>Total Rs.${totalAmount}</td>
										<td><a href="thankyou" class="btn btn-success">Check Out</a></td>			
					
				<td><a href=></a>
			</table>
		</div>
	</div>
</html>