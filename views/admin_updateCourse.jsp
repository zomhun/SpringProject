<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
							<h3 class="box-title">Update Course</h3>
							<div class="table-responsive">
								<form:form name='updateCourseForm' action="updateCourseForm"
									method='POST' modelAttribute="c">
									<form:input path="id" type="hidden" />

									<div class="form-outline mb-4">
										<label class="form-label" for="courseName">Course Name</label>
										<form:input type="text" id="courseName" path="courseName"
											class="form-control" />
									</div>
									<div class="form-outline mb-4">
										<label class="form-label" for="numberOfCredit">Number
											Of Credit</label>
										<form:input type="text" id="numberOfCredit"
											path="numberOfCredit" class="form-control" />
									</div>
									<div class="form-outline mb-4">
										<label class="form-label" for="price">Price</label>
										<form:input type="text" id="price" path="price"
											class="form-control" />
									</div>
									<div class="form-outline mb-4">
										<label class="form-label" for="coefficient">Coefficient</label>
										<form:input type="text" id="coefficient" path="coefficient"
											class="form-control" />
									</div>
									<div class="form-outline mb-4">
										<label class="form-label" for="labId">Lab Id</label>
										<form:select path="labId.id">
											<form:options items="${listOfLab}"
												itemLabel="labName" itemValue="id" />
										</form:select>
									</div>
									<div class="form-outline mb-4">
										<label class="form-label" for="stillEmpty">Still Empty</label>
										<form:input type="text" id="stillEmpty" path="stillEmpty"
											class="form-control" />
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