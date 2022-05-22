<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Login</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- favicon
        ============================================ -->
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">

<!-- Google Fonts
        ============================================ -->
<link href='https://fonts.googleapis.com/css?family=Norican'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>

<!-- Bootstrap CSS
        ============================================ -->
<link rel="stylesheet"
	href="<c:url value="/resources"/>/frontend/css/bootstrap.min.css">
<!-- Bootstrap CSS
        ============================================ -->
<link rel="stylesheet"
	href="<c:url value="/resources"/>/frontend/css/font-awesome.min.css">
<!-- owl.carousel CSS
        ============================================ -->
<link rel="stylesheet"
	href="<c:url value="/resources"/>/frontend/css/owl.carousel.css">
<link rel="stylesheet"
	href="<c:url value="/resources"/>/frontend/css/owl.theme.css">
<link rel="stylesheet"
	href="<c:url value="/resources"/>/frontend/css/owl.transitions.css">
<!-- jquery-ui CSS
        ============================================ -->
<link rel="stylesheet"
	href="<c:url value="/resources"/>/frontend/css/jquery-ui.css">
<!-- meanmenu CSS
        ============================================ -->
<link rel="stylesheet"
	href="<c:url value="/resources"/>/frontend/css/meanmenu.min.css">
<!-- nivoslider CSS
        ============================================ -->
<link rel="stylesheet"
	href="<c:url value="/resources"/>/frontend/lib/css/nivo-slider.css">
<link rel="stylesheet"
	href="<c:url value="/resources"/>/frontend/lib/css/preview.css">
<!-- animate CSS
        ============================================ -->
<link rel="stylesheet"
	href="<c:url value="/resources"/>/frontend/css/animate.css">
<!-- magic CSS
        ============================================ -->
<link rel="stylesheet"
	href="<c:url value="/resources"/>/frontend/css/magic.css">
<!-- normalize CSS
        ============================================ -->
<link rel="stylesheet"
	href="<c:url value="/resources"/>/frontend/css/normalize.css">
<!-- main CSS
        ============================================ -->
<link rel="stylesheet"
	href="<c:url value="/resources"/>/frontend/css/main.css">
<!-- style CSS
        ============================================ -->
<link rel="stylesheet"
	href="<c:url value="/resources"/>/frontend/style.css">
<!-- responsive CSS
        ============================================ -->
<link rel="stylesheet"
	href="<c:url value="/resources"/>/frontend/css/responsive.css">
<!-- modernizr JS
        ============================================ -->
<script
	src="<c:url value="/resources"/>/frontend/js/vendor/modernizr-2.8.3.min.js"></script>
</head>
<body>
	<!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
	<!-- Add your site or application content here -->
	<jsp:include page="frontend_header.jsp"></jsp:include>
	<!-- cart item area start -->
	<div class="shopping-cart">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="location">
						<ul>
							<li><a href="index.html" title="go to homepage">Home<span>/</span></a>
							</li>
							<li><strong>Register page</strong></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="login-area ptb-120">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3 text-center">
					<div class="login">
						<div class="login-form-container">
							<div class="login-text">
								<h2><spring:message code="Register" text="Register" /></h2>
								<span><spring:message code="PleaseRegisterusingaccountdetailbellow" text="Please Register using account detail bellow." /></span>
							</div>
							<div class="login-form">
								<form:form name='registerForm' action="registerForm"
									method='POST' enctype="multipart/form-data" modelAttribute="u">

									<!-- Username input -->
									<div class="form-outline mb-4">
										<label class="form-label" for="username"><spring:message code="Username" text="Username" /></label>
										<form:input type="text" id="username" path="username"
											class="form-control" />
									</div>

									<!-- Email input -->
									<div class="form-outline mb-4">
										<label class="form-label" for="email"><spring:message code="Email" text="Email" /></label>
										<form:input type="email" id="email" path="email"
											class="form-control" />
									</div>
									<!-- Password input -->
									<div class="form-outline mb-4">
										<label class="form-label" for="password"><spring:message code="Password" text="Password" /></label>
										<form:input type="password" id="password" class="form-control"
											path="password" />
									</div>
									<!-- Password input -->
									<div class="form-outline mb-4">
										<label class="form-label" for="confirmPassword"><spring:message code="ConfirmPassword" text="Confirm Password" /></label>
										<input type="password" id="confirmPassword"
											name="confirmPassword" class="form-control" />
									</div>
									<div class="form-outline mb-4">
										<label class="form-label"><spring:message code="Gender" text="Gender" /></label>
										</br>
										<label class="form-label"><spring:message code="Male" text="Male" /></label></br>
										<form:radiobutton path="gender" value="true" id="male" />
										<label class="form-label"><spring:message code="Female" text="Female" /></label>
										<form:radiobutton path="gender" value="false" id="female" />
									</div>
									<div class="form-outline mb-4">
										<label class="form-label" for="dateOfBirth"><spring:message code="DateOfBirth" text="Date Of Birth" /></label>
										<form:input type="date" id="dateOfBirth" class="form-control"
											path="dateOfBirth" />
									</div>
									<div class="form-outline mb-4">
										<label class="form-label" for="avatar"><spring:message code="Avatar" text="Avatar" /></label>
										<input name="imageUrl" type="file" id="avatar" />
									</div>
									<div class="form-outline mb-4">
										<label class="form-label" for="phone"><spring:message code="Phone" text="Phone" /></label>
										<form:input type="text" id="phone" class="form-control"
											path="phone" />
									</div>
									<div class="form-outline mb-4">
										<label class="form-label" for="address"><spring:message code="Address" text="Address" /></label>
										<form:textarea id="address" class="form-control"
											path="address"></form:textarea>

									</div>

									<!-- Submit button -->
									<form:button type="submit"
										class="btn btn-primary btn-block mb-3"><spring:message code="Register" text="Register" /></form:button>
								</form:form>
								<a href="login"><button style="float: right"><spring:message code="Login" text="Login" /></button></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="frontend_footer.jsp"></jsp:include>
</body>

<!-- Mirrored from preview.hasthemes.com/james-preview/james/register.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 11 Jan 2021 00:39:06 GMT -->
</html>
