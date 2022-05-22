<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<jsp:include page="admin_head.jsp"></jsp:include>
<body>
	<div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5"
		data-sidebartype="full" data-sidebar-position="absolute"
		data-header-position="absolute" data-boxed-layout="full">
		<!-- ============================================================== -->
		<!-- Topbar header - style you can find in pages.scss -->
		<!-- ============================================================== -->
		<jsp:include page="admin_header.jsp"></jsp:include>
		<!-- ============================================================== -->
		<!-- End Topbar header -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<jsp:include page="admin_leftSideBar.jsp"></jsp:include>
		<!-- ============================================================== -->
		<!-- End Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Page wrapper  -->
		<!-- ============================================================== -->
		<div class="page-wrapper">
			<!-- ============================================================== -->
			<!-- Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<div class="page-breadcrumb bg-white">
				<div class="row align-items-center">
					<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
						<h4 class="page-title">Basic Table</h4>
					</div>
					<div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
						<div class="d-md-flex">
							<ol class="breadcrumb ms-auto">
								<li><a href="#" class="fw-normal">Dashboard</a></li>
							</ol>
							<a href="https://www.wrappixel.com/templates/ampleadmin/"
								target="_blank"
								class="btn btn-danger  d-none d-md-block pull-right ms-3 hidden-xs hidden-sm waves-effect waves-light text-white">Upgrade
								to Pro</a>
						</div>
					</div>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- ============================================================== -->
			<!-- End Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- Container fluid  -->
			<!-- ============================================================== -->
			<div class="container-fluid">
				<!-- ============================================================== -->
				<!-- Start Page Content -->
				<!-- ============================================================== -->
				<div class="row">
					<div class="col-sm-12">
						<div class="white-box">
							<h3 class="box-title">Update User</h3>
							<div class="table-responsive">
								<form:form name='updateUserForm' action="updateUserForm"
									method='POST' enctype="multipart/form-data" modelAttribute="u">
									<form:input path="id" type="hidden"/>

									<!-- Username input -->
									<div class="form-outline mb-4">
										<label class="form-label" for="username">Username</label>
										<form:input type="text" id="username" path="username"
											class="form-control" />
									</div>

									<!-- Email input -->
									<div class="form-outline mb-4">
										<label class="form-label" for="email">Email</label>
										<form:input type="email" id="email" path="email"
											class="form-control" />
									</div>
									<!-- Password input -->
									<div class="form-outline mb-4">
										<label class="form-label" for="password">Password</label>
										<form:input type="password" id="password" class="form-control"
											path="password" />
									</div>
									<!-- Password input -->
									<div class="form-outline mb-4">
										<label class="form-label" for="confirmPassword">Confirm Password</label>
										<input type="password" id="confirmPassword" name="confirmPassword" class="form-control"  value="${u.password}" />
									</div>
									<div class="form-outline mb-4">
										<label class="form-label">Gender</label> </br> 
										<label class="form-label">Male</label> 
											<form:radiobutton path="gender" value="true" id="male"/></br>
											 <label class="form-label">Female</label> 
											<form:radiobutton path="gender" value="false" id="female"/>
									</div>
									<div class="form-outline mb-4">
										<label class="form-label" for="dateOfBirth">Date Of Birth</label>
										<form:input type="date" id="dateOfBirth" class="form-control"
											path="dateOfBirth" />
									</div>
									<div class="form-outline mb-4">
										<label class="form-label" for="avatar">Avatar</label>
										<input type="file" id="avatar" name="imageUrl" />
										<input type="hidden" name="oldImageUrl" value="${u.avatar}" />
									</div>
									<div class="form-outline mb-4">
										<label class="form-label" for="phone">Phone</label>
										<form:input type="text" id="phone" class="form-control"
											path="phone" />
									</div>
									<div class="form-outline mb-4">
										<label class="form-label" for="address">Address</label>
										<form:textarea id="address" class="form-control"
											path="address"></form:textarea>

									</div>

									<!-- Submit button -->
									<form:button type="submit"
										class="btn btn-primary btn-block mb-3">Update</form:button>
								</form:form>
							</div>
						</div>
					</div>
				</div>
				<!-- ============================================================== -->
				<!-- End PAge Content -->
				<!-- ============================================================== -->
				<!-- ============================================================== -->
				<!-- Right sidebar -->
				<!-- ============================================================== -->
				<!-- .right-sidebar -->
				<!-- ============================================================== -->
				<!-- End Right sidebar -->
				<!-- ============================================================== -->
			</div>
			<!-- ============================================================== -->
			<!-- End Container fluid  -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- footer -->
			<!-- ============================================================== -->
			<footer class="footer text-center">
				2021 © Ample Admin brought to you by <a
					href="https://www.wrappixel.com/">wrappixel.com</a>
			</footer>
			<!-- ============================================================== -->
			<!-- End footer -->
			<!-- ============================================================== -->
		</div>
		<!-- ============================================================== -->
		<!-- End Page wrapper  -->
		<!-- ============================================================== -->
	</div>
	<jsp:include page="admin_footer.jsp"></jsp:include>
</body>
</html>