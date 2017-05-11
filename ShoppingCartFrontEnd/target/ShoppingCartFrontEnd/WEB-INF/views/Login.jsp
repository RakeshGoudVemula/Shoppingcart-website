
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
	 <c:url var="loginUrl" value="/j_spring_security_check" />
		<form  action="${loginUrl}" method="post" >
			<h1>Login</h1>
			  
			<div>
				<input type="text" placeholder="Username" required id="id" name="id" class="form-control" required/>
				
			</div>
			<div>
				<input type="password" placeholder="Password" required id="password" class="form-control" name="password"  required />
			</div>
			<div>
				<input type="submit" value="Let me order" />
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<a href="SignUp.html">Forget Password?</a>
				</div>
				</form>
				</div>
				
</body>
</html>