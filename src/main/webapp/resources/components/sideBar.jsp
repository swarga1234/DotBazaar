
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
				aria-controls="categoriesList"><h5>Categories</h5> </a>
			<div class="collapse show" id="categoriesList">
				<div class="list-group" id="categoriesListGroup">
					<c:choose>
						<c:when test="${sessionScope.user!=null}">
							<a
								href="${pageContext.request.contextPath}/market-place/category/all"
								class="list-group-item list-group-item-action"> All
								Products</a>
							<c:forEach var="category" items="${categories}">
								<a
									href="${pageContext.request.contextPath}/market-place/category/${category.categoryId }"
									class="list-group-item list-group-item-action">
									${category.categoryName} </a>
							</c:forEach>

						</c:when>
						<c:otherwise>
							<a href="${pageContext.request.contextPath}/category/all"
								class="list-group-item list-group-item-action"> All
								Products</a>
							<c:forEach var="category" items="${categories}">
								<a
									href="${pageContext.request.contextPath}/category/${category.categoryId }"
									class="list-group-item list-group-item-action">
									${category.categoryName} </a>
							</c:forEach>

						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
	<div class="sidebarOptions">
		<div class="account">
			<a class="list-group-item list-group-item-action"
				data-toggle="collapse" href="#account" aria-expanded="true"
				aria-controls="account"><h5>Help & Settings</h5> </a>
			<div class="collapse show" id="account">
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
<script>
	//Activate list items on click using Bootstrap's list group component
	$('#categoriesListGroup a').click(function(e) {
		
		$(this).addClass('active').siblings().removeClass('active');
	});
</script>