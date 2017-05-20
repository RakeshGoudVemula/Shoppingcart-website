<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/MyStyle.css">

<script src="WEB-INF/resources/js/jquery-3.2.0.js"></script>
<script src="WEB-INF/resources/js/bootstrap.js"></script>
<script src="WEB-INF/resources/js/MyStyle.js"></script> -->

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
body {
	background-image: url("resources/images/bg-10-full.jpg");
	background-size: cover;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-top" id="navbar">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="Home" class="navbar-brand">
				<img src="<c:url value="/resources/images/Rolex_Logo.png"/>"
					style="max-height: 50px; margin-top: -15px;" alt="logo" />
			</a>
		</div>
		<div class="collapse navbar-collapse" id="navbar-collapse">
			<ul class="nav navbar-nav navbar-right">
				<!-- User -->
				<c:if test="${isUser=='true'}">
					<li><a href="myCart">
							<i class="fa fa-shopping-cart" aria-hidden="true"></i> My Cart <span class="badge">${cartsize}</span> <span
								class="label label-warning">${cartSize}</span>
						</a></li>
					<li><a href="secure_logout">
							<i class="fa fa-sign-out" aria-hidden="true"></i>Logout
						</a></li>
					<!-- Admin -->
				</c:if>
				<c:if test="${isAdmin=='true'}">
					<li><a href="<c:url value="secure_logout" />">
							<i class="fa fa-sign-out" aria-hidden="true"></i> Logout
						</a></li>

				</c:if>
				<c:if test="${!isUser=='true' && !isAdmin =='true'}">
					<li><a href="RegistrationPage">
							<i class="fa fa-user-plus" aria-hidden="true"></i> Register
						</a></li>
					<li><a href="Login">
							<i class="fa fa-sign-in" aria-hidden="true"></i> Login
						</a></li>
				</c:if>

			</ul>

			<!-- dropdown menu -->

			<ul class="nav navbar-nav">

				<c:forEach var="category" items="${categoryList}">
					<li class="dropdown"><a class="dropdown-toggle" href="#">${category.name}
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<c:forEach var="product" items="${productList}">
								<li><a href="#">${product.name}</a></li>
							</c:forEach>
						</ul></li>
				</c:forEach>
				<li><a href="ContactUs">
						<i class="fa fa-pencil-square-o" aria-hidden="true"></i> Contact
						Us
					</a></li>

			</ul>
		</div>
	</div>
	</nav>
</body>
</html>