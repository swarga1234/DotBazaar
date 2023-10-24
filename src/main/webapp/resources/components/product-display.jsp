<%@page import="com.swarga.project.dotbazaar.util.GeneralUtilities"%>
<%@page import="com.swarga.project.dotbazaar.entities.Product"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/product-display.css">
<div class="container-fluid text-center" style="padding-top: 150px !important;
    padding-bottom: 150px !important;">
	<div class="row">
		<c:forEach var="product" items="${products}">
			<div class="col-sm-4 mt-5">
				<div class="card ml-2 mr-2">
					<div class="card-body text-center">
						<div class="container-fluid text-center">
							<img alt="Product Photo"
								style="max-height: 350px; max-width: 100%; box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);"
								src="${pageContext.request.contextPath}/resources/Products/${product.productPhotos[0]}"
								class="img-fluid rounded">
						</div>
						<div class="container-fluid text-justify mt-3">
							<h5 class="card-title " style="font-weight: bold;">${product.productName }</h5>
							<c:set var="first10Words"
								value="${GeneralUtilities.getFirstTenWordsOFDesc({product.productDesc})}" />
							<p class="card-text">${first10Words}</p>

						</div>
						<div class="container-fluid mt-3 text-left">
							<c:set var="discountedPrice"
								value="${GeneralUtilities.getDiscountedPrice(product.productPrice ,product.productDiscount)}" />
							<h5 style="font-weight: bold; display: inline;">&#8377;
								${discountedPrice}</h5>
							<p style="font-size: 0.8em; display: inline;">
								M.R.P: <span class="strikeout"> &#8377;
									${product.productPrice}</span> (
									${product.productDiscount}% off)

							</p>

						</div>

					</div>
				</div>
			</div>
		</c:forEach>

	</div>

</div>