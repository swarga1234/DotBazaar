
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/sideBar.css">
<div class="blur-background-sidebar" id="blur-background-sidebar"></div>
<div class="sidebar">
	<div class="profile">
		<img
			src="${pageContext.request.contextPath}/resources/images/default-profile-pic.png"
			alt="User Profile">
		<c:choose>
			<c:when test="${sessionScope.user!=null}">
				<h2 style="color: #fff">${sessionScope.user.userName}</h2>
			</c:when>
			<c:otherwise>
				<h2 style="color: #fff">Hello, Guest</h2>
			</c:otherwise>
		</c:choose>

	</div>
	<div class="sidebarOptions">
		<div class="categories">
			<a class="list-group-item list-group-item-action"
				data-toggle="collapse" href="#categoriesList" aria-expanded="true"
				aria-controls="categoriesList"><h4>Categories</h4> </a>
			<div class="collapse" id="categoriesList">
				<div class="list-group">
					<a href="#" class="list-group-item list-group-item-action active">
						Cras justo odio </a> <a href="#"
						class="list-group-item list-group-item-action">Dapibus ac
						facilisis in</a> <a href="#"
						class="list-group-item list-group-item-action">Morbi leo risus</a>
					<a href="#" class="list-group-item list-group-item-action">Porta
						ac consectetur ac</a> <a href="#"
						class="list-group-item list-group-item-action disabled">Vestibulum
						at eros</a>
				</div>
			</div>
		</div>
	</div>
	<div class="sidebarOptions">
		<div class="account">
			<a class="list-group-item list-group-item-action"
				data-toggle="collapse" href="#account" aria-expanded="true"
				aria-controls="account"><h4>Help & Settings</h4> </a>
			<div class="collapse" id="account">
				<div class="list-group">
					<a href="#" class="list-group-item list-group-item-action">Your
						Account</a> <a href="#" class="list-group-item list-group-item-action">Customer
						Service</a> <a href="#" class="list-group-item list-group-item-action">Your
						Orders</a>
				</div>
			</div>
		</div>
	</div>
	<div class="login-logout">
		<c:choose>
			<c:when test="${sessionScope.user!=null}">
				<a href="${pageContext.request.contextPath}/logout">
					<button class="btn">Logout</button>
				</a>
			</c:when>
			<c:otherwise>
				<button class="btn" id="login-sidebar">Login</button>
			</c:otherwise>
		</c:choose>


	</div>

</div>