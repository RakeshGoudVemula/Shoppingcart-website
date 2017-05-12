
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

	<div class="container">
		<c:url var="action" value="/j_spring_security_check"/>
		<form class="form-horizontal" action="${action}" method="post">
			<div class="form-group">
				<label for="Username">Username:</label> <input type="text"
					class="form-control" name="id" id="id" placeholder="Enter Username"
					required />
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" name="password" id="password" placeholder="Enter password"
					required>
			</div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			
			<button type="submit" class="btn btn-success">Submit</button>
		</form>
	</div>
	</form>
</body>
</html>