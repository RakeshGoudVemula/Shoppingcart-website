<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Electronics Shoppe Stores</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="Home">Electronics Shoppe Store</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="Home">Home</a></li>
			<c:forEach var="category" items="${categoryList}">
				<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">${category.name}<span
							class="caret"></span>
					</a>
					<ul class="dropdown-menu">
					</ul></li>
			</c:forEach>
			<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">
					Products <span class="caret"></span>
				</a>
				<ul class="dropdown-menu">

					<c:forEach var="product" items="${productList}">
						<li><a href="#">${product.name}</a></li>

					</c:forEach>
				</ul></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<!-- Not signed in -->
			<c:if test="${!isUser=='true' && !isAdmin=='true'}">
				<li><a href="RegistrationPage">
						<span class="glyphicon glyphicon-pencil"></span> Register
					</a></li>
				<li><a href="Login">
						<span class="glyphicon glyphicon-log-in"></span>Login
					</a></li>

			</c:if>
				<!-- Admin  -->
			<c:if test="${isAdmin=='true'}">

				<li><a href="secure_logout">
						<span class="glyphicon glyphicon-pencil"></span> SignOut
					</a></li>			
			</c:if>
			<!-- User -->
			<c:if test="${isUser=='true'}">

				<li><a href="myCart">
						<span class="glyphicon glyphicon-shopping-cart"></span> MyCart
					</a></li>
				<li><a href="secure_logout">
						<span class="glyphicon glyphicon-log-in"></span>Signout
					</a></li>
			</c:if>

		</ul>
	</div>
	</nav>

	<div class="container"></div>


</body>
</html>