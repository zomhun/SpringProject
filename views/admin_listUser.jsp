<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
							<form action="searchAdvanceUser" method="post"
								class="app-search d-none d-md-block me-3">
								<input type="text" placeholder="Username"
									class="form-control mt-0" name="username">
									<input type="text" placeholder="Email"
									class="form-control mt-0" name="email">
									<input type="text" placeholder="Phone"
									class="form-control mt-0" name="phone">
									<input type="text" placeholder="Address"
									class="form-control mt-0" name="address">
								<input type="submit" value="search" />
							</form>
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
							<h3 class="box-title">List User</h3>
							<h2>${mess}</h2>
							<div class="table-responsive">
								<table class="table text-nowrap">
									<thead>
										<tr>
											<th class="border-top-0">ID</th>
											<th class="border-top-0">Username</th>
											<th class="border-top-0">Email</th>
											<th class="border-top-0">Gender</th>
											<th class="border-top-0">Date Of Birth</th>
											<th class="border-top-0">Avatar</th>
											<th class="border-top-0">Phone</th>
											<th class="border-top-0">Address</th>
											<th class="border-top-0">Action</th>
											<th class="border-top-0">More</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${list}" var="u">
											<tr>
												<td>${u.id}</td>
												<td>${u.username}</td>
												<td>${u.email}</td>
												<td>${u.gender?"Male":"Female"}</td>
												<td>${u.dateOfBirth}</td>
												<td><img
													src="<c:url value="../resources"/>/images/${u.avatar}"
													style="height: 50px" /></td>
												<td>${u.phone}</td>
												<td>${u.address}</td>
												<td><a href="initUpdateUser?id=${u.id}">Update</a> <a
													href="deleteUser?id=${u.id}">Delete</a></td>
												<td><a href="listUserCourse?id=${u.id}">List of
														registered courses</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
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
	<script
		src="<c:url value="../resources"/>/plugins/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap tether Core JavaScript -->
	<script
		src="<c:url value="../resources"/>/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
	<script src="<c:url value="../resources"/>/js/app-style-switcher.js"></script>
	<!--Wave Effects -->
	<script src="<c:url value="../resources"/>/js/waves.js"></script>
	<!--Menu sidebar -->
	<script src="<c:url value="../resources"/>/js/sidebarmenu.js"></script>
	<!--Custom JavaScript -->
	<script src="<c:url value="../resources"/>/js/custom.js"></script>
</body>
</html>