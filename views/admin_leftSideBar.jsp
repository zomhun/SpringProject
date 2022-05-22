<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<aside class="left-sidebar" data-sidebarbg="skin6">
	<!-- Sidebar scroll-->
	<div class="scroll-sidebar">
		<!-- Sidebar navigation-->
		<nav class="sidebar-nav">
			<ul id="sidebarnav">
				<!-- User Profile-->
				<li class="sidebar-item pt-2"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="<c:url value="/admin/welcome" />" aria-expanded="false">
						<i class="far fa-clock" aria-hidden="true"></i> <span
						class="hide-menu">Users</span>
				</a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="<c:url value="/admin/listCourse" />" aria-expanded="false"> <i
						class="fa fa-user" aria-hidden="true"></i> <span class="hide-menu">Courses</span>
				</a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="<c:url value="/admin/listLab" />" aria-expanded="false"> <i
						class="fa fa-table" aria-hidden="true"></i> <span
						class="hide-menu">Labs</span>
				</a></li>
				<li class="sidebar-item"><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="<c:url value="/user/user" />" aria-expanded="false"> <i
						class="fa fa-table" aria-hidden="true"></i> <span
						class="hide-menu">User Page</span>
				</a></li>
			</ul>

		</nav>
		<!-- End Sidebar navigation -->
	</div>
	<!-- End Sidebar scroll-->
</aside>