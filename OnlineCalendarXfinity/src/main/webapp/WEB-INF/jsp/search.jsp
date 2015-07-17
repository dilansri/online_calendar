<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Xfinity Online Calendar</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="../assets/css/main.css" />
		<link rel="stylesheet" href="../assets/datepicker/pikaday.css" />
	</head>
	<body id="top">
	
		<section id="four" class="wrapper">
			<header class="inner">
					
			</header>

			<div class="inner">
			<h2>Search Events</h2>
					
					<form name="searchForm" action="" method="post">
							<div class="row uniform">
								<div class="6u 12u$(xsmall)">
									<input type="text" name="startDate" id="startDate" value="${startDateString}" placeholder="From:" />
								</div>
								<div class="6u$ 12u$(xsmall)">
									<input type="text" name="endDate" id="endDate" value="${endDateString}" placeholder="To:" />
								</div>
								<div class="12u$">
									<ul class="actions">
										<li><input type="submit" value="Search" class="special" /></li>
									</ul>
								</div>
							</div>
					</form>
				</div>
		
			<div class="inner">
			<section>
						<div class="table-wrapper">
							<table class="alt">
								<thead>
									<tr>
										<th>Event</th>
										<th>Start Time</th>
										<th>End Time</th>
								</thead>
								<tbody>
									<c:forEach  var="item" items="${result}">
										<tr>
											<td>${item.text}</td>
											<td>${item.start_date}</td>
											<td>${item.end_date}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</section>
			</div>
		</section>
		<!-- Footer -->
			<footer id="footer">
				<p class="copyright">&copy; Group Xfinity. Credits: UCD & NSBM</a></p>
			</footer>

		<!-- Scripts -->
			<script src="../assets/js/jquery.min.js"></script>
			<script src="../assets/js/jquery.scrolly.min.js"></script>
			<script src="../assets/js/skel.min.js"></script>
			<script src="../assets/js/util.js"></script>
			<script src="../assets/js/main.js"></script>
			<script src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.5.1/moment.min.js"></script>
			<script src="../assets/datepicker/pikaday.js"></script>
			
			<script>

		    	var picker = new Pikaday({ field: document.getElementById('startDate'),format:'DD-MM-YYYY' });

		        var picker = new Pikaday({ field: document.getElementById('endDate'),format:'DD-MM-YYYY' });
			</script>

	</body>
</html>