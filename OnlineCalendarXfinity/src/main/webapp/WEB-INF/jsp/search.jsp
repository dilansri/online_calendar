<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Xfinity Search</title>

		<!-- BEGIN META -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="keywords" content="your,keywords">
		<meta name="description" content="Short explanation about this website">
		<!-- END META -->

		<!-- BEGIN STYLESHEETS -->
		<link href='http://fonts.googleapis.com/css?family=Roboto:300italic,400italic,300,400,500,700,900' rel='stylesheet' type='text/css'/>
		<link type="text/css" rel="stylesheet" href="../resources/css/theme-default/bootstrap.css?1422792965" />
		<link type="text/css" rel="stylesheet" href="../resources/css/theme-default/materialadmin.css?1425466319" />
		<link type="text/css" rel="stylesheet" href="../resources/css/theme-default/font-awesome.min.css?1422529194" />
		<link type="text/css" rel="stylesheet" href="../resources/css/theme-default/material-design-iconic-font.min.css?1421434286" />
		<link type="text/css" rel="stylesheet" href="../resources/css/theme-default/libs/bootstrap-datepicker/datepicker3.css?1424887858" />
		<link rel="stylesheet" href="../calendar_assets/css/main.css" />
		<!-- END STYLESHEETS -->

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script type="text/javascript" src="../resources/js/libs/utils/html5shiv.js?1403934957"></script>
		<script type="text/javascript" src="../resources/js/libs/utils/respond.min.js?1403934956"></script>
		<![endif]-->
	</head>
	<body class="menubar-hoverable header-fixed menubar-pin ">
		<header id="header">

				<!-- Logo -->
					<h1 id="logo">Xfinity Calendar</h1>

				<!-- Nav -->
					<nav id="nav">
						<ul>
							<li><a href="./planner">Planner</a></li>
							<li><a href="./agenda">Agenda</a></li>
							<li><a href="./teamCalendar">Team Calendar</a></li>
							<li><a href="./share">Share Calendar</a></li>
							
							<li><a href="#Logout">Logout</a></li>
						</ul>
					</nav>

		</header>
		<section>
			<div class="container">
			<div class="row">
			<div class="card">
				<div class="card-head style-primary">
					<header>Search Events</header>
				</div>
				<div class="card-body">
					<form method="POST" class="form">
						<div class="form-group">
							<div class="input-daterange input-group" id="demo-date-range">
								<div class="input-group-content">
									<input type="text" class="form-control" name="startDate" required /> <label>Date
										range</label>
								</div>
								<span class="input-group-addon">to</span>
								<div class="input-group-content">
									<input type="text" class="form-control" name="endDate" required />
									<div class="form-control-line"></div>
								</div>
							</div>						
						</div>
						<button type="submit" class="btn ink-reaction btn-lg btn-primary">Find Events</button>
						
						<p>${no_result}</p>
					</form>
						<c:if test="${fn:length(result) gt 0}">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>Start Time</th>
									<th>End Time</th>
									<th>Event</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach  var="item" items="${result}">
								<tr>
									
									<td><fmt:formatDate pattern="E d/M/y h:m a" value="${item.start_date}" /></td>
									<td><fmt:formatDate pattern="E d/M/y h:m a" value="${item.end_date}" /></td>
									<td>${item.text}</td>
									
								</tr>
								</c:forEach>
							</tbody>
						</table>
						</c:if>
	
					</div>
				<!--end .card-body -->
			</div>
			<!--end .card -->
			</div>
			</div>
		</section>

	<!-- BEGIN JAVASCRIPT -->
		<script src="../resources/js/libs/jquery/jquery-1.11.2.min.js"></script>
		<script src="../resources/js/libs/jquery/jquery-migrate-1.2.1.min.js"></script>
		<script src="../resources/js/libs/bootstrap/bootstrap.min.js"></script>
		<script src="../resources/js/libs/spin.js/spin.min.js"></script>
		<script src="../resources/js/libs/autosize/jquery.autosize.min.js"></script>
		<script src="../resources/js/libs/nanoscroller/jquery.nanoscroller.min.js"></script>
		
		<script src="../resources/js/libs/moment/moment.min.js"></script>
		<script src="../resources/js/libs/bootstrap-datepicker/bootstrap-datepicker.js"></script>
		
		<script src="../resources/js/core/source/App.js"></script>
		<script src="../resources/js/core/source/AppNavigation.js"></script>
		<script src="../resources/js/core/source/AppOffcanvas.js"></script>
		<script src="../resources/js/core/source/AppCard.js"></script>
		<script src="../resources/js/core/source/AppForm.js"></script>
		<script src="../resources/js/core/source/AppNavSearch.js"></script>
		<script src="../resources/js/core/source/AppVendor.js"></script>
		<script src="../resources/js/core/demo/Demo.js"></script>
		<script src="../resources/js/core/demo/DemoFormComponents.js"></script>
		<!-- END JAVASCRIPT -->
	</body>
</html>
