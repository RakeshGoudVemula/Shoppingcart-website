<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<%-- 		<table>
			<c:forEach var="product" items="${productList }">
				<tr>
					<td><img alt="${product.name}"
						src="<c:url value= "resources/img/${product.id}.jpg"/>"></td>
					<td><a href="mycart/add/${product.id}">Add to Cart</a>
				</tr>
		</table> --%>
		<c:forEach var="product" items="${productList}">
			<div class="col-sm-3">
				<article class="col-item">
				<div class="photo">
					<div class="options-cart-round">
						<a href="mycart/add/${product.id}" class="btn btn-info"
							title="Add to cart">
							<span class="fa fa-shopping-cart"></span>
						</a>
					</div>
					<a href="">
						<img src="<c:url value= "resources/img/${product.id}.jpg"/>"
							class="img-responsive" alt="${product.id}" />
					</a>
					<%-- <a href="<spring:url value="/manage-product-get/${product.Id}"/>"
                                   data-toggle="tooltip" title="Click to get Product Details">
                                <span class="glyphicon glyphicon-info-sign"/></a> --%>
				</div>
				<div class="info">
					<div class="row">
						<div class="price-details col-md-6">
							<p class="details">${product.description}</p>
							<h1>${product.name}</h1>
							<span class="price-new"><i class="fa fa-inr"
								aria-hidden="true">${product.price}</i></span>
						</div>
					</div>
				</div>
				</article>
				<p class="text-center">${product.name}</p>
			</div>
		</c:forEach>
	</div>
</body>
</html>