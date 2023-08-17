<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Sign Up</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
	<div class="container">
		<h2>User Sign Up</h2>
		<form id="signup-form" action="signup" method="post">
			<label for="username">Username:</label> <input type="text"
				id="userName" name="userName" required> <label
				for="password">Password:</label> <input type="password"
				id="userPassword" name="userPassword" required>
			<button type="submit">Sign Up</button>
		</form>
	</div>
	<c:if test="${message!=null}">
		<div id="popup" class="popup">
			<div class="popup-content">
				<span id="popup-message"> ${message} </span>
				<button id="close-popup">Close</button>
			</div>
		</div>
	</c:if>
	<iframe name="hidden-iframe" style="display: none;"></iframe>
	<%--  <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script> --%>
	<script
		src="${pageContext.request.contextPath}/resources/js/script1.js"></script>
</body>
</html>
