<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Xfinity Online Calendar - Register</title>

<!-- BEGIN META -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="your,keywords">
<meta name="description" content="Short explanation about this website">
<!-- END META -->

<!-- BEGIN STYLESHEETS -->
<link
	href='http://fonts.googleapis.com/css?family=Roboto:300italic,400italic,300,400,500,700,900'
	rel='stylesheet' type='text/css' />
<link type="text/css" rel="stylesheet"
	href="./resources/css/theme-default/bootstrap.css?1422792965" />
<link type="text/css" rel="stylesheet"
	href="./resources/css/theme-default/materialadmin.css?1425466319" />
<link type="text/css" rel="stylesheet"
	href="./resources/css/theme-default/font-awesome.min.css?1422529194" />
<link type="text/css" rel="stylesheet"
	href="./resources/css/theme-default/material-design-iconic-font.min.css?1421434286" />
<!-- END STYLESHEETS -->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
		<script type="text/javascript" src="./resources/js/libs/utils/html5shiv.js?1403934957"></script>
		<script type="text/javascript" src="./resources/js/libs/utils/respond.min.js?1403934956"></script>
		<![endif]-->
</head>
<body class="menubar-hoverable header-fixed ">

	<!-- BEGIN LOGIN SECTION -->
	<section class="section-account">
		<div class="img-backdrop"
			style="background-image: url('../../assets/img/img16.jpg')"></div>
		<div class="spacer"></div>
		<div class="card contain-sm style-transparent">
			<div class="card-body">
				<div class="row">
					<div class="col-sm-12">
						<br /> <span class="text-lg text-bold text-primary">Xfinity Online Calendar Registration</span> <br />
						<br />
						
						<form class="form floating-label"
							action="./register" method="post">
							
							

						    <c:if test="${error != null}">       
						        <div class="alert alert-callout alert-danger" role="alert">
									<strong>Oh snap!</strong> ${error}
								</div>
						    </c:if>
						    
						    <c:if test="${success != null}">       
						        <div class="alert alert-callout alert-success" role="alert">
									<strong>Congratulations! </strong> ${success} Start using Xfinity Calendar now. <a href="./login" style="color:teal;">Login</a> here.
								</div>
						    </c:if>
						    
							<div class="form-group">
								<input type="text" class="form-control" id="username"
									name="username" value="${param.username}" required <c:if test="${success != null}">disabled</c:if>> <label for="username">Username</label>
							</div>
							<div class="form-group">
								<input type="email" class="form-control" id="email"
									name="email" value="${param.email}" required <c:if test="${success != null}">disabled</c:if> > <label for="email">Email</label>
							</div>
							<div class="form-group">
								<input type="password" class="form-control" id="password" <c:if test="${success != null}">disabled</c:if>
									name="password" required pattern=".{6,}" title="Password must be six or more characters"> <label for="password">Password</label>
							</div>
							<div class="form-group">
								<input type="password" class="form-control" id="confirm_password" <c:if test="${success != null}">disabled</c:if>
									name="confirm_password" required> <label for="confirm_password">Confirm Password</label>
							</div>
							<br />
							<div class="row">
								<div class="col-xs-6 text-left">
									
								</div>
								<!--end .col -->
								<div class="col-xs-6 text-right">
									<button class="btn btn-primary btn-raised" type="submit" <c:if test="${success != null}">disabled</c:if>>Register</button>
								</div>
								<!--end .col -->
							</div>
							<!--end .row -->
						</form>
					</div>
					
				</div>
				<!--end .row -->
			</div>
			<!--end .card-body -->
		</div>
		<!--end .card -->
	</section>
	<!-- END LOGIN SECTION -->
	
	<script>
		var password = document.getElementById("password")
		  , confirm_password = document.getElementById("confirm_password");
	
		function validatePassword(){
		  if(password.value != confirm_password.value) {
		    confirm_password.setCustomValidity("Passwords Don't Match");
		  } else {
		    confirm_password.setCustomValidity('');
		  }
		}
	
		password.onchange = validatePassword;
		confirm_password.onkeyup = validatePassword;
	</script>

	<!-- BEGIN JAVASCRIPT -->
	<script src="./resources/js/libs/jquery/jquery-1.11.2.min.js"></script>
	<script src="./resources/js/libs/jquery/jquery-migrate-1.2.1.min.js"></script>
	<script src="./resources/js/libs/bootstrap/bootstrap.min.js"></script>
	<script src="./resources/js/libs/spin.js/spin.min.js"></script>
	<script src="./resources/js/libs/autosize/jquery.autosize.min.js"></script>
	<script
		src="./resources/js/libs/nanoscroller/jquery.nanoscroller.min.js"></script>
	<script src="./resources/js/core/source/App.js"></script>
	<script src="./resources/js/core/source/AppNavigation.js"></script>
	<script src="./resources/js/core/source/AppOffcanvas.js"></script>
	<script src="./resources/js/core/source/AppCard.js"></script>
	<script src="./resources/js/core/source/AppForm.js"></script>
	<script src="./resources/js/core/source/AppNavSearch.js"></script>
	<script src="./resources/js/core/source/AppVendor.js"></script>
	<script src="./resources/js/core/demo/Demo.js"></script>
	<!-- END JAVASCRIPT -->

</body>
</html>
