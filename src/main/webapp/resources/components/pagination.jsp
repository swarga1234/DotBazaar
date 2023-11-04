<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/pagination-style.css">
<c:set var="currentPage" value="${param.page}" />
<c:choose>
	<c:when test="${empty currentPage}">
		<c:set var="currentPage" value="1" />
	</c:when>
</c:choose>

<c:set var="pagesToShow" value="3" />
<c:set var="startPage" value="${currentPage - (pagesToShow / 2)}" />
<c:set var="endPage" value="${currentPage + (pagesToShow / 2)}" />
<c:choose>
	<c:when test="${totalPages < pagesToShow}">
		<c:set var="startPage" value="1" />
		<c:set var="endPage" value="${totalPages}" />
	</c:when>
</c:choose>
<c:choose>
	<c:when test="${startPage < 1}">
		<c:set var="startPage" value="1" />
		<c:set var="endPage" value="${startPage + pagesToShow - 1}" />
	</c:when>
	<c:when test="${endPage > totalPages}">
		<c:set var="endPage" value="${totalPages}" />
		<c:set var="startPage" value="${endPage - pagesToShow + 1}" />
	</c:when>
</c:choose>
<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">
		<li class="page-item ${currentPage == 1 ? 'disabled' : ''}"><c:choose>
				<c:when test="${currentPage != 1}">
					<a class="page-link" href="?page=${currentPage - 1}"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						<span class="sr-only">Previous</span>
					</a>
				</c:when>
				<c:otherwise>
					<span class="page-link" aria-hidden="true">&laquo;</span>
				</c:otherwise>
			</c:choose></li>
		<c:forEach begin="${startPage}" end="${endPage}" var="i">
			<li class="page-item ${i == currentPage ? 'active' : ''}"><a
				class="page-link" href="?page=${i}">${i}</a></li>
		</c:forEach>
		<li class="page-item ${currentPage == totalPages ? 'disabled' : ''}"><c:choose>
				<c:when test="${currentPage < totalPages}">
					<a class="page-link" href="?page=${currentPage + 1}"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
						class="sr-only">Previous</span>
					</a>
				</c:when>
				<c:otherwise>
					<span class="page-link" aria-hidden="true">&raquo;</span>
				</c:otherwise>
			</c:choose></li>
	</ul>
</nav>