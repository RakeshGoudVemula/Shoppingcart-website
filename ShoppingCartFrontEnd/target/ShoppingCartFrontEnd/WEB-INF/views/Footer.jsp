<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">

<style type="text/css">
html {
	position: absolute;
	min-height: 100%;
}

body {
	margin-bottom: 150px;
}

.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 100px;
	background-color: #111;
	text-align: center;
}

.container {
	margin-top: 50px;
	color: #fff;
	width: 100%;
}

.fa-twitter {
	color: #4099FF;
}

.fa-facebook {
	color: #3B5998;
}

.fa-linkedin {
	color: #007bb6;
}

.fa {
	opacity: 0.7;
	transition: 1s;
	-webkit-transition: 1s;
}

.fa:hover {
	opacity: 1;
	transition: 1s;
	-webkit-transition: 1s;
}

.social:hover {
	-webkit-transform: scale(1.1);
	-moz-transform: scale(1.1);
	-o-transform: scale(1.1);
}

.social {
	-webkit-transform: scale(0.8);
	/* Browser Variations: */
	-moz-transform: scale(0.8);
	-o-transform: scale(0.8);
	-webkit-transition-duration: 0.5s;
	-moz-transition-duration: 0.5s;
	-o-transition-duration: 0.5s;
}

#social-fb:hover {
	color: #3B5998;
}

#social-tw:hover {
	color: #4099FF;
}

#social-gp:hover {
	color: #d34836;
}
</style>
</head>

<body>

	<div class="footer">
		<div class="container">

			<a href='https://www.facebook.com/'>
				<i id="social-fb" class="fa fa-facebook fa-3x fa-fw social"></i>
			</a>
			<a href='https://twitter.com/'>
				<i id="social-tw" class="fa fa-twitter fa-3x fa-fw social"></i>
			</a>

			<a href='https://www.linkedin.com/in/rakesh-chintu-14046a8b/'>
				<i id="social-li" class="fa fa-linkedin fa-3x fa-fw social"></i>
			</a>

			<a href="https://plus.google.com/">
				<i id="social-gp" class="fa fa-google-plus-square fa-3x social"></i>

			</a>

		</div>
	</div>


</body>
</html>