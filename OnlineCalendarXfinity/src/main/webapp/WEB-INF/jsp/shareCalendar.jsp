<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Share My Calendar</title>

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
		<!-- END STYLESHEETS -->

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script type="text/javascript" src="../resources/js/libs/utils/html5shiv.js?1403934957"></script>
		<script type="text/javascript" src="../resources/js/libs/utils/respond.min.js?1403934956"></script>
		<![endif]-->
	</head>
	<body class="menubar-hoverable header-fixed ">


		<!-- BEGIN BASE-->
		<div id="base">

			<!-- BEGIN OFFCANVAS LEFT -->
			<div class="offcanvas">
			</div><!--end .offcanvas-->
			<!-- END OFFCANVAS LEFT -->

			<!-- BEGIN CONTENT-->
			<div id="content">
				<section>
					<div class="section-body contain-lg">
						<!-- BEGIN INTRO -->
						<div class="row">
							<div class="col-lg-12">
								<h1 class="text-primary">Share My Calendar</h1>
							</div><!--end .col -->
						</div><!--end .row -->
						<!-- END INTRO -->
						<hr />
						<div class="col-md-8 col-md-offset-2"></div>
						<c:if test="${error != null}">       
						        <div class="alert alert-callout alert-danger" role="alert">
									<strong>Oh snap!</strong> ${error}
								</div>
						    </c:if>
						    
						    <c:if test="${success != null}">       
						        <div class="alert alert-callout alert-success" role="alert">
									<strong>Success!</strong>${success}
								</div>
						</c:if>
						</div>
						
						<!-- BEGIN DEFAULT TABLE -->
						<form class="form floating-label" action="./share" accept-charset="utf-8" method="post">
							<div class="col-lg-12">
								<h2 class="text-primary"></h2>
							</div><!--end .col -->
							<div class="col-lg-offset-1 col-md-8">
									<div class="card">
										<div class="card-body">
											<div class="form-group">
												<div class="input-group">
													<div class="input-group-content">
														<input name="shared_with" type="text" class="form-control" id="groupbutton9">
														<label for="groupbutton9">Enter username to share</label>
													</div>
													<div class="input-group-btn">
														<button class="btn btn-primary btn-raised" type="submit">Share</button>
													</div>
												</div>
											</div>
										</div><!--end .card-body -->
									</div><!--end .card -->
							</div><!--end .col -->
						</form>
						<hr />
						<div class="col-md-6">
						
							<h3 class="text-primary">Calendars Shared With Me</h3>
							<div class="card">
								<div class="card-body">
									<div class="form-group">
										<ul class="list divider-full-bleed">
											<c:forEach var="item" items="${sharedWithMeUsers}">
										    	
										    	<li class="tile">
													<a class="tile-content ink-reaction" href="./viewCalendar?user=${item}">
														<div class="tile-text">${item}</div>
													</a>
													<a class="btn btn-flat ink-reaction"  href="#">
														<i class="fa fa-calendar"></i>
													</a>
												</li>
										    </c:forEach>
											
											
										</ul>
									</div>
								</div><!--end .card-body -->
							</div><!--end .card -->	
						</div><!--end .col -->
						
						
						<div class="col-md-6">
							<h3 class="text-primary">Calendars Shared By Me</h3>

							<div class="card">
								<div class="card-body">
									<div class="form-group">
										<ul class="list divider-full-bleed">
											<c:forEach var="item" items="${sharedByMeUsers}">
										    	
										    	<li class="tile">
													<a class="tile-content ink-reaction">
														<div class="tile-text">${item}</div>
													</a>
													<a class="btn btn-flat ink-reaction"  href="#">
														<i class="fa fa-trash"></i>
													</a>
												</li>
										    </c:forEach>
											
										</ul>
									</div>
								</div><!--end .card-body -->
							</div><!--end .card -->	
						</div><!--end .col -->
						<div class="col-lg-offset-1 col-md-8">
														
						</div><!--end .col -->
						
					</div><!--end .row -->
				</section><!--end .section-body -->
			</div>
		</div><!--end #base-->
		<!-- END BASE -->

		<!-- BEGIN JAVASCRIPT -->
		<script src="../resources/js/libs/jquery/jquery-1.11.2.min.js"></script>
		<script src="../resources/js/libs/jquery/jquery-migrate-1.2.1.min.js"></script>
		<script src="../resources/js/libs/bootstrap/bootstrap.min.js"></script>
		<script src="../resources/js/libs/spin.js/spin.min.js"></script>
		<script src="../resources/js/libs/autosize/jquery.autosize.min.js"></script>
		<script src="../resources/js/libs/nanoscroller/jquery.nanoscroller.min.js"></script>
		<script src="../resources/js/core/source/App.js"></script>
		<script src="../resources/js/core/source/AppNavigation.js"></script>
		<script src="../resources/js/core/source/AppOffcanvas.js"></script>
		<script src="../resources/js/core/source/AppCard.js"></script>
		<script src="../resources/js/core/source/AppForm.js"></script>
		<script src="../resources/js/core/source/AppNavSearch.js"></script>
		<script src="../resources/js/core/source/AppVendor.js"></script>
		<script src="../resources/js/core/demo/Demo.js"></script>
		<!-- END JAVASCRIPT -->

	</body>
</html>

