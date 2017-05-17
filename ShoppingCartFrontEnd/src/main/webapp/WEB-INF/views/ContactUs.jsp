<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
* {
	box-sizing: border-box;
}

h2 {
	text-align: center;
	margin-bottom: 50px;
	color: #fff;
}

/* form starting stylings ------------------------------- */
.group {
	position: relative;
	margin-bottom: 35px;
}

input {
	font-size: 18px;
	padding: 5px 10px 10px 5px;
	display: block;
	width: 100%;
	border: none;
	border-bottom: 1px solid #fff;
	background: transparent;
}

input:focus {
	outline: none;
}

/* LABEL ======================================= */
label {
	color: #fff;
	font-size: 18px;
	font-weight: normal;
	position: absolute;
	pointer-events: none;
	left: 5px;
	top: 10px;
	transition: 0.2s ease all;
	-moz-transition: 0.2s ease all;
	-webkit-transition: 0.2s ease all;
}

/* active state */
input:focus ~ label, input:valid ~ label {
	top: -20px;
	font-size: 14px;
	color: #fff;
}

/* BOTTOM BARS ================================= */
.bar {
	position: relative;
	display: block;
	width: 100%;
}

.bar:before, .bar:after {
	content: '';
	height: 2px;
	width: 0;
	bottom: 1px;
	position: absolute;
	background: #fff;
	transition: 0.2s ease all;
	-moz-transition: 0.2s ease all;
	-webkit-transition: 0.2s ease all;
}

.bar:before {
	left: 50%;
}

.bar:after {
	right: 50%;
}

/* active state */
input:focus ~ .bar:before, input:focus ~ .bar:after {
	width: 50%;
}

/* HIGHLIGHTER ================================== */
.highlight {
	position: absolute;
	height: 60%;
	width: 100px;
	top: 25%;
	left: 0;
	pointer-events: none;
	opacity: 0.5;
}

/* active state */
input:focus ~ .highlight {
	-webkit-animation: inputHighlighter 0.3s ease;
	-moz-animation: inputHighlighter 0.3s ease;
	animation: inputHighlighter 0.3s ease;
}

/* ANIMATIONS ================ */
@
-webkit-keyframes inputHighlighter {from { background:#fff;
	
}

to {
	width: 0;
	background: transparent;
}

}
@
-moz-keyframes inputHighlighter {from { background:#fff;
	
}

to {
	width: 0;
	background: transparent;
}

}
@
keyframes inputHighlighter {from { background:#fff;
	
}

to {
	width: 0;
	background: transparent;
}

}
#panel {
	border: 1px solid rgb(200, 200, 200);
	box-shadow: rgba(0, 0, 0, 0.1) 0px 5px 5px 2px;
	background: -webkit-linear-gradient(90deg, #2caab3 0%, #2c8cb3 100%);
	background: red; /* For browsers that do not support gradients */
	background: -webkit-linear-gradient(90deg, #2caab3 0%, #2c8cb3 100%);
	/* For Safari 5.1 to 6.0 */
	background: -o-linear-gradient(90deg, #2caab3 0%, #2c8cb3 100%);
	/* For Opera 11.1 to 12.0 */
	background: -moz-linear-gradient(90deg, #2caab3 0%, #2c8cb3 100%);
	/* For Firefox 3.6 to 15 */
	background: linear-gradient(90deg, #2caab3 0%, #2c8cb3 100%);
	/* Standard syntax (must be last) */
	border-radius: 4px;
	top: 50px;
}
</style>
</head>
<body>

	<div class="container">

		<div class="col-lg-offset-4 col-lg-4" id="panel">
			<h2>Get In Touch</h2>

			<form>

				<div class="group">
					<input type="text" required> <span class="highlight"></span>
					<span class="bar"></span> <label>Name</label>
				</div>

				<div class="group">
					<input type="text" required> <span class="highlight"></span>
					<span class="bar"></span> <label>Email</label>
				</div>

				<div class="group">
					<input type="text" required> <span class="highlight"></span>
					<span class="bar"></span> <label>Mobile No</label>
				</div>

				<div class="group">
					<input type="text" required> <span class="highlight"></span>
					<span class="bar"></span> <label>Message</label>
				</div>
				<div class="group">
					<center>
						<a href="Home">
							<button type="submit" class="btn btn-warning">
								Send <span class="glyphicon glyphicon-send"></span>
							</button>
						</a>
					</center>
					
				</div>
			</form>
			
			<div class="col-md-4">
                        <p style="color:#fff;">
                            <strong><i class="fa fa-map-marker"></i> Address</strong><br>
                            1216/Hyderabad, India.
                        </p>
                        <p style="color:#fff;"><strong><i class="fa fa-phone"></i> Phone Number</strong><br>
                           (+91)236976</p>
                        <p style="color:#fff;">
                            <strong><i class="fa fa-envelope"></i>  Email Address</strong><br>
                            chintu.rakesh17@gmail.com</p>
                        <p></p>
                    </div>
		</div>
	</div>

</body>
</html>