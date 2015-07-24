<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Xfinity Calendar</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="../calendar_assets/css/main.css" />
	</head>
    <body>
    
    	<header id="header">

				<!-- Logo -->
					<h1 id="logo" style="font-size:34px;font-weight: 400;">Xfinity Calendar <span style="font-size:18px;"> Planner <c:choose> <c:when test="${param.map != null and param.map == 'yes' }"> <span style="font-size:10px; font-weight:400;"><a style="text-decoration: none;" href="./planner">Hide Map</a></span>  </c:when> <c:otherwise> <span style="font-size:10px; font-weight:400;"><a style="text-decoration: none;" href="./planner?map=yes">Show Map</a></span> </c:otherwise> </c:choose> </span></h1>
					
				<!-- Nav -->
					<nav id="nav">
						<ul>
							<li><a href="./planner" >Planner</a></li>
							<li><a href="./agenda" >Agenda</a></li>
							<li><a href="./teamCalendar" >Team Calendar</a></li>
							<li><a href="./doctorCalendar">Doctor Appointments</a></li>
							<li><a href="./share" >Share Calendar</a></li>
							<li><a href="./search">Search Events</a></li>
							<li><a href="./settings">Settings</a></li>
							<li><a href="../logout">Logout</a></li>
						</ul>
					</nav>

			</header>
    
        <div class="content" id="content">
           <div id="scheduler">${body}</div>
        </div>
        
       
    </body>
</html>