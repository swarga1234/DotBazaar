
<a href="javascript:void(0);" class="profile-button" onclick="toggleSidebar()"> <img src="${pageContext.request.contextPath}/resources/images/default-profile-pic.png"
	alt="Profile Picture" class="profile-picture"> <span
	class="username">${sessionScope.user.userName}</span>
</a>

<!-- Logout button -->
<a href="${pageContext.request.contextPath}/logout">
	<button class="btnLogin-popup">Logout</button>
</a>