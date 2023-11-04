<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
</head>
<body>
	<%@include file="../../resources/components/navbar.jsp"%>
	<%@include file="../../resources/components/sideBar.jsp"%>
	<%@include file="../../resources/components/product-display.jsp"%>
	<div class="wrapper">
		<span class="icon-close"><ion-icon name="close"></ion-icon></span>
		<div class="form-box login">
			<h2>Login</h2>
			<form id="login-form" action="login" method="post">
				<div class="input-box">
					<span class="icon"><ion-icon name="mail"></ion-icon></span> <input
						type="email" name="userEmail" required> <label>User
						Email</label>
				</div>
				<div class="input-box">
					<span class="icon"><a href="javascript:void(0);"
						id="show-password-login"><ion-icon id="password-icon-login"
								name="eye-off"></ion-icon></a></span> <input type="password"
						id="passsword-login" name="userPassword" required> <label>Password</label>
				</div>
				<div class="remember-forget">
					<label><input type="checkbox"> Remember me</label> <a
						href="#"> Forget Password?</a>
				</div>
				<button type="submit" class="btn">Login</button>
				<div class="login-register">
					<p>
						Dont have an account? <a href="javascript:void(0);"
							class="register-link">Register</a>
					</p>
				</div>

			</form>
		</div>
		<div class="form-box registration">
			<h2>Sign Up</h2>
			<form id="signup-form" action="registration" method="post">

				<div class="input-box">
					<span class="icon"><ion-icon name="mail"></ion-icon></span> <input
						type="email" name="userEmail" maxlength="100" required> <label>User
						Email</label>
				</div>
				<div class="input-box">
					<span class="icon"><ion-icon name="person"></ion-icon></span> <input
						type="text" name="userName" maxlength="100" required> <label>User
						Name</label>
				</div>
				<div class="input-box">
					<span class="icon"><ion-icon name="call"></ion-icon></span> <input
						type="tel" name="userPhone" pattern="[0-9]{10}"
						inputmode="numeric" required> <label>Mobile No: </label>
				</div>
				<div class="input-box">
					<span class="icon"><ion-icon name="home"></ion-icon></span> <input
						type="text" name="userAddress" maxlength="100" required> <label>Enter
						Address </label>
				</div>


				<div class="input-box">
					<span class="icon"><a href="javascript:void(0);"
						id="show-password-register"><ion-icon
								id="password-icon-regsiter" name="eye-off"></ion-icon></a></span> <input
						type="password" id="password-register" name="userPassword"
						maxlength="100" required> <label>Password</label>
				</div>
				<div class="remember-forget">
					<label><input type="checkbox" required> I agree to
						all terms & conditions</label>
				</div>
				<button type="submit" class="btn">Register</button>
				<div class="login-register">
					<p>
						Have an account? <a href="javascript:void(0);" class="login-link">Login</a>
					</p>
				</div>

			</form>
		</div>

	</div>
	<br>
	<footer class="footer">
		<%@include file="../../resources/components/pagination.jsp"%>
	</footer>
	<%@include file="../../resources/components/message-success.jsp"%>

	<%@include file="../../resources/components/message-error.jsp"%>


	<iframe name="hidden-iframe" style="display: none;"></iframe>

	<div id="session-message"
		data-message="<%=session.getAttribute("message")%>"></div>
	<%
	session.removeAttribute("message");
	%>


	<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/sideBar.js"></script>
</body>
</html>