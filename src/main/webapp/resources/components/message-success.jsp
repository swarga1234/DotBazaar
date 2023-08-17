<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/messageStyle.css">
<div id="popup" class="popup">
	<div class="icon-message">
		<i class="far fa-check-circle regular-icon icon-message-image"
			style="color: #50C878; font-size: 100px"></i>
	</div>
	<div class="popup-content">
		<span id="popup-message"> ${success} </span>
	</div>
	<div class="close">
		<button id="close-popup" class="close-popup">Close</button>
	</div>
</div>
