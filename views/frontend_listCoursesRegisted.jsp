<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
							<li><strong>Login page</strong></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="login-area">
		<div class="container">
			<table class="table text-nowrap">
				<thead>
					<tr>
						<th class="border-top-0">ID</th>
						<th class="border-top-0"><spring:message code="CourseName" text="CourseName" /></th>
						<th class="border-top-0"><spring:message code="NumberOfCredit" text="Number Of Credit" /></th>
						<th class="border-top-0"><spring:message code="Price" text="Price" /></th>
						<th class="border-top-0"><spring:message code="Coefficient" text="Coefficient" /></th>
						<th class="border-top-0"><spring:message code="LabName" text="Lab Name" /></th>
						<th class="border-top-0"><spring:message code="StillEmpty" text="Still Empty" /></th>
						<th class="border-top-0"><spring:message code="Action" text="Action" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="l">
						<tr>
							<td>${l.courseId.id}</td>
							<td>${l.courseId.courseName}</td>
							<td>${l.courseId.numberOfCredit}</td>
							<td><fmt:formatNumber value = "${l.courseId.price}" type = "currency"/></td>
							<td>${l.courseId.coefficient}</td>
							<td>${l.courseId.labId.labName}</td>
							<td>${l.courseId.stillEmpty}</td>
							<td><a href="deleteUserCourse?id=${l.id}"><spring:message code="Delete" text="Delete" /></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="frontend_footer.jsp"></jsp:include>
</body>

<!-- Mirrored from preview.hasthemes.com/james-preview/james/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 11 Jan 2021 00:39:06 GMT -->
</html>
