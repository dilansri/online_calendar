
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Calendar Settings</title>

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
<!DOCTYPE HTML>
<html>
<head></head>
<body>
	<h1>Settings</h1>
	<form method="POST">
	REC: <input name="rec_color" type="color" value="${pref.recurringColor}" />
	<input name="rec_text_color" type="color" value="${pref.recurringTextColor}" /> <br>
	
	SUN <input name="sun_color" type="color" value="${pref.sundayColor}" />
	<input name="sun_text_color" type="color" value="${pref.sundayTextColor}" /> <br>
	
	MON <input name="mon_color" type="color" value="${pref.mondayColor}" />
	<input name="mon_text_color" type="color" value="${pref.mondayTextColor}" /> <br>
	
	TUE <input name="tue_color" type="color" value="${pref.tuesdayColor}" />
	<input name="tue_text_color" type="color" value="${pref.tuesdayTextColor}" /> <br>
	
	WED <input name="wed_color" type="color" value="${pref.wednesdayColor}" />
	<input name="wed_text_color" type="color" value="${pref.wednesdayTextColor}" /> <br>
	
	THU <input name="thu_color" type="color" value="${pref.thursdayColor}" />
	<input name="thu_text_color" type="color" value="${pref.thursdayTextColor}" /> <br>
	
	FRI <input name="fri_color" type="color" value="${pref.fridayColor}" />
	<input name="fri_text_color" type="color" value="${pref.fridayTextColor}" /> <br>
	
	SAT <input name="sat_color" type="color" value="${pref.saturdayColor}" />
	<input name="sat_text_color" type="color" value="${pref.saturdayTextColor}" /> <br>
	Skin
	 <select name="skin">
	  <option <c:if test="${pref.skin == 'TERRACE'}"> selected </c:if> value="TERRACE">TERRACE</option>
	  <option <c:if test="${pref.skin == 'CLASSIC'}"> selected </c:if> value="CLASSIC">CLASSIC</option>
	  <option <c:if test="${pref.skin == 'GLOSSY'}"> selected </c:if> value="GLOSSY">GLOSSY</option>
	</select> 
	
	
	<input type="submit" value="submit" />
	</form>
	
	<h2>${success}</h2>
</body>

</html>