
<header>
	<h2 class="logo">DotBaazar</h2>
	<nav class="navigation">
		<a href="${pageContext.request.contextPath}/"><span class="icon"><ion-icon
					name="cart"></ion-icon></span> MyCart</a> <a
			href="${pageContext.request.contextPath}/"> Home</a>
		<c:choose>
			<c:when test="${sessionScope.user!=null}">
				<%-- <a href="#">${sessionScope.user.userName}</a>
				<a href="${pageContext.request.contextPath}/logout" class="logout-button"><button
						class="btnLogin-popup">Log Out</button></a> --%>
				<c:choose>
					<c:when test="${sessionScope.user.userType=='Admin'}">
						<a href="${pageContext.request.contextPath}/admin-page"> Admin
							Page</a>
					</c:when>
				</c:choose>



				<%@include file="../../resources/components/profile-tab.jsp"%>


			</c:when>
			<c:otherwise>
				<a href="#" class="profile-button" onclick="toggleSidebar()"> <img
					src="${pageContext.request.contextPath}/resources/images/default-profile-pic.png"
					alt="Profile Picture" class="profile-picture"> <span
					class="username">Hello, Guest</span>
				</a>
				<button class="btnLogin-popup">Login</button>
			</c:otherwise>
		</c:choose>

	</nav>

	<!-- <nav class="navbar navbar-expand-lg navbar-dark custom-bg">

		<div class="container">
			<a class="navbar-brand" href="#">DotBazaar</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="#">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Categories </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">Action</a> <a
								class="dropdown-item" href="#">Another action</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Something else here</a>
						</div></li>
				</ul>
				<form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>

				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="login">Login

					</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="register">Register </a></li>

				</ul>
			</div>
		</div>
	</nav>
 -->
	<%-- <script src="${pageContext.request.contextPath}/resources/js/script.js"></script> --%>
</header>
