<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>eShopee</title>

</head>
<body>
	<form action="register">
				<div class="row">
						<div class="col-lg-6">
							<div class="well well-sm">
								<strong><span class="glyphicon glyphicon-asterisk"></span>Required
									Field</strong>
							</div>
							<div class="form-group">
								<label for="InputName">Enter Name</label>
								<div class="input-group">
									<input type="text" class="form-control" name="uName"
										id="uName" placeholder="Enter Name" required> <span
										class="input-group-addon"><span
										class="glyphicon glyphicon-asterisk"></span></span>
								</div>
							</div>
							<div class="form-group">
								<label for="InputEmail">Enter UserName</label>
								<div class="input-group">
									<input type="text" class="form-control" id="username"
										name="username" placeholder="Enter username" required>
									<span class="input-group-addon"><span
										class="glyphicon glyphicon-asterisk"></span></span>
								</div>
							</div>
							
							<div class="form-group">
								<label for="InputEmail">Enter Mobile Number</label>
								<div class="input-group">
									<input type="text" class="form-control" id="contact"
										name="contact" placeholder="Enter contact Number" required>
									<span class="input-group-addon"><span
										class="glyphicon glyphicon-asterisk"></span></span>
								</div>
							</div>
							
								<div class="input-group"></div>
								<div class="form-group">
									<label for="InputEmail">Enter Password</label>
									<div class="input-group">
										<input type="password" class="form-control" id="password"
											name="password" placeholder="password" required> <span
											class="input-group-addon"><span
											class="glyphicon glyphicon-asterisk"></span></span>
									</div>
								</div>

							</div>
							<input type="submit" name="submit" id="submit" value="Submit"
								class="btn btn-info pull-right">
						</div>



	</form>
</body>
</html>