
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Xfinity Calendar - Settings</title>

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
		<link type="text/css" rel="stylesheet" href="../resources/css/theme-default/libs/bootstrap-colorpicker/bootstrap-colorpicker.css?1424887860" />
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
							<div class="col-sm-12">
								<h1 class="text-primary">User Settings</h1>
							</div><!--end .col -->
						</div><!--end .row -->
						<!-- END INTRO -->
						<hr />
						<!-- BEGIN DEFAULT TABLE -->
						
						
						<div class="row">
						<form class="form floating-label" action="#" accept-charset="utf-8" method="post">
							<div class="col-sm-8 col-sm-offset-2">
								<c:if test="${success != null}">       
							        <div class="alert alert-callout alert-success" role="alert">
										<strong> ${success} </strong>
									</div>
							    </c:if>
							</div>
							<div class="col-sm-11 col-sm-offset-1">
								<h2 class="text-primary">Skin</h2>
							</div><!--end .col -->
							<div class="col-sm-offset-1 col-sm-8">
								<div class="card">
									<div class="card-body">
										<div class="form-group">
											<select name="skin" class="form-control">
											  <option <c:if test="${pref.skin == 'TERRACE'}"> selected </c:if> value="TERRACE">TERRACE</option>
											  <option <c:if test="${pref.skin == 'CLASSIC'}"> selected </c:if> value="CLASSIC">CLASSIC</option>
											  <option <c:if test="${pref.skin == 'GLOSSY'}"> selected </c:if> value="GLOSSY">GLOSSY</option>
											</select>
											<label for="select1">Select skin</label>
										</div>
									</div><!--end .card-body -->
								</div><!--end .card -->
								
								
								
							</div><!--end .col -->
							<div class="col-sm-11 col-sm-offset-1">
								<h2 class="text-primary">Event Settings</h2>
							</div><!--end .col -->
							<div class="col-sm-offset-1 col-sm-8">
								<div class="card">
									<div class="card-body">
										<table class="table no-margin">
											<thead>												
											</thead>
											<tbody>
												<tr>
													<td>Sunday</td>
													<td>
													<div class="form-group">
														<div class="color_picker input-group colorpicker-component" data-color="${pref.sundayColor}" data-color-format="rgb" style="width: 60%;">
															<div class="input-group-content">
																<input name="sun_color" type="text" value="${pref.sundayColor}" readonly="" class="form-control">
																<label>Event Color</label>
															</div>
															<div class="input-group-addon"><i style="border-style: solid; border-width: 1px; border-color:black;background-color: ${pref.sundayColor};"></i></div>
														</div>
													</div><!--end .form-group -->
													</td>
													<td>
													<div class="form-group">
														<div class="color_picker input-group colorpicker-component" data-color="${pref.sundayTextColor}" data-color-format="rgb" style="width: 60%;">
															<div class="input-group-content">
																<input name="sun_text_color" type="text" value="${pref.sundayTextColor}" readonly="" class="form-control">
																<label>Text Color</label>
															</div>
															<div class="input-group-addon"><i style="border-style: solid; border-width: 1px; border-color:black;background-color: ${pref.sundayTextColor};"></i></div>
														</div>
													</div><!--end .form-group -->													
													</td>
												</tr>
												<tr>
													<td>Monday</td>
													<td>
													<div class="form-group">
														<div class="color_picker input-group colorpicker-component" data-color="${pref.mondayColor}" data-color-format="rgb" style="width: 60%;">
															<div class="input-group-content">
																<input name="mon_color" type="text" value="${pref.mondayColor}" readonly="" class="form-control">
																<label>Event Color</label>
															</div>
															<div class="input-group-addon"><i style="border-style: solid; border-width: 1px; border-color:black;background-color: ${pref.mondayColor};"></i></div>
														</div>
													</div><!--end .form-group -->
													</td>
													<td>
													<div class="form-group">
														<div class="color_picker input-group colorpicker-component" data-color="${pref.mondayTextColor}" data-color-format="rgb" style="width: 60%;">
															<div class="input-group-content">
																<input name="mon_text_color" type="text" value="${pref.mondayTextColor}" readonly="" class="form-control">
																<label>Text Color</label>
															</div>
															<div class="input-group-addon"><i style="border-style: solid; border-width: 1px; border-color:black;background-color: ${pref.mondayTextColor};"></i></div>
														</div>
													</div><!--end .form-group -->													
													</td>
												</tr>
												<tr>
													<td>Tuesday</td>
													<td>
													<div class="form-group">
														<div class="color_picker input-group colorpicker-component" data-color="${pref.tuesdayColor}" data-color-format="rgb" style="width: 60%;">
															<div class="input-group-content">
																<input name="tue_color" type="text" value="${pref.tuesdayColor}" readonly="" class="form-control">
																<label>Event Color</label>
															</div>
															<div class="input-group-addon"><i style="border-style: solid; border-width: 1px; border-color:black;background-color: ${pref.tuesdayColor};"></i></div>
														</div>
													</div><!--end .form-group -->
													</td>
													<td>
													<div class="form-group">
														<div class="color_picker input-group colorpicker-component" data-color="${pref.tuesdayTextColor}" data-color-format="rgb" style="width: 60%;">
															<div class="input-group-content">
																<input name="tue_text_color" type="text" value="${pref.tuesdayTextColor}" readonly="" class="form-control">
																<label>Text Color</label>
															</div>
															<div class="input-group-addon"><i style="border-style: solid; border-width: 1px; border-color:black;background-color: ${pref.tuesdayTextColor};"></i></div>
														</div>
													</div><!--end .form-group -->													
													</td>
												</tr>
												<tr>
													<td>Wednesday</td>
													<td>
													<div class="form-group">
														<div class="color_picker input-group colorpicker-component" data-color="${pref.wednesdayColor}" data-color-format="rgb" style="width: 60%;">
															<div class="input-group-content">
																<input name="wed_color" type="text" value="${pref.wednesdayColor}" readonly="" class="form-control">
																<label>Event Color</label>
															</div>
															<div class="input-group-addon"><i style="border-style: solid; border-width: 1px; border-color:black;background-color: ${pref.wednesdayColor};"></i></div>
														</div>
													</div><!--end .form-group -->
													</td>
													<td>
													<div class="form-group">
														<div class="color_picker input-group colorpicker-component" data-color="${pref.wednesdayTextColor}" data-color-format="rgb" style="width: 60%;">
															<div class="input-group-content">
																<input name="wed_text_color" type="text" value="${pref.wednesdayTextColor}" readonly="" class="form-control">
																<label>Text Color</label>
															</div>
															<div class="input-group-addon"><i style="border-style: solid; border-width: 1px; border-color:black;background-color: ${pref.wednesdayTextColor};"></i></div>
														</div>
													</div><!--end .form-group -->													
													</td>
												</tr>
												<tr>
													<td>Thursday</td>
													<td>
													<div class="form-group">
														<div class="color_picker input-group colorpicker-component" data-color="${pref.thursdayColor}" data-color-format="rgb" style="width: 60%;">
															<div class="input-group-content">
																<input name="thu_color" type="text" value="${pref.thursdayColor}" readonly="" class="form-control">
																<label>Event Color</label>
															</div>
															<div class="input-group-addon"><i style="border-style: solid; border-width: 1px; border-color:black;background-color: ${pref.thursdayColor};"></i></div>
														</div>
													</div><!--end .form-group -->
													</td>
													<td>
													<div class="form-group">
														<div class="color_picker input-group colorpicker-component" data-color="${pref.thursdayTextColor}" data-color-format="rgb" style="width: 60%;">
															<div class="input-group-content">
																<input name="thu_text_color" type="text" value="${pref.thursdayTextColor}" readonly="" class="form-control">
																<label>Text Color</label>
															</div>
															<div class="input-group-addon"><i style="border-style: solid; border-width: 1px; border-color:black;background-color: ${pref.thursdayTextColor};"></i></div>
														</div>
													</div><!--end .form-group -->													
													</td>
												</tr>
												<tr>
													<td>Friday</td>
													<td>
													<div class="form-group">
														<div class="color_picker input-group colorpicker-component" data-color="${pref.fridayColor}" data-color-format="rgb" style="width: 60%;">
															<div class="input-group-content">
																<input name="fri_color" type="text" value="${pref.fridayColor}" readonly="" class="form-control">
																<label>Event Color</label>
															</div>
															<div class="input-group-addon"><i style="border-style: solid; border-width: 1px; border-color:black;background-color: ${pref.fridayColor};"></i></div>
														</div>
													</div><!--end .form-group -->
													</td>
													<td>
													<div class="form-group">
														<div class="color_picker input-group colorpicker-component" data-color="${pref.fridayTextColor}" data-color-format="rgb" style="width: 60%;">
															<div class="input-group-content">
																<input name="fri_text_color" type="text" value="${pref.fridayTextColor}" readonly="" class="form-control">
																<label>Text Color</label>
															</div>
															<div class="input-group-addon"><i style="border-style: solid; border-width: 1px; border-color:black;background-color: ${pref.fridayTextColor};"></i></div>
														</div>
													</div><!--end .form-group -->													
													</td>
												</tr>
												<tr>
													<td>Saturday</td>
													<td>
													<div class="form-group">
														<div class="color_picker input-group colorpicker-component" data-color="${pref.saturdayColor}" data-color-format="rgb" style="width: 60%;">
															<div class="input-group-content">
																<input name="sat_color" type="text" value="${pref.saturdayColor}" readonly="" class="form-control">
																<label>Event Color</label>
															</div>
															<div class="input-group-addon"><i style="border-style: solid; border-width: 1px; border-color:black;background-color: ${pref.saturdayColor};"></i></div>
														</div>
													</div><!--end .form-group -->
													</td>
													<td>
													<div class="form-group">
														<div class="color_picker input-group colorpicker-component" data-color="${pref.saturdayTextColor}" data-color-format="rgb" style="width: 60%;">
															<div class="input-group-content">
																<input name="sat_text_color" type="text" value="${pref.saturdayTextColor}" readonly="" class="form-control">
																<label>Text Color</label>
															</div>
															<div class="input-group-addon"><i style="border-style: solid; border-width: 1px; border-color:black;background-color: ${pref.saturdayTextColor};"></i></div>
														</div>
													</div><!--end .form-group -->													
													</td>
												</tr>
											</tbody>
										</table>
									</div><!--end .card-body -->
								</div><!--end .card -->
							</div><!--end .col -->
							
							<div class="col-sm-11 col-sm-offset-1">
								<h2 class="text-primary">Recurring Events Settings </h2>
							</div><!--end .col -->
							<div class="col-sm-offset-1 col-sm-8">
								<div class="card">
									<div class="card-body">
										<table class="table no-margin">
											<thead>
												
											</thead>
											<tbody>
												<tr>
													<td>
													<div class="form-group">
														<div class="color_picker input-group colorpicker-component" data-color="${pref.recurringColor}" data-color-format="rgb" style="width: 60%;">
															<div class="input-group-content">
																<input name="rec_color" type="text" value="${pref.recurringColor}" readonly="" class="form-control">
																<label>Event Color</label>
															</div>
															<div class="input-group-addon"><i style="border-style: solid; border-width: 1px; border-color:black;background-color: ${pref.recurringColor};"></i></div>
														</div>
													</div><!--end .form-group -->
													</td>
													<td>
													<div class="form-group">
														<div class="color_picker input-group colorpicker-component" data-color="${pref.recurringTextColor}" data-color-format="rgb" style="width: 60%;">
															<div class="input-group-content">
																<input name="rec_text_color" type="text" value="${pref.recurringTextColor}" readonly="" class="form-control">
																<label>Text Color</label>
															</div>
															<div class="input-group-addon"><i style="border-style: solid; border-width: 1px; border-color:black;background-color: ${pref.recurringTextColor};"></i></div>
														</div>
													</div><!--end .form-group -->													
													</td>
												</tr>
											</tbody>
										</table>
									</div><!--end .card-body -->
								</div><!--end .card -->
								
								<button class="btn btn-primary btn-raised" type="submit">Save</button>
							</div><!--end .col -->
							
							
						</form>
						</div><!--end .row -->
						<!-- END DEFAULT TABLE -->
					</div><!--end .section-body -->
				</section>
		</div><!--end #base-->
		<!-- END BASE -->

		<!-- BEGIN JAVASCRIPT -->
		<script src="../resources/js/libs/jquery/jquery-1.11.2.min.js"></script>
		<script src="../resources/js/libs/jquery/jquery-migrate-1.2.1.min.js"></script>
		<script src="../resources/js/libs/bootstrap/bootstrap.min.js"></script>
		<script src="../resources/js/libs/spin.js/spin.min.js"></script>
		<script src="../resources/js/libs/autosize/jquery.autosize.min.js"></script>
		<script src="../resources/js/libs/nanoscroller/jquery.nanoscroller.min.js"></script>
		<script src="../resources/js/libs/moment/moment.min.js"></script>
		<script src="../resources/js/libs/bootstrap-colorpicker/bootstrap-colorpicker.min.js"></script>
		<script src="../resources/js/core/source/App.js"></script>
		<script src="../resources/js/core/source/AppNavigation.js"></script>
		<script src="../resources/js/core/source/AppOffcanvas.js"></script>
		<script src="../resources/js/core/source/AppCard.js"></script>
		<script src="../resources/js/core/source/AppForm.js"></script>
		<script src="../resources/js/core/source/AppNavSearch.js"></script>
		<script src="../resources/js/core/source/AppVendor.js"></script>
		<script src="../resources/js/core/demo/Demo.js"></script>
		<!-- END JAVASCRIPT -->
		<script>
			$('.color_picker').colorpicker();
		</script>

	</body>
</html>
