<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>eShopee</title>

</head>
<body>
	<form action="">

		<div class="container">
			<!-- Registration form - START -->
			<div class="container">
				<div class="row">
					<form role="form">
						<div class="col-lg-6">
							<div class="well well-sm">
								<strong><span class="glyphicon glyphicon-asterisk"></span>Required
									Field</strong>
							</div>
							<div class="form-group">
								<label for="InputName">Enter Name</label>
								<div class="input-group">
									<input type="text" class="form-control" name="InputName"
										id="InputName" placeholder="Enter Name" required> <span
										class="input-group-addon"><span
										class="glyphicon glyphicon-asterisk"></span></span>
								</div>
							</div>
							<div class="form-group">
								<label for="InputEmail">Enter Email</label>
								<div class="input-group">
									<input type="email" class="form-control" id="InputEmailFirst"
										name="InputEmail" placeholder="Enter Email" required>
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

				</div>
			</div>
		</div>
		</div>
		<!-- Registration form - END -->

		</div>

	</form>
</body>
</html>