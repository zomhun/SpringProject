<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Page</title>
</head>
<body>
    <h1>User Page</h1>
    <h2>Welcome: ${pageContext.request.userPrincipal.name}</h2>
    <p>${pageContext.request.remoteUser}</p>
    <sec:authorize access="hasRole('ADMIN')">
    	<a href="<c:url value="/admin/welcome" />">Admin Page</a>
	</sec:authorize>
    <br />
    <p>${u.email}</p>
    <p>${u.username}</p>
    <form action="<c:url value="/j_spring_security_logout" />" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
        <input type="submit" value="Logout" />
    </form>
</body>
</html>
