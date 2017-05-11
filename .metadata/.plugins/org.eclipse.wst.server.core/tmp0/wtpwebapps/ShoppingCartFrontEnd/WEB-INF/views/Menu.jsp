<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>eShopee</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="Home">ShoppingCart</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="Home">Home</a></li>
			<c:forEach var="category" items="${categoryList}">
			<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">${category.name}<span class="caret"></span></a>
															
				<ul class="dropdown-menu">
			</ul>
			</li>
					</c:forEach>
				
			<%-- <li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Products <span class="caret"></span></a>
				<ul class="dropdown-menu">

					<c:forEach var="product" items="${productList}">
						<li><a href="#">${product.name}</a></li>

					</c:forEach>
				</ul></li> --%>
		</ul>
		
		<ul class="nav navbar-nav navbar-right">
			<li><a href="RegistrationPage"><span
					class="glyphicon glyphicon-pencil"></span> Register</a></li>
			<li><a href="LoginPage"><span
					class="glyphicon glyphicon-log-in"></span> Login</a></li>
		</ul>
	</div>
	</nav>

	<div class="container"></div>


</body>
</html>