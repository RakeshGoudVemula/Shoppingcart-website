<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="<c:url value="resources/css/bootstrap.css"/>">
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="<c:url value="resources/css/MyStyle.css"/>">
<script src="<c:url value="resources/js/jquery-3.2.1.js"/>"></script>
<script src="<c:url value="resources/js/bootstrap.js"/>"></script>
<title>Luxury Watches Store</title>

</head>
<body>
	<hr color="green">
	<jsp:include page="Menu.jsp"></jsp:include>
	${message}
	<c:if test="${isUserClickedCart=='true'}">

		<jsp:include page="MyCart.jsp"></jsp:include>
	</c:if>

	<c:if test="${isUserAtRoot=='true'}">

		<jsp:include page="Carousel.jsp"></jsp:include>

	</c:if>
	<hr>
	<jsp:include page="AllProducts.jsp"></jsp:include>

	<c:if test="${isAdmin=='true'}">
		<jsp:include page="admin/AdminHome.jsp"></jsp:include>
	</c:if>

	<c:if test="${isAdminClickedCategories=='true'}">
		<jsp:include page="admin/Category.jsp"></jsp:include>

	</c:if>

	<c:if test="${isAdminClickedSuppliers=='true' }">
		<jsp:include page="admin/Supplier.jsp"></jsp:include>
	</c:if>

	<c:if test="${isAdminClickedProducts=='true' }">
		<jsp:include page="admin/Product.jsp"></jsp:include>
		<div class="container col-sm-offset-3 col-sm-9" style="color: green">${pMessage}</div>
	</c:if>

	<c:if test="${isUserClickedLogin=='true'}">
		<jsp:include page="Login.jsp"></jsp:include>
	</c:if>
	<c:if test="${isUserClickedRegister=='true'}">
		<jsp:include page="Registration.jsp"></jsp:include>
	</c:if>
	<c:if test="${isUserClickedShoppingCart=='true'}">
		<jsp:include page="Home.jsp"></jsp:include>
	</c:if>
	<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>