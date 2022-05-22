<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
	<!-- header area start -->
	<jsp:include page="frontend_header.jsp"></jsp:include>
	<!-- header area end -->
	<div class="login-area">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3 text-center">
					<div class="login">
						<div class="login-form-container">
							<div class="login-text">
								<h2><spring:message code="Login" text="Login" /></h2>
								<span><spring:message code="PleaseLoginUsingAccountDetailBellow" text="Please login using account detail bellow" />.</span>
							</div>
							<div class="login-form">
								<form name='loginForm'
									action="<c:url value='j_spring_security_login' />"
									method='POST'>
									<h2>${mess}</h2>
									<input type='text' id="username" placeholder="<spring:message code="Username" text="Username" />"
										name='username' /> <input type='password' id="password"
										placeholder="<spring:message code="Password" text="Password" />" name='password' />
									<div class="button-box">
										<button name="submit" type="submit" class="default-btn"><spring:message code="Login" text="Login" /></button>
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" />
									</div>
								</form>
								<a href="register"><button style="float: right"><spring:message code="Register" text="Register" /></button></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="frontend_footer.jsp"></jsp:include>
</body>

<!-- Mirrored from preview.hasthemes.com/james-preview/james/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 11 Jan 2021 00:39:06 GMT -->
</html>
