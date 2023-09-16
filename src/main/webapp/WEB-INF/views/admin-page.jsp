<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/admin-page.css">
</head>
<body>
	<%@include file="../../resources/components/navbar.jsp"%>
	<%@include file="../../resources/components/sideBar.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<div class="card ml-2 mr-2">
					<div class="card-body text-center">
						<div class="container">
							<img alt="users"
								style="max-width: 125px; box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);"
								src="${pageContext.request.contextPath}/resources/images/customer.png"
								class="img-fluid rounded-circle">
						</div>
						<div class="container mt-3">
							<h2 class="card-title text-uppercase">Users</h2>
							<p class="card-text">0</p>
						</div>

					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="card ml-2 mr-2">
					<div class="card-body text-center">
						<div class="container">
							<img alt="categories"
								style="max-width: 125px; box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);"
								src="${pageContext.request.contextPath}/resources/images/menu.png"
								class="img-fluid rounded">
						</div>
						<div class="container mt-3">
							<h2 class="card-title text-uppercase">Categories</h2>
							<p class="card-text">0</p>
						</div>

					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="card ml-2 mr-2">
					<div class="card-body text-center">
						<div class="container">
							<img alt="products"
								style="max-width: 125px; box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);"
								src="${pageContext.request.contextPath}/resources/images/cosmetic.png"
								class="img-fluid rounded">
						</div>
						<div class="container mt-3">
							<h2 class="card-title text-uppercase">Products</h2>
							<p class="card-text">0</p>
						</div>

					</div>
				</div>
			</div>

		</div>
		<div class="row mt-4">
			<div class="col-sm-6">
				<div class="card ml-2 mr-2">
					<div class="card-body text-center">
						<div class="container image-link">
							<img alt="add category" style="max-width: 125px"
								src="${pageContext.request.contextPath}/resources/images/add-category.png"
								class="img-fluid rounded" data-toggle="modal"
								data-target="#add-category-admin">

						</div>
						<div class="container mt-3">
							<h2 class="card-title text-uppercase">Add Category</h2>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="card ml-2 mr-2">
					<div class="card-body text-center">
						<div class="container image-link">
							<img alt="add product" style="max-width: 125px"
								src="${pageContext.request.contextPath}/resources/images/add-product.png"
								class="img-fluid rounded" data-toggle="modal"
								data-target="#add-product-admin">

						</div>
						<div class="container mt-3">
							<h2 class="card-title text-uppercase">Add Product</h2>
						</div>
					</div>
				</div>
			</div>

		</div>

	</div>

	<div class="modal fade" id="add-product-admin" tabindex="-1"
		role="dialog" aria-labelledby="addCategoryCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header text-uppercase">
					<h5 class="modal-title text-center" id="exampleModalLongTitle">Add
						Product</h5>
					<span class="icon-close" data-dismiss="modal"><ion-icon
							name="close"></ion-icon></span>

				</div>
				<div class="modal-body">
					<form id="add-product-admin-form" action="add-product"
						method="post" enctype="multipart/form-data">
						<div class="form-group">
							<label class="text-uppercase">Product name</label> <input
								type="text" class="form-control" id="productName"
								name="productName" required>
						</div>
						<div class="form-group">
							<label class="text-uppercase">Description</label>
							<textarea class="form-control" id="productDesc"
								name="productDesc" rows="3"></textarea>
						</div>
						<div class="form-group">
							<label class="text-uppercase">Product Price</label> <input
								type="number" class="form-control" id="productPrice"
								name="productPrice" min="0" value="0" step=".01" required>
						</div>
						<div class="form-group">
							<label class="text-uppercase">Product Discount</label> <input
								type="number" class="form-control" id="productDiscount"
								name="productDiscount" min="0" value="0" step="1" required>
						</div>
						<div class="form-group">
							<label class="text-uppercase">Product Quantity</label> <input
								type="number" class="form-control" id="productQuantity"
								name="productQuantity" min="0" value="0" step="1" required>
						</div>
						<div class="form-group">

							<label class="text-uppercase">Category</label> <select
								class="form-control" id="categoryId" name="categoryId" required>
								<c:forEach var="category" items="${categories}">
									<option value="${category.categoryId}">${category.categoryName }</option>
								</c:forEach>

							</select>



						</div>
						<div class="form-group">
							<label class="text-uppercase">Upload Photos (only .png,
								.jpeg, .jpg)</label> <input type="file" class="form-control-file"
								id="productPhotoFiles" name="productPhotoFiles" multiple
								accept=".png, .jpeg, .jpg" required>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn text-uppercase">Add
								Product</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
	<div class="modal fade" id="add-category-admin" tabindex="-1"
		role="dialog" aria-labelledby="addProductCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header text-uppercase">
					<h5 class="modal-title text-center" id="exampleModalLongTitle">Add
						Category</h5>
					<span class="icon-close" data-dismiss="modal"><ion-icon
							name="close"></ion-icon></span>

				</div>
				<div class="modal-body">
					<form id="add-category-admin-form" action="add-category"
						method="post">
						<div class="form-group">
							<label class="text-uppercase">Category name</label> <input
								type="text" class="form-control" id="categoryName"
								name="categoryName" required>
						</div>
						<div class="form-group">
							<label class="text-uppercase">Description</label>
							<textarea class="form-control" id="categoryDescription"
								name="categoryDescription" rows="3"></textarea>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn text-uppercase">Add
								Category</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>

	<%@include file="../../resources/components/message-success.jsp"%>

	<%@include file="../../resources/components/message-error.jsp"%>
	<div id="session-message"
		data-message="<%=session.getAttribute("message")%>"></div>
	<%
	session.removeAttribute("message");
	%>
	<script
		src="${pageContext.request.contextPath}/resources/js/adminScript.js"></script>
		<script
		src="${pageContext.request.contextPath}/resources/js/sideBar.js"></script>

</body>
</html>