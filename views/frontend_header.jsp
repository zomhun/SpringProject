<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<header>
	<div class="top-link">
		<div class="container">
			<div class="row">
				<div class="col-md-7 col-md-offset-3 col-sm-9 hidden-xs">
					<div class="site-option">
						<ul>
							<li class="language"><spring:message code="Language"
									text="Language" />
								<ul class="sub-site-option">
									<li><a href="?lang=en_US"><spring:message code="en"
												text="English" />
											<fmt:setLocale value="en_US" /></a></li>
									<li><a href="?lang=vi_VN"><spring:message code="vn"
												text="Vietnamese" />
											<fmt:setLocale value="vi_VN" /></a></li>
								</ul></li>
						</ul>
					</div>
				</div>
				<div class="col-md-2 col-sm-3">
					<div class="dashboard">
						<div class="account-menu">
							<ul>
								<li class="search"><a href="#"> <i class="fa fa-search"></i>
								</a>
									<ul class="search">
										<li>
											<form action="#">
												<input type="text">
												<button type="submit">
													<i class="fa fa-search"></i>
												</button>
											</form>
										</li>
									</ul></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="mainmenu-area home2 product-items">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<div class="logo">
						<a href="index.html"> <img
							src="<c:url value="resources"/>/frontend/img/logo.png" alt="">
						</a>
					</div>
				</div>
				<div class="col-md-9">
					<div class="mainmenu">
						<nav>
							<ul>
								<li><a href="<c:url value="/user" />/user"><spring:message
											code="ListCourses" text="List Courses" /></a></li>
								<li><a href="<c:url value="/user" />/listCoursesRegisted"><spring:message
											code="ListCoursesRegisted" text="List Courses Registed" /></a></li>
								<li><img src="<c:url value="../resources"/>/images/${u.avatar}" alt="" style="width:50px"></li>
								<li><a href="<c:url value="/user" />/initUpdateUser">${u.username}</a></li>
								<li><sec:authorize access="isAuthenticated()">
										<form action="<c:url value="/j_spring_security_logout" />"
											method="post">
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" /> <input type="submit"
												value="Logout" />
										</form>
									</sec:authorize></li>
								<sec:authorize access="hasRole('ADMIN')">
									<li><a href="<c:url value="/admin/welcome" />"><spring:message
												code="AdminPage" text="Admin Page" /></a></li>
								</sec:authorize>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
	<h2>${mess}</h2>
</header>