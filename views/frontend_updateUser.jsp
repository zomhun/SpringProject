<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<jsp:include page="frontend_head.jsp"></jsp:include>
<body>
	<!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
	<!-- Add your site or application content here -->
	<!-- header area start -->
	<jsp:include page="frontend_header.jsp"></jsp:include>
	<!-- header area end -->
	<!-- cart item area start -->
	<div class="shopping-cart">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="location">
						<ul>
							<li><a href="index.html" title="go to homepage">Home<span>/</span></a>
							</li>
							<li><strong>Update User</strong></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="login-area">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3 text-center">
					<div class="login">
						<div class="login-form-container">
							<div class="login-text">
								<h2><spring:message code="UpdateUser" text="Update User" /></h2>
							</div>
							<div class="login-form">
								<form:form name='updateUserForm' action="updateUserForm"
									method='POST' enctype="multipart/form-data" modelAttribute="u">
									<form:input path="id" type="hidden"/>

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
										<input type="password" id="confirmPassword" name="confirmPassword" class="form-control"  value="${u.password}" />
									</div>
									<div class="form-outline mb-4">
										<label class="form-label"><spring:message code="Gender" text="Gender" /></label> </br> 
										<label class="form-label"><spring:message code="Male" text="Male" /></label> 
											<form:radiobutton path="gender" value="true" id="male"/></br>
											 <label class="form-label"><spring:message code="Female" text="Female" /></label> 
											<form:radiobutton path="gender" value="false" id="female"/>
									</div>
									<div class="form-outline mb-4">
										<label class="form-label" for="dateOfBirth"><spring:message code="DateOfBirth" text="Date Of Birth" /></label>
										<form:input type="date" id="dateOfBirth" class="form-control"
											path="dateOfBirth" />
									</div>
									<div class="form-outline mb-4">
										<label class="form-label" for="avatar"><spring:message code="Avatar" text="Avatar" /></label>
										<input type="file" id="avatar" name="imageUrl" />
										<input type="hidden" name="oldImageUrl" value="${u.avatar}" />
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
										class="btn btn-primary btn-block mb-3"><spring:message code="Update" text="Update" /></form:button>
								</form:form>
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
